package ie.gmit.sw.Model;

import java.util.*;

/**
 * Created by Sean on 09/01/2017.
 */
public class AdjacencyList {

    private Map<Class, List<Class>> adjacencyList = new HashMap<>();

    public Set<Map.Entry<Class, List<Class>>> entrySet() {

        return adjacencyList.entrySet();
    }

    public int size() {

        return adjacencyList.size();
    }

    public boolean isEmpty() {

        return adjacencyList.isEmpty();
    }

    public List<Class> get(Object key) {

        return adjacencyList.get(key);
    }

    public boolean containsKey(Object key) {

        return adjacencyList.containsKey(key);
    }

    public List<Class> put(Class key, List<Class> value) {

        return adjacencyList.put(key, value);
    }

    public List<Class> remove(Object key) {
        return adjacencyList.remove(key);
    }

    public void clear() {

        adjacencyList.clear();
    }

    public Set<Class> keySet() {

        return adjacencyList.keySet();
    }

    public Collection<List<Class>> values() {

        return adjacencyList.values();
    }

}
