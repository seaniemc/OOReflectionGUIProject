package ie.gmit.sw;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by Sean on 05/01/2017.
 */
public class ClassMap {

    private Map <ClassList, StablityMetric> classMap = new HashMap<ClassList, StablityMetric>();

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

    public StablityMetric get(Object key) {
        return classMap.get(key);
    }

    public StablityMetric put(ClassList key, StablityMetric value) {
        return classMap.put(key, value);
    }

    public StablityMetric remove(Object key) {
        return classMap.remove(key);
    }

    public void clear() {
        classMap.clear();
    }

    public Set<ClassList> keySet() {
        return classMap.keySet();
    }




}
