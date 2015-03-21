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

// TODO: Auto-generated Javadoc
/**
 * The Class EmailSettings.
 */
public class EmailSettings {

	/** The auth. */
	private static boolean auth;
	
	/** The file path. */
	private static String filePath;
	
	/** The host. */
	private static String host;
	
	/** The port. */
	private static int port;
	
	/** The props. */
	private static Properties props;
	
	/** The ssl. */
	private static boolean SSL;
	
	/** The user name. */
	private static String userName;

	/**
	 * Gets the auth.
	 *
	 * @return the auth
	 */
	public static Boolean getAuth() {
		return auth;
	}

	/**
	 * Gets the host.
	 *
	 * @return the host
	 */
	public static String getHost() {
		return host;
	}

	/**
	 * Gets the port.
	 *
	 * @return the port
	 */
	public static int getPort() {
		return port;
	}

	/**
	 * Gets the properties.
	 *
	 * @return the properties
	 */
	public static Properties getProperties() {
		return props;
	}

	/**
	 * Gets the props.
	 *
	 * @return the props
	 */
	public static Properties getProps() {
		return props;
	}

	/**
	 * Gets the ssl.
	 *
	 * @return the ssl
	 */
	public static Boolean getSSL() {
		return SSL;
	}

	/**
	 * Gets the user name.
	 *
	 * @return the user name
	 */
	public static String getUserName() {
		return userName;
	}

	/**
	 * Instantiates a new email settings.
	 *
	 * @throws FileNotFoundException
	 *             the file not found exception
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
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
	 * Sets the auth.
	 *
	 * @param auth
	 *            the new auth
	 * @throws FileNotFoundException
	 *             the file not found exception
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public void setAuth(String auth) throws FileNotFoundException, IOException {
		getProps().setProperty("AUTH", auth);
		getProps().store(new FileOutputStream(filePath), null);
	}

	/**
	 * Sets the host.
	 *
	 * @param host
	 *            the new host
	 * @throws FileNotFoundException
	 *             the file not found exception
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public void setHost(String host) throws FileNotFoundException, IOException {
		getProps().setProperty("HOST", host);
		getProps().store(new FileOutputStream(filePath), null);
	}

	/**
	 * Sets the port.
	 *
	 * @param port
	 *            the new port
	 * @throws FileNotFoundException
	 *             the file not found exception
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public void setPort(int port) throws FileNotFoundException, IOException {
		getProps().setProperty("PORT", String.valueOf(port));
		getProps().store(new FileOutputStream(filePath), null);
	}

	/**
	 * Sets the ssl.
	 *
	 * @param SSL
	 *            the new ssl
	 * @throws FileNotFoundException
	 *             the file not found exception
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public void setSSL(String SSL) throws FileNotFoundException, IOException {
		getProps().setProperty("SSL", SSL);
		getProps().store(new FileOutputStream(filePath), null);
	}

	/**
	 * Sets the user name.
	 *
	 * @param userName
	 *            the new user name
	 * @throws FileNotFoundException
	 *             the file not found exception
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public void setUserName(String userName) throws FileNotFoundException,
			IOException {
		getProps().setProperty("USERNAME", userName);
		getProps().store(new FileOutputStream(filePath), null);
	}

}