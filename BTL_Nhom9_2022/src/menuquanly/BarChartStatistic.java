package menuquanly;

import java.awt.EventQueue;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import org.jfree.chart.*;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;


public class BarChartStatistic extends JFrame {

	private JPanel contentPane;
	private static List<TypeStatic> tmp = new ArrayList<>();


	/**
	 * Create the frame.
	 */
	public BarChartStatistic() {
		this.setTitle("BIỂU ĐỒ");
		this.setSize(730, 450);
		this.setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		ChartPanel chartPanel = new ChartPanel(createChart());
		chartPanel.setPreferredSize(new java.awt.Dimension(700, 367));
		contentPane.add(chartPanel);
	}
	
	public static JFreeChart createChart() {
		JFreeChart barChart = ChartFactory.createBarChart("BIỂU ĐỒ THỐNG KÊ", "Type", "Total",
				createDataset(), PlotOrientation.VERTICAL, false, false, false);
		return barChart;
	}
	
	public static CategoryDataset createDataset() {
		try {
			tmp = Statistic.fileRead("Report.bin");
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		for(TypeStatic o : tmp) {
			dataset.addValue(o.getSumTotal(), "Số lượng", o.getType());		
		}
		return dataset;
	}

}
