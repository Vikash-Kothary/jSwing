// Vikash Kothary
package jSwing;

import java.awt.Toolkit;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class jFrame extends JFrame {

	private JMenuBar menuBar = new JMenuBar();
	private String title;
	private int width, height;

	// Constructors
	public jFrame() {
		initFrame();
	}

	public jFrame(String _title) {
		title = _title;
		setTitle(title); // set the frame title

		initFrame();
	}

	public jFrame(int _width, int _height) {
		width = _width;
		height = _height;
		setSize(width, height); // set the frame size

		initFrame();
	}

	public jFrame(String _title, int _width, int _height) {
		title = _title;
		width = _width;
		height = _height;
		setTitle(title); // set the frame title
		setSize(width, height); // set the frame size

		initFrame();
	}

	private void initFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // stops program when
														// exits frame
		setJMenuBar(menuBar);
	}

	// changes jpanel container in frame
	public void setContainer(JPanel panel) {
		getContentPane().removeAll(); // empties frame background
		getContentPane().add(panel); // add panel to background
		// refresh panel (optional)
		panel.revalidate();
		panel.repaint();
		// refresh frame
		revalidate(); // if error: validate();
		repaint();
	}

	// public jPanel getContainer(){
	// return
	// }

	// // logs mouse location when clicked
	// public void mouseLogger() {
	// this.addMouseListener(new MouseListener() {
	// @Override
	// public void mouseClicked(MouseEvent e) {
	// System.out.println("x: " + e.getX() + " y: " + e.getY());
	// }
	//
	// @Override
	// public void mousePressed(MouseEvent e) {
	// }
	//
	// @Override
	// public void mouseReleased(MouseEvent e) {
	// }
	//
	// @Override
	// public void mouseEntered(MouseEvent e) {
	// }
	//
	// @Override
	// public void mouseExited(MouseEvent e) {
	// }
	// });
	// }
	// maximise frame
	public void maximiseFrame() {
		setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH); // maximise
	}

	// frame's location is set to the centre to the screen
	public void centreFrame() {
		Toolkit tk = Toolkit.getDefaultToolkit();
		int x = ((int) tk.getScreenSize().getWidth() - width) / 2;
		int y = ((int) tk.getScreenSize().getHeight() - height) / 2;
		setLocation(x, y);
	}

	public void exitFrame() {
		dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
		// setVisible(false);
		// dispose();
	}

	public JMenu addMenu(String menuTitle, String[] menuItems) {
		if(menuItems!=null){
	        JMenu menu = new JMenu(menuTitle);
	        for (String itemTitle : menuItems) {
	            JMenuItem menuItem = new JMenuItem(itemTitle);
	            menu.add(menuItem);
	        }
	        menuBar.add(menu);
	        return menu;
		}
		return null;
    }

	public JMenuItem getMenuItem(JMenu menu, String menuItemName) {
		return menuBar.getMenu(0).getItem(0);
	}

	public JMenuItem getMenuItem(String menuName, String menuItemName) {
		for (int i = 0; i < menuBar.getMenuCount(); i++) {
			JMenu menu = menuBar.getMenu(i);
			if (menu.getText().equals(menuName)) {
				for (int j = 0; j < menu.getItemCount(); j++) {
					JMenuItem menuItem = menu.getItem(j);
					if (menuItem.getText().equals(menuItemName)) {
						return menuItem;
					}
				}
			}
		}
		return null;
	}
}
