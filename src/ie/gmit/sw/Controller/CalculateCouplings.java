package ie.gmit.sw.Controller;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import ie.gmit.sw.Model.Measurement;

/**
 * Created by Sean on 05/01/2017.
 */
public class CalculateCouplings {

    private static ClassMap map;
    private static Measurement measure;

    private String Name;

    private int afferentCoupling;
    private int efferentCoupling = 0;

    public CalculateCouplings(){
        super();
    }

    public CalculateCouplings(ClassList mylist){
        getEfferent(mylist);
    }

    public ClassMap getEfferent(ClassList list){
        map = new ClassMap();

        //cycle through the list
        for (int i = 0; i < list.size(); i++) {


            //Get the class needed for efferent inspection
            Class cla = list.getMyClass(i);

            //get the interfaces from the class
            Class[] interfaces = cla.getInterfaces();

            //if the class implements any interfaces increment efferent
            for(Class inter : interfaces){

                //if the interface is part of the list
                if(list.contains(inter)){
                    efferentCoupling++;
                }

            }//end interfaces

            Constructor[] cons = cla.getConstructors();
            Class[] conParams;

            for(Constructor c: cons){

                conParams = c.getParameterTypes();

                for(Class par: conParams){

                    //if the paramater name is on the list of classes ++
                    if(list.contains(par.getName())){
                        efferentCoupling ++;
                    }

                }

            }//end Constructor params

            Field[] fields = cla.getFields();

            for(Field fie: fields ){

                //if the field name is on the list of classes ++
                if(list.contains(fie.getName()))
                    efferentCoupling ++;


            }//fields

            //get the methods for the class
            Method[] classMethods = cla.getMethods();
            Class[] params;

            //
            for(Method meth: classMethods){

                Class returnTypes = meth.getReturnType();

                if(list.contains(meth.getReturnType().getName())){
                    efferentCoupling ++;
                }

            }

            //pass in the list and the class name to check for afferent coupling
            afferentCoupling = getAfferent(list, cla.getName());

            Name = cla.getName();

            //pass the the class name into setClassName
            /*measure;

            //pass in the efferentCoupling for the class
            measure.setEfferentCoupling();
            //pass in the afferentCoupling for the class
            measure.setAfferentCoupling();*/
            measure = new Measurement(efferentCoupling,afferentCoupling,Name);
            //System.out.println(measure.getStability());
            cla = list.getMyClass(i);

            //put the class(key) measure (value)
            map.put(cla, measure);

        }//end for


        //resets efferent coupling
        efferentCoupling = 0;

        return map;
    }//getAfferent


    //method passes in the ClassList and the class name to be checked
    public int getAfferent(ClassList list, String name){
        int afferent = 0;

        for (int i = 0; i < list.size(); i++) {

            //Get the class needed for afferent inspection
            Class cla = list.getMyClass(i);

            Class[] interfaces = cla.getInterfaces();

            //if the class implements any interfaces increment efferent
            for(Class inter : interfaces){

                //if the interface name is same as inter.getName() then increment afferent
                if(inter.getName() == name){
                    afferent ++;
                }

            }//end interfaces

            Constructor[] cons = cla.getConstructors();
            Class[] conParams;

            for(Constructor c: cons) {

                conParams = c.getParameterTypes();

                for (Class par : conParams) {

                    //if constructor params == name then increment
                    if (par.getName() == name) {
                        afferent++;
                    }
                }
            }

            Field[] fields = cla.getFields();
            for(Field fie: fields ){

                if(fie.getName() == name)
                    afferent++;
            }//fields

            Method[] classMethods = cla.getMethods();
            Class[] params;

            for(Method meth: classMethods){

                Class returnTypes = meth.getReturnType();

                if(meth.getReturnType().getName() == name){

                    afferent ++;
                }

            }
        }

        return afferent;
    }

}
