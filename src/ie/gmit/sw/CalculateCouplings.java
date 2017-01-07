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

    public CalculateCouplings(){
        super();
    }

    public MeasureList getAfferent(ClassList list){
        mList = new MeasureList();
        measure = new Measure();
        //ClassList newList = new ClassList();

        for (int i = 0; i < list.size(); i++) {

            //Get the class needed for afferent inspection
            Class cla = list.getMyClass(i);
            //ClassList list2 = new ClassList();
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
                System.out.println("Afferent coupling Interfaces" +afferentCoupling + "Efferent coupling" +efferentCoupling);

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
                System.out.println("Afferent coupling Constructor " +afferentCoupling + " Efferent coupling " +efferentCoupling);
                Field[] fields = inspecClass.getFields();

                for(Field fie: fields ){

                    //if the field name is on the list of classes ++
                    if(list.contains(fie.getName()))
                        efferentCoupling ++;


                    if(fie.getName() == inspecClass.getName())
                    afferentCoupling++;
                }//fields
                System.out.println("Afferent coupling Fields " + afferentCoupling + " Efferent coupling " +efferentCoupling);
                Method[] classMethods = inspecClass.getMethods();
                Class[] params;

                for(Method meth: classMethods){

                    Class returnTypes = meth.getReturnType();

                    if(meth.getReturnType().getName() == cla.getName()){

                        afferentCoupling ++;
                    }

                }
                System.out.println("Afferent coupling Methods " +afferentCoupling + " Efferent coupling " +efferentCoupling);
                efferentName = inspecClass.getName();
                measure.setClassName(efferentName);
                measure.setEfferentCoupling(efferentCoupling);

                mList.add(measure);
            }//end second for

            //resets efferent coupling
            efferentCoupling = 0;

            afferentName = cla.getName();
            measure.setClassName(afferentName);
            measure.setAfferentCoupling(afferentCoupling);
            mList.add(measure);
            System.out.println("Mlist size" +mList.size());
        }//end first for

        //resets afferentCoupling

        afferentCoupling = 0;

        return mList;
    }//getAfferent

    public int getAfferent(ClassList list, String name){
        int afferent = 0;

        for (int i = 0; i < list.size(); i++) {

            //Get the class needed for afferent inspection
            Class cla = list.getMyClass(i);

            if (cla.getName() == name) {
                afferent = 1;
            }

            }

        return afferent;
    }
}
