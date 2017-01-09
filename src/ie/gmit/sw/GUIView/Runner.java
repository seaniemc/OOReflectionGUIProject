package ie.gmit.sw.GUIView;


import ie.gmit.sw.Controller.TestRunner;

public class Runner {
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new AppWindow();
			}
		});
	}
}
