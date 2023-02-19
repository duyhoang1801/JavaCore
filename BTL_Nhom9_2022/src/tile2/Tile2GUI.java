package tile2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

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
import java.util.List;
import java.util.Locale;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JSeparator;
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

public class Tile2GUI extends JFrame {
	Tile2GUI frame;
	
	public static List<Tile2> list = new ArrayList<>();
	private TileManager1 tm1 = new TileManager1();
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
	private JTextField textType;
	private JTextField textLong;
	private JTable table = new JTable();
	private JScrollPane scrollPane;
	private DefaultTableModel tableModel = new DefaultTableModel();
	private JButton btnReset;
	private JComboBox comboBox;
	private JTextField textSearch;
	private JButton btnSearch;
	private JComboBox cbSort;
	private JButton btnSort;
	private JComboBox cbIsNC;
	private JTable tableStatistic = new JTable();
	private DefaultTableModel tableModel_S = new DefaultTableModel();
	
	private final JTextField textField = new JTextField();
	private JTextField textStatus;
	private JButton btnTk;
	private JScrollPane scrollPane_1;
	private static List<TypeStatic> listT = new ArrayList<>();
	
	
	/**
	 * Create the frame.
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public Tile2GUI() throws IOException, ClassNotFoundException {
		this.setLocationRelativeTo(null);
		this.setTitle("Tile Management");
		
		list = TileManager1.generatedTile(20);
		MyFile.binaryOutputFile(list);
		
		textField.setToolTipText("");
		textField.setColumns(10);
		initTable();
		initTableS();
		list = MyFile.binaryInputFile("Tile2.bin", MyFile.countObject());
		fillTable(list);
			
		this.setResizable(false);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 759, 677);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 250, 205));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(255, 255, 255));
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("File");
		mnNewMenu.setFont(new Font("Roboto", Font.PLAIN, 12));
		mnNewMenu.setSelectedIcon(null);
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Log out");
		mntmNewMenuItem_1.setFont(new Font("Roboto", Font.PLAIN, 12));
		mntmNewMenuItem_1.setIcon(new ImageIcon(Tile2GUI.class.getResource("/login/logoutIC.png")));
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginGUI lg = new LoginGUI();
				lg.setVisible(true);	
				lg.setLocationRelativeTo(null);
				Tile2GUI.this.dispose();
			}
		});
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Managements System");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QuanLyGUI qlv = new QuanLyGUI();
				qlv.setVisible(true);
				qlv.setLocationRelativeTo(null);
				Tile2GUI.this.dispose();
			}
		});
		mntmNewMenuItem_3.setFont(new Font("Roboto", Font.PLAIN, 12));
		mntmNewMenuItem_3.setIcon(new ImageIcon(Tile2GUI.class.getResource("/login/MenuIC.png")));
		mnNewMenu.add(mntmNewMenuItem_3);
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Exit");
		mntmNewMenuItem.setIcon(new ImageIcon(Tile2GUI.class.getResource("/login/exitIcon.png")));
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
				JOptionPane.showMessageDialog(contentPane, "Program created by Nguyen Chi Dung_153", "Information", JOptionPane.PLAIN_MESSAGE);
			}
		});
		mntmNewMenuItem_2.setIcon(new ImageIcon(Tile2GUI.class.getResource("/login/inforIC.png")));
		mntmNewMenuItem_2.setFont(new Font("Roboto", Font.PLAIN, 12));
		mnNewMenu_1.add(mntmNewMenuItem_2);
		
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("TILE2 MANAGEMENT");
		lblNewLabel.setBackground(new Color(50, 205, 50));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(0, 0, 128));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNewLabel.setBounds(10, 0, 725, 77);
		contentPane.add(lblNewLabel);
		
		lblNewLabel2 = new JLabel("Total");
		lblNewLabel2.setForeground(new Color(25, 25, 112));
		lblNewLabel2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel2.setBounds(20, 177, 82, 28);
		contentPane.add(lblNewLabel2);
		
		lblNewLabel_3 = new JLabel("Name");
		lblNewLabel_3.setForeground(new Color(25, 25, 112));
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_3.setBounds(20, 80, 82, 28);
		contentPane.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Price");
		lblNewLabel_4.setForeground(new Color(25, 25, 112));
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_4.setBounds(20, 125, 82, 28);
		contentPane.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("Tile Type");
		lblNewLabel_5.setForeground(new Color(25, 25, 112));
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_5.setBounds(20, 222, 82, 28);
		contentPane.add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("Tile Size");
		lblNewLabel_6.setForeground(new Color(25, 25, 112));
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_6.setBounds(20, 267, 82, 28);
		contentPane.add(lblNewLabel_6);
		
		lblNewLabel_6 = new JLabel("Tile ");
		lblNewLabel_6.setForeground(new Color(25, 25, 112));
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_6.setBounds(20, 267, 82, 28);
		contentPane.add(lblNewLabel_6);
		
		textName = new JTextField();
		textName.setToolTipText("");
		textName.setColumns(10);
		textName.setBounds(122, 87, 208, 20);
		contentPane.add(textName);
		
		textPrice = new JTextField();
		textPrice.setColumns(10);
		textPrice.setBounds(122, 132, 208, 20);
		contentPane.add(textPrice);

		textTotal = new JTextField();
		textTotal.setColumns(10);
		textTotal.setBounds(122, 177, 208, 20);
		contentPane.add(textTotal);
		
		textType = new JTextField();
		textType.setColumns(10);
		textType.setBounds(122, 222, 208, 20);
		contentPane.add(textType);
		
		textLong = new JTextField();
		textLong.setColumns(10);
		textLong.setBounds(124, 267, 206, 20);
		contentPane.add(textLong);
		
		//Set Icon
		URL ic = Tile2GUI.class.getResource("Tileicon.png");
		Image img = Toolkit.getDefaultToolkit().createImage(ic);
		this.setIconImage(img);
		
		textStatus = new JTextField();
		textStatus.setToolTipText("");
		textStatus.setColumns(10);
		textStatus.setBounds(20, 432, 715, 20);
		contentPane.add(textStatus);
		
		JButton btnAdd = new JButton("ADD");
		btnAdd.setBackground(new Color(255, 255, 0));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!checkValidData()) {
					return;
				}
				Tile2 tl = new Tile2();
				int Tile_ID = (int) (list.get(list.size()-1).getProduct_id() + 1);
				tl.setProduct_id(Tile_ID);
				tl.setProduct_name(textName.getText().trim());
				tl.setProduct_price(Double.valueOf(textPrice.getText().trim()));
				tl.setProduct_total(Integer.valueOf(textTotal.getText().trim()));
				tl.setTile_type(textType.getText().trim());
				tl.setTile_size(Double.valueOf(textLong.getText().trim()));
				for (Tile2 tile : list) {
					if (tl.getProduct_id()==tile.getProduct_id()) {
						JOptionPane.showMessageDialog(contentPane, "Tile already exist!", "Error", JOptionPane.ERROR_MESSAGE);
						return;
					}
				}
				tm1.addTile(tl);
				JOptionPane.showMessageDialog(contentPane, "Add Success", "Successful", JOptionPane.PLAIN_MESSAGE);
				textStatus.setText("Add Success!!! Add Information: " + Tile_ID +  ", " + textName.getText() + ", " + textPrice.getText() + ", " + textTotal.getText() + ", " + textType.getText() + ", " + textLong.getText());
				StatusTimer();
				try {
					list = MyFile.binaryInputFile("Tile2.bin", MyFile.countObject());
					fillTable(list);
					resetField();
				} catch (IOException | ClassNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnAdd.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnAdd.setBounds(20, 305, 80, 23);
		contentPane.add(btnAdd);
		
		JButton btnEdit = new JButton("EDIT");
		btnEdit.setBackground(new Color(255, 255, 0));
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
				for (Tile2 tile : list) {
					if (tile.getProduct_id() == id) {
						tile.setProduct_id(id);
						tile.setProduct_name(textName.getText().trim());
						tile.setProduct_price(Double.valueOf(textPrice.getText().trim()));
						tile.setProduct_total(Integer.valueOf(textTotal.getText().trim()));
						tile.setTile_type(textType.getText().trim());
						tile.setTile_size(Double.valueOf(textLong.getText().trim()));
						break;
					}
				}
				textStatus.setText("Edit Success!!! Edit Tile Id: " + id +  ", " + textName.getText() + ", " + textPrice.getText() + ", " + textTotal.getText() + ", " + textType.getText() + ", " + textLong.getText());
				StatusTimer();
				try {
					writeToFile();
					list = MyFile.binaryInputFile("Tile2.bin", MyFile.countObject());
					fillTable(list);
					resetField();
				} catch (IOException | ClassNotFoundException e2) {
					e2.printStackTrace();
				}
				JOptionPane.showMessageDialog(contentPane, "Edit Success", "Successful", JOptionPane.PLAIN_MESSAGE);
			}	
		});
		btnEdit.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnEdit.setBounds(120, 305, 80, 23);
		contentPane.add(btnEdit);
		
		JButton btnDelete = new JButton("DEL");
		btnDelete.setBackground(new Color(255, 255, 0));
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
				for (Tile2 tl : list) {
					if (tl.getProduct_id() == Integer.parseInt((String)table.getValueAt(row, 0))) {
						tm1.deleTile(tl);
						break;
					}
				}
				JOptionPane.showMessageDialog(contentPane, "Delete Success", "Successful", JOptionPane.PLAIN_MESSAGE);
				textStatus.setText("Delete Success!!! Delete Tile Id: " + id );
				StatusTimer();
				try {
					writeToFile();
					list = MyFile.binaryInputFile("Tile2.bin", MyFile.countObject());
					fillTable(list);
					resetField();
				} catch (IOException | ClassNotFoundException e3) {
					e3.printStackTrace(); 
				}
			}
		});
		btnDelete.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnDelete.setBounds(220, 305, 80, 23);
		contentPane.add(btnDelete);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				textName.setText((String) table.getValueAt(row, 1));
				textPrice.setText(Tile2GUI.formatString((String)table.getValueAt(row, 2)));
				textTotal.setText((String) table.getValueAt(row, 3));
				textType.setText((String) table.getValueAt(row, 4));
				textLong.setText((String) table.getValueAt(row, 5));
				id = Integer.parseInt((String)table.getValueAt(row, 0));
			}
		});
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 462, 725, 116);
		JScrollBar vertical = scrollPane.getVerticalScrollBar();
		vertical.setValue( vertical.getMaximum());
		contentPane.add(scrollPane);
		scrollPane.setViewportView(table);		
		
		JButton btnExit = new JButton("EXIT");
		btnExit.setBackground(new Color(0, 191, 255));
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnExit.setBounds(379, 584, 149, 31);
		contentPane.add(btnExit);
		
		btnReset = new JButton("RESET");
		btnReset.setBackground(new Color(255, 255, 0));
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetAll();
			}
		});
		btnReset.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnReset.setBounds(320, 305, 94, 23);
		contentPane.add(btnReset);
		
		comboBox = new JComboBox();
		comboBox.setBackground(new Color(0, 255, 0));
		comboBox.setFont(new Font("Times New Roman", Font.BOLD, 16));
		comboBox.addItem(new Item("Search Name", "name"));
		comboBox.addItem(new Item("Search Price", "price"));
		comboBox.setBounds(20, 338, 116, 28);
		contentPane.add(comboBox);
		
		textSearch = new JTextField();
		textSearch.setBounds(136, 338, 184, 28);
		contentPane.add(textSearch);
		textSearch.setColumns(10);
		
		btnSearch = new JButton("SEARCH");
		btnSearch.setBackground(new Color(0, 255, 0));
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object item = comboBox.getSelectedItem();
				String value = ((Item)item).getValue();
				List<Tile2> listSearch = new ArrayList<>();
				if (textSearch.getText().compareTo("") == 0) {
					JOptionPane.showMessageDialog(contentPane, "You have not entered the search value", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				String textInput = textSearch.getText().trim();
				if (value.compareTo("name") == 0) {
					listSearch = tm1.searchTile(textSearch.getText());
					textStatus.setText("The list has been search by name: " + textInput);
					StatusTimer();
				} else if (value.compareTo("price") == 0) {
					try {
						double price = Double.parseDouble(textInput);
						if (price <= 0) {
							JOptionPane.showMessageDialog(contentPane, "Price must be greater than 0", "Error", JOptionPane.ERROR_MESSAGE);
						}
						listSearch = tm1.searchTile(price);
						textStatus.setText("The list has been search by price: " + price);
						StatusTimer();
					} catch (Exception e4) {
						JOptionPane.showMessageDialog(contentPane, "Price must be real numbers", "Error", JOptionPane.ERROR_MESSAGE);
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
		btnSearch.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnSearch.setBounds(320, 338, 94, 28);
		contentPane.add(btnSearch);
		
		cbSort = new JComboBox();
		cbSort.setBackground(new Color(0, 255, 0));
		cbSort.addItem(new Item("Sorted Price", "price"));
		cbSort.addItem(new Item("Sorted Type", "type"));
		cbSort.setFont(new Font("Times New Roman", Font.BOLD, 16));
		cbSort.setBounds(20, 394, 116, 28);
		contentPane.add(cbSort);
		
		btnSort = new JButton("SORT");
		btnSort.setBackground(new Color(0, 255, 0));
		btnSort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int totalRow = table.getRowCount();
				int totalColumn = table.getColumnCount();
				List<Tile2> listSort = new ArrayList<>();
				for (int i = 0; i < totalRow; i++) {
					Tile2 tl = new Tile2();
					tl.setProduct_id(Integer.parseInt((String)table.getValueAt(i, 0)));
					tl.setProduct_name((String)table.getValueAt(i, 1));
					tl.setProduct_price(Double.parseDouble(Tile2GUI.formatString((String)table.getValueAt(i, 2))));
					tl.setProduct_total(Integer.parseInt((String)table.getValueAt(i, 3)));
					tl.setTile_type((String)table.getValueAt(i, 4));
					tl.setTile_size(Double.parseDouble((String)table.getValueAt(i, 5)));
					listSort.add(tl);
				}
				
				Object itemSort = cbSort.getSelectedItem();
				String valueSort = ((Item)itemSort).getValue();
				
				Object itemIsNC = cbIsNC.getSelectedItem();
				String valueIsNC = ((Item)itemIsNC).getValue();
				
				if (valueSort.compareTo("price") == 0) {
					if (valueIsNC.compareTo("asc") == 0) {
						Collections.sort(listSort, new SortedByPrice());
						textStatus.setText("The list has been sorted in ascending order by price");	
						StatusTimer();
					} else {
						Collections.sort(listSort, new SortedByPrice().reversed());
						textStatus.setText("The list has been sorted in descending order by price");	
						StatusTimer();
					}
				} else {
					if (valueIsNC.compareTo("asc") == 0) {
						Collections.sort(listSort, new sortedByType());
						textStatus.setText("The list has been sorted in ascending order by type");
						StatusTimer();
					} else {
						Collections.sort(listSort, new sortedByType().reversed());
						textStatus.setText("The list has been sorted in descending order by type");
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
		btnSort.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnSort.setBounds(320, 394, 94, 28);
		contentPane.add(btnSort);
		
		cbIsNC = new JComboBox();
		cbIsNC.setBackground(Color.WHITE);
		cbIsNC.addItem(new Item("Ascending", "asc"));
		cbIsNC.addItem(new Item("Decreasing", "desc"));
		cbIsNC.setFont(new Font("Times New Roman", Font.BOLD, 16));
		cbIsNC.setBounds(137, 394, 183, 28);
		contentPane.add(cbIsNC);
		
		
		JButton btnSort_1 = new JButton("BACK HOME");
		btnSort_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					QuanLyGUI qlv = new QuanLyGUI();
					qlv.setVisible(true);
					qlv.setLocationRelativeTo(null);
					Tile2GUI.this.dispose();
			}
		});
		btnSort_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnSort_1.setBackground(new Color(0, 191, 255));
		btnSort_1.setBounds(220, 584, 149, 31);
		contentPane.add(btnSort_1);
		
		btnTk = new JButton("Staticstic");
		btnTk.addActionListener(new ActionListener() {
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
				textStatus.setText("The list statistics by tile type!!!!!");
				StatusTimer();
				BarChartStatistic bc = new BarChartStatistic();
				bc.setVisible(true);
				bc.setLocationRelativeTo(null);
				bc.setSize(730, 450);
				bc.setResizable(false);
			}
		});
		btnTk.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnTk.setBackground(Color.WHITE);
		btnTk.setBounds(526, 397, 94, 23);
		contentPane.add(btnTk);
		
		
		JScrollPane scrollPane_1 = new JScrollPane(tableStatistic);
		scrollPane_1.setBounds(442, 87, 293, 300);
		contentPane.add(scrollPane_1);
	}
	
	private void initTableS() {		
		tableStatistic.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		tableStatistic.setBackground(new Color(253, 245, 230));
		tableStatistic.getTableHeader().setFont(new Font("Times New Roman", Font.BOLD, 14));
		tableStatistic.getTableHeader().setBackground(new Color(255, 228, 181));
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
		
		tableStatistic.setRowHeight(60);
		
		DefaultTableCellRenderer rightRendererS = new DefaultTableCellRenderer();
        rightRendererS.setHorizontalAlignment(SwingConstants.CENTER);
        
        for (int columnIndex = 0; columnIndex < tableModel_S.getColumnCount(); columnIndex++)
        {
        	tableStatistic.getColumnModel().getColumn(columnIndex).setCellRenderer(rightRendererS);
        }
	}
	
	private void initTable() {
		String[] columns = { "ID", "Name", "Price", "Total", "Type", "Size"};
		tableModel.setColumnIdentifiers(columns);
		table.setModel(tableModel);
	}
	private void fillTable(List<Tile2> list) throws IOException, ClassNotFoundException {
		tableModel.setRowCount(0);
		for (Tile2 tl : list) {
			tableModel.addRow(new String[] {
					String.format("%d", tl.getProduct_id()), tl.getProduct_name(), decimalFormat.format(tl.getProduct_price()),
					"" + tl.getProduct_total(), tl.getTile_type(), String.format("%.2f", tl.getTile_size())
			});
		}
		table.setRowHeight(30);
		DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(SwingConstants.CENTER);
 
        for (int columnIndex = 0; columnIndex < tableModel.getColumnCount(); columnIndex++)
        {
            table.getColumnModel().getColumn(columnIndex).setCellRenderer(rightRenderer);
        }
        table.getColumnModel().getColumn(0).setPreferredWidth(50);
        table.getColumnModel().getColumn(1).setPreferredWidth(120);
        table.getColumnModel().getColumn(2).setPreferredWidth(120);
        table.getColumnModel().getColumn(3).setPreferredWidth(150);
        table.getColumnModel().getColumn(4).setPreferredWidth(150);
        table.getColumnModel().getColumn(5).setPreferredWidth(150);
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
		try {
			double Long = Double.parseDouble(textLong.getText());
			if (Long <= 0) {
				sb.append("Size must be greater than 0");
			}
		} catch(Exception e10) {
			sb.append("Size must be whole numbers");
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
			sb.append("The Tile name cannot be blank \n");
		}
		if(textPrice.getText().equals("")) {
			sb.append("The Tile price cannot be blank \n");
		}
		if(textTotal.getText().equals("")) {
			sb.append("The Tile total cannot be blank \n");
		}
		if(textType.getText().equals("")) {
			sb.append("The Tile type cannot be blank \n");
		}
		if(textLong.getText().equals("")) {
			sb.append("The Tile Size cannot be blank \n");
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
		textType.setText("");
		textLong.setText("");
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
		MyFile.binaryOutputFile(list);
	}
	
	public static int Sa(String type) {
		int count = 0;
		for(Tile2 o:list) {
			if (o.getTile_type().equals(type)) {
				count++;
			}
		}
		return count;
	}
	
	public static List<TypeStatic> addStatic() {
		List<TypeStatic> lt = new ArrayList<>();
		
		lt.add( new TypeStatic("Gach men", Sa("Gach men")));
		lt.add( new TypeStatic("Gach bong kieng", Sa("Gach bong kieng")));
		lt.add( new TypeStatic("Gach bong", Sa("Gach bong")));
		lt.add( new TypeStatic("Gach Granite", Sa("Gach Granite")));
		lt.add( new TypeStatic("Gach Ceramic", Sa("Gach Ceramic")));
		lt.add( new TypeStatic("Gach gia go", Sa("Gach gia go")));
		
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
