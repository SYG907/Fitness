package Model;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;


//테이블 모델 클래스 
public class CustomerTableModel extends AbstractTableModel{

	ArrayList data = new ArrayList();
	String[] columnNames = { "고객번호", "이름", "주소", "비고"};
	
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
