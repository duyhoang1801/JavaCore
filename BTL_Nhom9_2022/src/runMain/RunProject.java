package runMain;

import login.*;
import menuquanly.QuanLyGUI;
import housingql.*;
import computerql.*;

import java.io.IOException;

import javax.swing.UIManager;

import org.jfree.chart.labels.AbstractCategoryItemLabelGenerator;

import Tile1.*;
import tile2.*;

public class RunProject {
	
	public static void main(String[] args) {
		try {			
			LoginGUI lg = new LoginGUI();
			lg.setVisible(true);
			lg.setLocationRelativeTo(null);
			lg.setResizable(false);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
