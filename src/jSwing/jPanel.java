// Vikash Kothary
package jSwing;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import PRA.Results;

@SuppressWarnings("serial")
public class jPanel extends JPanel {
	
    private Image bgImage = null;
	private int width, height;
	private ArrayList<jPanel> panels;
    private ArrayList<JLabel> labels;
    private ArrayList<JButton> buttons;
	private ArrayList<jScrollPane> lists;
	private ArrayList<jScrollPane> textAreas;
	private ArrayList<JTextField> textFields;
	private ArrayList<JTabbedPane> tabbedPanes;
	private ArrayList<JTable> tables;
	private ArrayList<JCheckBox> checkBoxes;
	
	
	private Random rand = new Random();
	private final XYSeries series = new XYSeries("StudentData");

    // Constructor
    public jPanel() {
    	super();
        _init();
    }

//    // use only for layout-less panel
//    public jPanel(int _width, int _height) {
//        width = _width;
//        height = _height;
//        _init();
//    
//    }
    
    private void _init() {
    	panels = new ArrayList<>();
        labels = new ArrayList<>();
        buttons = new ArrayList<>();
        lists = new ArrayList<>();
        textAreas = new ArrayList<>();
        textFields = new ArrayList<>();
        tabbedPanes = new ArrayList<>();
        tables = new ArrayList<>();
        checkBoxes = new ArrayList<>();
    }

    public void setBackground(String path) {
        bgImage = new ImageIcon(path).getImage()
                .getScaledInstance(this.getWidth(), getHeight(), Image.SCALE_FAST);
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (bgImage != null) {
            g.drawImage(bgImage, 0, 0, this);
        }
    }
    
    public jPanel getPanel(String name){
    	for (jPanel panel : panels) {
            if (panel.getName().equals(name)) {
                return panel;
            }
        }
        return null;
    }

    public JLabel getLabel(String text) {
        for (JLabel label : labels) {
            if (label.getText().contains(text)) {
                return label;
            }
        }
        return null;
    }

    public JButton getButton(String text) {
        for (JButton button : buttons) {
            if (button.getText().contains(text)) {
                return button;
            }
        }
        return null;
    }
    
    public jScrollPane getList(String name){
    	for(jScrollPane list : lists){
    		if (list.getName().equals(name)){
    			return list;
    		}
    	}
		return null;
    }
    
    public jScrollPane getTextArea(String name){
    	for(jScrollPane tArea : textAreas){
    		if(tArea.getName().equals(name)){
    			return tArea;
    		}
    	}
		return null;
    }
    
    public jPanel getScrollPanel(String name){
    	for(jPanel panel : panels){
    		if(panel.getName().equals(name)){
    			return panel;
    		}
    	}
    	return null;
    }
    
    public JTextField getTextField(String text){
    	for(JTextField tField : textFields){
    		if(tField.getName().contains(text)){
    			return tField;
    		}
    	}
    	return null;
    }
    
    public JTabbedPane getTabbedPane(String text){
    	for(JTabbedPane tPane : tabbedPanes){
    		if(tPane.getName().contains(text)){
    			return tPane;
    		}
    	}
    	return null;
    }
    
    public JCheckBox getCheckBox(String text){
    	for (JCheckBox cBox : checkBoxes){
    		if(cBox.getText().contains(text)){
    			return cBox;
    		}
    	}
    	return null;
    }
    
    public jPanel addPanel(String name){
    	jPanel panel = new jPanel();
    	panel.setName(name);
    	add(panel);
    	panels.add(panel);
    	return panel;
    }
    
    public jPanel addPanel(String name, String format){
    	jPanel panel = new jPanel();
    	panel.setName(name);
    	add(panel, format);
    	panels.add(panel);
    	return panel;
    }
//    public JButton addButton(String name, Rectangle location) {
//        JButton button = new JButton(name);
//        button.setBounds(location);
//        add(button);
//        return button;
//    }
    
    public JButton addButton(String text) {
        JButton button = new JButton(text);
        add(button);
        buttons.add(button);
        return button;
    }

    public JButton addButton(String text, String format) {
        JButton button = new JButton(text);
        add(button, format);
        buttons.add(button);
        return button;
    }
    
    public JTextField addTextField(String text, String name, String format){
    	JTextField textField = new JTextField();
    	textField.setText(text);
    	textField.setName(name);
    	textFields.add(textField);
    	add(textField, format);
    	
    	return textField;
    }

//    public JScrollPane addTextArea(String text, Rectangle location, boolean edit) {
//        JTextArea textArea = new JTextArea(text);
//        textArea.setEditable(edit);
//        JScrollPane scrollPane = new JScrollPane(textArea);
//        scrollPane.setBounds(location);
//        add(scrollPane);
//        return scrollPane;
//    }
    
    public jScrollPane addTextArea(String text, String name) {
        JTextArea textArea = new JTextArea(text);
        jScrollPane scrollPane = new jScrollPane(textArea, name);
        textAreas.add(scrollPane);
        add(scrollPane);
        return scrollPane;
    }

//    public void addImage(String path, Rectangle location) {
//        try {
//            Image image = ImageIO.read(new File(path));
//            image.getScaledInstance(location.width, location.height, Image.SCALE_SMOOTH);
//            JLabel picLabel = new JLabel(new ImageIcon(image));
//            picLabel.setBounds(location);
//            picLabel.setBorder(BorderFactory.createLineBorder(Color.black));
//            add(picLabel);
//        } catch (IOException e) {
//            System.out.println(e);
//        }
//    }
    
    public void addImage(File file) {
        try {
            Image image = ImageIO.read(file);
            JLabel picLabel = new JLabel(new ImageIcon(image));
//            picLabel.setBorder(BorderFactory.createLineBorder(Color.black));
            add(picLabel);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public void addImage(URL url) {
        try {
            Image image = ImageIO.read(url);
            JLabel picLabel = new JLabel(new ImageIcon(image));
//            picLabel.setBorder(BorderFactory.createLineBorder(Color.black));
            add(picLabel);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public void addScaledImage(String path, int imgWidth, int imgHeight) {
        try {
            Image image = ImageIO.read(new File(path));
            image = image.getScaledInstance(imgWidth, imgHeight, Image.SCALE_SMOOTH);
            JLabel picLabel = new JLabel(new ImageIcon(image));
//            picLabel.setBorder(BorderFactory.createLineBorder(Color.black));
            add(picLabel);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public JLabel addLabel(String text) {
        JLabel label = new JLabel(text);
        add(label);
        labels.add(label);
        return label;
    }

    public JLabel addLabel(String text, String format) {
        JLabel label = new JLabel(text);
        add(label, format);
        labels.add(label);
        return label;
    }

	public jScrollPane addList(String[] text, String name) {
		if(text!=null){
	        JList list = new JList(text);
	        list.setName(name);
	        jScrollPane scrollPane = new jScrollPane(list, name);
	        lists.add(scrollPane);
	        add(scrollPane);
	        return scrollPane;
		}
		return null;
    }
	
	public jScrollPane addScrollPanel(String panelName, String paneName){
		
			jPanel panel = new jPanel();
			panel.setName(panelName);
			jScrollPane scrollPane = new jScrollPane(panel, paneName);
			scrollPane.setName(paneName);
			panels.add(panel);
			add(scrollPane);
			return scrollPane;
		
	}
	
	
	
	public JCheckBox addCheckBox(String text){
		JCheckBox checkBox = new JCheckBox(text);
		
		add(checkBox);
		checkBoxes.add(checkBox);
		return checkBox;
	}

	
	public JTabbedPane addPane(String text){
		JTabbedPane pane = new JTabbedPane();
		pane.setName(text);
		tabbedPanes.add(pane);
		add(pane);
		return pane;
		
	}
	
	public JTable addTable (String text, Object[][] results, String[] columns){
		JTable table = new JTable(results, columns);
		table.setName(text);
		//add(table);
		tables.add(table);
		return table;
		
	}
	
	
	public ChartPanel createChartPanel(){
		JFreeChart chartPanel1 = ChartFactory.createScatterPlot(
				"Student Scatter", "Student Average", "Selected Result", createData());
		ChartPanel chartPanel2 = new ChartPanel(chartPanel1);
		chartPanel2.setPreferredSize(new Dimension(500,500));

		return chartPanel2;
		
	}
	
	private XYDataset createData(){
		XYSeriesCollection studentData = new XYSeriesCollection();
		for (int i = 0; i< 25; i++){
			series.add(rand.nextGaussian(), rand.nextGaussian());
		}
		studentData.addSeries(series);
		return studentData;
	}
	
	

    public void setPadding(int top, int left, int bottom, int right) {
        setBorder(new EmptyBorder(top, left, bottom, right));
    }

}
