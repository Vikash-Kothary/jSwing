// Vikash Kothary
package jSwing;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class jPanel extends JPanel {
	
    private Image bgImage = null;
	private int width, height;
    private ArrayList<JLabel> labels;
    private ArrayList<JButton> buttons;
	private ArrayList<jScrollPane> lists;
	private ArrayList<jScrollPane> textAreas;
	private ArrayList<JTextField> textFields;
	private ArrayList<JList> temps;

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
        labels = new ArrayList<>();
        buttons = new ArrayList<>();
        lists = new ArrayList<>();
        textAreas = new ArrayList<>();
        textFields = new ArrayList<>();
        temps = new ArrayList<>();
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
    
    public JTextField getTextField(String text){
    	for(JTextField tField : textFields){
    		if(tField.getName().contains(text)){
    			return tField;
    		}
    	}
    	return null;
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
	        list.setName("studentList");
	        jScrollPane scrollPane = new jScrollPane(list, name);
	        temps.add(list);
	        lists.add(scrollPane);
	        add(scrollPane);
	        return scrollPane;
		}
		return null;
    }
	
	
    public void setPadding(int top, int left, int bottom, int right) {
        setBorder(new EmptyBorder(top, left, bottom, right));
    }

}
