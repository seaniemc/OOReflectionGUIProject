package ie.gmit.sw.Controller;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Sean on 09/01/2017.
 */
public class DependancyList {
    private List<Class> dependancies = new ArrayList<>();

    public int size() {
        return dependancies.size();
    }

    public boolean isEmpty() {
        return dependancies.isEmpty();
    }

    public boolean contains(Object o) {
        return dependancies.contains(o);
    }

    public boolean add(Class aClass) {
        return dependancies.add(aClass);
    }

    public boolean remove(Object o) {
        return dependancies.remove(o);
    }

    public void clear() {
        dependancies.clear();
    }

    public Class get(int index) {
        return dependancies.get(index);
    }

    public Class set(int index, Class element) {
        return dependancies.set(index, element);
    }


}
