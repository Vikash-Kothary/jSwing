package GUIClasses;



import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class jPanel extends JPanel {
    private Image bgImage = null;
    private Dimension size = null;

    public jPanel() { // Constructor
     //   setLayout(null); // allows objects to be moved anywhere
//        size = new Dimension(400,400);

    }
    
    public jPanel(Dimension Size) {
        setLayout(null);
        size = Size;
    }

    public JPanel getPanel() {
        return this; // returns panel
    }
    
    @Override
    public int getWidth(){
        if (size!=null){
            return size.width;
        }
        return super.getWidth();
    }
    
    @Override
    public int getHeight(){
        if (size!=null){
            return size.height;
        }
        return super.getHeight();
    }
    
    public void background(Color colour){
        setBackground(colour); // sets background colour
    }
    
    public void background(String path){
        //bgImage = new ImageIcon(path).getImage();
//            .getScaledInstance(this.getWidth(), getHeight(), Image.SCALE_FAST);
        //repaint();
    }
    
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        if(bgImage!=null){
            g.drawImage(bgImage, 0, 0, this);
        }
    }

    public JButton addButton(String name, Rectangle location) {
        JButton button = new JButton(name);
        button.setBounds(location);
        add(button);
        return button;
    }

 
    public JScrollPane addTextArea(String[] text, Rectangle location, boolean edit) {
        //JTextArea textArea = new JTextArea(text);
        //textArea.setEditable(edit);
    	
    	JList list = new JList(text);
        JScrollPane scrollPane = new JScrollPane(list);
        scrollPane.setBounds(location);
        add(scrollPane);
        return scrollPane;
    }
    
    public JMenuBar addMenuBar(String[] text){
    	JMenuBar menuBar = new JMenuBar();
    	JMenuItem[] menuItems = new JMenuItem[text.length];
    	for (int i = 0; i<text.length; i++){
    		menuItems[i] = new JMenuItem(text[i].toString());
    		menuBar.add(menuItems[i]);
    	}
    	
    	add(menuBar);
    	return menuBar;
    }
    
    public void addImage(String path, Rectangle location) {
        try {
            Image image = ImageIO.read(new File(path));
            image.getScaledInstance(location.width, location.height, Image.SCALE_SMOOTH);
            JLabel picLabel = new JLabel(new ImageIcon(image));
            picLabel.setBounds(location);
            picLabel.setBorder(BorderFactory.createLineBorder(Color.black));
            add(picLabel);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    
    
}
