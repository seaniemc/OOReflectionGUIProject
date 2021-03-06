package ie.gmit.sw.GUIView;

/**
 * Created by Sean on 10/01/2017.
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;

/**
 * This Class is used to display the results of the
 * adjacency list
 */
public class AdjacencySummary extends JDialog {

    private static final long serialVersionUID = 777L;
    private AdjacentSummaryTable ast = null;
    private JTable table = null;
    private JScrollPane tableScroller = null;
    private JButton btnClose = null;
    private JPanel tablePanel = new JPanel();
    private JPanel buttonPanel = new JPanel();
    private Container c;

    public AdjacencySummary(JFrame parent, boolean modal){

        super(parent, modal);
        super.setTitle("Adjacency List");
        super.setResizable(true);

        this.setSize(new Dimension(800, 500));

        c = getContentPane();
        c.setLayout(new FlowLayout());

        createTable();
        configureButtonPanel();

        c.add(tablePanel);
        c.add(buttonPanel);
    }

    //used to create the table model.
    public AdjacentSummaryTable getTableModel(){

        return ast;
    }

    /**
     * creates the table structure
     */
    private void createTable() {
        ast = new AdjacentSummaryTable();
        table = new JTable(ast);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        table.setSelectionBackground(Color.YELLOW);

        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        TableColumn column = null;
        for (int i = 0; i < table.getColumnCount(); i++) {
            column = table.getColumnModel().getColumn(i);
            if (i == 0) {
                column.setPreferredWidth(180);
                column.setMaxWidth(180);
                column.setMinWidth(180);
            } else {
                column.setPreferredWidth(400);
                column.setMaxWidth(400);
                column.setMinWidth(400);
            }
        }

        tableScroller = new JScrollPane(table);
        tableScroller.setPreferredSize(new java.awt.Dimension(475, 500));
        tableScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);

        tablePanel.add(tableScroller, FlowLayout.LEFT);
    }

    private void configureButtonPanel(){
        buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));

        //Configure the Cancel button
        btnClose = new JButton("Close");
        btnClose.setToolTipText("Close this Window");
        btnClose.setPreferredSize(new java.awt.Dimension(100, 40));
        btnClose.setMaximumSize(new java.awt.Dimension(100, 40));
        btnClose.setMargin(new java.awt.Insets(2, 2, 2, 2));
        btnClose.setMinimumSize(new java.awt.Dimension(100, 40));
        btnClose.setIcon(new ImageIcon("images/close.gif"));
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                dispose();
            }
        });

        buttonPanel.add(btnClose);
    }
}
