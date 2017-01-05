package ie.gmit.sw;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by Sean on 05/01/2017.
 */
public class CalculateCouplings {

    private static MeasureList mList;
    private static Measure measure;
    private String afferentName ;
    private String efferentName;
    private int afferentCoupling = 0;
    private int efferentCoupling = 0;

    public CalculateCouplings(ClassList list){

        getAfferent(list);
    }

    public void getAfferent(ClassList list){

        measure = new Measure();

        for (int i = 0; i < list.size(); i++) {

            //Get the class needed for afferent inspection
            Class cla = list.getMyClass(i);

            for (int j = 0; j < list.size(); j++){

                //class which we inspect to see if it holds any references to class list.getMyClass(i);
                //also used to perform the check for efferent coupling
                Class inspecClass = list.getMyClass(j);

                Class[] interfaces = inspecClass.getInterfaces();

                //if the class implements any interfaces increment efferent
                for(Class inter : interfaces){

                    efferentCoupling++;
                    //if the interface name is same as list.getMyClass(i) then increment afferent
                    if(inter.getName() == cla.getName()){
                        afferentCoupling ++;
                    }

                }//end interfaces

                Constructor[] cons = inspecClass.getConstructors();
                Class[] conParams;

                for(Constructor c: cons){

                    conParams = c.getParameterTypes();

                    for(Class par: conParams){

                        //if the paramater name is on the list of classes ++
                        if(list.contains(par.getName())){
                            efferentCoupling ++;
                        }

                        //if constructor params == cla.getName()) then increment
                        if( par.getName() == cla.getName()){
                            afferentCoupling++;
                        }
                    }

                }//end Constructor params

                Field[] fields = inspecClass.getFields();

                for(Field fie: fields ){

                    //if the field name is on the list of classes ++
                    if(list.contains(fie.getName()))
                        efferentCoupling ++;


                    if(fie.getName() == inspecClass.getName())
                    afferentCoupling++;
                }//fields

                Method[] classMethods = inspecClass.getMethods();
                Class[] params;

                for(Method meth: classMethods){

                    Class returnTypes = meth.getReturnType();

                    if(meth.getReturnType().getName() == cla.getName()){

                        afferentCoupling ++;
                    }

                    params = meth.getParameterTypes();

                    for(Class methodParams: params){

                        if(list.contains(methodParams.getName())) {
                            efferentCoupling++;
                        }

                        if(methodParams.getName() == inspecClass.getName()) {
                            afferentCoupling++;
                        }

                    }
                }


                efferentName = inspecClass.getName();
                measure.setClassName(efferentName);
                measure.setEfferentCoupling(efferentCoupling);

                mList.add(measure);
            }//end second for

            efferentCoupling = 0;

            afferentName = cla.getName();
            measure.setClassName(afferentName);
            measure.setAfferentCoupling(afferentCoupling);
            mList.add(measure);
        }//end first for


        afferentCoupling = 0;

    StablityMetric metric = new StablityMetric(list,mList);
    }//getAfferent
}
