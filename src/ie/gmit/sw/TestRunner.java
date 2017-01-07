package ie.gmit.sw;

import java.io.IOException;

/**
 * Created by Sean on 03/01/2017.
 */
public class TestRunner {

    public static void main(String [] args) throws IOException, NoSuchMethodException {
        //1st Read in Jar file
        ReadinJarFile jar = new ReadinJarFile();

        ClassList list = new ClassList();

        list = jar.init("test-jar.jar");

        CalculateCouplings cal = new CalculateCouplings();

        MeasureList mList = new MeasureList();

        mList = cal.getAfferent(list);

        //3rd get a copy of coupling list


        //4th calculate stability metric
        StabilityMetric stab = new StabilityMetric(list, mList);
    }
}
