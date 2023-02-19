package housingql;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import login.LoginGUI;
import menuquanly.*;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Color;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import javax.swing.JToolBar;
import javax.swing.JDesktopPane;
import javax.swing.JLayeredPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;


@SuppressWarnings("serial")
public class HousingGUI extends JFrame {

	HousingGUI frame;
	
	private JPanel contentPane;
	private JTextField textID;
	private JTextField textName;
	private JTextField textPrice;
	private JTextField textTotal;
	private JTextField textArea;
	private JTextField textType;
	private JTextField textSearch;
	private JTable table = new JTable();
	private DefaultTableModel tableModel = new DefaultTableModel();
	private DefaultTableModel tableModel_S = new DefaultTableModel();
	
	private static List<Housing> lst = new ArrayList<>();
	private static List<TypeStatic> listT = new ArrayList<>();
	
	private JTextField textStatus;
	private JTable tableStatistic = new JTable();

    
	/**
	 * Create the frame.
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public HousingGUI() throws ClassNotFoundException, IOException {
		
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setTitle("Housing Management");
		lst = Housing.generateHousing(15);
		HousingData.fileWrite(lst, "Housing.bin");
		initTable();
		initTableS();
		lst = HousingData.fileRead("Housing.bin");
		
		
		
		
		fillTable(lst);
		
		
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
				HousingGUI.this.dispose();
			}
		});
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Managements System");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QuanLyGUI qlv = new QuanLyGUI();
				qlv.setVisible(true);
				qlv.setLocationRelativeTo(null);
				HousingGUI.this.dispose();
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
				JOptionPane.showMessageDialog(contentPane, "Program created by Nguyen The Hung_722", "Information", JOptionPane.PLAIN_MESSAGE);
			}
		});
		mntmNewMenuItem_2.setIcon(new ImageIcon(HousingGUI.class.getResource("/login/inforIC.png")));
		mntmNewMenuItem_2.setFont(new Font("Roboto", Font.PLAIN, 12));
		mnNewMenu_1.add(mntmNewMenuItem_2);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("HousingManager");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 30));
		lblNewLabel.setBounds(0, 0, 745, 49);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Product_ID");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(20, 60, 114, 28);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Product_Name");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(20, 99, 114, 28);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Product_Price");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setBounds(20, 138, 114, 28);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Product_Total");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_4.setBounds(20, 177, 114, 28);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Housing_Area");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_5.setBounds(20, 216, 114, 28);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Housing_Type");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_6.setBounds(20, 255, 114, 28);
		contentPane.add(lblNewLabel_6);
		
		textID = new JTextField();
		textID.setBounds(144, 60, 284, 20);
		contentPane.add(textID);
		textID.setColumns(10);
		
		textName = new JTextField();
		textName.setBounds(144, 105, 284, 20);
		contentPane.add(textName);
		textName.setColumns(10);
		
		textPrice = new JTextField();
		textPrice.setBounds(144, 144, 284, 20);
		contentPane.add(textPrice);
		textPrice.setColumns(10);
		
		textTotal = new JTextField();
		textTotal.setBounds(144, 183, 284, 20);
		contentPane.add(textTotal);
		textTotal.setColumns(10);
		
		textArea = new JTextField();
		textArea.setBounds(144, 222, 284, 20);
		contentPane.add(textArea);
		textArea.setColumns(10);
		
		textType = new JTextField();
		textType.setBounds(144, 261, 284, 20);
		contentPane.add(textType);
		textType.setColumns(10);
		
		textStatus = new JTextField();
		textStatus.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		textStatus.setBounds(18, 419, 704, 20);
		contentPane.add(textStatus);
		textStatus.setColumns(10);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setForeground(new Color(0, 0, 0));
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAdd.setBackground(new Color(0, 191, 255));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = textID.getText();
				for(int i=0; i<lst.size(); i++) {
					if (textID.getText().equals(lst.get(i).getProduct_id())) {
						JOptionPane.showMessageDialog(contentPane, "Housing already exists!", "Error", JOptionPane.ERROR_MESSAGE);
						xoaForm();
						return;
					}
				}
				if(textID.getText().equals("") | textName.getText().equals("")) {
					JOptionPane.showMessageDialog(contentPane, "Add Failed", "Error", JOptionPane.ERROR_MESSAGE);
					xoaForm();
				} else {					
					String name = textName.getText();
					String type = textType.getText();
					Long price = Long.valueOf(textPrice.getText());
					double area = Double.valueOf(textArea.getText());
					int total = Integer.valueOf(textTotal.getText());
					
					Housing h1 = new Housing();
					h1.setProduct_id(id);
					h1.setProduct_name(name);
					h1.setProduct_price(price);
					h1.setProduct_total(total);
					h1.setHousing_area(area);
					h1.setHousing_type(type);
					
					lst.add(h1);	
					JOptionPane.showMessageDialog(contentPane, "Add Success", "Successful", JOptionPane.PLAIN_MESSAGE);
					textStatus.setText("Add Success!!! Add Information: " + id + ", " + name + ", " + price + ", " + total + ", " + area + ", " + type );
					StatusTimer();
					try {
						writeToFile(lst, "Housing.bin");
						lst = HousingData.fileRead("Housing.bin");
						fillTable(lst);
						xoaForm();
					} catch (IOException | ClassNotFoundException e1) {
						e1.printStackTrace();
					}
					
				}
			}			
		});
		btnAdd.setBounds(20, 308, 95, 23);
		contentPane.add(btnAdd);
		
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnEdit.setBackground(new Color(0, 191, 255));
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {													
				String id = textID.getText();
				int count=0;
				for(int i=0; i<lst.size(); i++) {
					if(!lst.get(i).getProduct_id().equals(id)) {
						count++;
					}
					if(i==lst.size() && count>0) {
						JOptionPane.showMessageDialog(contentPane, "Edit Failed", "Error", JOptionPane.ERROR_MESSAGE);
						xoaForm();
						break;
					}
				}
				String name = textName.getText();
				long price = Long.valueOf(textPrice.getText());
				int total = Integer.valueOf(textTotal.getText());
				double area = Double.valueOf(textArea.getText());
				String type = textType.getText();
				for(Housing h:lst) {
					if(h.getProduct_id().equals(id)) {
						h.setProduct_id(id);
						h.setProduct_name(name);
						h.setProduct_price(price);
						h.setProduct_total(total);
						h.setHousing_area(area);
						h.setHousing_type(type);
						textStatus.setText("Edit Success!!! Edit Information: " + id + ", " + name + ", " + price + ", " + total + ", " + area + ", " + type );
						JOptionPane.showMessageDialog(contentPane, "Edit Success", "Successful", JOptionPane.PLAIN_MESSAGE);
						StatusTimer();
					}
				}			
				
				try {				
					writeToFile(lst, "Housing.bin");
					lst = HousingData.fileRead("Housing.bin");
					fillTable(lst);
					xoaForm();
				} catch (IOException | ClassNotFoundException e2) {
					e2.printStackTrace();
				}				
			}
		});
		btnEdit.setBounds(176, 308, 95, 23);
		contentPane.add(btnEdit);
		
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnDelete.setBackground(new Color(0, 191, 255));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {						
				String id = textID.getText();
				int count = 0;
				
				for(int i=0; i<lst.size(); i++) {
					if(!lst.get(i).getProduct_id().equals(id)) {
						count++;
					}
					if(i==lst.size() && count>0) {
						JOptionPane.showMessageDialog(contentPane, "Delete Failed", "Error", JOptionPane.ERROR_MESSAGE);
						xoaForm();
						break;
					}
				}
				
				for (int i=0; i<lst.size(); i++) {
					if (lst.get(i).getProduct_id().equals(id)) {
						lst.remove(i);
						textStatus.setText("Delete Success!!! Delete Information: Housing ID - " + id);
						StatusTimer();
						JOptionPane.showMessageDialog(contentPane, "Delete Success", "Successful", JOptionPane.PLAIN_MESSAGE);
					}
				}
				
				try {
					writeToFile(lst, "Housing.bin");
					lst = HousingData.fileRead("Housing.bin");
					fillTable(lst);
					xoaForm();
				} catch (IOException | ClassNotFoundException e2) {
					e2.printStackTrace();
				}
				
			}
			
		});

		btnDelete.setBounds(333, 308, 95, 23);
		contentPane.add(btnDelete);
		
		
		
		
		
		JLabel lblNewLabel_7 = new JLabel("Tìm Kiếm");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_7.setBounds(20, 342, 114, 28);
		contentPane.add(lblNewLabel_7);
		
		textSearch = new JTextField();
		textSearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String query = textSearch.getText();
				
				filter(query);
			}
		});
		textSearch.setBounds(107, 348, 321, 20);
		contentPane.add(textSearch);
		textSearch.setColumns(10);
		
		

		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				textID.setText((String) table.getValueAt(row, 0));
				textName.setText((String) table.getValueAt(row, 1));
				textPrice.setText((String) (table.getValueAt(row, 2) + ""));
				textTotal.setText((String) (table.getValueAt(row, 3) + ""));
				textArea.setText((String) (table.getValueAt(row, 4) + ""));
				textType.setText((String) (table.getValueAt(row, 5)+ ""));			
			}
		});
		

		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(18, 450, 704, 122);
		contentPane.add(scrollPane);
		
		
		String sort[] = {"Price ASC", "Price DEC", "Area ASC", "Area DEC"};
		@SuppressWarnings({ "rawtypes", "unchecked" })
		JComboBox comboBox = new JComboBox(sort);
		comboBox.setBackground(new Color(255, 255, 255));
		comboBox.setBounds(107, 381, 220, 23);
		comboBox.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		contentPane.add(comboBox);
		
		
		JLabel lblNewLabel_8 = new JLabel("Sort");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_8.setBounds(20, 381, 89, 28);
		contentPane.add(lblNewLabel_8);
		
		JButton btnback = new JButton("BACK HOME");
		btnback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QuanLyGUI qlv = new QuanLyGUI();
				qlv.setVisible(true);
				qlv.setLocationRelativeTo(null);
				HousingGUI.this.dispose();

			}
		});
		btnback.setBackground(new Color(65, 105, 225));
		btnback.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnback.setBounds(208, 583, 158, 30);
		contentPane.add(btnback);
		
		JButton btnNewButton_1 = new JButton("EXIT");
		btnNewButton_1.setVerticalAlignment(SwingConstants.TOP);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton_1.setBackground(new Color(65, 105, 225));
		btnNewButton_1.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnNewButton_1.setBounds(376, 583, 156, 30);
		contentPane.add(btnNewButton_1);
		
		JButton btnSort = new JButton("Sort");
		btnSort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String valueSort = (String) comboBox.getSelectedItem();
				if(valueSort.equals("Price ASC")) {
					Housing.sortedHousingPrice(lst, true);
					textStatus.setText("The list has been sorted in ascending order by price");	
					StatusTimer();
				}
				if(valueSort.equals("Price DEC")) {
					Housing.sortedHousingPrice(lst, false);
					textStatus.setText("The list has been sorted in descending order by price");
					StatusTimer();
				}
				if(valueSort.equals("Area ASC")) {
					Housing.sortedHousingArea(lst, true);
					textStatus.setText("The list has been sorted in ascending order by area");
					StatusTimer();
				}
				if(valueSort.equals("Area DEC")) {
					Housing.sortedHousingArea(lst, false);
					textStatus.setText("The list has been sorted in descending order by price");
					StatusTimer();
				}
				
				try {
					writeToFile(lst, "Housing.bin");
					lst = HousingData.fileRead("Housing.bin");
					fillTable(lst);
					xoaForm();
				} catch (IOException | ClassNotFoundException e2) {
					e2.printStackTrace();
				}
			}
		});
		btnSort.setBackground(new Color(0, 191, 255));
		btnSort.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSort.setBounds(348, 381, 80, 23);
		contentPane.add(btnSort);
		
		
		JButton btnNewButton = new JButton("Statistical");
		
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
				textStatus.setText("Statistic Success!!! The list statistics by the number of Housing type!!!");
				StatusTimer();
				
				BarChartStatistic bc = new BarChartStatistic();
				bc.setVisible(true);
				bc.setLocationRelativeTo(null);
				bc.setSize(730, 450);
				bc.setResizable(false);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBackground(new Color(0, 191, 255));
		btnNewButton.setBounds(552, 346, 102, 23);
		contentPane.add(btnNewButton);
		
		
		JScrollPane scrollPane_1 = new JScrollPane(tableStatistic);
		scrollPane_1.setBounds(484, 60, 238, 271);
		contentPane.add(scrollPane_1);
		
		//Set Icon
		URL ic = HousingGUI.class.getResource("housingicon.png");
		Image img = Toolkit.getDefaultToolkit().createImage(ic);
		this.setIconImage(img);

	}

	/**
	 * Hàm khởi tạo bảng
	 */
	private void initTable() {		
		table.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		table.setBackground(new Color(253, 245, 230));
		table.getTableHeader().setFont(new Font("Times New Roman", Font.BOLD, 14));
		table.getTableHeader().setBackground(new Color(255, 228, 181));
		table.setModel(tableModel);
		tableModel.addColumn("Product_ID");
		tableModel.addColumn("Product_Name");
		tableModel.addColumn("Product_Price");
		tableModel.addColumn("Product_Total");
		tableModel.addColumn("Housing_Area");
		tableModel.addColumn("Housing_Type");
	}
	
	/**
	 * Hàm khởi tạo bảng thống kê
	 */
	private void initTableS() {		
		tableStatistic.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		tableStatistic.setBackground(new Color(253, 245, 230));
		tableStatistic.getTableHeader().setFont(new Font("Times New Roman", Font.BOLD, 14));
		tableStatistic.getTableHeader().setBackground(new Color(255, 228, 181));
		tableStatistic.setModel(tableModel_S);
		tableModel_S.addColumn("Type");
		tableModel_S.addColumn("Total");
	}
	
	/**
	 * Hàm hiển thị dữ liệu lên bảng
	 * @param list
	 */
	private void fillTable(List<Housing> list) {
		tableModel.setRowCount(0);
		Object o[] = new Object[lst.size()];
		for(Housing h:lst) {
			o[0] = h.getProduct_id();
			o[1] = h.getProduct_name();
			o[2] = h.getProduct_price();
			o[3] = h.getProduct_total();
			o[4] = h.getHousing_area();
			o[5] = h.getHousing_type();
			tableModel.addRow(o);
		}
		
		table.setRowHeight(25);
		
		DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        
        for (int columnIndex = 0; columnIndex < tableModel.getColumnCount(); columnIndex++)
        {
            table.getColumnModel().getColumn(columnIndex).setCellRenderer(rightRenderer);
        }
	}
	
	/**
	 * Hàm hiển thị dữ liệu lên bảng thống kê
	 * @param list
	 */
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
	
	/**
	 * Hàm reset textField
	 */
	public void xoaForm() {
		textID.setText("");
		textName.setText("");
		textPrice.setText("");
		textTotal.setText("");
		textArea.setText("");
		textType.setText("");
	}
	
	/**
	 * Hàm set filter cho bảng
	 * @param query
	 */
	private void filter(String query) {
		TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(tableModel);
		table.setRowSorter(tr);
		tr.setRowFilter(RowFilter.regexFilter(query));
	}
	
	/**
	 * Hàm cài đặt thời gian hẹn giờ cho textStatus
	 */
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
	
	public static void writeToFile(List<Housing> listHou, String fileName) throws IOException {
		HousingData.fileWrite(listHou, fileName);
	}
	
	/**
	 * Hàm đếm số loại Housing_type
	 * @param name
	 * @return
	 */
	public static int Sa(String name) {
		int count = 0;
		for(Housing o:lst) {
			if (o.getHousing_type().equals(name)) {
				count++;
			}
		}
		return count;
	}
	
	/**
	 * Hàm lưu thông tin thống kê vào list
	 * @return
	 */
	public static List<TypeStatic> addStatic() {
		List<TypeStatic> lt = new ArrayList<>();
		
		lt.add( new TypeStatic("Villa", Sa("Villa")));
		lt.add( new TypeStatic("Apartment", Sa("Apartment")));
		lt.add( new TypeStatic("Home", Sa("Home")));
		lt.add( new TypeStatic("Shophouse", Sa("Shophouse")));
		lt.add( new TypeStatic("Resort", Sa("Resort")));
		lt.add( new TypeStatic("Officetel", Sa("Officetel")));
		lt.add( new TypeStatic("Motel", Sa("Motel")));
		
		return lt;
	}
}