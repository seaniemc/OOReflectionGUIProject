package ie.gmit.sw;

import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
public class ReadinJarFile {
	
	public static void main(String[] args) throws FileNotFoundException, IOException{
		
		JarInputStream in = new JarInputStream(new FileInputStream(new File("mylib.jar")));
		
		JarEntry next = in.getNextJarEntry();
		
		while (next != null) 
		{
			 if (next.getName().endsWith(".class")) 
			 {
				 String name = next.getName().replaceAll("/", "\\.");
				 
				 name = name.replaceAll(".class", "");
				 
				 if (!name.contains("$")) name.substring(0, name.length() - ".class".length());
				 
				 System.out.println(name);
			 }
			 next = in.getNextJarEntry();
		}
		
	}
	
}
