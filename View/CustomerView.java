package View;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import Model.CustomerTableModel;

import java.sql.*;


public class CustomerView extends JPanel implements ActionListener{

	//member 변수 선언 
	JTextField tfcustTel, tfcustName, tfcustaddr;
	JButton bcustInsert, bcustDelete, bcustCancle, bcustModify;
	JTable tableCustomer;
	CustomerTableModel tbModelCust; //테이블다루는 클래스 변수 선언 
//	CustomerModel model;
	Connection con;
	
	
	public CustomerView() { //생성자 함수 
		addLayout(); // 화면설계
		eventProc(); //이벤트 등록 
		connectDB(); // DB연결
	}
	
	 void connectDB() {
		
	}

	 void eventProc() {
		
	}

	 void addLayout() {
		 tfcustaddr = new JTextField();
		 tfcustName = new JTextField();
		 tfcustTel = new JTextField();
		 
		 bcustCancle = new JButton("취소");
		 bcustDelete = new JButton("삭제");
		 bcustInsert = new JButton("등록");
		 bcustModify = new JButton("변경");
		 
		 tbModelCust = new CustomerTableModel();
		 
		 
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	
	
	
}
