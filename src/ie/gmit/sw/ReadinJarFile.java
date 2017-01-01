package ie.gmit.sw;


import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


public class ReadinJarFile {

	private static ClassList list; 

	public static void main(String[] args) throws FileNotFoundException, IOException{
		
		list = new ClassList();
		
		JarInputStream in = new JarInputStream(new FileInputStream(new File("test-jar.jar")));
		
		JarEntry next = in.getNextJarEntry();
		
		while (next != null) 
		{
			 if (next.getName().endsWith(".class")) 
			 {
				 String name = next.getName().replaceAll("/", "\\.");
				 
				 name = name.replaceAll(".class", "");
				 
				 if (!name.contains("$")) name.substring(0, name.length() - ".class".length());
				 
			 	 System.out.println(name);

				 Class queryClass;

				 try {
					 queryClass = Class.forName(name);
					 list.add(queryClass);
				 } catch (ClassNotFoundException e) {
					 e.printStackTrace();
				 }


					 //System.out.println("Couldn't find class '" + name + "'"); // if class is not found
					 //System.exit(1);
				 // reflection
				 System.out.println(list.size());
			 }
			 next = in.getNextJarEntry();
			 
		}
	
	}
	
}
