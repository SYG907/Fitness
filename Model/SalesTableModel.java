package Model;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class SalesTableModel extends AbstractTableModel {

	ArrayList data = new ArrayList();
	String[] columnNames = { "등록번호", "고객번호", "직원번호", "결제금액"};
	
	
	@Override
	public int getRowCount() {
		return data.size();
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public Object getValueAt(int row, int col) {
		ArrayList temp = (ArrayList) data.get(row);
		return temp.get(col);
	}
	public String getColumnName(int col) {
		return columnNames[col];

	}
	
	
	
}
