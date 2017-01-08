package ie.gmit.sw.Controller;

import ie.gmit.sw.Model.Measurement;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Sean on 08/01/2017.
 */
public class ClassMap {

    private Map<Class, Measurement> classMap = new HashMap<>();

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

    public Measurement get(Object key) {
        return classMap.get(key);
    }

    public Measurement put(Class key, Measurement value) {
        return classMap.put(key, value);
    }

    public Measurement remove(Object key) {
        return classMap.remove(key);
    }

    public void clear() {
        classMap.clear();
    }

    public Collection<Measurement> values() {
        return classMap.values();
    }
}
