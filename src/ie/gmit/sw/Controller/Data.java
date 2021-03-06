package ie.gmit.sw.Controller;

import ie.gmit.sw.Model.AdjacencyList;
import ie.gmit.sw.Model.Measurement;

import java.util.Iterator;
import java.util.Map;

/**
 * Created by Sean on 08/01/2017.
 */

/**
 * This class is responible for retiving the data need for the tables in the GUI
 */
public class Data {

    //private ClassMap map;
    public Data(ClassMap map){
        getData(map);
    }
    public Data(){
        super();
    }

    /**
     * Takes a map as a paramater and returns a 2 dimensional Object array with
     * the contents of the map values. Returned in the format required for the table of a swing component.
     * @param map
     * @return Object[][]
     */
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

    /**
     *Takes a map as a paramater and returns a 2 dimensional Object array, with
     * the map key's and values. Returned in the format required for the table of a swing component.
     * @param aList
     * @return Object[][]
     */
    public Object[][] getAdjacData(AdjacencyList aList) {
        int i = 0;
        Object[][] data = new Object[aList.size()][2];


        Iterator entries = aList.entrySet().iterator();
        while (entries.hasNext()) {
            Map.Entry thisEntry = (Map.Entry) entries.next();
            data[i][0] = thisEntry.getKey();
            data[i][1] = thisEntry.getValue();

            i++;
        }

        return data;
    }

}
