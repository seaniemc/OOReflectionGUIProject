package ie.gmit.sw;

/**
 * Created by Sean on 03/01/2017.
 */
public class ClassDetails {
    private static ClassList classlist;

    public ClassDetails(Class cls){
        getInterfaces(cls);
    }

    public void getInterfaces(Class cls){
        boolean iface = cls.isInterface(); //Is it an interface?
        System.out.println("Is Class an Interface?: " + iface);

        Class[] interfaces = cls.getInterfaces(); //Get the set of interface it implements
        // for each interface, print name
        for(Class i : interfaces){

            System.out.println("Implements Interface: " + i.getName());
        }


        //return interfaces;
    }
}
