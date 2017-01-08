package ie.gmit.sw;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Sean on 08/01/2017.
 */
public class ClassMap {

    private Map<Class, Measure> classMap = new HashMap<>();

    public int size() {
        return classMap.size();
    }

    public boolean isEmpty() {
        return classMap.isEmpty();
    }

    public boolean containsKey(Object key) {
        return classMap.containsKey(key);
    }

    public boolean containsValue(Object value) {
        return classMap.containsValue(value);
    }

    public Measure get(Object key) {
        return classMap.get(key);
    }

    public Measure put(Class key, Measure value) {
        return classMap.put(key, value);
    }

    public Measure remove(Object key) {
        return classMap.remove(key);
    }

    public void clear() {
        classMap.clear();
    }

    public Collection<Measure> values() {
        return classMap.values();
    }
}
