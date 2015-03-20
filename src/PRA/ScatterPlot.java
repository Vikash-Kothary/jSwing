package PRA;

import java.awt.GridLayout;
import java.util.Random;

import javax.swing.JTable;

import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import jSwing.jFrame;
import jSwing.jPanel;

public class ScatterPlot extends jFrame{
	
	private Random rand = new Random();
	private final XYSeries series = new XYSeries("StudentData");
	
	public ScatterPlot(XYSeriesCollection studentData ){
		super("ScatterPlot");
		setSize(1200,600);
		jPanel container = addContainer();
		jPanel scatterPanel = container.addPanel("scatterPanel");
		scatterPanel.setLayout(new GridLayout(1,1));
		
			

		getFrameContainer().getPanel("scatterPanel").createChartPanel(studentData);


		setVisible(true);
	}

}
