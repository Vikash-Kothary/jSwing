package PRA;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import jSwing.jFrame;
import jSwing.jPanel;



@SuppressWarnings("serial")
public class EmailPopup extends jFrame{
		
	
	
	
	public EmailPopup(final StudentList mainList){
		super("Email");
		setSize(1000,600);
		final jPanel wholeThing = addContainer();
		wholeThing.setLayout(new GridLayout(1,1));
		final jPanel makeEmailContainer = wholeThing.addPanel("makeEmailContainer");
		final jPanel previewEmailContainer = new jPanel();
		
		makeEmailContainer.setLayout(new BorderLayout());
		jPanel students = makeEmailContainer.addPanel("students", BorderLayout.WEST);
		students.setLayout(new BorderLayout());
		jPanel buttons = students.addPanel("buttons", BorderLayout.NORTH);
		buttons.setLayout(new FlowLayout());
		buttons.addButton("Select All");
		buttons.addButton("Select None");
		
		students.addScrollPanel("scrollPanel","scrollPane");
		students.getScrollPanel("scrollPanel").setLayout(new GridLayout(mainList.size(),1));
		students.getScrollPanel("scrollPanel").setSize(200,200);
		for (int i = 0; i < mainList.size(); i++){
			students.getScrollPanel("scrollPanel").addCheckBox(mainList.getStudent(i).getStudentName());
		}
		
		
		jPanel emailComponents = makeEmailContainer.addPanel("emailComponents", BorderLayout.CENTER);
		emailComponents.setLayout(new BorderLayout());
		emailComponents.addTextField(null, "Header", BorderLayout.NORTH);
		emailComponents.addTextArea(null, "Footer");
		jPanel bottom = emailComponents.addPanel("bottom", BorderLayout.SOUTH);
		bottom.setLayout(new BorderLayout());
		bottom.addButton("Next", BorderLayout.EAST);
		
		buttons.getButton("Select All").addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				for (int i = 0; i < mainList.size(); i++){
					getFrameContainer().getPanel("students").getScrollPanel("scrollPanel").getCheckBox(mainList.getStudent(i).getStudentName()).setSelected(true);
				}
			}
		});
		buttons.getButton("Select None").addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				for (int i = 0; i < mainList.size(); i++){
					getFrameContainer().getPanel("students").getScrollPanel("scrollPanel").getCheckBox(mainList.getStudent(i).getStudentName()).setSelected(false);
				}
			}
		});
		
		bottom.getButton("Next").addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				wholeThing.remove(makeEmailContainer);
				wholeThing.add(previewEmailContainer);
				wholeThing.revalidate();
				wholeThing.repaint();
			}
		});

		setVisible(true);
		
		
		previewEmailContainer.setLayout(new BorderLayout());
		jPanel emailPreview = previewEmailContainer.addPanel("EmailPreview", BorderLayout.CENTER);
		jPanel previewButtons = previewEmailContainer.addPanel("PreviewButtons", BorderLayout.SOUTH);
		previewButtons.addButton("Previous");
		previewButtons.addButton("Send");	
		
		previewButtons.getButton("Previous").addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				wholeThing.remove(previewEmailContainer);
				wholeThing.add(makeEmailContainer);
				wholeThing.revalidate();
				wholeThing.repaint();
			}
		});
		
		
		
	}
	
}
