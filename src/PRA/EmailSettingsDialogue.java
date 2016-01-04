package PRA;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

import jSwing.jFrame;
import jSwing.jPanel;


public class EmailSettingsDialogue extends jFrame {

	
	
	/**
	 * Builds the window with all widgets for changing SMTP settings 
	 * Adds actionListeners to the buttons to commit or dispose of the settings.
	 *
	 * @throws FileNotFoundException the file not found exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public EmailSettingsDialogue() throws FileNotFoundException, IOException {
		super("Settings");
		this.setMinimumSize(new Dimension(300,150));
		final EmailSettings emailSettings = new EmailSettings();
		

		SpinnerModel spinnerModel = new SpinnerNumberModel(
				emailSettings.getPort(), 0, 999, 1);

		jPanel container = addContainer();
		container.setLayout(new BorderLayout());
		final jPanel settings = container.addPanel("Settings", BorderLayout.CENTER);
		settings.setLayout(new GridLayout(6, 2));
		settings.addLabel("SMTP Server: ");
		settings.addTextField(emailSettings.getHost(), "Server", null);
		settings.addLabel("Port: ");
		settings.addSpinner(spinnerModel, "Port");
		settings.addLabel("UserName: ");
		settings.addTextField(emailSettings.getUserName(), "userName", null);

		settings.addLabel("SMTP Authorisation: ");
		String[] fields = { "TRUE", "FALSE" };
		settings.addComboBox(fields, "AuthBox");
		settings.addLabel("SSL Encryption: ");
		settings.addComboBox(fields, "SSLBox");

		settings.addButton("Confirm");
		settings.addButton("Cancel");

		settings.getButton("Cancel").addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				exitFrame();
			}
		});

		settings.getButton("Confirm").addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setSettings(settings, emailSettings);
			}
		});

		pack();
		centreFrame();
		setVisible(true);

	}
	
	/**
	 * Pulls data from widgets and stores them as variables in the EmailSettings object .
	 *
	 * @param settings the settings
	 * @param emailSettings the email settings
	 */
	public void setSettings(jPanel settings, EmailSettings emailSettings){
		try {
			emailSettings.setPort((Integer) settings.getSpinner("Port")
					.getValue());
			emailSettings.setAuth(settings.getComboBox("AuthBox")
					.getSelectedItem().toString());
			emailSettings.setSSL(settings.getComboBox("SSLBox")
					.getSelectedItem().toString());
			emailSettings.setUserName(settings.getTextField("userName")
					.getText());
			emailSettings.setHost(settings.getTextField("Server")
					.getText());
			exitFrame();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

}
