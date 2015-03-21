/*
 * PRA Coursework - Deep Vein Thrombosis
 * @author  Vikash Kothary
 * @author  Toby Birkett
 */
package jSwing;

import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

// TODO: Auto-generated Javadoc
/**
 * The Class jTabbedPane.
 */
@SuppressWarnings("serial")
public class jTabbedPane extends JTabbedPane {
	
	/** The tabs. */
	ArrayList<jScrollPane> tabs;

	/**
	 * Instantiates a new j tabbed pane.
	 */
	public jTabbedPane() {
		tabs = new ArrayList<>();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.swing.JTabbedPane#add(java.lang.String, java.awt.Component)
	 */
	/**
	 * Adds the.
	 *
	 * @param title
	 *            the title
	 * @param component
	 *            the component
	 * @return the j scroll pane
	 */
	public jScrollPane add(String title, jScrollPane component) {
		Component success = super.add(title, component);
		addCloseTabButton(title, component);
		return (jScrollPane) success;
	}

	/**
	 * Adds the close tab button.
	 *
	 * @param title
	 *            the title
	 * @param panel
	 *            the panel
	 */
	private void addCloseTabButton(String title, final jScrollPane panel) {
		final JTabbedPane tabbedPane = this;
		jPanel titlePanel = new jPanel();
		titlePanel.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
		titlePanel.setOpaque(false);
		JLabel titleLbl = titlePanel.addLabel(title);
		titleLbl.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 5));
		JLabel closeButton = titlePanel.addLabel("x");
		closeButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tabbedPane.remove(panel);
			}
		});
		titlePanel.add(closeButton);
		setTabComponentAt(indexOfComponent(panel), titlePanel);
	}

	/**
	 * Adds the table tab.
	 *
	 * @param tabName
	 *            the tab name
	 * @param table
	 *            the table
	 * @return the j scroll pane
	 */
	public jScrollPane addTableTab(String tabName, JTable table) {
		table.setName(tabName);
		jScrollPane scrollTable = new jScrollPane(table, tabName);
		tabs.add(scrollTable);
		addTab(tabName, scrollTable);
		return scrollTable;
	}

	/**
	 * Adds the table tab.
	 *
	 * @param tabName
	 *            the tab name
	 * @param results
	 *            the results
	 * @param columns
	 *            the columns
	 * @return the j scroll pane
	 */

	public jScrollPane addTableTab(String tabName, Object[][] results,
			String[] columns) {
		JTable table = new JTable(results, columns);
		table.setName(tabName);
		jScrollPane scrollTable = new jScrollPane(table, tabName);
		tabs.add(scrollTable);
		addTab(tabName, scrollTable);
		addCloseTabButton(tabName, scrollTable);
		return scrollTable;
	}

	/**
	 * Gets the number of tabs.
	 *
	 * @return the number of tabs
	 */
	public int getNumberOfTabs() {
		return tabs.size();
	}

	/**
	 * Gets the tab.
	 *
	 * @param index
	 *            the index
	 * @return the tab
	 */
	public jScrollPane getTab(int index) {
		return tabs.get(index);
	}

	/**
	 * Gets the tabs.
	 *
	 * @return the tabs
	 */
	public ArrayList<jScrollPane> getTabs() {
		return tabs;
	}

	/**
	 * Removes the tab.
	 *
	 * @param index
	 *            the index
	 * @return the j scroll pane
	 */
	public jScrollPane removeTab(int index) {
		return tabs.remove(index);
	}
}
