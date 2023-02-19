package login;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import menuquanly.QuanLyGUI;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;

import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class LoginGUI extends JFrame {	
	public static ArrayList<User> u = new ArrayList<>();
	private JPanel contentPane;
	public static JTextField textUserName;
	private JPasswordField passwordField;
	UserData us = new UserData();
	

	/**
	 * Create the frame.
	 */
	public LoginGUI() {
		this.setTitle("Login");
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		
		u = UserData.generateUser();
		UserData.fileWrite(u);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(175, 238, 238));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("NHÓM 9");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Georgia", Font.BOLD, 20));
		lblNewLabel.setBounds(10, 23, 198, 29);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setFont(new Font("Roboto", Font.BOLD, 20));
		lblNewLabel_1.setBounds(24, 79, 156, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Khoa Công Nghệ Thông Tin");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Roboto", Font.BOLD, 15));
		lblNewLabel_2.setBounds(0, 70, 208, 33);
		panel.add(lblNewLabel_2);

		JLabel lblIcon = new JLabel();
		lblIcon.setHorizontalAlignment(SwingConstants.CENTER);
		lblIcon.setBounds(45, 114, 127, 127);
		lblIcon.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(LoginGUI.class.getResource("logo.png"))));
		panel.add(lblIcon);
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("User Name");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3.setBounds(10, 94, 75, 14);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Password");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4.setBounds(10, 130, 75, 14);
		panel_1.add(lblNewLabel_4);
		
		textUserName = new JTextField();
		textUserName.setBounds(90, 92, 113, 20);
		panel_1.add(textUserName);
		textUserName.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(90, 128, 113, 20);
		panel_1.add(passwordField);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ArrayList<User> lst = new ArrayList<>();
				try {
					lst = UserData.fileRead();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				String username = textUserName.getText();
				String password = new String(passwordField.getPassword());
				
				if(username.equals("") | password.equals("")) {
					JOptionPane.showMessageDialog(btnNewButton, "Username or password is empty");
				} else {
					for(int i=0; i<lst.size(); i++) {
						if(username.equals(lst.get(i).getUsername()) && password.equals(lst.get(i).getPassword())) {
							QuanLyGUI qlv = new QuanLyGUI();
							qlv.setVisible(true);
							qlv.setLocationRelativeTo(null);
							LoginGUI.this.dispose();
							break;
						} 
						if(i == lst.size()-1) {
							JOptionPane.showMessageDialog(btnNewButton, "Username or Password is not correct");
							xoaForm();
							break;
						}
					}
				}			
				
			}
		});
		btnNewButton.setBackground(new Color(211, 211, 211));
		btnNewButton.setBounds(10, 173, 89, 23);
		panel_1.add(btnNewButton);
		
		
		
		JButton btnNewButton_1 = new JButton("Exit");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton_1.setBackground(new Color(211, 211, 211));
		btnNewButton_1.setBounds(114, 173, 89, 23);
		panel_1.add(btnNewButton_1);
		
		JLabel lblNewLabel_5 = new JLabel("Đăng Nhập");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setFont(new Font("Roboto", Font.BOLD, 20));
		lblNewLabel_5.setBounds(10, 24, 193, 32);
		panel_1.add(lblNewLabel_5);
		
		//Set Icon
		URL ic = LoginGUI.class.getResource("login.png");
		Image img = Toolkit.getDefaultToolkit().createImage(ic);
		this.setIconImage(img);
	}
	
	void xoaForm() {
		textUserName.setText("");
		passwordField.setText("");
	}
	
	public static int checkUser() {
		int t=0;
		ArrayList<User> lt = new ArrayList<>();
		try {
			lt = UserData.fileRead();
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String username = textUserName.getText();
		for(int i=0; i<lt.size(); i++) {
			if(lt.get(i).getUsername().equals(username)) {
				t=i;
			}
		}		
		return t;
	}
}
