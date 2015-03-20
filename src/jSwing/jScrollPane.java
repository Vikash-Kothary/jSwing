package jSwing;

import java.awt.Component;

import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class jScrollPane extends JScrollPane {
	private String name;
	private Component object;

	public jScrollPane(Component _object) {
		super(_object);
		object = _object;
		// if(object instanceof JTextArea){
		// ((JTextArea) object).getDocument().addDocumentListener(this);
		// }
	}

	public jScrollPane(Component _object, String _name) {
		super(_object);
		object = _object;
		name = _name;
	}

	@Override
	public void setName(String _name) {
		name = _name;
	}

	@Override
	public String getName() {
		return name;
	}

	public Component getObject() {
		if (object instanceof JTextArea) {
			return object;
		} else if (object instanceof JList) {
			return object;
		} else if (object instanceof jPanel) {
			return object;
		}

		return object;
	}

	public JList getList() {
		return (JList) object;
	}

	public jPanel getPanel() {
		return (jPanel) object;
	}

	public void updateList(String[] text) {
		if (object instanceof JList) {
			((JList) object).setListData(text);
			setViewportView(object);
			revalidate();
			repaint();
		}
	}
}