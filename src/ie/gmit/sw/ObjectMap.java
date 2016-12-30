package ie.gmit.sw;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ObjectMap {
	
	@SuppressWarnings("rawtypes")
	private Map <Class, List<Class>> Graph  = new  HashMap<Class, List<Class>> ();

	public void clear() {
		Graph.clear();
	}

	public boolean containsValue(Object arg0) {
		return Graph.containsValue(arg0);
	}

	public List<Class> get(Object arg0) {
		return Graph.get(arg0);
	}

	public boolean isEmpty() {
		return Graph.isEmpty();
	}

	public List<Class> remove(Object key) {
		return Graph.remove(key);
	}

	public int size() {
		return Graph.size();
	}

}
