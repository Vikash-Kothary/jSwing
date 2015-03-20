package PRA;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.mail.*;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JTextField;

import jSwing.jFrame;
import jSwing.jPanel;

@SuppressWarnings("serial")
public class EmailPopup extends jFrame{
		
	private String toEmail = "tobyrbirkett@gmail.com";
	private String fromEmail = "dvtPRACoursework@gmail.com";
	private String host = EmailSettings.getHost();
	private String subject;
	private String body;
	 
	
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
					getFrameContainer().getPanel("makeEmailContainer").getPanel("students").getScrollPanel("scrollPanel").getCheckBox(mainList.getStudent(i).getStudentName()).setSelected(true);
				}
			}
		});
		buttons.getButton("Select None").addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				for (int i = 0; i < mainList.size(); i++){
					getFrameContainer().getPanel("makeEmailContainer").getPanel("students").getScrollPanel("scrollPanel").getCheckBox(mainList.getStudent(i).getStudentName()).setSelected(false);
					
				}
			} 
		});
		
		bottom.getButton("Next").addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				subject = getFrameContainer().getPanel("makeEmailContainer").getPanel("emailComponents").getTextField("Header").getText();
				
				body = getFrameContainer().getPanel("makeEmailContainer").getPanel("emailComponents").getjTextArea("Footer").getText();
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
		
		previewButtons.getButton("Send").addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				Properties props = new Properties();
				
				props.put("mail.smtp.auth", EmailSettings.getAuth());
				props.put("mail.smtp.starttls.enable", EmailSettings.getSSL());
				props.put("mail.smtp.host", EmailSettings.getHost());
				props.put("mail.smtp.port", EmailSettings.getPort());
				
				Session session = Session.getInstance(props, 
						new javax.mail.Authenticator(){ 
							protected PasswordAuthentication getPasswordAuthentication(){ 
								return new PasswordAuthentication(EmailSettings.getUserName(), "passworddvt");
							}	
			});
				
				MimeMessage message = new MimeMessage(session);
				try {
					message.setFrom(new InternetAddress(EmailSettings.getUserName()));
					message.addRecipient(Message.RecipientType.TO, new InternetAddress("tobyrbirkett@gmail.com"));
					message.setSubject(subject);
					message.setText(body);
					Transport.send(message);
					System.out.println("Done");
				} catch (MessagingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
				
				
			}
		});
		
	}
	
}
