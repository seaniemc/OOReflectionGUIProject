package ie.gmit.sw;


import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


public class ReadinJarFile {

	private static ClassList list;
	//private static MeasureList mList;


	public ClassList init(String jarName) throws IOException, NoSuchMethodException {

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

				//System.out.println(name);

				Class queryClass = null;

				try {
					queryClass = Class.forName(name);
					list.add(queryClass);
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}

			}
			next = in.getNextJarEntry();

		}
		return list;
	}

}
