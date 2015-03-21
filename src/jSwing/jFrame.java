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

/**
 * The class jFrame is a derived class of JFrame. It is a base
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

	/** The containers. */
	private ArrayList<jPanel> containers;
	
	/** The menu bar. */
	private JMenuBar menuBar;
	
	/** The title. */
	private String title;
	
	/** The height. */
	private int width, height;

	/**
	 * Class constructor. Instantiates a new jFrame.
	 */
	public jFrame() {
		initFrame();
	}

	/*
	 * Class constructor that sets the JFrame component's size.
	 * @param width width of JFrame window
	 * @param height
	 * @param _width
	 * @param _width
	 * @see JFrame
	 */
	/**
	 * Instantiates a new j frame.
	 *
	 * @param _width
	 *            the _width
	 * @param _height
	 *            the _height
	 */
	/**
	 * @param _width
	 * @param _height
	 */
	public jFrame(int _width, int _height) {
		width = _width;
		height = _height;
		setSize(width, height); // set the frame size

		initFrame();
	}

	/**
	 * Instantiates a new j frame.
	 *
	 * @param _title
	 *            the _title
	 */
	public jFrame(String _title) {
		title = _title;
		setTitle(title); // set the frame title

		initFrame();
	}

	/**
	 * Instantiates a new j frame.
	 *
	 * @param _title
	 *            the _title
	 * @param _width
	 *            the _width
	 * @param _height
	 *            the _height
	 */
	public jFrame(String _title, int _width, int _height) {
		title = _title;
		width = _width;
		height = _height;
		setTitle(title); // set the frame title
		setSize(width, height); // set the frame size

		initFrame();
	}

	/**
	 * Inits the frame.
	 */
	private void initFrame() {
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		containers = new ArrayList<>();
	}
	
	/**
	 * Gets the frame.
	 *
	 * @return the frame
	 */
	public jFrame getFrame(){
		return this;
	}

	/**
	 * Adds the container.
	 *
	 * @return the j panel
	 */
	public jPanel addContainer() {
		jPanel panel = new jPanel();
		containers.add(panel);
		setContainer(panel);
		return panel;
	}
	
	/**
	 * Adds the container.
	 *
	 * @param name
	 *            the name
	 * @return the j panel
	 */
	public jPanel addContainer(String name) {
		jPanel panel = new jPanel();
		panel.setName(name);
		containers.add(panel);
		setContainer(panel);
		return panel;
	}

	/**
	 * Adds the menu.
	 *
	 * @param menuTitle
	 *            the menu title
	 * @param menuItems
	 *            the menu items
	 * @return the j menu
	 */
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
	/**
	 * Centre frame.
	 */
	public void centreFrame() {
		// TODO multiple screens: should appear in the centre of the primary
		// screen
		Toolkit tk = Toolkit.getDefaultToolkit();
		int x = ((int) tk.getScreenSize().getWidth() - width) / 2;
		int y = ((int) tk.getScreenSize().getHeight() - height) / 2;
		setLocation(x, y);
	}

	/**
	 * Exit frame.
	 */
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

	/**
	 * Gets the frame container.
	 *
	 * @return the frame container
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

	/**
	 * Gets the menu item.
	 *
	 * @param menu
	 *            the menu
	 * @param menuItemName
	 *            the menu item name
	 * @return the menu item
	 */
	public JMenuItem getMenuItem(JMenu menu, String menuItemName) {
		return menuBar.getMenu(0).getItem(0);
	}

	/**
	 * Gets the menu item.
	 *
	 * @param menuName
	 *            the menu name
	 * @param menuItemName
	 *            the menu item name
	 * @return the menu item
	 */
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
	/**
	 * Maximise frame.
	 */
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
	/**
	 * Sets the container.
	 *
	 * @param panel
	 *            the new container
	 */
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
	
	/**
	 * Change container.
	 *
	 * @param name
	 *            the name
	 * @return true, if successful
	 */
	public boolean changeContainer(String name) {
		for(jPanel container : containers){
			container.getName().equals(name);
			setContainer(container);
			return true;
		}
		return false;
	}
	
	/**
	 * Gets the clipboard data.
	 *
	 * @return the clipboard data
	 */
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
