package Tile1;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import Tile1.*;
import housingql.Housing;
import housingql.HousingData;
import housingql.HousingGUI;
import login.LoginGUI;
import menuquanly.*;


public class TileGUI extends JFrame {
	TileGUI frame;
	
	public static List<Tile> list = new ArrayList<>();
	public static  TileManagerImp tmp= new TileManagerImp();
	Locale locale = new Locale("en", "EN");
	DecimalFormat decimalFormat = (DecimalFormat)NumberFormat.getNumberInstance(locale);
	public static int id;
	
	private JPanel contentPane;
	private JLabel lblNewLabel2;
	private JLabel lblNewLabel_10;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JTextField textName;
	private JTextField textPrice;
	private JTextField textTotal;
	private JTextField textSize;
	private JTextField textColor;
	private JTextField textID;
	private JTable table = new JTable();
	private JScrollPane scrollPane;
	private DefaultTableModel tableModel = new DefaultTableModel();
	private JButton btnReset;
	private JLabel lblNewLabel_1;
	private JComboBox comboBox;
	private JLabel lblNewLabel_7;
	private JTextField textSearch;
	private JButton btnSearch;
	private JLabel lblNewLabel_8;
	private JComboBox cbSort;
	private JButton btnSort;
	private JComboBox cbIsNC;
	
	private JTable tableStatistic = new JTable();
	private DefaultTableModel tableModel_S= new DefaultTableModel();
	private JTextField textStatus;
	private final JTextField textField = new JTextField();
	private static List<Tile> lst = new ArrayList<>();
	private static List<TypeStatic> listT = new ArrayList<>();

	
	public TileGUI() throws IOException, ClassNotFoundException {
		
		this.setResizable(false);
		this.setTitle("Tile Management");
		this.setLocationRelativeTo(null);
		
		textField.setToolTipText("");
		textField.setColumns(10);
		
		list = Tile.generateTile(20);
		ReaFile.binaryOutputFile(list);
		
		initTable();	
		initTableS();
		list = ReaFile.binaryInputFile();
		fillTable(list);
			
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
				TileGUI.this.dispose();
			}
		});
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Managements System");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QuanLyGUI qlv = new QuanLyGUI();
				qlv.setVisible(true);
				qlv.setLocationRelativeTo(null);
				TileGUI.this.dispose();
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
				JOptionPane.showMessageDialog(contentPane, "Program created by Tran Viet Cuong_322", "Information", JOptionPane.PLAIN_MESSAGE);
			}
		});
		mntmNewMenuItem_2.setIcon(new ImageIcon(TileGUI.class.getResource("/login/inforIC.png")));
		mntmNewMenuItem_2.setFont(new Font("Roboto", Font.PLAIN, 12));
		mnNewMenu_1.add(mntmNewMenuItem_2);
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 759, 677);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(0, 255, 51));
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnExit = new JButton("EXIT ");
		btnExit.setBackground(Color.WHITE);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnExit.setBounds(381, 583, 158, 25);
		contentPane.add(btnExit);
		
		JLabel lblNewLabel = new JLabel("TILE MANAGEMENT");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblNewLabel.setBounds(426, 3, 265, 41);
		contentPane.add(lblNewLabel);
		
		lblNewLabel2 = new JLabel("Total of Tiles");
		lblNewLabel2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel2.setBounds(10, 121, 169, 28);
		contentPane.add(lblNewLabel2);
		
		
		lblNewLabel_10 = new JLabel("Tile ID");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_10.setBounds(10, 11, 149, 28);
		contentPane.add(lblNewLabel_10);
		
		
		lblNewLabel_3 = new JLabel("Tile Name");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setBounds(10, 41, 149, 28);
		contentPane.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Tile Price ($)");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_4.setBounds(10, 81, 169, 28);
		contentPane.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("Tile Size");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_5.setBounds(10, 161, 169, 28);
		contentPane.add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("Tile Color");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_6.setBounds(10, 201, 169, 28);
		contentPane.add(lblNewLabel_6);
		
		textName = new JTextField();
		textName.setToolTipText("");
		textName.setColumns(10);
		textName.setBounds(153, 48, 181, 20);
		contentPane.add(textName);
		
		textPrice = new JTextField();
		textPrice.setColumns(10);
		textPrice.setBounds(153, 88, 181, 20);
		contentPane.add(textPrice);


		textTotal = new JTextField();
		textTotal.setColumns(10);
		textTotal.setBounds(153, 128, 181, 20);
		contentPane.add(textTotal);
		
		textSize = new JTextField();
		textSize.setColumns(10);
		textSize.setBounds(153, 168, 181, 20);
		contentPane.add(textSize);
		
		textColor = new JTextField();
		textColor.setColumns(10);
		textColor.setBounds(153, 208, 181, 20);
		contentPane.add(textColor);
		
		
		textID = new JTextField();
		textID.setColumns(10);
		textID.setBounds(153, 18, 181, 20);
		contentPane.add(textID);
	
		textStatus = new JTextField();
		textStatus.setToolTipText("");
		textStatus.setColumns(10);
		textStatus.setBounds(10, 355, 730, 20);
		contentPane.add(textStatus);
		
		JButton btnAdd = new JButton("ADD");
		btnAdd.setBackground(Color.WHITE);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!checkValidData()) {
					return;
				}
				Tile tl = new Tile();
				int Tile_ID = (int) (list.get(list.size()-1).getProduct_id() + 1);
				tl.setProduct_id(Integer.valueOf(textID.getText().trim()));
				tl.setProduct_name(textName.getText().trim());
				tl.setProduct_price(Double.valueOf(textPrice.getText().trim()));
				tl.setProduct_total(Integer.valueOf(textTotal.getText().trim()));
				tl.settile_size(Float.valueOf(textSize.getText().trim()));
				tl.setTile_color(textColor.getText());
				for (Tile c : list) {
					if(tl.getProduct_id() == c.getProduct_id()) {
						JOptionPane.showMessageDialog(contentPane, "Tile already exist!", "Error", JOptionPane.ERROR_MESSAGE);
						return;
					}
					if (tl.getProduct_name().compareTo(c.getProduct_name()) == 0) {
						JOptionPane.showMessageDialog(contentPane, "Tile already exist!", "Error", JOptionPane.ERROR_MESSAGE);
						return;
					}
				}
				tmp.addTile(tl);
				JOptionPane.showMessageDialog(contentPane, "Add Success", "Successful", JOptionPane.PLAIN_MESSAGE);
				textStatus.setText("Add Success!!! Add Information: " + textID.getText() +  ", " + textName.getText() + ", " + textPrice.getText() + ", " + textTotal.getText() + ", " + textColor.getText() + ", " + textSize.getText());
				StatusTimer();
				try {
					list=ReaFile.binaryInputFile();
					fillTable(list);
					resetField();
				} catch (IOException | ClassNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnAdd.setBounds(10, 238, 80, 23);
		contentPane.add(btnAdd);
		
		JButton btnEdit = new JButton("EDIT");
		btnEdit.setBackground(Color.WHITE);
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
				for (Tile c : list) {
					if (c.getProduct_id() == Integer.valueOf(textID.getText().trim())) {
						c.setProduct_id(Integer.valueOf(textID.getText().trim()));
						c.setProduct_name(textName.getText().trim());
						c.setProduct_price(Double.valueOf(textPrice.getText().trim()));
						c.setProduct_total(Integer.valueOf(textTotal.getText().trim()));
						c.settile_size(Float.valueOf(textSize.getText().trim()));
						c.setTile_color(textColor.getText().trim());
						break;
					}
				}
				textStatus.setText("Edit Success!!! Edit Tile Id: " + textID.getText() +  ", " + textName.getText() + ", " + textPrice.getText() + ", " + textTotal.getText() + ", " + textColor.getText() + ", " + textSize.getText());
				StatusTimer();
				try {
					writeToFile();
					list = ReaFile.binaryInputFile();
					fillTable(list);
					resetField();
				} catch (IOException | ClassNotFoundException e2) {
					e2.printStackTrace();
				}
				JOptionPane.showMessageDialog(contentPane, "Edit Success", "Successful", JOptionPane.PLAIN_MESSAGE);
			}	
		});
		btnEdit.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnEdit.setBounds(103, 238, 80, 23);
		contentPane.add(btnEdit);
		
		JButton btnDelete = new JButton("DEL");
		btnDelete.setBackground(Color.WHITE);
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
				
				
				for (int i=0; i<list.size(); i++) {
					if (list.get(i).getProduct_id() == Integer.parseInt(textID.getText())) {
						list.remove(i);
						textStatus.setText("Delete Success!!! Delete Information: Housing ID - " + (String)table.getValueAt(row, 0));
						StatusTimer();
						JOptionPane.showMessageDialog(contentPane, "Delete Success", "Successful", JOptionPane.PLAIN_MESSAGE);
					}
				}
				try {
					writeToFile();
					list = ReaFile.binaryInputFile();
					fillTable(list);
					resetField();
				} catch (IOException | ClassNotFoundException e3) {
					e3.printStackTrace(); 
				}
			}
		});
		
		
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnDelete.setBounds(196, 238, 80, 23);
		contentPane.add(btnDelete);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				textID.setText((String)table.getValueAt(row, 0) );
				textName.setText((String) table.getValueAt(row, 1));
				textPrice.setText(TileGUI.formatString((String)table.getValueAt(row, 2)));
				textTotal.setText((String) table.getValueAt(row, 3));
				textSize.setText((String) table.getValueAt(row, 4));
				textColor.setText((String) table.getValueAt(row, 5));
				
			}
		});
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 385, 730, 189);
		JScrollBar vertical = scrollPane.getVerticalScrollBar();
		vertical.setValue( vertical.getMaximum());
		contentPane.add(scrollPane);
		scrollPane.setViewportView(table);		
		
		
		
		
		btnReset = new JButton("RESET");
		btnReset.setBackground(Color.WHITE);
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetAll();
			}
		});
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnReset.setBounds(289, 238, 89, 23);
		contentPane.add(btnReset);
		
		

		comboBox = new JComboBox();
		comboBox.setBackground(Color.WHITE);
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 13));
		comboBox.addItem(new Item("Search by Name", "name"));
		comboBox.addItem(new Item("Search by Price", "price"));
		comboBox.addItem(new Item("Search by Size", "size"));
		comboBox.addItem(new Item("Search by Color", "color"));
		comboBox.setBounds(10, 279, 142, 23);
		contentPane.add(comboBox);
		
		
		textSearch = new JTextField();
		textSearch.setBounds(153, 279, 126, 23);
		contentPane.add(textSearch);
		textSearch.setColumns(10);
		
		btnSearch = new JButton("SEARCH");
		btnSearch.setBackground(Color.WHITE);
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object item = comboBox.getSelectedItem();
				String value = ((Item)item).getValue();
				List<Tile> listSearch = new ArrayList<>();
				if (textSearch.getText().compareTo("") == 0) {
					JOptionPane.showMessageDialog(contentPane, "You have not entered the search value", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				String textInput = textSearch.getText().trim();
				if (value.compareTo("name") == 0) {
					listSearch = tmp.searchTile(textSearch.getText());
					textStatus.setText("The list has been search by name: " + textInput);
					StatusTimer();
				} else if (value.compareTo("price") == 0) {
					try {
						double price = Double.parseDouble(textInput);
						if (price <= 0) {
							JOptionPane.showMessageDialog(contentPane, "Price must be greater than 0", "Error", JOptionPane.ERROR_MESSAGE);
						}
						listSearch = tmp.searchTile(price);
						textStatus.setText("The list has been search by price: " + textInput);
						StatusTimer();
					} catch (Exception e4) {
						JOptionPane.showMessageDialog(contentPane, "Price must be real numbers", "Error", JOptionPane.ERROR_MESSAGE);
					}	
				} else if (value.compareTo("size") == 0) {
					try {
						double size = Double.parseDouble(textInput);
						if (size <= 0) {
							JOptionPane.showMessageDialog(contentPane, "Size must be greater than 0", "Error", JOptionPane.ERROR_MESSAGE);
						}
						listSearch = tmp.searchTileBySize(size);
						textStatus.setText("The list has been search by size: " + textInput);
						StatusTimer();
					} catch (Exception e4) {
						JOptionPane.showMessageDialog(contentPane, "Size must be real numbers", "Error", JOptionPane.ERROR_MESSAGE);
					}
				} else if (value.compareTo("Color") == 0) {
					listSearch = tmp.searchTileByColor(textInput);
					textStatus.setText("The list has been search by color: " + textInput);
					StatusTimer();
				}
				
				try {
					fillTable(listSearch);
					textSearch.setText("");
				} catch (IOException | ClassNotFoundException e6) {
					e6.printStackTrace();
				}	
			}
		});
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnSearch.setBounds(289, 279, 89, 23);
		contentPane.add(btnSearch);;
		
		
		cbSort = new JComboBox();
		cbSort.setBackground(Color.WHITE);
		cbSort.addItem(new Item("Sorted by Price", "price"));
		cbSort.addItem(new Item("Sorted by Size", "size"));
		cbSort.setFont(new Font("Tahoma", Font.BOLD, 12));
		cbSort.setBounds(10, 317, 142, 23);
		contentPane.add(cbSort);
		
		btnSort = new JButton("SORT");
		btnSort.setBackground(Color.WHITE);
		btnSort.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
				int totalRow = table.getRowCount();
				int totalColumn = table.getColumnCount();
				List<Tile> listSort = new ArrayList<>();
				for (int i = 0; i < totalRow; i++) {
					Tile com = new Tile();
					com.setProduct_id(Integer.parseInt((String)table.getValueAt(i, 0)));
					com.setProduct_name((String)table.getValueAt(i, 1));
					com.setProduct_price(Double.parseDouble(TileGUI.formatString((String)table.getValueAt(i, 2))));
					com.setProduct_total(Integer.parseInt((String)table.getValueAt(i, 3)));
					com.settile_size(Float.parseFloat((String)table.getValueAt(i,4)));
					
					com.setTile_color((String)table.getValueAt(i, 5));
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
				} else  {
					if (valueIsNC.compareTo("asc") == 0) {
						Collections.sort(listSort, new sortedBysize());
						textStatus.setText("The list has been sorted in ascending order by size");
						StatusTimer();
					} else {
						Collections.sort(listSort, new sortedBysize().reversed());
						textStatus.setText("The list has been sorted in descending order by size");
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
		btnSort.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnSort.setBounds(289, 317, 89, 23);
		contentPane.add(btnSort);
		
		cbIsNC = new JComboBox();
		cbIsNC.setBackground(Color.WHITE);
		cbIsNC.addItem(new Item("Ascending", "asc"));
		cbIsNC.addItem(new Item("Decreasing", "desc"));
		cbIsNC.setFont(new Font("Tahoma", Font.BOLD, 12));
		cbIsNC.setBounds(153, 317, 126, 23);
		contentPane.add(cbIsNC);
		
		JButton btnNewButton = new JButton("Statistical");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				List<TypeStatic> listS = addStatic();	
				try {
					Statistic.fileWrite(listS, "Report.bin");
					listT = Statistic.fileRead("Report.bin");
				} catch (IOException | ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				fillTableS(listT);
				textStatus.setText("The list statistics by tile type!!!!!");
				StatusTimer();
				
				BarChartStatistic bc = new BarChartStatistic();
				bc.setVisible(true);
				bc.setLocationRelativeTo(null);
				bc.setSize(730, 450);
				bc.setResizable(false);
			}
		});
		
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setBounds(504, 306, 110, 23);
		contentPane.add(btnNewButton);
		
		JButton btnback = new JButton("BACK HOME");
		btnback.setBackground(new Color(255, 255, 255));
		btnback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QuanLyGUI qlv = new QuanLyGUI();
				qlv.setVisible(true);
				qlv.setLocationRelativeTo(null);
				TileGUI.this.dispose();
			}
		});
		btnback.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnback.setBounds(213, 583, 158, 25);
		contentPane.add(btnback);
		
		
		
		JScrollPane scrollPane_1 = new JScrollPane(tableStatistic);
		scrollPane_1.setBounds(436, 50, 238, 234);
		contentPane.add(scrollPane_1);
	//Set Icon
			URL ic = TileGUI.class.getResource("tile.png");
			Image img = Toolkit.getDefaultToolkit().createImage(ic);
			this.setIconImage(img);
	}
	
	
	
	private void initTable() {	
		String[] columns = { "ID", "Name", "Price($)", "Total", "Size", "Color"};
		tableModel.setColumnIdentifiers(columns);
		table.setModel(tableModel);
	}
	private void fillTable(List<Tile> list) throws IOException, ClassNotFoundException {
		tableModel.setRowCount(0);
		for (Tile com : list) {
			tableModel.addRow(new String[] {
					String.format("%d", com.getProduct_id()), com.getProduct_name(), decimalFormat.format(com.getProduct_price()),
					"" + com.getProduct_total(),  String.format("%.2f", com.gettile_size()), com.gettile_color()
			});
		}
		table.setRowHeight(30);
		DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(SwingConstants.CENTER);
 
        for (int columnIndex = 0; columnIndex < tableModel.getColumnCount(); columnIndex++)
        {
            table.getColumnModel().getColumn(columnIndex).setCellRenderer(rightRenderer);
        }
        table.getColumnModel().getColumn(1).setPreferredWidth(200);
        table.getColumnModel().getColumn(2).setPreferredWidth(150);
        table.getTableHeader().setFont(new Font("Times New Roman", Font.BOLD, 18));
		tableModel.fireTableDataChanged();
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
		if (sb.length() > 0) {
			JOptionPane.showMessageDialog(contentPane, sb.toString(), "Error", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
	}
	public boolean validataEmtyField() {
		StringBuilder sb = new StringBuilder();
		if(textName.getText().equals("")) {
			sb.append("The tile name cannot be blank \n");
		}
		if(textPrice.getText().equals("")) {
			sb.append("The tile price cannot be blank \n");
		}
		if(textTotal.getText().equals("")) {
			sb.append("The tile total cannot be blank \n");
		}
		if(textSize.getText().equals("")) {
			sb.append("The tile size cannot be blank \n");
		}
		if(textColor.getText().equals("")) {
			sb.append("The tile color cannot be blank \n");
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
		textSize.setText("");
		textColor.setText("");
		textSearch.setText("");
		textID.setText("");
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
	
	
	
	private void initTableS() {		
		tableStatistic.setFont(new Font("Times New Roman", Font.PLAIN, 14));
//		tableStatistic.setBackground(new Color(192, 192, 192));
		tableStatistic.getTableHeader().setFont(new Font("Times New Roman", Font.BOLD, 14));
		tableStatistic.getTableHeader().setBackground(new Color(192, 192, 192));
		tableStatistic.setModel(tableModel_S);
		tableModel_S.addColumn("Type");
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
	public static List<TypeStatic> addStatic() {
		List<TypeStatic> lt = new ArrayList<>();
		
		lt.add( new TypeStatic("Gạch men", Sa("Gạch men")));
		lt.add( new TypeStatic("Gạch Granite", Sa("Gạch Granite")));
		lt.add( new TypeStatic("Gạch giả gỗ", Sa("Gạch giả gỗ")));
		lt.add( new TypeStatic("Gạch kính", Sa("Gạch kính")));
		lt.add( new TypeStatic("Gạch bóng kiếng", Sa("Gạch bóng kiếng")));
		lt.add( new TypeStatic("Gạch bông", Sa("Gạch bông")));
		return lt;
	}
	public static int Sa(String Product_name) {
		int count = 0;
		for(Tile o:list) {
			if (o.getProduct_name().equals(Product_name)) {
				count++;
			}
		}
		return count;
	}
	
	
	
	public static void writeToFile(List<Housing> listHou, String fileName) throws IOException {
		HousingData.fileWrite(listHou, fileName);
	}
	
	public static void writeToFile() throws IOException, ClassNotFoundException {
		ReaFile.binaryOutputFile(list);
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
}
