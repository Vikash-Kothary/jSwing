package PRA;

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

	public EmailSettingsDialogue() throws FileNotFoundException, IOException {
		super("Settings");
		setSize(500, 300);

		final EmailSettings emailSettings = new EmailSettings();

		SpinnerModel spinnerModel = new SpinnerNumberModel(
				EmailSettings.getPort(), 0, 999, 1);

		jPanel container = addContainer();
		final jPanel settings = container.addPanel("Settings");
		settings.setLayout(new GridLayout(7, 2));
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
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		
		setVisible(true);

	}

}
