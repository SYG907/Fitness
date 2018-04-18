package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.AbstractTableModel;

//import view.VideoView.VideoTableModel;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;

public class ProgramView extends JFrame  implements ActionListener{

	private JPanel contentPane;
//	private JTextField tfCustId;
//	private JTextField tfProgNo;
//	private JTextField tfProgDay;
//	private JTextField tfProgSearch;
		
	
	JTextField tfCustId, tfProgNo, tfProgDay, tfProgSearch;
	JComboBox comProgTerm, comProgName, comProgTIme, comProgSearch;
	JCheckBox cbReReg;
	JButton bProgInsert, bProgModify, bProgDelete;
	JTable tableProg;
	ProgTableModel tbModelProg;
	
	//ProgramModel model; //비즈니스로직 JDBC연결
	
	
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProgramView frame = new ProgramView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ProgramView() {
		addLayout();
		initSytle();
		eventProc();
		connectDB();
	}
	
	void initSytle(){
		tfProgNo.setEditable(false);
	}
	
	public void connectDB(){	// DB연결
		try {
//			model = new ProgramModel();
			System.out.println("프로그램 연결성공");
		} catch (Exception e) {
			System.out.println("프로그램 연결실패:"+e.getMessage());
			e.printStackTrace();
		}
		
	}
	
	public void eventProc(){
		bProgInsert.addActionListener(this);
		bProgModify.addActionListener(this);
		bProgDelete.addActionListener(this);
		tfProgSearch.addActionListener(this);		
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		Object evt = e.getSource();
		//다중입고 체크박스 클릭시
		if(evt==bProgInsert){
			JOptionPane.showMessageDialog(null, "등록성공");
		}else if(evt==bProgModify){
			JOptionPane.showMessageDialog(null, "수정성공");			
		}else if(evt==bProgDelete){
			JOptionPane.showMessageDialog(null, "삭제성공");			
		}else if(evt==tfProgSearch){
			JOptionPane.showMessageDialog(null, "탐색성공");	
		}
		
	
		
	}
	
	
	
	public void addLayout(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel p_west = new JPanel();
		contentPane.add(p_west);
		p_west.setLayout(new BorderLayout(0, 0));
		
		JPanel p_west_center = new JPanel();
		p_west.add(p_west_center, BorderLayout.CENTER);
		p_west_center.setLayout(new BorderLayout(0, 10));
		
		JPanel p_west_center_north = new JPanel();
		p_west_center.add(p_west_center_north, BorderLayout.NORTH);
		p_west_center_north.setLayout(new GridLayout(6, 2, 0, 5));
		p_west_center.setBorder(new TitledBorder("프로그램 정보입력"));
		
		JLabel lbCustId = new JLabel("고객ID");
		lbCustId.setHorizontalAlignment(SwingConstants.CENTER);
		p_west_center_north.add(lbCustId);
		
		tfCustId = new JTextField();
		p_west_center_north.add(tfCustId);
		tfCustId.setColumns(10);
		
		JLabel lbProgNo = new JLabel("등록번호");
		lbProgNo.setHorizontalAlignment(SwingConstants.CENTER);
		p_west_center_north.add(lbProgNo);
		
		tfProgNo = new JTextField();
		p_west_center_north.add(tfProgNo);
		tfProgNo.setColumns(10);
		
		JLabel lbProgDay = new JLabel("동륵일");
		lbProgDay.setHorizontalAlignment(SwingConstants.CENTER);
		p_west_center_north.add(lbProgDay);
		
		tfProgDay = new JTextField();
		p_west_center_north.add(tfProgDay);
		tfProgDay.setColumns(10);
		
		JLabel lbProgTerm = new JLabel("등록기간");
		lbProgTerm.setHorizontalAlignment(SwingConstants.CENTER);
		p_west_center_north.add(lbProgTerm);
		
		
		comProgTerm = new JComboBox();
		comProgTerm.setModel(new DefaultComboBoxModel(new String[] {"1개월", "3개월", "6개월", "1년"}));
		p_west_center_north.add(comProgTerm);
		
		JLabel lbProgName = new JLabel("프로그램");
		lbProgName.setHorizontalAlignment(SwingConstants.CENTER);
		p_west_center_north.add(lbProgName);
		
		comProgName = new JComboBox();
		comProgName.setModel(new DefaultComboBoxModel(new String[] {"수영", "스피닝", "핫요가", "피트니스", "필라테스"}));
		p_west_center_north.add(comProgName);
		
		JLabel lbProgTime = new JLabel("시간");
		lbProgTime.setHorizontalAlignment(SwingConstants.CENTER);
		p_west_center_north.add(lbProgTime);
		
		comProgTIme = new JComboBox();
		comProgTIme.setModel(new DefaultComboBoxModel(new String[] {"09:00-09:50", "10:00-10:50", "11:00-11:50", "18:00-18:50", "19:00-19:50", "20:00-20:50", "21:00-21:50"}));
		p_west_center_north.add(comProgTIme);
		
		JPanel p_west_south = new JPanel();
		p_west.add(p_west_south, BorderLayout.SOUTH);
		p_west_south.setLayout(new GridLayout(2, 0, 0, 0));
		
		JPanel p_west_south1 = new JPanel();
		p_west_south.add(p_west_south1);
		
		cbReReg = new JCheckBox("재등록이면 체크해주세요");
		p_west_south1.add(cbReReg);
		
		JPanel p_west_south2 = new JPanel();
		p_west_south.add(p_west_south2);
		p_west_south2.setLayout(new GridLayout(0, 3, 0, 0));
		
		bProgInsert = new JButton("등록");
		p_west_south2.add(bProgInsert);
		
		bProgModify = new JButton("수정");
		p_west_south2.add(bProgModify);
		
		bProgDelete = new JButton("삭제");
		p_west_south2.add(bProgDelete);
		
		JPanel p_east = new JPanel();
		contentPane.add(p_east);
		p_east.setLayout(new BorderLayout(0, 0));
		p_east.setBorder(new TitledBorder("프로그램 현황 목록"));
		
		tbModelProg = new ProgTableModel();
		tableProg = new JTable(tbModelProg);
		tableProg.setModel(tbModelProg);
		
		JScrollPane scrollPane = new JScrollPane(tableProg);
		p_east.add(scrollPane, BorderLayout.CENTER);
		
		JPanel p_east_south = new JPanel();
		p_east.add(p_east_south, BorderLayout.SOUTH);
		p_east_south.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		p_east_south.setBorder(new TitledBorder("탐색기능"));
		
		comProgSearch = new JComboBox();
		comProgSearch.setModel(new DefaultComboBoxModel(new String[] {"등록일", "등록기간", "프로그램"}));
		p_east_south.add(comProgSearch);
		
		tfProgSearch = new JTextField();
		p_east_south.add(tfProgSearch);
		tfProgSearch.setColumns(10);
		
	}

	
	class ProgTableModel extends AbstractTableModel { 
		  
		ArrayList data = new ArrayList();
		String [] columnNames = {"고객ID","등록일","등록기간","프로그램","시간"};

		//=============================================================
		// 1. 기본적인 TabelModel  만들기
		// 아래 세 함수는 TabelModel 인터페이스의 추상함수인데
		// AbstractTabelModel에서 구현되지 않았기에...
		// 반드시 사용자 구현 필수!!!!

		    public int getColumnCount() { 
		        return columnNames.length; 
		    } 
		     
		    public int getRowCount() { 
		        return data.size(); 
		    } 

		    public Object getValueAt(int row, int col) { 
				ArrayList temp = (ArrayList)data.get( row );
		        return temp.get( col ); 
		    }
		    
		    public String getColumnName(int col){
		    	return columnNames[col];
		    }
	}

}
