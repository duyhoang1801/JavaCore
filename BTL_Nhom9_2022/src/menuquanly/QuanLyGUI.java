package menuquanly;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Tile1.TileGUI;
import computerql.ComputerGUI;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;

import housingql.HousingGUI;
import login.LoginGUI;
import tile2.Tile2GUI;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class QuanLyGUI extends JFrame {
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					 = new QuanLyGUI();
//					frame.setVisible(true);
//					
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public QuanLyGUI() {
		
		this.setResizable(false);
		this.setTitle("Management");
		this.setLocationRelativeTo(null);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 796, 483);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton_5 = new JButton("EXIT");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		JButton btnNewButton_6 = new JButton("Information Team");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InformationTeam.frame.setVisible(true);
				InformationTeam.frame.setLocationRelativeTo(null);
			}
		});
		btnNewButton_6.setBackground(new Color(255, 255, 240));
		btnNewButton_6.setForeground(new Color(0, 139, 139));
		btnNewButton_6.setFont(new Font("Roboto", Font.BOLD, 12));
		btnNewButton_6.setBounds(625, 406, 147, 29);
		contentPane.add(btnNewButton_6);
		btnNewButton_5.setForeground(new Color(0, 128, 128));
		btnNewButton_5.setBackground(new Color(240, 255, 255));
		btnNewButton_5.setFont(new Font("Roboto", Font.BOLD, 12));
		btnNewButton_5.setBounds(369, 406, 107, 29);
		contentPane.add(btnNewButton_5);
		
		JButton btnNewButton_4 = new JButton("LOG OUT");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginGUI lg = new LoginGUI();
				lg.setVisible(true);	
				lg.setLocationRelativeTo(null);
				QuanLyGUI.this.dispose();
			}
		});
		btnNewButton_4.setForeground(new Color(0, 139, 139));
		btnNewButton_4.setFont(new Font("Roboto", Font.BOLD, 12));
		btnNewButton_4.setBackground(new Color(240, 255, 255));
		btnNewButton_4.setBounds(268, 406, 102, 29);
		contentPane.add(btnNewButton_4);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBackground(new Color(0, 204, 204));
		lblNewLabel_1.setIcon(new ImageIcon(QuanLyGUI.class.getResource("hy.jpg")));
		lblNewLabel_1.setBounds(0, 112, 782, 334);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Housing Management");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(LoginGUI.checkUser() == 0 | LoginGUI.checkUser() == 4) {
					HousingGUI hv;
					try {
						hv = new HousingGUI();
						hv.setVisible(true);
						hv.setLocationRelativeTo(null);
						QuanLyGUI.this.dispose();
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				else {
					JOptionPane.showMessageDialog(contentPane, "You do not have permission to use this function!", "Notification", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Roboto", Font.BOLD, 15));
		btnNewButton.setBackground(new Color(0, 204, 255));
		btnNewButton.setBounds(0, 71, 199, 41);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Computer Management");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(LoginGUI.checkUser() == 2 | LoginGUI.checkUser() == 4) {
					ComputerGUI cg;
					try {
						cg = new ComputerGUI();
						cg.setVisible(true);
						cg.setLocationRelativeTo(null);
						QuanLyGUI.this.dispose();
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				else {
					JOptionPane.showMessageDialog(contentPane, "You do not have permission to use this function!", "Notification", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setFont(new Font("Roboto", Font.BOLD, 15));
		btnNewButton_1.setBackground(new Color(0, 204, 255));
		btnNewButton_1.setBounds(388, 71, 199, 41);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Tile_1 Management");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(LoginGUI.checkUser() == 1 | LoginGUI.checkUser() == 4) {
					TileGUI tg;
					try {
						tg = new TileGUI();
						tg.setVisible(true);
						tg.setLocationRelativeTo(null);
						QuanLyGUI.this.dispose();
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				else {
					JOptionPane.showMessageDialog(contentPane, "You do not have permission to use this function!", "Notification", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		btnNewButton_2.setFont(new Font("Roboto", Font.BOLD, 15));
		btnNewButton_2.setBackground(new Color(0, 204, 255));
		btnNewButton_2.setBounds(191, 71, 199, 41);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Tile_2 Management");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(LoginGUI.checkUser() == 3 | LoginGUI.checkUser() == 4) {
					Tile2GUI tg2;
					try {
						tg2 = new Tile2GUI();
						tg2.setVisible(true);
						tg2.setLocationRelativeTo(null);
						QuanLyGUI.this.dispose();
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else {
					JOptionPane.showMessageDialog(contentPane, "You do not have permission to use this function!", "Notification", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		btnNewButton_3.setForeground(new Color(255, 255, 255));
		btnNewButton_3.setFont(new Font("Roboto", Font.BOLD, 15));
		btnNewButton_3.setBackground(new Color(0, 204, 255));
		btnNewButton_3.setBounds(583, 71, 199, 41);
		contentPane.add(btnNewButton_3);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(72, 209, 204));
		panel_1.setBounds(0, 11, 782, 60);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("MANAGEMENT SYSTEM");
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 22));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 5, 769, 44);
		panel_1.add(lblNewLabel);
		
		//Set icon
		URL ic = QuanLyGUI.class.getResource("mnicon.png");
		Image img = Toolkit.getDefaultToolkit().createImage(ic);
		this.setIconImage(img);
	}
}
