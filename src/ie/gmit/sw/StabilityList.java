package ie.gmit.sw;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sean on 06/01/2017.
 */
public class StabilityList {

    private List<StabilityMetric> sList = new ArrayList<StabilityMetric>();

    public int size() {
        return sList.size();
    }

    public boolean contains(Object o) {
        return sList.contains(o);
    }

    public boolean add(StabilityMetric stablityMetric) {
        return sList.add(stablityMetric);
    }

    public void clear() {
        sList.clear();
    }

    public StabilityMetric get(int index) {
        return sList.get(index);
    }


}
