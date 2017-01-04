package ie.gmit.sw;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by Sean on 03/01/2017.
 */
public class ClassDetails {

    //private static ClassList classlist;
    private Class myCla;
    private int efferentCoup = 0;

    public ClassDetails(ClassList cls) throws NoSuchMethodException {
        getInterfaces(cls);
    }

    public void getInterfaces(ClassList cls) throws NoSuchMethodException {

        for (int i = 0; i < cls.size(); i++) {

            Class cla = cls.getMyClass(i);
            cla.getName();

            Class[] interfaces = cla.getInterfaces();

            for(Class inter : interfaces){
                System.out.println("Interfaces: " + inter.getName());
                efferentCoup++;
            }

            Constructor[] cons = cla.getConstructors();
            Class[] conParams;

            for(Constructor c: cons){
                System.out.println("Contructor: " + c.getName());
                conParams = c.getParameterTypes();

                for(Class par: conParams){

                    efferentCoup++;
                }

            }

            Field[] fields = cla.getFields();

            for(Field fie: fields ){
                System.out.println("Fields: " + fie.getName());
                efferentCoup++;
            }
            myCla = cla;
            Method[] classMethods = cla.getMethods();


            efferentCoup = 0;
        }
        System.out.println(myCla.getName()+"Its efferent coupling" + efferentCoup);

    }
}
