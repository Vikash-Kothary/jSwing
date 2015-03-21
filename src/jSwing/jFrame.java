// Vikash Kothary
package jSwing;

import java.awt.Frame;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

/*
 * jFrame class is a derived class of JFrame. It is a base
 * class for the creating and handling swing windows. It also
 * handles the adding of a menu bar to all windows.
 * @author  Vikash Kothary
 * @author  Toby Birkett
 * @see JFrame
 * @see JPanel
 * @see JMenuBar
 * @see JMenu
 * @see JMenuItem
 */
@SuppressWarnings("serial")
public class jFrame extends JFrame {

	private ArrayList<jPanel> containers;
	private JMenuBar menuBar;
	private String title;
	private int width, height;

	// Constructors
	/*
	 * Class constructor.
	 * @see JFrame
	 */
	public jFrame() {
		initFrame();
	}

	/*
	 * Class constructor that sets the JFrame component's size.
	 * @param width
	 * @param height
	 * @see JFrame
	 */
	public jFrame(int _width, int _height) {
		width = _width;
		height = _height;
		setSize(width, height); // set the frame size

		initFrame();
	}

	public jFrame(String _title) {
		title = _title;
		setTitle(title); // set the frame title

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
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		containers = new ArrayList<>();
	}
	
	public jFrame getFrame(){
		return this;
	}

	public jPanel addContainer() {
		jPanel panel = new jPanel();
		containers.add(panel);
		setContainer(panel);
		return panel;
	}
	
	public jPanel addContainer(String name) {
		jPanel panel = new jPanel();
		panel.setName(name);
		containers.add(panel);
		setContainer(panel);
		return panel;
	}

	public JMenu addMenu(String menuTitle, String[] menuItems) {
		if (menuItems != null) {
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

	// frame's location is set to the centre to the screen
	public void centreFrame() {
		// TODO multiple screens: should appear in the centre of the primary
		// screen
		Toolkit tk = Toolkit.getDefaultToolkit();
		int x = ((int) tk.getScreenSize().getWidth() - width) / 2;
		int y = ((int) tk.getScreenSize().getHeight() - height) / 2;
		setLocation(x, y);
	}

	public void exitFrame() {
		dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
		// // Alternative method to close frame
		// setVisible(false);
		// dispose();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.awt.Window#setSize(int, int)
	 */

	public jPanel getFrameContainer() {
		return (jPanel) getContentPane().getComponent(0);
	}

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

	// maximise frame
	public void maximiseFrame() {
		setExtendedState(getExtendedState() | Frame.MAXIMIZED_BOTH); // maximise
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.awt.Window#pack()
	 */
	@Override
	public void pack() {
		super.pack();
		width = super.getBounds().width;
		height = super.getBounds().height;
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
	
	public boolean changeContainer(String name) {
		for(jPanel container : containers){
			container.getName().equals(name);
			setContainer(container);
			return true;
		}
		return false;
	}
	
	public String getClipboardData() {
		try {
			return (String) Toolkit.getDefaultToolkit().getSystemClipboard()
					.getData(DataFlavor.stringFlavor);
		} catch (HeadlessException | UnsupportedFlavorException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
