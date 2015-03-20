package PRA;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import jSwing.jFrame;
import jSwing.jPanel;





@SuppressWarnings("serial")
public class EmailPopup extends jFrame{
		
	private String toEmail = "tobyrbirkett@gmail.com";
	private String fromEmail = "dvtPRACoursework@gmail.com";
	
	private String subject;
	private String body;
	 
	
	public EmailPopup(final StudentList mainList) throws FileNotFoundException, IOException{
		super("Email");
		setSize(1000,600);
		final jPanel wholeThing = addContainer();
		wholeThing.setLayout(new GridLayout(1,1));
		final jPanel makeEmailContainer = wholeThing.addPanel("makeEmailContainer");
		final jPanel previewEmailContainer = new jPanel();
		final EmailSettings emailSettings = new EmailSettings();
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
				jPanel passPanel = new jPanel();
				passPanel.addLabel("Password: ");
				passPanel.addPasswordField("passwordField");
				final int option = JOptionPane.showOptionDialog(null, passPanel, "Enter Password",  
						JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, "OK");
				if (option == 0){
					final char[] password = passPanel.getPasswordField("passwordField").getPassword();
					Properties props = new Properties();
					
					props.put("mail.smtp.auth", emailSettings.getAuth());
					props.put("mail.smtp.starttls.enable", emailSettings.getSSL());
					props.put("mail.smtp.host", emailSettings.getHost());
					props.put("mail.smtp.port", emailSettings.getPort());
					
					Session session = Session.getInstance(props, 
							new javax.mail.Authenticator(){ 
								protected PasswordAuthentication getPasswordAuthentication(){ 
									return new PasswordAuthentication(emailSettings.getUserName(), new String(password));
								}	
					});
					
					MimeMessage message = new MimeMessage(session);
					try {
						message.setFrom(new InternetAddress(emailSettings.getUserName()));
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
				
				
				 
				
				
			}
		});
		
	}
	
}
