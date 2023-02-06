package Controller.Sample2;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Dao.implMember;
import Model.member;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextArea;

public class addMemberUI extends JFrame {

	private JPanel contentPane;
	private JTextField username;
	private JTextField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addMemberUI frame = new addMemberUI();
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
	public addMemberUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea show = new JTextArea();
		show.setBounds(104, 204, 233, 47);
		contentPane.add(show);
		
		JLabel lblNewLabel = new JLabel("帳號");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(104, 81, 70, 31);
		contentPane.add(lblNewLabel);
		
		username = new JTextField();
		username.setBounds(184, 81, 136, 31);
		contentPane.add(username);
		username.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("註冊");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(137, 28, 98, 43);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("密碼");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(104, 122, 70, 31);
		contentPane.add(lblNewLabel_2);
		
		password = new JTextField();
		password.setColumns(10);
		password.setBounds(184, 122, 136, 31);
		contentPane.add(password);
		
		JButton add = new JButton("註冊");
		add.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String Username=username.getText();
				String Password=password.getText();
				
				boolean b=new implMember().queryUser(Username);
				if(b) {
					show.setText("已註冊的帳號");
				}
				else {
					member m=new member(null,Username,Password,null,null,null);
					new implMember().add(m);
					show.setText("註冊成功");
				}
			}
		});
		add.setBounds(114, 163, 98, 31);
		contentPane.add(add);
		
		JButton back = new JButton("返回登入");
		back.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				loginUI l=new loginUI();
				l.show();
				dispose();
			}
		});
		back.setBounds(222, 163, 98, 31);
		contentPane.add(back);
	}
}
