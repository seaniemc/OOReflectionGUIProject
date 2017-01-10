package ie.gmit.sw.Controller;

import ie.gmit.sw.Model.AdjacencyList;

import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sean on 09/01/2017.
 */
public class PopulateAdjacency {
    private AdjacencyList adList;
    //private DependancyList depList;


    public PopulateAdjacency(ClassList list){
        fillList(list);
    }
    public PopulateAdjacency(){
        super();
    }

    /**
     * Cycles through the class list and creates an adjacency list i.e list of dependancies
     * @param list
     * @return
     */
    public AdjacencyList fillList (ClassList list){

        adList = new AdjacencyList();

        for (int i = 0; i < list.size(); i++) {

            //create a new lis each loop
            List<Class> depList = new ArrayList<Class>();

            Class cla = list.getMyClass(i);


            /*if(!(cla.isInterface() || Modifier.isAbstract(cla.getModifiers()))){
                depList.add(cla);
            }*/
            //get the interfaces from the class
            Class[] interfaces = cla.getInterfaces();

            for(Class inter : interfaces){

                //if the interface is part of the list
                if(list.contains(inter)){
                    depList.add(inter);
                }

            }//end interfaces

            if(!cla.isInterface()){ // if class is not an interface

                Class sclass = cla.getSuperclass();

                if(list.contains(sclass)){

                    depList.add(sclass);
                }

            }

            Constructor[] cons = cla.getConstructors();
            Class[] conParams;

            for(Constructor c: cons){

                conParams = c.getParameterTypes();

                for(Class par: conParams){

                    if(list.contains(par.getName())){
                        depList.add(par);
                    }

                }

            }//end Constructor params

            Field[] fields = cla.getDeclaredFields();

            for(Field fie: fields ){

                Type t = fie.getType();
                //if the field name is on the list of classes ++
                if(list.contains(t.getClass())){
                    depList.add(t.getClass());
                }



            }//fields

            Constructor constrs[] = cla.getDeclaredConstructors();

            if(constrs.length > 0){
                for(Constructor constr : constrs){
                    Class p[] = constr.getParameterTypes();
                    if(p.length > 0){
                        for(Class item : p){
                            if(list.contains(item)){
                                depList.add(item);
                            }
                        }
                    }
                }
            }

            //get the methods for the class
            Method[] classMethods = cla.getMethods();
            Class[] params;

            //
            for(Method meth: classMethods){

                Class returnTypes = meth.getReturnType();

                if(list.contains(meth.getReturnType().getName())){

                    depList.add(returnTypes);
                }



                params = meth.getParameterTypes(); //Get method parameters
                for(Class mp : params){

                    if(list.contains(mp)){

                        // add class to dependancy list
                        depList.add(mp);

                    } // if
                } // foreach
            }
            //add the Class(Key) List(Value) to Map
            adList.put(cla, depList);
        }//end for
        return adList;
    }
}
