package ie.gmit.sw.GUIView;

import ie.gmit.sw.Controller.*;
import ie.gmit.sw.Controller.Readable;
import ie.gmit.sw.Model.AdjacencyList;

import javax.swing.*;
import javax.swing.border.BevelBorder;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

public class AppWindow {

	private JFrame frame;
	private AppSummary appS;
    private AdjacencySummary adJS;
    private ClassList list;

	public AppWindow(){
		//Create a window for the application
		frame = new JFrame();
		frame.setTitle("G00316649 Sean McGrath - GMIT");
		frame.setSize(550, 500);
		frame.setResizable(false);
		frame.setLayout(new FlowLayout());
		
        //The file panel will contain the file chooser
        JPanel top = new JPanel(new FlowLayout(FlowLayout.LEADING));
        top.setBorder(new javax.swing.border.TitledBorder("Click Browse To Select Jar File"));
        top.setPreferredSize(new java.awt.Dimension(500, 100));
        top.setMaximumSize(new java.awt.Dimension(500, 100));
        top.setMinimumSize(new java.awt.Dimension(500, 100));
        
        final JTextField txtFileName =  new JTextField(20);
		txtFileName.setPreferredSize(new java.awt.Dimension(100, 30));
		txtFileName.setMaximumSize(new java.awt.Dimension(100, 30));
		txtFileName.setMargin(new java.awt.Insets(2, 2, 2, 2));
		txtFileName.setMinimumSize(new java.awt.Dimension(100, 30));


        //Choose jar file
		JButton btnChooseFile = new JButton("Browse...");
		btnChooseFile.setToolTipText("Please Select Jar File");
        btnChooseFile.setPreferredSize(new java.awt.Dimension(90, 30));
        btnChooseFile.setMaximumSize(new java.awt.Dimension(90, 30));
        btnChooseFile.setMargin(new java.awt.Insets(2, 2, 2, 2));
        btnChooseFile.setMinimumSize(new java.awt.Dimension(90, 30));
		btnChooseFile.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(ActionEvent evt) {

        		JFileChooser fc = new JFileChooser("./");

        		int returnVal = fc.showOpenDialog(frame);

            	if (returnVal == JFileChooser.APPROVE_OPTION) {

                	File file = fc.getSelectedFile().getAbsoluteFile();

                	String name = file.getAbsolutePath();

                    if(name.endsWith(".jar") == true){
                        txtFileName.setText(name);
                    }

                	System.out.println("You selected the following file: " + name);
            	}
			}
        });
		
		JButton btnOther = new JButton("Calculate Stability");
		btnOther.setToolTipText("Stability");
		btnOther.setPreferredSize(new java.awt.Dimension(150, 30));
		btnOther.setMaximumSize(new java.awt.Dimension(150, 30));
		btnOther.setMargin(new java.awt.Insets(2, 2, 2, 2));
		btnOther.setMinimumSize(new java.awt.Dimension(150, 30));
		btnOther.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(ActionEvent evt) {
            	//System.out.println("Do Something");
                appS =  new AppSummary(frame, true);

                Readable jar = new ReadinJarFile();

                //Create a new instance of ClassList
                list = new ClassList();

                //Call jar.init Method and pass in Jr file name
                try {
                    list = jar.init(txtFileName.getText());
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                }

                ClassMap map = new ClassMap();
                //create new instance of CalculateCouplings
                CalculateCouplings cal = new CalculateCouplings();

                map = cal.getEfferent(list);

                Data stabD = new Data();
                stabD.getData(map);

                TypeSummaryTableModel tstm = appS.getTableModel();

                tstm.setData(stabD.getData(map));

                appS.setVisible(true);



            }
        });
		
        top.add(txtFileName);
        top.add(btnChooseFile);
        top.add(btnOther);
        frame.getContentPane().add(top); //Add the panel to the window
        
        
        //A separate panel for the programme output
        JPanel mid = new JPanel(new FlowLayout(FlowLayout.LEADING));
        mid.setBorder(new BevelBorder(BevelBorder.RAISED));
        mid.setPreferredSize(new java.awt.Dimension(500, 300));
        mid.setMaximumSize(new java.awt.Dimension(500, 300));
        mid.setMinimumSize(new java.awt.Dimension(500, 300));
        
        CustomControl cc = new CustomControl(new java.awt.Dimension(500, 300));
        cc.setBackground(Color.WHITE);
        cc.setPreferredSize(new java.awt.Dimension(300, 300));
        cc.setMaximumSize(new java.awt.Dimension(300, 300));
        cc.setMinimumSize(new java.awt.Dimension(300, 300));
        mid.add(cc);
		frame.getContentPane().add(mid);
		
        JPanel bottom = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        bottom.setPreferredSize(new java.awt.Dimension(500, 50));
        bottom.setMaximumSize(new java.awt.Dimension(500, 50));
        bottom.setMinimumSize(new java.awt.Dimension(500, 50));
        
        JButton btnDialog = new JButton("Show Class Adjacency List"); //Create Quit button
        btnDialog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {

                adJS = new AdjacencySummary(frame, true);

                Readable jar = new ReadinJarFile();

                //Create a new instance of ClassList
                list = new ClassList();

                //Call jar.init Method and pass in Jr file name
                try {
                    list = jar.init(txtFileName.getText());
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                }
                AdjacencyList map = new AdjacencyList();

                PopulateAdjacency pop = new PopulateAdjacency();

                map = pop.fillList(list);

                Data data = new Data();
                data.getAdjacData(map);

                AdjacentSummaryTable ast = adJS.getTableModel();

                ast.setAdjacData(data.getAdjacData(map));

                adJS.setVisible(true);
			}
        });
        
        JButton btnQuit = new JButton("Quit"); //Create Quit button
        btnQuit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            	System.exit(0);
			}
        });
        bottom.add(btnDialog);
        bottom.add(btnQuit);

        frame.getContentPane().add(bottom);       
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		new AppWindow();
	}
}