package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import Model.CustomerModel;
import Model.CustomerTableModel;
import Model.vo.Customer;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;

import java.sql.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class Customerview extends JPanel implements ActionListener {

	JTextField tfcustTel, tfcustName, tfcustaddr, tfcustSearch;
	JButton bcustInsert, bcustDelete, bcustModify;
	JTable tableCustomer;
	JComboBox comcustSearch;
	CustomerTableModel tbModelCust; // 테이블다루는 클래스 변수 선언

	CustomerModel model;
	Connection con;

	public Customerview() { // 생성자 함수
		addLayout(); // 화면설계
		eventProc(); // 이벤트 등록
		connectDB(); // DB연결
	}

	
	/////******* DB 연결**********/////// 
	private void connectDB() {

	}

	
	/////*******이벤트 등록**********/////// 
	private void eventProc() {
		bcustDelete.addActionListener(this);
		bcustInsert.addActionListener(this);
		bcustModify.addActionListener(this);
		tfcustSearch.addActionListener(this);
		tableCustomer.addMouseListener(new MouseAdapter() {

			// public void mouseClicked(MouseEvent e) {
			// int row = tableCustomer.getSelectedRow();
			// int col = 0;
			// String data = (String)tableCustomer.getValueAt(row, col);
			// int no = Integer.parseInt(data);
			// System.out.println(data);
			//// JOptionPane.showMessageDialog(null, no);
			// try {
			//// Customer vo = model.selectByPk(no);
			// tfcustTel.setText(String.valueOf(vo.getCustTel()));
			// tfcustName.setText(vo.getCustName());
			// tfcustaddr.setText(vo.getCustAddr());
			// } catch (Exception e1) {
			// System.out.println("검색실패 " + e1.getMessage());
			// }
			// }
		});

	}

	
	/////*******화면**********/////// 
	private void addLayout() {
		tfcustaddr = new JTextField();
		tfcustName = new JTextField();
		tfcustTel = new JTextField();
		tfcustSearch = new JTextField();

		bcustDelete = new JButton("삭제");
		bcustInsert = new JButton("등록");
		bcustModify = new JButton("변경");

		String[] cbcustSearch = { "이름", "ID" };
		comcustSearch = new JComboBox(cbcustSearch);

		tbModelCust = new CustomerTableModel();
		tableCustomer = new JTable(tbModelCust);

		// **********화면 구성 ***************
		// 왼쪽 영역
		JPanel p_west = new JPanel();
		p_west.setLayout(new BorderLayout());
		// 왼쪽 가운데
		JPanel p_west_center = new JPanel();
		p_west_center.setLayout(null);

		// JLabel tellabel = new JLabel("전화번호(ID)");
		// BevelBorder border = new BevelBorder(BevelBorder.RAISED);
		// tellabel.setBorder(border);
		// p_west_center.add(tellabel);

		JLabel label = new JLabel("전화번호(ID)");
		label.setBounds(12, 49, 77, 40);
		p_west_center.add(label);
		p_west_center.add(tfcustTel);
		tfcustTel.setBounds(90, 59, 123, 21);
		JLabel label_1 = new JLabel("이       름");
		label_1.setBounds(12, 119, 77, 40);
		p_west_center.add(label_1);
		p_west_center.add(tfcustName);
		tfcustName.setBounds(90, 129, 123, 21);
		JLabel label_2 = new JLabel("주       소");
		label_2.setBounds(12, 186, 77, 48);
		p_west_center.add(label_2);
		p_west_center.add(tfcustaddr);
		tfcustaddr.setBounds(90, 200, 123, 21);
		p_west_center.setBorder(new TitledBorder("회원 정보 입력"));

		// 왼쪽 가운데의 아래쪽
		JPanel p_west_center_south = new JPanel();
		p_west_center_south.setLayout(new GridLayout(1, 3));
		p_west_center_south.add(bcustInsert);
		p_west_center_south.add(bcustDelete);
		p_west_center_south.add(bcustModify);
		p_west.add(p_west_center, BorderLayout.CENTER);
		p_west.add(p_west_center_south, BorderLayout.SOUTH);

		// 화면구성 - 오른쪽영역
		JPanel p_east = new JPanel();
		p_east.setLayout(new BorderLayout());

		// 회원 검색 영역
		JPanel p_east_north = new JPanel();
		p_east_north.setBorder(new TitledBorder("회원 검색"));

		p_east.add(p_east_north, BorderLayout.NORTH);
		GroupLayout gl_p_east_north = new GroupLayout(p_east_north);
		gl_p_east_north.setHorizontalGroup(gl_p_east_north.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_p_east_north.createSequentialGroup().addGap(28)
						.addComponent(comcustSearch, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(tfcustSearch, GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE).addContainerGap()));
		gl_p_east_north.setVerticalGroup(gl_p_east_north.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_p_east_north.createSequentialGroup().addGap(5)
						.addGroup(gl_p_east_north.createParallelGroup(Alignment.BASELINE)
								.addComponent(tfcustSearch, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(comcustSearch, GroupLayout.PREFERRED_SIZE, 21,
										GroupLayout.PREFERRED_SIZE))));
		p_east_north.setLayout(gl_p_east_north);

		// 테이블을 붙일때에는 반드시 JScrollPane() 이렇게 해야함 그래야 화면에 보임.
		p_east.add(new JScrollPane(tableCustomer), BorderLayout.CENTER);
		// 전체 화면에 왼쪽 오른쪽 붙이기
		setLayout(new GridLayout(1, 2));
		add(p_west);
		add(p_east);
	}
	
	
	
	/////*******이벤트 수행 **********/////// 
	public void actionPerformed(ActionEvent e) {
		Object evt = e.getSource();
		if (evt == bcustInsert) {
			System.out.println("회원등록");
		} else if (evt == bcustModify) {
			System.out.println("회원수정");
		} else if (evt == bcustDelete) {
			System.out.println("회원삭제");
		}
	}

}
