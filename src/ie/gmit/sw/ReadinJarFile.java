package ie.gmit.sw;


import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


public class ReadinJarFile {

	private static ClassList list;

	public ReadinJarFile(String jarName) throws IOException, NoSuchMethodException {

		init(jarName);
	}

	public void init(String jarName) throws IOException, NoSuchMethodException {

		list = new ClassList();

		JarInputStream in = new JarInputStream(new FileInputStream(new File(jarName)));

		JarEntry next = in.getNextJarEntry();

		while (next != null)
		{
			if (next.getName().endsWith(".class"))
			{
				String name = next.getName().replaceAll("/", "\\.");

				name = name.replaceAll(".class", "");

				if (!name.contains("$")) name.substring(0, name.length() - ".class".length());

				System.out.println(name);

				Class queryClass = null;

				try {
					queryClass = Class.forName(name);
					list.add(queryClass);
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
				//Class cls = queryClass;
				ClassDetails clsD = new ClassDetails(list);

				System.out.println(list.size());
			}
			next = in.getNextJarEntry();

		}
	}

	
	//}
	
}
