package ie.gmit.sw.Controller;

import ie.gmit.sw.Model.Measurement;

import java.util.Iterator;
import java.util.Map;

/**
 * Created by Sean on 09/01/2017.
 */
public class DependancyData implements Datable {

    public DependancyData (AdjacencyList aList){
        getAdjacData(aList);
    }

    public DependancyData(){
        super();
    }

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
        /*for (Class entry : aList.keySet()){

             = aList.values();
            data[i][1] = aList.get(entry);

            i++;
        }*/

        return data;
    }

    @Override
    public Object[][] getData(Object obj) {
        return new Object[0][];
    }
}
