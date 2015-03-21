/*
 * PRA Coursework - Deep Vein Thrombosis
 * @author  Vikash Kothary
 * @author  Toby Birkett
 */
package jSwing;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JProgressBar;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.border.EmptyBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 * The Class jPanel.
 */
@SuppressWarnings("serial")
public class jPanel extends JPanel {
	// TODO remove dependency on jScrollPane as deprecated
	/** The bg image. */
	private Image bgImage = null;
	
	/** The buttons. */
	private ArrayList<JButton> buttons;
	
	/** The check boxes. */
	private ArrayList<JCheckBox> checkBoxes;
	
	/** The combo boxes. */
	private ArrayList<JComboBox<?>> comboBoxes;
	
	/** The labels. */
	private ArrayList<JLabel> labels;
	
	/** The lists. */
	private ArrayList<jScrollPane> lists;
	
	/** The panels. */
	private ArrayList<jPanel> panels;
	
	/** The password fields. */
	private ArrayList<JPasswordField> passwordFields;
	
	/** The progress bars. */
	private ArrayList<JProgressBar> progressBars;
	
	/** The rand. */
	private Random rand = new Random();
	
	/** The scroll panels. */
	private ArrayList<jScrollPane> scrollPanels;
	
	/** The series. */
	private final XYSeries series = new XYSeries("StudentData");
	
	/** The spinners. */
	private ArrayList<JSpinner> spinners;

	/** The tabbed panes. */
	private ArrayList<jTabbedPane> tabbedPanes;
	
	/** The tables. */
	private ArrayList<jScrollPane> tables;

	/** The text areas. */
	private ArrayList<jScrollPane> textAreas;
	
	/** The text fields. */
	private ArrayList<JTextField> textFields;

	// Constructor
	/**
	 * Instantiates a new j panel.
	 */
	public jPanel() {
		super();
		_init();
	}

	// // use only for layout-less panel
	// public jPanel(int _width, int _height) {
	// width = _width;
	// height = _height;
	// _init();
	//
	// }

	/**
	 * _init.
	 */
	private void _init() {
		panels = new ArrayList<>();
		scrollPanels = new ArrayList<>();
		labels = new ArrayList<>();
		buttons = new ArrayList<>();
		lists = new ArrayList<>();
		textAreas = new ArrayList<>();
		textFields = new ArrayList<>();
		tabbedPanes = new ArrayList<>();
		tables = new ArrayList<>();
		checkBoxes = new ArrayList<>();
		spinners = new ArrayList<>();
		comboBoxes = new ArrayList<>();
		passwordFields = new ArrayList<>();
		progressBars = new ArrayList<>();
	}

	/**
	 * Adds the button.
	 *
	 * @param text
	 *            the text
	 * @return the j button
	 */
	public JButton addButton(String text) {
		JButton button = new JButton(text);
		add(button);
		buttons.add(button);
		return button;
	}

	/**
	 * Adds the button.
	 *
	 * @param text
	 *            the text
	 * @param format
	 *            the format
	 * @return the j button
	 */
	public JButton addButton(String text, String format) {
		JButton button = new JButton(text);
		add(button, format);
		buttons.add(button);
		return button;
	}

	/**
	 * Adds the check box.
	 *
	 * @param text
	 *            the text
	 * @return the j check box
	 */
	public JCheckBox addCheckBox(String text) {
		JCheckBox checkBox = new JCheckBox(text);

		add(checkBox);
		checkBoxes.add(checkBox);
		return checkBox;
	}

	/**
	 * Adds the combo box.
	 *
	 * @param fields
	 *            the fields
	 * @param name
	 *            the name
	 * @return the j combo box
	 */
	public JComboBox<?> addComboBox(String[] fields, String name) {
		JComboBox<?> comboBox = new JComboBox<>(fields);
		comboBox.setName(name);
		comboBoxes.add(comboBox);
		add(comboBox);
		return comboBox;
	}

	/**
	 * Adds the image.
	 *
	 * @param file
	 *            the file
	 */
	public void addImage(File file) {
		try {
			Image image = ImageIO.read(file);
			JLabel picLabel = new JLabel(new ImageIcon(image));
			// picLabel.setBorder(BorderFactory.createLineBorder(Color.black));
			add(picLabel);
		} catch (IOException e) {
			System.out.println(e);
		}
	}

	/**
	 * Adds the image.
	 *
	 * @param url
	 *            the url
	 */
	public void addImage(URL url) {
		try {
			Image image = ImageIO.read(url);
			JLabel picLabel = new JLabel(new ImageIcon(image));
			// picLabel.setBorder(BorderFactory.createLineBorder(Color.black));
			add(picLabel);
		} catch (IOException e) {
			System.out.println(e);
		}
	}

	/**
	 * Adds the label.
	 *
	 * @param text
	 *            the text
	 * @return the j label
	 */
	public JLabel addLabel(String text) {
		JLabel label = new JLabel(text);
		label.setName(text);
		add(label);
		labels.add(label);
		return label;
	}
	
	/**
	 * Adds the label.
	 *
	 * @param text
	 *            the text
	 * @param format
	 *            the format
	 * @param name
	 *            the name
	 * @return the j label
	 */
	public JLabel addLabel(String text, String format, String name) {
		JLabel label = new JLabel(text);
		label.setName(name);
		add(label, format);
		labels.add(label);
		return label;
	}

	/**
	 * Adds the label.
	 *
	 * @param text
	 *            the text
	 * @param format
	 *            the format
	 * @return the j label
	 */
	public JLabel addLabel(String text, String format) {
		JLabel label = new JLabel(text);
		add(label, format);
		labels.add(label);
		return label;
	}

	/**
	 * Adds the list.
	 *
	 * @param text
	 *            the text
	 * @param name
	 *            the name
	 * @return the j scroll pane
	 */
	public jScrollPane addList(String[] text, String name) {
		if (text != null) {
			JList<?> list = new JList<>(text);
			list.setName(name);
			jScrollPane scrollPane = new jScrollPane(list, name);
			lists.add(scrollPane);
			add(scrollPane);
			return scrollPane;
		}
		return null;
	}

	/**
	 * Adds the pane.
	 *
	 * @param text
	 *            the text
	 * @return the j tabbed pane
	 */
	public jTabbedPane addPane(String text) {
		jTabbedPane pane = new jTabbedPane();
		pane.setName(text);
		tabbedPanes.add(pane);
		add(pane);
		return pane;
	}

	/**
	 * Adds the pane.
	 *
	 * @param text
	 *            the text
	 * @param format
	 *            the format
	 * @return the j tabbed pane
	 */
	public jTabbedPane addPane(String text, String format) {
		jTabbedPane pane = new jTabbedPane();
		pane.setName(text);
		tabbedPanes.add(pane);
		add(pane);
		return pane;
	}

	/**
	 * Adds the panel.
	 *
	 * @param name
	 *            the name
	 * @return the j panel
	 */
	public jPanel addPanel(String name) {
		jPanel panel = new jPanel();
		panel.setName(name);
		add(panel);
		panels.add(panel);
		return panel;
	}

	// public JScrollPane addTextArea(String text, Rectangle location, boolean
	// edit) {
	// JTextArea textArea = new JTextArea(text);
	// textArea.setEditable(edit);
	// JScrollPane scrollPane = new JScrollPane(textArea);
	// scrollPane.setBounds(location);
	// add(scrollPane);
	// return scrollPane;
	// }

	/**
	 * Adds the panel.
	 *
	 * @param name
	 *            the name
	 * @param format
	 *            the format
	 * @return the j panel
	 */
	public jPanel addPanel(String name, String format) {
		jPanel panel = new jPanel();
		panel.setName(name);
		add(panel, format);
		panels.add(panel);
		return panel;
	}

	// public JButton addButton(String name, Rectangle location) {
	// JButton button = new JButton(name);
	// button.setBounds(location);
	// add(button);
	// return button;
	// }

	// public void addImage(String path, Rectangle location) {
	// try {
	// Image image = ImageIO.read(new File(path));
	// image.getScaledInstance(location.width, location.height,
	// Image.SCALE_SMOOTH);
	// JLabel picLabel = new JLabel(new ImageIcon(image));
	// picLabel.setBounds(location);
	// picLabel.setBorder(BorderFactory.createLineBorder(Color.black));
	// add(picLabel);
	// } catch (IOException e) {
	// System.out.println(e);
	// }
	// }

	/**
	 * Adds the password field.
	 *
	 * @param name
	 *            the name
	 * @return the j password field
	 */
	public JPasswordField addPasswordField(String name) {
		JPasswordField passwordField = new JPasswordField();
		passwordField.setName(name);
		passwordFields.add(passwordField);
		add(passwordField);
		return passwordField;
	}

	/**
	 * Adds the progress bar.
	 *
	 * @param min
	 *            the min
	 * @param max
	 *            the max
	 * @param name
	 *            the name
	 * @return the j progress bar
	 */
	public JProgressBar addProgressBar(int min, int max, String name) {
		JProgressBar progressBar = new JProgressBar(min, max);
		progressBar.setName(name);
		progressBars.add(progressBar);
		add(progressBar);
		return progressBar;
	}

	/**
	 * Adds the scaled image.
	 *
	 * @param path
	 *            the path
	 * @param imgWidth
	 *            the img width
	 * @param imgHeight
	 *            the img height
	 */
	public void addScaledImage(String path, int imgWidth, int imgHeight) {
		try {
			Image image = ImageIO.read(new File(path));
			image = image.getScaledInstance(imgWidth, imgHeight,
					Image.SCALE_SMOOTH);
			JLabel picLabel = new JLabel(new ImageIcon(image));
			// picLabel.setBorder(BorderFactory.createLineBorder(Color.black));
			add(picLabel);
		} catch (IOException e) {
			System.out.println(e);
		}
	}

	/**
	 * Adds the scroll panel.
	 *
	 * @param panelName
	 *            the panel name
	 * @return the j scroll pane
	 */
	public jScrollPane addScrollPanel(String panelName) {
		jPanel panel = new jPanel();
		panel.setName(panelName);
		jScrollPane scrollPane = new jScrollPane(panel, panelName);
		scrollPanels.add(scrollPane);
		add(scrollPane);
		return scrollPane;
	}

	/**
	 * Adds the scroll panel.
	 *
	 * @param panelName
	 *            the panel name
	 * @param format
	 *            the format
	 * @return the j scroll pane
	 */
	public jScrollPane addScrollPanel(String panelName, String format) {
		jPanel panel = new jPanel();
		panel.setName(panelName);
		jScrollPane scrollPane = new jScrollPane(panel, panelName);
		scrollPanels.add(scrollPane);
		add(scrollPane, format);
		return scrollPane;
	}

	/**
	 * Adds the spinner.
	 *
	 * @param spinnerModel
	 *            the spinner model
	 * @return the j spinner
	 */
	public JSpinner addSpinner(SpinnerModel spinnerModel) {
		JSpinner spinner = new JSpinner(spinnerModel);
		spinners.add(spinner);
		add(spinner);
		return spinner;

	}

	/**
	 * Adds the spinner.
	 *
	 * @param spinnerModel
	 *            the spinner model
	 * @param name
	 *            the name
	 * @return the j spinner
	 */
	public JSpinner addSpinner(SpinnerModel spinnerModel, String name) {
		JSpinner spinner = new JSpinner(spinnerModel);
		spinner.setName(name);
		spinners.add(spinner);
		add(spinner);
		return spinner;
	}

	/**
	 * Adds the table.
	 *
	 * @param name
	 *            the name
	 * @param data
	 *            the data
	 * @param headers
	 *            the headers
	 * @return the j scroll pane
	 */
	public jScrollPane addTable(String name, Object[][] data, String[] headers) {
		JTable table = new JTable(data, headers);
		table.setName(name);
		jScrollPane scrollTable = new jScrollPane(table, name);
		tables.add(scrollTable);
		add(scrollTable);
		return scrollTable;

	}

	/**
	 * Adds the text area.
	 *
	 * @param text
	 *            the text
	 * @param name
	 *            the name
	 * @return the j scroll pane
	 */
	public jScrollPane addTextArea(String text, String name) {
		JTextArea textArea = new JTextArea(text);
		textArea.setName(name);
		jScrollPane scrollPane = new jScrollPane(textArea, name);
		textAreas.add(scrollPane);
		add(scrollPane);
		return scrollPane;
	}

	/**
	 * Adds the text field.
	 *
	 * @param text
	 *            the text
	 * @param name
	 *            the name
	 * @param format
	 *            the format
	 * @return the j text field
	 */
	public JTextField addTextField(String text, String name, String format) {
		JTextField textField = new JTextField();
		textField.setName(name);
		textFields.add(textField);
		add(textField, format);
		return textField;
	}



	/**
	 * Creates the chart panel.
	 *
	 * @param studentData
	 *            the student data
	 * @param name
	 *            the name
	 * @param axis
	 *            the axis
	 * @param dimensions
	 *            the dimensions
	 * @return the chart panel
	 */
	public ChartPanel createChartPanel(XYDataset studentData, String name, String[] axis, int[] dimensions) {
		JFreeChart chartPanel1 = ChartFactory.createScatterPlot(
				name, axis[0], axis[1],
				studentData);
		ChartPanel chartPanel2 = new ChartPanel(chartPanel1);
		chartPanel2.setPreferredSize(new Dimension(dimensions[0],dimensions[1]));
		add(chartPanel2);
		return chartPanel2;

	}

	// public JButton addButton(String name, Rectangle location) {
	// JButton button = new JButton(name);
	// button.setBounds(location);
	// add(button);
	// return button;
	// }

	/**
	 * Creates the data.
	 *
	 * @return the XY dataset
	 */
	private XYDataset createData() {
		XYSeriesCollection studentData = new XYSeriesCollection();
		for (int i = 0; i < 25; i++) {
			series.add(rand.nextGaussian(), rand.nextGaussian());
		}
		studentData.addSeries(series);
		return studentData;
	}

	/**
	 * Gets the button.
	 *
	 * @param text
	 *            the text
	 * @return the button
	 */
	public JButton getButton(String text) {
		for (JButton button : buttons) {
			if (button.getText().contains(text)) {
				return button;
			}
		}
		return null;
	}

	// public JScrollPane addTextArea(String text, Rectangle location, boolean
	// edit) {
	// JTextArea textArea = new JTextArea(text);
	// textArea.setEditable(edit);
	// JScrollPane scrollPane = new JScrollPane(textArea);
	// scrollPane.setBounds(location);
	// add(scrollPane);
	// return scrollPane;
	// }

	// public void addImage(String path, Rectangle location) {
	// try {
	// Image image = ImageIO.read(new File(path));
	// image.getScaledInstance(location.width, location.height,
	// Image.SCALE_SMOOTH);
	// JLabel picLabel = new JLabel(new ImageIcon(image));
	// picLabel.setBounds(location);
	// picLabel.setBorder(BorderFactory.createLineBorder(Color.black));
	// add(picLabel);
	// } catch (IOException e) {
	// System.out.println(e);
	// }
	// }

	/**
	 * Gets the check box.
	 *
	 * @param text
	 *            the text
	 * @return the check box
	 */
	public JCheckBox getCheckBox(String text) {
		for (JCheckBox cBox : checkBoxes) {
			if (cBox.getText().contains(text)) {
				return cBox;
			}
		}
		return null;
	}

	/**
	 * Gets the combo box.
	 *
	 * @param text
	 *            the text
	 * @return the combo box
	 */
	public JComboBox<?> getComboBox(String text) {
		for (int i = 0; i < comboBoxes.size(); i++) {
			if (comboBoxes.get(i).getName().contains(text)) {
				return comboBoxes.get(i);
			}
		}
		return null;
	}

	/**
	 * Gets the label.
	 *
	 * @param text
	 *            the text
	 * @return the label
	 */
	public JLabel getLabel(String text) {
		for (JLabel label : labels) {
			if (label.getName().contains(text)) {
				return label;
			}
		}
		return null;
	}
	
	

	/**
	 * Gets the list.
	 *
	 * @param name
	 *            the name
	 * @return the list
	 */
	public jScrollPane getList(String name) {
		for (jScrollPane list : lists) {
			if (list.getName().equals(name)) {
				return list;
			}
		}
		return null;
	}

	/**
	 * Gets the panel.
	 *
	 * @param name
	 *            the name
	 * @return the panel
	 */
	public jPanel getPanel(String name) {
		for (jPanel panel : panels) {
			if (panel.getName().equals(name)) {
				return panel;
			}
		}
		return null;
	}

	/**
	 * Gets the password field.
	 *
	 * @param text
	 *            the text
	 * @return the password field
	 */
	public JPasswordField getPasswordField(String text) {
		for (JPasswordField passwordField : passwordFields) {
			if (passwordField.getName().contains(text)) {
				return passwordField;
			}
		}
		return null;
	}

	/**
	 * Gets the progress bar.
	 *
	 * @param text
	 *            the text
	 * @return the progress bar
	 */
	public JProgressBar getProgressBar(String text) {
		for (JProgressBar progressBar : progressBars) {
			if (progressBar.getName().contains(text)) {
				return progressBar;
			}
		}
		return null;
	}

	/**
	 * Gets the scroll panel.
	 *
	 * @param name
	 *            the name
	 * @return the scroll panel
	 */
	public jScrollPane getScrollPanel(String name) {
		for (jScrollPane panel : scrollPanels) {
			if (panel.getName().equals(name)) {
				return panel;
			}
		}
		return null;
	}

	/**
	 * Gets the spinner.
	 *
	 * @param text
	 *            the text
	 * @return the spinner
	 */
	public JSpinner getSpinner(String text) {
		for (JSpinner spinner : spinners) {
			if (spinner.getName().contains(text)) {
				return spinner;
			}
		}
		return null;
	}

	/**
	 * Gets the tabbed pane.
	 *
	 * @param text
	 *            the text
	 * @return the tabbed pane
	 */
	public jTabbedPane getTabbedPane(String text) {
		for (jTabbedPane tPane : tabbedPanes) {
			if (tPane.getName().contains(text)) {
				return tPane;
			}
		}
		return null;
	}

	/**
	 * Gets the text area.
	 *
	 * @param name
	 *            the name
	 * @return the text area
	 */
	public jScrollPane getTextArea(String name) {
		for (jScrollPane tArea : textAreas) {
			if (tArea.getName().equals(name)) {
				return tArea;
			}
		}
		return null;
	}

	/**
	 * Gets the text field.
	 *
	 * @param text
	 *            the text
	 * @return the text field
	 */
	public JTextField getTextField(String text) {
		for (JTextField tField : textFields) {
			if (tField.getName().contains(text)) {
				return tField;
			}
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (bgImage != null) {
			g.drawImage(bgImage, 0, 0, this);
		}
	}

	/**
	 * Sets the background.
	 *
	 * @param path
	 *            the new background
	 */
	public void setBackground(String path) {
		bgImage = new ImageIcon(path).getImage().getScaledInstance(
				this.getWidth(), getHeight(), Image.SCALE_FAST);
		repaint();
	}

	/**
	 * Sets the padding.
	 *
	 * @param top
	 *            the top
	 * @param left
	 *            the left
	 * @param bottom
	 *            the bottom
	 * @param right
	 *            the right
	 */
	public void setPadding(int top, int left, int bottom, int right) {
		setBorder(new EmptyBorder(top, left, bottom, right));
	}

	

}
