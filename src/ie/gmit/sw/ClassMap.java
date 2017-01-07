package ie.gmit.sw;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by Sean on 05/01/2017.
 */
public class ClassMap {

    private Map <ClassList, StabilityMetric> classMap = new HashMap<ClassList, StabilityMetric>();

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

    public StabilityMetric get(Object key) {
        return classMap.get(key);
    }

    public StabilityMetric put(ClassList key, StabilityMetric value) {
        return classMap.put(key, value);
    }

    public StabilityMetric remove(Object key) {
        return classMap.remove(key);
    }

    public void clear() {
        classMap.clear();
    }

    public Set<ClassList> keySet() {
        return classMap.keySet();
    }




}
