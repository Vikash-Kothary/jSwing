package PRA;

import java.awt.GridLayout;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

import jSwing.jFrame;
import jSwing.jPanel;



public class EmailSettings extends jFrame{
//		http://www.java-tips.org/java-se-tips/javax.swing/how-to-create-an-e-mail-client-in-java.html
//		http://www.tagwith.com/question_15608_how-to-send-mail-faster-using-javamail-api
//      http://stackoverflow.com/questions/193474/how-to-create-an-ini-file-to-store-some-settings-in-java

	private static String host;
	private static int port;
	private static String userName;
	private static boolean SSL;
	private static Properties props;
	private static String password;
	private static boolean auth;

	public EmailSettings() throws  IOException{
		super("Settings");
		setSize(300,300);
		
		Properties props = new Properties();
		props.load(new FileInputStream(new File("src\\config\\settings.ini")));
		
		host = props.getProperty("HOST");
		port = Integer.valueOf(props.getProperty("PORT"));
		userName = props.getProperty("USERNAME");
		SSL = Boolean.valueOf(props.getProperty("ENABLESSL"));
		password = props.getProperty("PASSWORD");
		auth = Boolean.valueOf(props.getProperty("AUTH"));
		
		SpinnerModel spinnerModel = new SpinnerNumberModel(port,0,999,1);
		
		jPanel container = addContainer();
		jPanel settings = container.addPanel("Settings");
		settings.setLayout(new GridLayout(4,2));
		settings.addLabel("SMTP Server: ");
		settings.addTextField(host, "Server", null);
		settings.addLabel("Port: ");
		settings.addSpinner(spinnerModel);
		settings.addLabel("UserName: ");
		settings.addTextField(userName, "userName",null);
		setVisible(true);
		
				
	}
	
	public static String getHost(){
		return host;
	}
	
	public static int getPort(){
		return port;
	}
	
	public static String getUserName(){
		return userName;
	}
	
	public static Boolean getSSL(){
		return SSL;
	}
	
	public static Properties getProperties(){
		return props;
	}
	
	public static Boolean getAuth(){
		return auth;
	}
	
}
