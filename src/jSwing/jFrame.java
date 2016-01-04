/*
 * PRA Coursework - Deep Vein Thrombosis
 * @author  Vikash Kothary
 * @author  Toby Birkett
 */
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
 * The Class jFrame.
 */
@SuppressWarnings("serial")
public class jFrame extends JFrame {

	/** The containers. */
	private ArrayList<jPanel> containers;
	
	/** The menu bar. */
	private JMenuBar menuBar;
	
	/** The title. */
	private String title;
	
	/** The height */
	private int width, height;

	/**
	 * Class constructor. Instantiates a new jFrame object.
	 */
	public jFrame() {
		initFrame();
	}

	/**
	 * Class constructor. Instantiates a new jFrame object and sets its size.
	 *
	 * @param _width
	 *            the width you would like to set the window
	 * @param _height
	 *            the height you would like to set the window
	 * 
	 */
	public jFrame(int _width, int _height) {
		width = _width;
		height = _height;
		setSize(width, height); // set the frame size

		initFrame();
	}

	/**
	 * Class constructor. Instantiates a new jFrame object and sets the window title.
	 *
	 * @param _title
	 *            the window title
	 *            
	 */
	public jFrame(String _title) {
		title = _title;
		setTitle(title); // set the frame title

		initFrame();
	}

	/**
	 * Class constructor. Instantiates a new jFrame object with a title and sets its size.
	 *
	 * @param _title
	 *            the window title
	 * @param _width
	 *            the width of the frame
	 * @param _height
	 *            the height of the frame
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
	 * Initialise the global variables in the frame and add a empty menu bar.
	 */
	private void initFrame() {
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		containers = new ArrayList<>();
	}
	
	/**
	 * Gets the frame object.
	 *
	 * @return the frame
	 */
	public jFrame getFrame(){
		return this;
	}

	/**
	 * Adds a container panel to the frame.
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
	 *            a name for the panel to be used to get it later
	 * @return the new jPanel
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
	 *            all the items in menu
	 * @return the menu
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
	 * Centres the frame in the screen.
	 */
	public void centreFrame() {
		// possible extension: TODO multiple screens: should appear in the centre of the primary screen
		Toolkit tk = Toolkit.getDefaultToolkit();
		int x = ((int) tk.getScreenSize().getWidth() - width) / 2;
		int y = ((int) tk.getScreenSize().getHeight() - height) / 2;
		setLocation(x, y);
	}

	/**
	 * Exit frame Simulates window close button.
	 */
	public void exitFrame() {
		dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
		// // Alternative method to close frame
		// setVisible(false);
		// dispose();
	}

	/**
	 * Gets the frame container panel.
	 *
	 * @return the frame container panel
	 * 
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
	 * Gets a menu item.
	 *
	 * @param menu
	 *            the menu
	 * @param menuItemName
	 *            the menu item's name
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
	/**
	 * Maximises frame.
	 */
	public void maximiseFrame() {
		setExtendedState(getExtendedState() | Frame.MAXIMIZED_BOTH); // maximise
	}

	/**
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
			e.printStackTrace();
		}
		return null;
	}
}
