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
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class jPanel extends JPanel {

    private Image bgImage = null;
    @SuppressWarnings("unused")
	private int width, height;
    private ArrayList<JLabel> labels;
    private ArrayList<JButton> buttons;

    // Constructor
    public jPanel() {
        _init();
    }

//    public jPanel(int _width, int _height) {
//        width = _width;
//        height = _height;
//        _init();
//    }
    private void _init() {
        labels = new ArrayList<>();
        buttons = new ArrayList<>();
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
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane);
//        components.add(scrollPane);
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
//            components.add(picLabel);
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
//            components.add(picLabel);
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
//            components.add(picLabel);
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
	public JScrollPane addList(String[] text) {
        JList list = new JList(text);
        JScrollPane scrollPane = new JScrollPane(list);
        add(scrollPane);
        return scrollPane;
    }

    public void setPadding(int top, int left, int bottom, int right) {
        setBorder(new EmptyBorder(top, left, bottom, right));
    }

}
