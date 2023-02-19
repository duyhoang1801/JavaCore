package computerql;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import housingql.HousingGUI;
import login.LoginGUI;
import menuquanly.BarChartStatistic;
import menuquanly.QuanLyGUI;
import menuquanly.Statistic;
import menuquanly.TypeStatic;

import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;

public class ComputerGUI extends JFrame {
	public static List<Computer> list = new ArrayList<>();
	private Computer cmd = new Computer();
	Locale locale = new Locale("en", "EN");
	DecimalFormat decimalFormat = (DecimalFormat)NumberFormat.getNumberInstance(locale);
	private static int id;
	
	private JPanel contentPane;
	private JLabel lblNewLabel2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JTextField textName;
	private JTextField textPrice;
	private JTextField textTotal;
	private JTextField textConfig;
	private JTextField textYear;
	private JTable table = new JTable();
	private JScrollPane scrollPane;
	private DefaultTableModel tableModel = new DefaultTableModel();
	private JButton btnReset;
	private JComboBox comboBox;
	private JTextField textSearch;
	private JTextField textStatus;
	private JButton btnSearch;
	private JComboBox cbSort;
	private JButton btnSort;
	private JComboBox cbIsNC;
	private JTable tableStatistic = new JTable();
	private DefaultTableModel tableModel_S = new DefaultTableModel();
	/**
	 * @wbp.nonvisual location=-60,454
	 */
	private final JTextField textField = new JTextField();
	private static List<TypeStatic> listT = new ArrayList<>();
	
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ComputerGUI frame = new ComputerGUI();
//					frame.setTitle("Computer Management");
//					frame.setVisible(true);
//					frame.setLocationRelativeTo(null);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
	
	/**
	 * Create the frame.
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public ComputerGUI() throws IOException, ClassNotFoundException {
		
		this.setResizable(false);
		this.setTitle("Computer Management");
		this.setLocationRelativeTo(null);
		
		list = Computer.generatedComputer(20);
		FileComputer.binaryOutputFile(list);
		
		textField.setToolTipText("");
		textField.setColumns(10);
		initTable();
		initTableS();
		list = FileComputer.binaryInputFile();
		fillTable(list);
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 759, 677);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(255, 255, 255));
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("File");
		mnNewMenu.setFont(new Font("Roboto", Font.PLAIN, 12));
		mnNewMenu.setSelectedIcon(null);
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Log out");
		mntmNewMenuItem_1.setFont(new Font("Roboto", Font.PLAIN, 12));
		mntmNewMenuItem_1.setIcon(new ImageIcon(HousingGUI.class.getResource("/login/logoutIC.png")));
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginGUI lg = new LoginGUI();
				lg.setVisible(true);	
				lg.setLocationRelativeTo(null);
				ComputerGUI.this.dispose();
			}
		});
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Managements System");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QuanLyGUI qlv = new QuanLyGUI();
				qlv.setVisible(true);
				qlv.setLocationRelativeTo(null);
				ComputerGUI.this.dispose();
			}
		});
		mntmNewMenuItem_3.setFont(new Font("Roboto", Font.PLAIN, 12));
		mntmNewMenuItem_3.setIcon(new ImageIcon(HousingGUI.class.getResource("/login/MenuIC.png")));
		mnNewMenu.add(mntmNewMenuItem_3);
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Exit");
		mntmNewMenuItem.setIcon(new ImageIcon(HousingGUI.class.getResource("/login/exitIcon.png")));
		mntmNewMenuItem.setFont(new Font("Roboto", Font.PLAIN, 12));
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenu mnNewMenu_1 = new JMenu("Help");
		mnNewMenu_1.setFont(new Font("Roboto", Font.PLAIN, 12));
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Information");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(contentPane, "Program created by Hoang Huu Duy_230", "Information", JOptionPane.PLAIN_MESSAGE);
			}
		});
		mntmNewMenuItem_2.setIcon(new ImageIcon(HousingGUI.class.getResource("/login/inforIC.png")));
		mntmNewMenuItem_2.setFont(new Font("Roboto", Font.PLAIN, 12));
		mnNewMenu_1.add(mntmNewMenuItem_2);
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 230, 140));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnExit = new JButton("EXIT ");
		btnExit.setForeground(new Color(255, 255, 255));
		btnExit.setBackground(new Color(255, 99, 71));
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		textStatus = new JTextField();
		textStatus.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		textStatus.setBounds(10, 349, 730, 23);
		contentPane.add(textStatus);
		textStatus.setColumns(10);

		btnExit.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnExit.setBounds(381, 588, 158, 25);
		contentPane.add(btnExit);

		JLabel lblNewLabel = new JLabel("COMPUTER MANAGEMENT");
		lblNewLabel.setForeground(new Color(255, 99, 71));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblNewLabel.setBounds(180, 0, 381, 41);
		contentPane.add(lblNewLabel);
		
		lblNewLabel2 = new JLabel("Total of Computers");
		lblNewLabel2.setForeground(new Color(0, 0, 0));
		lblNewLabel2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel2.setBounds(10, 121, 169, 28);
		contentPane.add(lblNewLabel2);
		
		lblNewLabel_3 = new JLabel("Computer Name");
		lblNewLabel_3.setForeground(new Color(0, 0, 0));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setBounds(10, 41, 149, 28);
		contentPane.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Computer Price ($)");
		lblNewLabel_4.setForeground(new Color(0, 0, 0));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_4.setBounds(10, 81, 169, 28);
		contentPane.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("Computer Config");
		lblNewLabel_5.setForeground(new Color(0, 0, 0));
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_5.setBounds(10, 161, 169, 28);
		contentPane.add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("Manufacture Year");
		lblNewLabel_6.setForeground(new Color(0, 0, 0));
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_6.setBounds(10, 201, 169, 28);
		contentPane.add(lblNewLabel_6);
		
		textName = new JTextField();
		textName.setForeground(new Color(255, 99, 71));
		textName.setToolTipText("");
		textName.setColumns(10);
		textName.setBounds(153, 48, 181, 20);
		contentPane.add(textName);
		
		textPrice = new JTextField();
		textPrice.setForeground(new Color(255, 99, 71));
		textPrice.setColumns(10);
		textPrice.setBounds(153, 88, 181, 20);
		contentPane.add(textPrice);

		textTotal = new JTextField();
		textTotal.setForeground(new Color(255, 99, 71));
		textTotal.setColumns(10);
		textTotal.setBounds(153, 128, 181, 20);
		contentPane.add(textTotal);
		
		textConfig = new JTextField();
		textConfig.setForeground(new Color(255, 99, 71));
		textConfig.setColumns(10);
		textConfig.setBounds(153, 168, 181, 20);
		contentPane.add(textConfig);
		
		textYear = new JTextField();
		textYear.setForeground(new Color(255, 99, 71));
		textYear.setColumns(10);
		textYear.setBounds(153, 208, 181, 20);
		contentPane.add(textYear);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setForeground(new Color(255, 255, 255));
		btnAdd.setBackground(new Color(255, 99, 71));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!checkValidData()) {
					return;
				}
				int ID = list.get(list.size()-1).getProduct_id() + 1;
				Computer com = new Computer();
				com.setProduct_id(ID);
				com.setProduct_name(textName.getText().trim());
				com.setProduct_price(Double.valueOf(textPrice.getText().trim()));
				com.setProduct_total(Integer.valueOf(textTotal.getText().trim()));
				com.setConfig(textConfig.getText().trim());
				com.setManufacture_year(Integer.valueOf(textYear.getText().trim()));
				for (Computer c : list) {
					if (com.getProduct_name().compareTo(c.getProduct_name()) == 0) {
						JOptionPane.showMessageDialog(contentPane, "Computer already exist!", "Error", JOptionPane.ERROR_MESSAGE);
						return;
					}
				}
				list.add(com);
				JOptionPane.showMessageDialog(contentPane, "Add Success", "Successful", JOptionPane.PLAIN_MESSAGE);
				textStatus.setText("Add Success!!! Add Information: " + ID +  ", " + textName.getText() + ", " + textPrice.getText() + ", " + textTotal.getText() + ", " + textConfig.getText() + ", " + textYear.getText());
				StatusTimer();
				try {
					writeToFile();
					list = FileComputer.binaryInputFile();
					fillTable(list);
					resetField();
				} catch (IOException | ClassNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAdd.setBounds(10, 238, 80, 23);
		contentPane.add(btnAdd);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.setForeground(new Color(255, 255, 255));
		btnEdit.setBackground(new Color(255, 99, 71));
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!checkValidData()) {
					return;
				}
				int choice = JOptionPane.showConfirmDialog(contentPane, "Are you sure you want to fix it?", "Question", JOptionPane.YES_NO_OPTION);
				if (choice == JOptionPane.NO_OPTION || choice == JOptionPane.CLOSED_OPTION) {
					resetField();
					return;
				}
				String NAME = textName.getText().trim();
				double PRICE = Double.valueOf(textPrice.getText().trim());
				int TOTAL = Integer.valueOf(textTotal.getText().trim());
				String CONFIG = textConfig.getText().trim();
				int YEAR = Integer.valueOf(textYear.getText().trim());
				for (Computer c : list) {
					if (c.getProduct_id() == id) {
						c.setProduct_id(id);
						c.setProduct_name(NAME);
						c.setProduct_price(PRICE);
						c.setProduct_total(TOTAL);
						c.setConfig(CONFIG);
						c.setManufacture_year(YEAR);
						break;
					}
				}
				try {
					writeToFile();
					list = FileComputer.binaryInputFile();
					fillTable(list);
					resetField();
				} catch (IOException | ClassNotFoundException e2) {
					e2.printStackTrace();
				}
				JOptionPane.showMessageDialog(contentPane, "Edit Success", "Successful", JOptionPane.PLAIN_MESSAGE);
				textStatus.setText("Edit Success!!! Edit Information: " + id + ", " + NAME + ", " + PRICE + ", " + TOTAL + ", " + CONFIG + ", " + YEAR);
				StatusTimer();
			}	
		});
		btnEdit.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnEdit.setBounds(103, 238, 80, 23);
		contentPane.add(btnEdit);
		
		JButton btnDelete = new JButton("Del");
		btnDelete.setForeground(new Color(255, 255, 255));
		btnDelete.setBackground(new Color(255, 99, 71));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				if (row == -1) {
					JOptionPane.showMessageDialog(contentPane, "You have not selected to delete", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				int choice = JOptionPane.showConfirmDialog(contentPane, "Are you sure you want to delete it? " + (String)table.getValueAt(row, 0), "Question", JOptionPane.YES_NO_OPTION);
				if(choice == JOptionPane.NO_OPTION || choice == JOptionPane.CLOSED_OPTION) {
					return;
				}
				for (Computer com : list) {
					if (com.getProduct_id() == Integer.parseInt((String)table.getValueAt(row, 0))) {
						cmd.delComputer(com);
						break;
					}
				}
				JOptionPane.showMessageDialog(contentPane, "Delete Success", "Successful", JOptionPane.PLAIN_MESSAGE);
				textStatus.setText("Delete Success!!! Delete Computer Id: " + id );
				StatusTimer();
				try {
					writeToFile();
					list = FileComputer.binaryInputFile();
					fillTable(list);
					resetField();
				} catch (IOException | ClassNotFoundException e3) {
					e3.printStackTrace(); 
				}
			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnDelete.setBounds(196, 238, 80, 23);
		contentPane.add(btnDelete);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				textName.setText((String) table.getValueAt(row, 1));
				textPrice.setText(ComputerGUI.formatString((String)table.getValueAt(row, 2)));
				textTotal.setText((String) table.getValueAt(row, 3));
				textConfig.setText((String) table.getValueAt(row, 4));
				textYear.setText((String) table.getValueAt(row, 5));
				id = Integer.parseInt((String)table.getValueAt(row, 0));
			}
		});
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 381, 730, 203);
		JScrollBar vertical = scrollPane.getVerticalScrollBar();
		vertical.setValue( vertical.getMaximum());
		contentPane.add(scrollPane);
		scrollPane.setViewportView(table);		
		
		btnReset = new JButton("Reset");
		btnReset.setForeground(new Color(255, 255, 255));
		btnReset.setBackground(new Color(255, 99, 71));
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetAll();
			}
		});
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnReset.setBounds(289, 238, 89, 23);
		contentPane.add(btnReset);
		
		comboBox = new JComboBox();
		comboBox.setForeground(new Color(255, 99, 71));
		comboBox.setBackground(new Color(255, 255, 255));
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 12));
		comboBox.addItem(new Item("Search by Name", "name"));
		comboBox.addItem(new Item("Search by Price", "price"));
		comboBox.addItem(new Item("Search by Config", "config"));
		comboBox.addItem(new Item("Search by Year", "year"));
		comboBox.setBounds(10, 279, 142, 23);
		contentPane.add(comboBox);
		
		textSearch = new JTextField();
		textSearch.setBounds(153, 279, 126, 23);
		contentPane.add(textSearch);
		textSearch.setColumns(10);
		
		btnSearch = new JButton("Search");
		btnSearch.setForeground(new Color(255, 255, 255));
		btnSearch.setBackground(new Color(255, 99, 71));
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object item = comboBox.getSelectedItem();
				String value = ((Item)item).getValue();
				List<Computer> listSearch = new ArrayList<>();
				if (textSearch.getText().compareTo("") == 0) {
					JOptionPane.showMessageDialog(contentPane, "You have not entered the search value", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				String textInput = textSearch.getText().trim();
				if (value.compareTo("name") == 0) {
					listSearch = cmd.searchComputer(textSearch.getText());
					textStatus.setText("The list has been search by name: " + textInput);
					StatusTimer();
				} else if (value.compareTo("price") == 0) {
					try {
						double price = Double.parseDouble(textInput);
						if (price <= 0) {
							JOptionPane.showMessageDialog(contentPane, "Price must be greater than 0", "Error", JOptionPane.ERROR_MESSAGE);
						}
						listSearch = cmd.searchComputer(price);
						textStatus.setText("The list has been search by price: " + price);
						StatusTimer();
					} catch (Exception e4) {
						JOptionPane.showMessageDialog(contentPane, "Price must be real numbers", "Error", JOptionPane.ERROR_MESSAGE);
					}
				} else if (value.compareTo("config") == 0) {
					listSearch = cmd.searchComputerbyConfig(textInput);
					textStatus.setText("The list has been search by config: " + textInput);
					StatusTimer();
				} else if (value.compareTo("year") == 0) {
					try {
						int year = Integer.parseInt(textInput);
						if (year < 2000) {
							JOptionPane.showMessageDialog(contentPane, "Year of manufacture must be greater than 2000", "Error", JOptionPane.ERROR_MESSAGE);
						}
						listSearch = cmd.searchComputerbyYear(year);
						textStatus.setText("The list has been search by year: " + year);
						StatusTimer();
					} catch (Exception e5) {
						JOptionPane.showMessageDialog(contentPane, "Year must be whole numbers", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
				try {
					fillTable(listSearch);
					textSearch.setText("");
				} catch (IOException | ClassNotFoundException e6) {
					e6.printStackTrace();
				}	
			}
		});
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSearch.setBounds(289, 279, 89, 23);
		contentPane.add(btnSearch);
		
		cbSort = new JComboBox();
		cbSort.setForeground(new Color(255, 99, 71));
		cbSort.setBackground(new Color(255, 255, 255));
		cbSort.addItem(new Item("Sorted by Price", "price"));
		cbSort.addItem(new Item("Sorted by Config", "config"));
		cbSort.setFont(new Font("Tahoma", Font.BOLD, 12));
		cbSort.setBounds(10, 317, 142, 23);
		contentPane.add(cbSort);
		
		btnSort = new JButton("Sort");
		btnSort.setForeground(new Color(255, 255, 255));
		btnSort.setBackground(new Color(255, 99, 71));
		btnSort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int totalRow = table.getRowCount();
				int totalColumn = table.getColumnCount();
				List<Computer> listSort = new ArrayList<>();
				for (int i = 0; i < totalRow; i++) {
					Computer com = new Computer();
					com.setProduct_id(Integer.parseInt((String)table.getValueAt(i, 0)));
					com.setProduct_name((String)table.getValueAt(i, 1));
					com.setProduct_price(Double.parseDouble(ComputerGUI.formatString((String)table.getValueAt(i, 2))));
					com.setProduct_total(Integer.parseInt((String)table.getValueAt(i, 3)));
					com.setConfig((String)table.getValueAt(i, 4));
					com.setManufacture_year(Integer.parseInt((String)table.getValueAt(i, 5)));
					listSort.add(com);
				}
				
				Object itemSort = cbSort.getSelectedItem();
				String valueSort = ((Item)itemSort).getValue();
				
				Object itemIsNC = cbIsNC.getSelectedItem();
				String valueIsNC = ((Item)itemIsNC).getValue();
				
				if (valueSort.compareTo("price") == 0) {
					if (valueIsNC.compareTo("asc") == 0) {
						Collections.sort(listSort, new sortedByPrice());
						textStatus.setText("The list has been sorted in ascending order by price");	
						StatusTimer();
					} else {
						Collections.sort(listSort, new sortedByPrice().reversed());
						textStatus.setText("The list has been sorted in descending order by price");
						StatusTimer();
					}
				} else {
					if (valueIsNC.compareTo("asc") == 0) {
						Collections.sort(listSort, new sortedByConfig());
						textStatus.setText("The list has been sorted in ascending order by config");
						StatusTimer();
					} else {
						Collections.sort(listSort, new sortedByConfig().reversed());
						textStatus.setText("The list has been sorted in descending order by config");
						StatusTimer();
					}
				}
				try {
					fillTable(listSort);
				} catch (ClassNotFoundException | IOException e7) {
					e7.printStackTrace();
				}
			}
		});
		btnSort.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSort.setBounds(289, 317, 89, 23);
		contentPane.add(btnSort);
		
		cbIsNC = new JComboBox();
		cbIsNC.setForeground(new Color(255, 99, 71));
		cbIsNC.setBackground(new Color(255, 255, 255));
		cbIsNC.addItem(new Item("Ascending", "asc"));
		cbIsNC.addItem(new Item("Decreasing", "desc"));
		cbIsNC.setFont(new Font("Tahoma", Font.BOLD, 12));
		cbIsNC.setBounds(153, 317, 126, 23);
		contentPane.add(cbIsNC);	
		
		
		JButton btnNewButton = new JButton("Statistic");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<TypeStatic> tmp = addStatic();	
				try {
					Statistic.fileWrite(tmp, "Report.bin");
					listT = Statistic.fileRead("Report.bin");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				fillTableS(listT);
				textStatus.setText("The list statistics by the number of config!!!" );
				StatusTimer();
				
				BarChartStatistic bc = new BarChartStatistic();
				bc.setVisible(true);
				bc.setLocationRelativeTo(null);
				bc.setSize(730, 450);
				bc.setResizable(false);
			}
		});
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBackground(new Color(255, 99, 71));
		btnNewButton.setBounds(509, 317, 98, 23);
		contentPane.add(btnNewButton);
		
		JButton btnback = new JButton("BACK HOME");
		btnback.setForeground(new Color(255, 255, 255));
		btnback.setBackground(new Color(255, 99, 71));
		btnback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QuanLyGUI qlv = new QuanLyGUI();
				qlv.setVisible(true);
				qlv.setLocationRelativeTo(null);
				ComputerGUI.this.dispose();
			}
		});
		btnback.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnback.setBounds(213, 588, 158, 25);
		contentPane.add(btnback);
		
		
		JScrollPane scrollPane_1 = new JScrollPane(tableStatistic);
		scrollPane_1.setBounds(403, 41, 305, 272);
		contentPane.add(scrollPane_1);	
		
		//Set Icon
		URL ic = ComputerGUI.class.getResource("computer.png");
		Image img = Toolkit.getDefaultToolkit().createImage(ic);
		this.setIconImage(img);
	}
	private void initTable() {
		String[] columns = { "ID", "Name", "Price($)", "Total", "Config", "Manu. Year"};
		tableModel.setColumnIdentifiers(columns);
		table.setModel(tableModel);
		table.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 14));
		table.getTableHeader().setBackground(new Color(255, 228, 181));
		table.setFont(new Font("Tahoma", Font.PLAIN, 13));
		table.setBackground(new Color(253, 245, 230));
	}
	private void fillTable(List<Computer> list) throws IOException, ClassNotFoundException {
		tableModel.setRowCount(0);
		for (Computer com : list) {
			tableModel.addRow(new String[] {
					String.format("%d", com.getProduct_id()), com.getProduct_name(), decimalFormat.format(com.getProduct_price()),
					"" + com.getProduct_total(), com.getConfig(), String.format("%d", com.getManufacture_year())
			});
		}
		table.setRowHeight(25);
		DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(SwingConstants.CENTER);
 
        for (int columnIndex = 0; columnIndex < tableModel.getColumnCount(); columnIndex++)
        {
            table.getColumnModel().getColumn(columnIndex).setCellRenderer(rightRenderer);
        }
        table.getColumnModel().getColumn(0).setPreferredWidth(50);
        table.getColumnModel().getColumn(1).setPreferredWidth(80);
        table.getColumnModel().getColumn(2).setPreferredWidth(80);
        table.getColumnModel().getColumn(3).setPreferredWidth(50);
        table.getColumnModel().getColumn(4).setPreferredWidth(80);
        table.getTableHeader().setFont(new Font("Times New Roman", Font.BOLD, 18));
		tableModel.fireTableDataChanged();
	}
	private void initTableS() {		
		tableStatistic.setFont(new Font("Tahoma", Font.PLAIN, 13));
		tableStatistic.setBackground(new Color(253, 245, 230));
		tableStatistic.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 14));
		tableStatistic.getTableHeader().setBackground(new Color(255, 228, 181));
		tableStatistic.setModel(tableModel_S);
		tableModel_S.addColumn("Config");
		tableModel_S.addColumn("Total");
	}
	private void fillTableS(List<TypeStatic> list) {
		tableModel_S.setRowCount(0);
		Object o[] = new Object[listT.size()];
		for(TypeStatic h:listT) {
			o[0] = h.getType();
			o[1] = h.getSumTotal();
			tableModel_S.addRow(o);
		}
		
		tableStatistic.setRowHeight(40);
		
		DefaultTableCellRenderer rightRendererS = new DefaultTableCellRenderer();
        rightRendererS.setHorizontalAlignment(SwingConstants.CENTER);
        
        for (int columnIndex = 0; columnIndex < tableModel_S.getColumnCount(); columnIndex++)
        {
        	tableStatistic.getColumnModel().getColumn(columnIndex).setCellRenderer(rightRendererS);
        }
	}
	public static String formatString(String s) {
		String str[]  = s.split("");
		StringBuilder newString = new StringBuilder();
		for(int i = 0; i < str.length; i++) {
			if(str[i].compareTo(",") != 0) {
				newString.append(str[i]);
			}
		}
		return newString.toString();
	}
	public boolean checkValidData() {
		if(!validataEmtyField()) {
			return false;
		}
		StringBuilder sb = new StringBuilder();
		try {
			double price = Double.parseDouble(textPrice.getText());
			if (price <= 0) {
				sb.append("Price must be greater than 0");
			}
		} catch(Exception e8) {
			sb.append("Price must be real numbers");
		}
		try {
			int total = Integer.parseInt(textTotal.getText());
			if (total <= 0) {
				sb.append("Total must be greater than 0");
			}
		} catch (Exception e9) {
			sb.append("Total must be whole numbers");
		}
		try {
			int year = Integer.parseInt(textYear.getText());
			if (year < 2000) {
				sb.append("Year must be greater than 2000");
			}
		} catch(Exception e10) {
			sb.append("Year must be whole numbers");
		}
		if (sb.length() > 0) {
			JOptionPane.showMessageDialog(contentPane, sb.toString(), "Error", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
	}
	public boolean validataEmtyField() {
		StringBuilder sb = new StringBuilder();
		if(textName.getText().equals("")) {
			sb.append("The computer name cannot be blank \n");
		}
		if(textPrice.getText().equals("")) {
			sb.append("The computer price cannot be blank \n");
		}
		if(textTotal.getText().equals("")) {
			sb.append("The computer total cannot be blank \n");
		}
		if(textConfig.getText().equals("")) {
			sb.append("The computer config cannot be blank \n");
		}
		if(textYear.getText().equals("")) {
			sb.append("The computer manufacture year cannot be blank \n");
		}
		if(sb.length() > 0 ) {
			JOptionPane.showMessageDialog(contentPane, sb.toString(), "Error", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
	}
	public void resetField() {
		textName.setText("");
		textPrice.setText("");
		textTotal.setText("");
		textConfig.setText("");
		textYear.setText("");
		textSearch.setText("");
	}
	public void resetAll() {
		resetField();
		try {
			fillTable(list);
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void writeToFile() throws IOException {
		FileComputer.binaryOutputFile(list);
	}
	public static int Sa(String name) {
		int count = 0;
		for(Computer o:list) {
			if (o.getConfig().equals(name)) {
				count++;
			}
		}
		return count;
	}
	public static List<TypeStatic> addStatic() {
		List<TypeStatic> lt = new ArrayList<>();
		
		lt.add( new TypeStatic("RTX 2080", Sa("RTX 2080")));
		lt.add( new TypeStatic("RTX 2070", Sa("RTX 2070")));
		lt.add( new TypeStatic("Radeon RX 5700", Sa("Radeon RX 5700")));
		lt.add( new TypeStatic("RTX 2060", Sa("RTX 2060")));
		lt.add( new TypeStatic("Radeon RX 5800", Sa("Radeon RX 5800")));
		lt.add( new TypeStatic("RTX 3080", Sa("RTX 3080")));
		lt.add( new TypeStatic("RTX 3090", Sa("RTX 3090")));
		
		return lt;
	}
	private void StatusTimer() {
		ActionListener listener = new ActionListener(){
	        public void actionPerformed(ActionEvent event){
	        	textStatus.setText("");
	        }
	    };
	    Timer timer = new Timer(5000, listener);
	    timer.setRepeats(false);
	    timer.start();
	}
}
class sortedByPrice implements Comparator<Computer> {

	@Override
	public int compare(Computer c1, Computer c2) {
		return (int) (c1.getProduct_price() - c2.getProduct_price());
	}
}
class sortedByConfig implements Comparator<Computer>{

	@Override
	public int compare(Computer c1, Computer c2) {
		String config1 = c1.getConfig();
		String config2 = c2.getConfig();
		
		byte at = (byte)config1.lastIndexOf(" ");
		if(at != -1) {
			config1 = config1.substring(at + 1);
		}
		at = (byte)config2.lastIndexOf(" ");
		if(at != -1) {
			config2 = config2.substring(at + 1);
		}
		return config1.compareToIgnoreCase(config2);
	}
}
class Item {
	private String key;
    private String value;

    public Item(String key, String value)
    {
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString()
    {
        return key;
    }

    public String getKey()
    {
        return key;
    }

    public String getValue()
    {
        return value;
    }
}
