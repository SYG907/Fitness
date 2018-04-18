package test;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;

public class FitnessShop extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FitnessShop frame = new FitnessShop();
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
	public FitnessShop() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 537, 510);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		JTabbedPane CustomerView = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addTab("고객관리", null, CustomerView, null);
		
		JTabbedPane EmployeeView = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addTab("직원관리", null, EmployeeView, null);
		
		JTabbedPane ProgramView = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addTab("프로그램관리", null, ProgramView, null);
		
		JTabbedPane PayView = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addTab("결제 및 매출관리", null, PayView, null);
	}

}
