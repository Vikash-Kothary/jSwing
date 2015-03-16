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
	private ArrayList<JScrollPane> lists;
	private ArrayList<JScrollPane> textAreas;
	private ArrayList<JTextField> textFields;

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
    
    public JScrollPane getList(String text){
    	for(JScrollPane list : lists){
    		if (list.getName().contains(text)){
    			return list;
    		}
    	}
		return null;
    }
    
    public JScrollPane getTextArea(String text){
    	for(JScrollPane tArea : textAreas){
    		if(tArea.getName().contains(text)){
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
    
    public JScrollPane addTextArea(String text) {
        JTextArea textArea = new JTextArea(text);
        textArea.setName(text);
        JScrollPane scrollPane = new JScrollPane(textArea);
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

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public JScrollPane addList(String[] text, String listName, String scrollName) {
		if(text!=null){
	        JList list = new JList(text);
	        list.setName(listName);
	        JScrollPane scrollPane = new JScrollPane(list);
	        scrollPane.setName(scrollName);
	        lists.add(scrollPane);
	        add(scrollPane);
//	        lists.add(list);
//	        return list;
		}
		return null;
    }
	
	public JList setList(String[] text, JList list, JScrollPane scrollPane){
	
		list.setListData(text);
		scrollPane.setViewportView(list);
		scrollPane.revalidate();
		scrollPane.repaint();
		return null;
	}

    public void setPadding(int top, int left, int bottom, int right) {
        setBorder(new EmptyBorder(top, left, bottom, right));
    }

}
