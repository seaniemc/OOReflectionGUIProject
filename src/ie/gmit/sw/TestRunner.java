package ie.gmit.sw;

import java.io.IOException;

/**
 * Created by Sean on 03/01/2017.
 */
public class TestRunner {

    public static void main(String [] args) throws IOException, NoSuchMethodException {
        //1st create instance of ReadinJarFile
        ReadinJarFile jar = new ReadinJarFile();

        //Create a new instance of ClassList
        ClassList list = new ClassList();

        //Call jar.init Method and pass in Jr file name
        list = jar.init("test-jar.jar");

        CalculateCouplings cal = new CalculateCouplings();

        MeasureList mList = new MeasureList();

        mList = cal.getEfferent(list);
        Measure myMeas = new Measure();
        double stab;
        for(int i = 0; i < mList.size(); i++){


            myMeas = mList.get(i);
            stab = myMeas.getStability();

            System.out.println(stab);
        }
    }
}
