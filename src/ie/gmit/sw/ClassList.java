package ie.gmit.sw;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClassList {
	
	//@SuppressWarnings("rawtypes")
	private List <Class> list  = new  ArrayList<Class> ();

	public boolean add(Class arg0) {
		return list.add(arg0);
	}

	public void clear() {
		list.clear();
	}

	public boolean contains(Object arg0) {

		return list.contains(arg0);
	}

	public Class getMyClass(int index) {

		return list.get(index);
	}

	public boolean isEmpty() {
		return list.isEmpty();
	}

	public boolean remove(Object arg0) {
		return list.remove(arg0);
	}

	public int size() {
		return list.size();
	}

	

}
