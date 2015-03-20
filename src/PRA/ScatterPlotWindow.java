package PRA;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.Random;

import javax.swing.JTable;

import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import jSwing.jFrame;
import jSwing.jPanel;

public class ScatterPlotWindow extends jFrame{
	
	private Random rand = new Random();
	private final XYSeries series = new XYSeries("StudentData");
	
	public ScatterPlotWindow(XYSeriesCollection studentData ){
		super("ScatterPlot");
		setSize(1000,600);
		jPanel container = addContainer();
		container.setLayout(new BorderLayout());
		container.setPadding(5, 5, 5, 5);
		
		container.createChartPanel(studentData);

//		pack();
		centreFrame();
		setVisible(true);
	}

}
