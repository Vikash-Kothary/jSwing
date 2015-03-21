package PRA;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.Random;

import javax.swing.JTable;

import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import jSwing.jFrame;
import jSwing.jPanel;
import jSwing.jTabbedPane;

public class ScatterPlotWindow extends jFrame{
	
	private Random rand = new Random();
	private XYSeries series = new XYSeries("StudentData");
	
	public ScatterPlotWindow(StudentList mainList, jTabbedPane tabbedPane ){
		super("ScatterPlot");
		setSize(1000,600);
		jPanel container = addContainer();
		container.setLayout(new BorderLayout());
		container.setPadding(5, 5, 5, 5);
		XYSeriesCollection studentData = new XYSeriesCollection();	
		String name = "Student ScatterPlot";
		String[] axis = {"Current Assessment Result", "Student Average Result"};
		int[] dimensions = {1100, 500};
		series = getData(tabbedPane, mainList);
		studentData.addSeries(series);
		container.createChartPanel(studentData, name, axis, dimensions);
		centreFrame();
		setVisible(true);
	}
	
	public XYSeries getData(jTabbedPane tabbedPane, StudentList mainList){
		JTable selectedTable = tabbedPane.getTab(tabbedPane.getSelectedIndex()).getTable();
//		String candKey = null;
		for (int i = 0; i < selectedTable.getRowCount(); i++){
			double average = 0;
			String candKey = (String) selectedTable.getValueAt(i, 2);
			int numberOfAverageTabs = tabbedPane.getTabCount() -1;
			for(int j = 0; j<tabbedPane.getTabCount(); j++){
				tabbed_if : if (j != tabbedPane.getSelectedIndex()){
								JTable nonSelectedTable = tabbedPane.getTab(j).getTable();
								if(i >= nonSelectedTable.getRowCount()){numberOfAverageTabs-=1; break tabbed_if;}
								if ((String) nonSelectedTable.getValueAt(i, 2) != candKey){numberOfAverageTabs-=1; break tabbed_if;}
								average += Integer.valueOf((String) nonSelectedTable.getValueAt(i, 3));	
							}	
					}	
					average = average / (numberOfAverageTabs);
					double x = (Double.valueOf((String) selectedTable.getValueAt(i, 3)));
					series.add(x, average);
		}
		return series;
	}
}
