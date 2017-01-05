package ie.gmit.sw;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sean on 05/01/2017.
 */
public class MeasureList {

    private List<Measure> list = new ArrayList<Measure>();

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public boolean contains(Object o) {
        return list.contains(o);
    }

    public boolean add(Measure measure) {
        return list.add(measure);
    }

    public boolean remove(Object o) {
        return list.remove(o);
    }

    public void clear() {
        list.clear();
    }

    public Measure get(int index) {
        return list.get(index);
    }




}
