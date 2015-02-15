package GUIClasses;



import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class jFrame extends JFrame{
    
    public jFrame(String title, int width, int height){ // Constructor
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // exit
//        setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH); // maximise
        setTitle(title); // set title
        pack();
        setSize(width,height); // set size
        
        // frame's location is set to the centre to the screen
        Toolkit tk = Toolkit.getDefaultToolkit();
        int x = ((int) tk.getScreenSize().getWidth() - width)/2; 
        int y = ((int) tk.getScreenSize().getHeight() - height)/2;
        setLocation(x, y);
        
        setVisible(true); // displays frame
        
        this.addComponentListener(new ComponentListener() {
            @Override
            public void componentResized(ComponentEvent e){
                e.getComponent().getSize();
            }

            @Override
            public void componentMoved(ComponentEvent e) {}

            @Override
            public void componentShown(ComponentEvent e) {}

            @Override
            public void componentHidden(ComponentEvent e) {}
        });
    }
    
    public jFrame(String title, Dimension size){ // Constructor
        
    }
    
    public void background(JPanel panel){ // changes jpanel in frame
        getContentPane().removeAll(); // empties frame background
        getContentPane().add(panel); // add panel to background
        // refresh panel (optional)
        panel.revalidate();
        panel.repaint();
        // refresh frame
        revalidate(); // if error: validate();
        repaint();
    }
    
    public void mouseLogger(){ // logs mouse location when clicked
        addMouseListener(new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println( "x: "+ e.getX() +" y: "+e.getY());
            }

            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {}

            @Override
            public void mouseEntered(MouseEvent e) {}

            @Override
            public void mouseExited(MouseEvent e) {}
        });
    }
}