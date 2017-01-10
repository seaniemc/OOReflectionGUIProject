package ie.gmit.sw.GUIView;

import javax.swing.table.AbstractTableModel;

/**
 * Created by Sean on 10/01/2017.
 */
public class AdjacentSummaryTable extends AbstractTableModel {

    private  String[] cols = {"Class", "Adjacency List"};

    private Object[][] adjacData = {
            {"Class", "Adjacency List"}
    };


    public void setAdjacData(Object[][] adjacData){
        this.adjacData = adjacData;
    }

    public int getColumnCount() {
        return cols.length;
    }

    public int getRowCount() {
        return adjacData.length;
    }

    public String getColumnName(int col) {
        return cols[col];
    }

    public Object getValueAt(int row, int col) {
        return adjacData[row][col];
    }

    public Class<?> getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }
}

