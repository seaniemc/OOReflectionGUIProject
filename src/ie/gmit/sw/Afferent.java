package ie.gmit.sw;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by Sean on 05/01/2017.
 */
public class Afferent {

    private static Measure measure;
    private String afferentName = " ";
    private String efferentNmae;
    private int afferentCoupling = 0;
    private int efferentCoupling = 0;

    public Afferent(ClassList list){

        getAfferent(list);
    }

    public void getAfferent(ClassList list){

        measure = new Measure();

        for (int i = 0; i < list.size(); i++) {

            //Get the class needed for afferent inspection
            Class cla = list.getMyClass(i);

            for (int j = 0; j < list.size(); j++){

                //this is the class which we inspect to see if it holds any references to class list.getMyClass(i);
                Class inspecClass = list.getMyClass(j);

                Class[] interfaces = inspecClass.getInterfaces();

                //if the class implements any interfaces increment efferent 
                for(Class inter : interfaces){

                    efferentCoupling++;
                    //if the interface mane is same as list.getMyClass(i) then increment afferent
                    if(inter.getName() == cla.getName()){
                        afferentCoupling ++;
                    }

                }//end interfaces

                Constructor[] cons = inspecClass.getConstructors();
                Class[] conParams;

                for(Constructor c: cons){
                   // System.out.println("Contructor: " + c.getName());
                    conParams = c.getParameterTypes();

                    for(Class par: conParams){
                        //if constructor params == cla.getName()) then increment
                        if( par.getName() == cla.getName()){
                            afferentCoupling++;
                        }
                    }

                }//end Constructor params

                Field[] fields = inspecClass.getFields();

                for(Field fie: fields ){

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
                }

                efferentNmae = inspecClass.getName();
            }//end second for
            afferentName = cla.getName();
        }//end first for
        // r
        measure.setClassName(afferentName);
    }//getAfferent
}
