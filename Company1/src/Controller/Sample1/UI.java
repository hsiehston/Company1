package Controller.Sample1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Dao.implMember;
import Model.member;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class UI extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField username;
	private JTextField password;
	private JTextField address;
	private JTextField mobile;
	private JTextField phone;
	private JTextField id2;
	private JTextField rename;
	private JTextField id1;
	private JTextField address1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UI frame = new UI();
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
	public UI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 202));
		panel.setBounds(48, 50, 211, 428);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("名子");
		lblNewLabel.setBounds(10, 39, 60, 32);
		panel.add(lblNewLabel);
		
		name = new JTextField();
		name.setBounds(80, 39, 109, 27);
		panel.add(name);
		name.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("帳號");
		lblNewLabel_1.setBounds(10, 90, 60, 32);
		panel.add(lblNewLabel_1);
		
		username = new JTextField();
		username.setColumns(10);
		username.setBounds(80, 90, 109, 27);
		panel.add(username);
		
		JLabel lblNewLabel_2 = new JLabel("密碼");
		lblNewLabel_2.setBounds(10, 143, 60, 32);
		panel.add(lblNewLabel_2);
		
		password = new JTextField();
		password.setColumns(10);
		password.setBounds(80, 143, 109, 27);
		panel.add(password);
		
		JLabel lblNewLabel_3 = new JLabel("地址");
		lblNewLabel_3.setBounds(10, 197, 60, 32);
		panel.add(lblNewLabel_3);
		
		address = new JTextField();
		address.setColumns(10);
		address.setBounds(80, 197, 109, 27);
		panel.add(address);
		
		JLabel lblNewLabel_4 = new JLabel("行動");
		lblNewLabel_4.setBounds(10, 250, 60, 32);
		panel.add(lblNewLabel_4);
		
		mobile = new JTextField();
		mobile.setColumns(10);
		mobile.setBounds(80, 250, 109, 27);
		panel.add(mobile);
		
		JLabel lblNewLabel_5 = new JLabel("電話");
		lblNewLabel_5.setBounds(10, 306, 60, 32);
		panel.add(lblNewLabel_5);
		
		phone = new JTextField();
		phone.setColumns(10);
		phone.setBounds(80, 306, 109, 27);
		panel.add(phone);
		
		JButton add = new JButton("新增");
		add.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String Name=name.getText();
				String Username=username.getText();
				String Password=password.getText();
				String Address=address.getText();
				String Mobile=mobile.getText();
				String Phone=phone.getText();
				member m=new member(Name,Username,Password,Address,Mobile,Phone);
				
				new implMember().add(m);
				
			}
		});
		add.setBounds(10, 353, 109, 37);
		panel.add(add);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 202));
		panel_1.setBounds(269, 50, 673, 428);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel total = new JLabel("");
		total.setHorizontalAlignment(SwingConstants.CENTER);
		total.setBounds(32, 392, 100, 26);
		panel_1.add(total);
		
		JTextArea show = new JTextArea();
		show.setBounds(32, 208, 594, 174);
		panel_1.add(show);
		
		id2 = new JTextField();
		id2.setBounds(222, 157, 78, 42);
		panel_1.add(id2);
		id2.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("ID");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setBounds(166, 156, 46, 42);
		panel_1.add(lblNewLabel_6);
		
		JLabel lblNewLabel_6_1 = new JLabel("名");
		lblNewLabel_6_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6_1.setBounds(295, 104, 46, 42);
		panel_1.add(lblNewLabel_6_1);
		
		rename = new JTextField();
		rename.setColumns(10);
		rename.setBounds(359, 105, 119, 42);
		panel_1.add(rename);
		
		JLabel lblNewLabel_6_2 = new JLabel("ID");
		lblNewLabel_6_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6_2.setBounds(166, 104, 46, 42);
		panel_1.add(lblNewLabel_6_2);
		
		id1 = new JTextField();
		id1.setColumns(10);
		id1.setBounds(222, 105, 78, 42);
		panel_1.add(id1);
		
		JButton update = new JButton("修改");
		update.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				String Name=rename.getText();
				String Address=address1.getText();
				
				int ID=Integer.parseInt(id1.getText());
				
				member m=new implMember().queryId(ID);
				
				m.setName(Name);
				m.setAddress(Address);
				
				new implMember().update(m);				
				
			}
		});
		update.setBounds(32, 104, 130, 42);
		panel_1.add(update);
		
		JButton btnNewButton_2 = new JButton("查詢");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				show.setText(new implMember().queryAll1()); 
				
				List<member> l=new implMember().queryAll2();
				total.setText("共:"+l.size()+"筆");
			}
		});
		btnNewButton_2.setBounds(32, 47, 130, 42);
		panel_1.add(btnNewButton_2);
		
		JButton delete = new JButton("刪除");
		delete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new implMember().delete(Integer.parseInt(id2.getText()));
			}
		});
		delete.setBounds(32, 156, 130, 42);
		panel_1.add(delete);
		
		JLabel lblNewLabel_6_1_1 = new JLabel("地址");
		lblNewLabel_6_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6_1_1.setBounds(480, 104, 46, 42);
		panel_1.add(lblNewLabel_6_1_1);
		
		address1 = new JTextField();
		address1.setColumns(10);
		address1.setBounds(544, 105, 119, 42);
		panel_1.add(address1);
	}
}
