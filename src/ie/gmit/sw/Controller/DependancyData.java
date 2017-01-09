package ie.gmit.sw.Controller;

import ie.gmit.sw.Model.Measurement;

/**
 * Created by Sean on 09/01/2017.
 */
public class DependancyData implements Datable {

    public DependancyData (AdjacencyList aList){
        getData(aList);
    }

    public DependancyData(){
        super();
    }
    public Object[][] getData(AdjacencyList aList) {
        int i = 0;
        Object[][] data = new Object[aList.size()][2];

        for (Class c : aList.keySet()){

            data[i][0] = aList.values();
            data[i][1] = aList.values();

            i++;
        }

        return data;
    }

    @Override
    public Object[][] getData(Object obj) {
        return new Object[0][];
    }
}
