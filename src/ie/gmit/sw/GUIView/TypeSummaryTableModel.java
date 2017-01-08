package ie.gmit.sw.GUIView;

import javax.swing.table.*;
public class TypeSummaryTableModel extends AbstractTableModel{
	private static final long serialVersionUID = 777L;
	private String[] cols = {"Class", "Stability Metric", "Efferent Coupling", "Afferent Coupling"};

	private Object[][] data = {
		{"Stuff 1", "Other Stuff 1", "Even More Stuff 1", ""}

	};

	public void  getData(Object[][] data) {
		this.data = data;
	}
	public int getColumnCount() {
        return cols.length;
    }
	
    public int getRowCount() {
        return data.length;
	}

    public String getColumnName(int col) {
    	return cols[col];
    }

    public Object getValueAt(int row, int col) {
        return data[row][col];
	}
   
    public Class<?> getColumnClass(int c) {
        return getValueAt(0, c).getClass();
	}
}