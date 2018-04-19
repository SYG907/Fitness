package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import javax.swing.border.TitledBorder;

import Model.SalesModel;
import Model.SalesTableModel;

import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

//import Model.SalesModel;
//import Model.SalesTableModel;
//import Model.vo.Sales;

public class SalesView extends JPanel {

	JTextField tfpay_No, tfReg_No, tfPay_price, tfReturn_Price;
	JButton bPay, bcancle, bDay, bYear, bMonth, bSearch;

	JTable tableSales;
	JComboBox CBYear, CBDay, CBMonth;
	JCheckBox ChbPayCard, ChbPayCash;
	JRadioButton ChbReturn;

	SalesTableModel tbModelSales; // 테이블다루는 클래스 변수 선언
	SalesModel model;

	public SalesView() { // 생성자 함수
		addLayout(); // 화면설계
		eventProc(); // 이벤트 등록
		connectDB(); // DB연결
	}

	private void addLayout() {
		tfpay_No = new JTextField();
		tfReg_No = new JTextField();
		tfPay_price = new JTextField();
		tfReturn_Price = new JTextField();

		bcancle = new JButton("취소");
		bPay = new JButton("결제");
		bYear = new JButton("년");
		bMonth = new JButton("월");
		bDay = new JButton("일");
		bSearch = new JButton("검색");

		String[] cbYear = { "2018", "2017" };
		CBYear = new JComboBox(cbYear);

		String[] cbMonth = { "1", "2", "3", "4" };
		CBMonth = new JComboBox(cbMonth);

		String[] cbDay = { "1", "2", "3" };
		CBDay = new JComboBox(cbDay);

		tbModelSales = new SalesTableModel();
		tableSales = new JTable(tbModelSales);

		// **********화면 구성 ***************
		// 왼쪽 영역
		JPanel jp = new JPanel();
		JPanel p_west = new JPanel();
		p_west.setLayout(new BorderLayout());
		// 왼쪽 가운데
		JPanel p_west_center = new JPanel();

		JLabel label = new JLabel("결제 번호");
		label.setBounds(12, 49, 77, 40);
		tfpay_No.setBounds(90, 59, 123, 21);

		JLabel label_1 = new JLabel("등록 번호");
		label_1.setBounds(12, 119, 77, 40);
		tfReg_No.setBounds(90, 129, 123, 21);

		JLabel label_2 = new JLabel("결제 방법");
		label_2.setBounds(12, 199, 77, 40);

		ChbPayCard = new JCheckBox("카드");
		ChbPayCash = new JCheckBox("현금");

		JLabel label_3 = new JLabel("결제 금액");
		label_3.setBounds(12, 269, 77, 40);
		tfPay_price.setBounds(90, 200, 123, 21);

		ChbReturn = new JRadioButton("환불 하시겠습니까?");

		JLabel label_4 = new JLabel("환불 금액");
		label_4.setBounds(12, 269, 77, 40);
		tfReturn_Price.setBounds(90, 200, 123, 21);

		p_west_center.setBorder(new TitledBorder("결제/ 환불 정보 입력"));

		// 왼쪽 가운데의 아래쪽
		JPanel p_west_center_south = new JPanel();
		p_west_center_south.setLayout(new GridLayout(1, 2));
		p_west_center_south.add(bPay);
		p_west_center_south.add(bcancle);
		p_west.add(p_west_center, BorderLayout.CENTER);
		GroupLayout gl_p_west_center = new GroupLayout(p_west_center);
		gl_p_west_center
				.setHorizontalGroup(gl_p_west_center.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_p_west_center.createSequentialGroup().addContainerGap()
								.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(tfReturn_Price, GroupLayout.PREFERRED_SIZE, 137,
										GroupLayout.PREFERRED_SIZE)
								.addContainerGap())
						.addGroup(
								gl_p_west_center.createSequentialGroup().addContainerGap(34, Short.MAX_VALUE)
										.addComponent(ChbReturn, GroupLayout.PREFERRED_SIZE, 155,
												GroupLayout.PREFERRED_SIZE)
										.addGap(28))
						.addGroup(
								gl_p_west_center.createSequentialGroup()
										.addComponent(label_1, GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(tfReg_No, GroupLayout.PREFERRED_SIZE, 131,
												GroupLayout.PREFERRED_SIZE)
										.addContainerGap())
						.addGroup(gl_p_west_center.createSequentialGroup()
								.addComponent(label, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(tfpay_No, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
								.addContainerGap())
						.addGroup(Alignment.LEADING, gl_p_west_center.createSequentialGroup()
								.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(ChbPayCard, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(ChbPayCash, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
								.addContainerGap(22, Short.MAX_VALUE))
						.addGroup(Alignment.LEADING,
								gl_p_west_center.createSequentialGroup().addComponent(label_3).addGap(30)
										.addComponent(tfPay_price, GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
										.addContainerGap()));
		gl_p_west_center.setVerticalGroup(gl_p_west_center.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_p_west_center.createSequentialGroup().addGap(36)
						.addGroup(gl_p_west_center.createParallelGroup(Alignment.BASELINE)
								.addComponent(label, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
								.addComponent(tfpay_No, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_p_west_center.createParallelGroup(Alignment.BASELINE).addComponent(label_1)
								.addComponent(tfReg_No, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_p_west_center.createParallelGroup(Alignment.BASELINE)
								.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
								.addComponent(ChbPayCard).addComponent(ChbPayCash))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_p_west_center.createParallelGroup(Alignment.BASELINE)
								.addComponent(tfPay_price, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
						.addGap(18).addComponent(ChbReturn).addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_p_west_center.createParallelGroup(Alignment.BASELINE)
								.addComponent(label_4, GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE).addComponent(
										tfReturn_Price, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGap(13)));
		p_west_center.setLayout(gl_p_west_center);
		p_west.add(p_west_center_south, BorderLayout.SOUTH);

		// 화면구성 - 오른쪽영역
		JPanel p_east = new JPanel();
		p_east.setLayout(new BorderLayout());

		// 오른쪽 상단
		JPanel p_east_north = new JPanel();
		p_east_north.setLayout(new GridLayout(1, 4));
		p_east_north.add(CBYear);
		p_east_north.add(CBDay);
		p_east_north.add(CBMonth);
		p_east_north.add(bSearch);

		JPanel p_east_south = new JPanel();
		p_east_south.setLayout(new GridLayout(1, 3));

		p_east_south.add(bDay);
		p_east_south.add(bMonth);
		p_east_south.add(bYear);

		// 테이블을 붙일때에는 반드시 JScrollPane() 이렇게 해야함 그래야 화면에 보임.
		p_east.add(new JScrollPane(tableSales), BorderLayout.CENTER);
		p_east.add(p_east_north, BorderLayout.NORTH);
		p_east.add(p_east_south, BorderLayout.SOUTH);

		// JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		// p_east.add(tabbedPane, BorderLayout.CENTER);
		// tabbedPane.add

		p_east.setBorder(new TitledBorder("매출 관리"));
		// 전체 화면에 왼쪽 오른쪽 붙이기

		setLayout(new GridLayout(1, 2));
		add(p_west);
		add(p_east);

	}

	///// ******* DB 연결**********///////
	private void connectDB() {
		try {
			// model = new CustomerModel();
			System.out.println("db연결 성공");
		} catch (Exception e) {
			System.out.println("회원 DB연결 실패 " + e.getMessage());
		}
	}

	///// *******이벤트 등록**********///////
	private void eventProc() {
		ButtonEventHandler btnHandler = new ButtonEventHandler();

		bPay.addActionListener(btnHandler);
		bcancle.addActionListener(btnHandler);
		// tableCustomer.addMouseListener(new MouseAdapter() {

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
		// });

	}

	class ButtonEventHandler implements ActionListener {

		///// *******이벤트 수행 **********///////
		public void actionPerformed(ActionEvent e) {
			Object evt = e.getSource();
			if (evt == bPay) {
				System.out.println("결제");
			} else if (evt == bcancle) {
				System.out.println("결제 취소");
			}
		}

	}
}
