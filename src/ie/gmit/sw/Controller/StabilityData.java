package ie.gmit.sw.Controller;

import ie.gmit.sw.GUIView.TypeSummaryTableModel;
import ie.gmit.sw.Model.Measurement;

/**
 * Created by Sean on 08/01/2017.
 */
public class StabilityData  {

    //private ClassMap map;
    public StabilityData (ClassMap map){
        getData(map);
    }
    public StabilityData(){
        super();
    }


    public Object[][] getData(ClassMap map) {
        int i = 0;
        Object[][] data = new Object[map.size()][4];

        for (Measurement myMeas: map.values()){

            data[i][0] = myMeas.getClassName();
            data[i][1] = myMeas.getStability();
            data[i][2] = myMeas.getEfferentCoupling();
            data[i][3] = myMeas.getAfferentCoupling();

            System.out.println(data);
            i++;
        }

        return data;
    }


}
