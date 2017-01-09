package ie.gmit.sw.Controller;

import java.io.IOException;

/**
 * Created by Sean on 03/01/2017.
 */
public class TestRunner {

    public static void main(String [] args) throws IOException, NoSuchMethodException {
        //1st create instance of Readable
        Readable jar = new ReadinJarFile();

        //Create a new instance of ClassList
        ClassList list = new ClassList();

        //Call jar.init Method and pass in Jr file name
        list = jar.init("test-jar.jar");

        ClassMap map = new ClassMap();
        //create new instance of CalculateCouplings
        CalculateCouplings cal = new CalculateCouplings();
        map = cal.getEfferent(list);

        StabilityData stabD = new StabilityData();
        stabD.getData(map);

        PopulateAdjacency adj = new PopulateAdjacency(list);

    }
}
