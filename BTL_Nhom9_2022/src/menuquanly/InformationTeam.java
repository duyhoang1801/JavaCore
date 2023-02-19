package menuquanly;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import housingql.HousingGUI;

import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.net.URL;
import java.awt.event.ActionEvent;

public class InformationTeam extends JFrame {
	private JPanel contentPane;
	static InformationTeam frame = new InformationTeam();

	/**
	 * Create the frame.
	 */
	public InformationTeam() {
		this.setTitle("Information");
		this.setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 521, 362);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(138, 170, 229));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_6 = new JLabel("NHÓM 9");
		lblNewLabel_6.setBackground(new Color(255, 255, 255));
		lblNewLabel_6.setForeground(new Color(255, 255, 255));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setFont(new Font("Segoe UI Black", Font.BOLD, 22));
		lblNewLabel_6.setBounds(0, 11, 507, 36);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel = new JLabel("Nguyễn Thế Hưng - Housing Management");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel.setBounds(186, 145, 266, 28);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Hoàng Hữu Duy - Computer Management");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_1.setBounds(186, 185, 266, 28);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Trần Viết Cường - Tile1 Management");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_2.setBounds(186, 225, 249, 28);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Nguyễn Chí Dũng - Tile2 Management");
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_3.setBounds(186, 265, 249, 28);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Giảng viên hướng dẫn");
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_4.setBounds(10, 72, 148, 28);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Hoàng Quang Huy");
		lblNewLabel_5.setForeground(new Color(255, 255, 255));
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_5.setBounds(186, 72, 148, 28);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_7 = new JLabel("Sinh viên thực hiện");
		lblNewLabel_7.setForeground(new Color(255, 255, 255));
		lblNewLabel_7.setBackground(new Color(243, 85, 60));
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_7.setBounds(10, 145, 148, 28);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("IT6019.3 - 20221IT6019003");
		lblNewLabel_8.setForeground(new Color(255, 255, 255));
		lblNewLabel_8.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_8.setBounds(186, 106, 182, 28);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_7_1 = new JLabel("Lớp");
		lblNewLabel_7_1.setForeground(Color.WHITE);
		lblNewLabel_7_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_7_1.setBackground(new Color(243, 85, 60));
		lblNewLabel_7_1.setBounds(10, 106, 106, 28);
		contentPane.add(lblNewLabel_7_1);
		
		//Set icon
		URL ic = InformationTeam.class.getResource("iticon.png");
		Image img = Toolkit.getDefaultToolkit().createImage(ic);
		this.setIconImage(img);
	}
}
