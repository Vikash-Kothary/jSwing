/*
 * PRA Coursework - Deep Vein Thrombosis
 * @author  Vikash Kothary
 * @author  Toby Birkett
 */
package jSwing;

import java.awt.Component;

import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;

/**
 * The Class jScrollPane.
 */
@SuppressWarnings("serial")
public class jScrollPane extends JScrollPane {
	
	/** The name. */
	private String name;
	
	/** The object. */
	private Component object;

	/**
	 * Instantiates a new j scroll pane.
	 *
	 * @param _object
	 *            the _object
	 */
	public jScrollPane(Component _object) {
		super(_object);
		object = _object;
		// if(object instanceof JTextArea){
		// ((JTextArea) object).getDocument().addDocumentListener(this);
		// }
	}

	/**
	 * Instantiates a new j scroll pane.
	 *
	 * @param _object
	 *            the _object
	 * @param _name
	 *            the _name
	 */
	public jScrollPane(Component _object, String _name) {
		super(_object);
		object = _object;
		name = _name;
	}

	/**
	 * Gets the list.
	 *
	 * @return the list
	 */
	public JList<?> getList() {
		if (object instanceof JList) {
			return (JList<?>) object;
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see java.awt.Component#getName()
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * Gets the object.
	 *
	 * @return the object
	 */
	public Component getObject() {
		return object;
	}

	/**
	 * Gets the panel.
	 *
	 * @return the panel
	 */
	public jPanel getPanel() {
		if (object instanceof jPanel) {
			return (jPanel) object;
		}
		return null;
	}

	/**
	 * Gets the table.
	 *
	 * @return the table
	 */
	public JTable getTable() {
		if (object instanceof JTable) {
			return (JTable) object;
		}
		return null;
	}

	/**
	 * Gets the text area.
	 *
	 * @return the text area
	 */
	public JTextArea getTextArea() {
		if (object instanceof JTextArea) {
			return (JTextArea) object;
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see java.awt.Component#setName(java.lang.String)
	 */
	@Override
	public void setName(String _name) {
		name = _name;
	}

	/**
	 * Update list.
	 *
	 * @param text
	 *            the text
	 */
	@SuppressWarnings("unchecked")
	public void updateList(String[] text) {
		if (object instanceof JList) {
			((JList<String>) object).setListData(text);
			setViewportView(object);
			revalidate();
			repaint();
		}
	}
}