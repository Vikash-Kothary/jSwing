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

@SuppressWarnings("serial")
public class jTabbedPane extends JTabbedPane {
	ArrayList<jScrollPane> tabs;

	public jTabbedPane() {
		tabs = new ArrayList<>();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.swing.JTabbedPane#add(java.lang.String, java.awt.Component)
	 */
	public jScrollPane add(String title, jScrollPane component) {
		Component success = super.add(title, component);
		addCloseTabButton(title, component);
		return (jScrollPane) success;
	}

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

	public jScrollPane addTableTab(String tabName, JTable table) {
		table.setName(tabName);
		jScrollPane scrollTable = new jScrollPane(table, tabName);
		tabs.add(scrollTable);
		addTab(tabName, scrollTable);
		return scrollTable;
	}

	/**
	 * @param numOfTabs
	 *            the numOftabs to set
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
	 * @return the numOfTabs
	 */
	public int getNumberOfTabs() {
		return tabs.size();
	}

	public jScrollPane getTab(int index) {
		return tabs.get(index);
	}

	public ArrayList<jScrollPane> getTabs() {
		return tabs;
	}

	public jScrollPane removeTab(int index) {
		return tabs.remove(index);
	}
}
