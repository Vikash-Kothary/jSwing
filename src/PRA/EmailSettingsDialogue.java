/*
 * PRA Coursework - Deep Vein Thrombosis
 * @author  Vikash Kothary
 * @author  Toby Birkett
 */
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

// TODO: Auto-generated Javadoc
/**
 * The Class EmailSettingsDialogue.
 */
public class EmailSettingsDialogue extends jFrame {

	/**
	 * Instantiates a new email settings dialogue.
	 *
	 * @throws FileNotFoundException
	 *             the file not found exception
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public EmailSettingsDialogue() throws FileNotFoundException, IOException {
		super("Settings");
		this.setMinimumSize(new Dimension(300,150));

		final EmailSettings emailSettings = new EmailSettings();

		SpinnerModel spinnerModel = new SpinnerNumberModel(
				EmailSettings.getPort(), 0, 999, 1);

		jPanel container = addContainer();
		container.setLayout(new BorderLayout());
		final jPanel settings = container.addPanel("Settings", BorderLayout.CENTER);
		settings.setLayout(new GridLayout(6, 2));
		settings.addLabel("SMTP Server: ");
		settings.addTextField(EmailSettings.getHost(), "Server", null);
		settings.addLabel("Port: ");
		settings.addSpinner(spinnerModel, "Port");
		settings.addLabel("UserName: ");
		settings.addTextField(EmailSettings.getUserName(), "userName", null);

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
		});

		pack();
		centreFrame();
		setVisible(true);

	}

}
