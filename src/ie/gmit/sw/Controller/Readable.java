package ie.gmit.sw.Controller;

import java.io.IOException;

public interface Readable {
	
	public ClassList init(String jarName) throws IOException, NoSuchMethodException;

}