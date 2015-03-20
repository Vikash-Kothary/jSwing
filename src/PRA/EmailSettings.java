package PRA;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class EmailSettings {

	private static String host;
	private static int port;
	private static String userName;
	private static boolean SSL;
	private static Properties props;
	private static boolean auth;
	private static String filePath;

	public EmailSettings() throws FileNotFoundException, IOException {
		Properties props = new Properties();
		filePath = "src\\config\\settings.ini";
		props.load(new FileInputStream(new File(filePath)));
		EmailSettings.props = props;
		host = props.getProperty("HOST");
		port = Integer.valueOf(props.getProperty("PORT"));
		userName = props.getProperty("USERNAME");
		SSL = Boolean.valueOf(props.getProperty("SSL"));
		auth = Boolean.valueOf(props.getProperty("AUTH"));
		props.setProperty("PORT", "55");
	}

	public static String getHost() {
		return host;
	}

	public void setPort(int port) throws FileNotFoundException, IOException {
		getProps().setProperty("PORT", String.valueOf(port));
		getProps().store(new FileOutputStream(filePath), null);
	}

	public void setUserName(String userName) throws FileNotFoundException,
			IOException {
		getProps().setProperty("USERNAME", userName);
		getProps().store(new FileOutputStream(filePath), null);
	}

	public void setSSL(String SSL) throws FileNotFoundException, IOException {
		getProps().setProperty("SSL", SSL);
		getProps().store(new FileOutputStream(filePath), null);
	}

	public void setAuth(String auth) throws FileNotFoundException, IOException {
		getProps().setProperty("AUTH", auth);
		getProps().store(new FileOutputStream(filePath), null);
	}

	public void setHost(String host) throws FileNotFoundException, IOException {
		getProps().setProperty("HOST", host);
		getProps().store(new FileOutputStream(filePath), null);
	}

	public static int getPort() {
		return port;
	}

	public static String getUserName() {
		return userName;
	}

	public static Boolean getSSL() {
		return SSL;
	}

	public static Properties getProperties() {
		return props;
	}

	public static Boolean getAuth() {
		return auth;
	}

	public static Properties getProps() {
		return props;
	}

}