
package jSwing;

import java.awt.Component;
import java.util.ArrayList;

import javax.swing.JTabbedPane;
import javax.swing.JTable;

public class jTabbedPane extends JTabbedPane {
	ArrayList<jScrollPane> tabs;
	
	public jTabbedPane() {
		tabs = new ArrayList<>();
	}
	
	/* (non-Javadoc)
	 * @see javax.swing.JTabbedPane#addTab(java.lang.String, java.awt.Component)
	 */
	@Override
	public void addTab(String title, Component component) {
		super.addTab(title, component);
	}

	/**
	 * @return the numOfTabs
	 */
	public int getNumberOfTabs() {
		return tabs.size();
	}

	/**
	 * @param numOfTabs the numOftabs to set
	 */

	public jScrollPane addTableTab(String tabName, Object[][] results, String[] columns) {
		JTable table = new JTable(results, columns);
		table.setName(tabName);
		jScrollPane scrollTable = new jScrollPane(table, tabName);
		tabs.add(scrollTable);
		addTab(tabName, scrollTable);
		return scrollTable;
	}
	
	public jScrollPane addTableTab(String tabName, JTable table) {
		table.setName(tabName);
		jScrollPane scrollTable = new jScrollPane(table, tabName);
		tabs.add(scrollTable);
		addTab(tabName, scrollTable);
		return scrollTable;
	}
	
	public jScrollPane removeTab(int index){
		return tabs.remove(index);
	}
	
	public jScrollPane getTab(int index){
		return tabs.get(index);
	}
	
	public ArrayList<jScrollPane> getTabs(){
		return tabs;
	}
}
