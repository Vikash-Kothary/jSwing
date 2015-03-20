package jSwing;

import java.awt.Component;

import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
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

	public JList<?> getList() {
		if (object instanceof JList) {
			return (JList<?>) object;
		}
		return null;
	}

	@Override
	public String getName() {
		return name;
	}

	public Component getObject() {
		return object;
	}

	public jPanel getPanel() {
		if (object instanceof jPanel) {
			return (jPanel) object;
		}
		return null;
	}

	public JTable getTable() {
		if (object instanceof JTable) {
			return (JTable) object;
		}
		return null;
	}

	public JTextArea getTextArea() {
		if (object instanceof JTextArea) {
			return (JTextArea) object;
		}
		return null;
	}

	@Override
	public void setName(String _name) {
		name = _name;
	}

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