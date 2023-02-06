package Controller.Sample2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Dao.implMember;
import Model.member;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class loginUI extends JFrame {

	private JPanel contentPane;
	private JTextField username;
	private JPasswordField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					loginUI frame = new loginUI();
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
	public loginUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(200, 255, 255));
		panel.setBounds(56, 51, 316, 173);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("帳號");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(50, 31, 79, 34);
		panel.add(lblNewLabel);
		
		username = new JTextField();
		username.setBounds(132, 31, 114, 34);
		panel.add(username);
		username.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("密碼");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(50, 75, 79, 34);
		panel.add(lblNewLabel_1);
		
		password = new JPasswordField();
		password.setBounds(132, 75, 114, 34);
		panel.add(password);
		
		JButton login = new JButton("登入");
		login.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String Username=username.getText();
				String Password=password.getText();
				
				member m=new implMember().queryMember(Username, Password);
				
				if(m!=null) {
					loginSuccess l=new loginSuccess();
					l.show();
					dispose();
				}
				else{
					loginError l=new loginError();
					l.show();
					dispose();
				}
			}
		});
		login.setBounds(77, 119, 95, 28);
		panel.add(login);
		
		JButton add = new JButton("註冊");
		add.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				addMemberUI a=new addMemberUI();
				a.show();
				dispose();
			}
		});
		add.setBounds(183, 119, 95, 28);
		panel.add(add);
	}
}
