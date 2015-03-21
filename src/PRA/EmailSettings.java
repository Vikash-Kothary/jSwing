/*
 * PRA Coursework - Deep Vein Thrombosis
 * @author  Vikash Kothary
 * @author  Toby Birkett
 */
package PRA;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;


 
public class EmailSettings {


	private static boolean auth;
	private static String filePath;
	private static String host;
	private static int port;
	private static Properties props;
	private static boolean SSL;
	private static String userName;


	/**
	 * @return auth
	 */
	public static Boolean getAuth() {
		return auth;
	}


	/**
	 * @return host
	 */
	public static String getHost() {
		return host;
	}


	/**
	 * @return port
	 */
	public static int getPort() {
		return port;
	}


	/**
	 * @return props
	 */
	public static Properties getProps() {
		return props;
	}

	
	/**
	 * @return SSL
	 */
	public static Boolean getSSL() {
		return SSL;
	}


	/**
	 * @return userName
	 */
	public static String getUserName() {
		return userName;
	}

	
	/**
	 * The method pulls the data stored in the settings.ini file and stores them in props
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
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


	/**
	 * @param auth
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public void setAuth(String auth) throws FileNotFoundException, IOException {
		getProps().setProperty("AUTH", auth);
		getProps().store(new FileOutputStream(filePath), null);
	}

	/**
	 * @param host
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public void setHost(String host) throws FileNotFoundException, IOException {
		getProps().setProperty("HOST", host);
		getProps().store(new FileOutputStream(filePath), null);
	}


	/**
	 * @param port
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public void setPort(int port) throws FileNotFoundException, IOException {
		getProps().setProperty("PORT", String.valueOf(port));
		getProps().store(new FileOutputStream(filePath), null);
	}

	
	/**
	 * @param SSL
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public void setSSL(String SSL) throws FileNotFoundException, IOException {
		getProps().setProperty("SSL", SSL);
		getProps().store(new FileOutputStream(filePath), null);
	}


	/**
	 * @param userName
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public void setUserName(String userName) throws FileNotFoundException,
			IOException {
		getProps().setProperty("USERNAME", userName);
		getProps().store(new FileOutputStream(filePath), null);
	}

}