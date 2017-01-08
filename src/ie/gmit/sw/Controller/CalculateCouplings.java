package ie.gmit.sw.Controller;

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

    private int afferentCoupling = 0;
    private int efferentCoupling = 0;

    public CalculateCouplings(){
        super();
    }

    public CalculateCouplings(ClassList mylist){
        getEfferent(mylist);
    }

    public ClassMap getEfferent(ClassList list){
        map = new ClassMap();
        measure = new Measurement();

        for (int i = 0; i < list.size(); i++) {

            //Get the class needed for afferent inspection
            Class cla = list.getMyClass(i);
            //ClassList list2 = new ClassList();

           afferentCoupling = getAfferent(list, cla.getName());
                //class which we inspect to see if it holds any references to class list.getMyClass(i);
                //also used to perform the check for efferent coupling


            Class[] interfaces = cla.getInterfaces();

            //if the class implements any interfaces increment efferent
            for(Class inter : interfaces){

                if(list.contains(inter)){
                    efferentCoupling++;
                }

            }//end interfaces
            System.out.println("Afferent coupling Interfaces" +afferentCoupling + "Efferent coupling" +efferentCoupling);

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
            System.out.println("Afferent coupling Constructor " +afferentCoupling + " Efferent coupling " +efferentCoupling);
            Field[] fields = cla.getFields();

            for(Field fie: fields ){

                //if the field name is on the list of classes ++
                if(list.contains(fie.getName()))
                    efferentCoupling ++;


            }//fields
            System.out.println("Afferent coupling Fields " + afferentCoupling + " Efferent coupling " +efferentCoupling);
            Method[] classMethods = cla.getMethods();
            Class[] params;

            for(Method meth: classMethods){

                Class returnTypes = meth.getReturnType();

                if(list.contains(meth.getReturnType().getName())){
                    efferentCoupling ++;
                }

            }

            Name = cla.getName();
            measure.setClassName(Name);

            measure.setEfferentCoupling(efferentCoupling);
            measure.setAfferentCoupling(afferentCoupling);

            cla = list.getMyClass(i);

            map.put(cla, measure);

            System.out.println("Mlist size" + map.size());
        }//end for


        //resets efferent coupling
        efferentCoupling = 0;

        return map;
    }//getAfferent

    public int getAfferent(ClassList list, String name){
        int afferent = 0;

        for (int i = 0; i < list.size(); i++) {

            //Get the class needed for afferent inspection
            Class cla = list.getMyClass(i);

            Class[] interfaces = cla.getInterfaces();

            //if the class implements any interfaces increment efferent
            for(Class inter : interfaces){

                //if the interface name is same as list.getMyClass(i) then increment afferent
                if(inter.getName() == name){
                    afferent ++;
                }

            }//end interfaces

            Constructor[] cons = cla.getConstructors();
            Class[] conParams;

            for(Constructor c: cons) {

                conParams = c.getParameterTypes();

                for (Class par : conParams) {

                    //if constructor params == cla.getName()) then increment
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
            //System.out.println("Afferent coupling Fields " + afferentCoupling + " Efferent coupling " +efferentCoupling);
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
