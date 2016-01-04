/*
 * PRA Coursework - Deep Vein Thrombosis
 * @author  Vikash Kothary
 * @author  Toby Birkett
 */
package PRA;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jsoup.Connection;
import org.jsoup.Connection.Method;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import jSwing.jFrame;
import jSwing.jPanel;

/**
 * The Class WebScraper.
 */
@SuppressWarnings("serial")
public class WebScraper extends jFrame {
	
	/** The uri of the page to be scraped. */
	private URI uri;

	/**
	 * Instantiates a new web scraper.
	 *
	 * @throws HeadlessException
	 *             the headless exception
	 * @throws UnsupportedFlavorException
	 *             the unsupported flavor exception
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public WebScraper() throws HeadlessException, UnsupportedFlavorException,
			IOException {
		super("Fetch Participation");
		setMinimumSize(new Dimension(400, 150));

		uri = null;
		addURLPage();

		pack();
		centreFrame();
		setVisible(true);
	}

	/**
	 * Adds the url page.
	 */
	private void addURLPage() {
		setMinimumSize(new Dimension(400, 100));
		jPanel container = addContainer("URL");
		container.setLayout(new BorderLayout());
		container.setPadding(5, 5, 5, 5);
		jPanel urlPanel = container.addPanel("urlPanel",
				BorderLayout.NORTH);
		urlPanel.setLayout(new BorderLayout());
		urlPanel.setPadding(5, 5, 5, 5);
		JLabel urlLabel = urlPanel.addLabel("URL:  ", BorderLayout.WEST);
		JTextField urlField = urlPanel.addTextField(null, "urlField",
				BorderLayout.CENTER);

		jPanel buttonsPanel = container.addPanel("buttonsPanel",
				BorderLayout.PAGE_END);
		buttonsPanel.setLayout(new GridLayout(1, 3, 5, 5));
		buttonsPanel.setPadding(5, 5, 5, 5);
		buttonsPanel.addButton("< Back").setEnabled(false);
		buttonsPanel.addButton("Paste URL").addActionListener(
				new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
							getFrameContainer().getPanel("urlPanel")
									.getTextField("urlField").setText(getClipboardData());
					}
				});
		buttonsPanel.addButton("Next >").addActionListener(
				new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						String urlLink = getFrameContainer()
								.getPanel("urlPanel").getTextField("urlField")
								.getText();
						try {
							// Will throw error if not actual url
							URL url = new URL(urlLink);
							uri = url.toURI();
						} catch (URISyntaxException | MalformedURLException e1) {
							e1.printStackTrace();
						} finally {
							if(uri!=null){
								addLoginPage();
							}else{
								JOptionPane.showMessageDialog(getFrame(),
										"Invalid URL");
							}
						}

					}
				});
	}

	/**
	 * Adds the login page.
	 */
	private void addLoginPage() {
		setMinimumSize(new Dimension(400, 150));
		jPanel container = addContainer("Login");
		container.setLayout(new BorderLayout());
		container.setPadding(5, 5, 5, 5);
		jPanel loginPanel = container.addPanel("loginPanel",
				BorderLayout.CENTER);
		loginPanel.setLayout(new GridLayout(2, 1, 5, 5));
		loginPanel.setPadding(5, 5, 5, 5);
		jPanel usernameField = loginPanel.addPanel("usernameField");
		usernameField.setLayout(new BorderLayout());
		usernameField.addLabel("Username:  ", BorderLayout.WEST);
		usernameField.addTextField(null, "Username", BorderLayout.CENTER );

		jPanel passwordField = loginPanel.addPanel("passwordField");
		passwordField.setLayout(new BorderLayout());
		passwordField.addLabel("Password:  ", BorderLayout.WEST);
		passwordField.addTextField(null, "Password", BorderLayout.CENTER );
		
		jPanel buttonsPanel = container.addPanel("buttonsPanel",
				BorderLayout.PAGE_END);
		buttonsPanel.setLayout(new GridLayout(1, 3, 5, 5));
		buttonsPanel.setPadding(5, 5, 5, 5);
		buttonsPanel.addButton("< Back").addActionListener(
				new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						getFrame().changeContainer("URL");
					}
				});
		buttonsPanel.addButton("Login >").addActionListener(
				new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						try {
							scrape(uri);
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					}
				});

	}

	/**
	 * TODO Scrapes data.
	 *
	 * @param url
	 *            the url
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	private void scrape(URI url) throws IOException {
		String username = getFrameContainer().getPanel("loginPanel").getPanel("usernameField")
				.getTextField("Username").getText();
		String password = getFrameContainer().getPanel("loginPanel").getPanel("passwordField")
				.getTextField("Password").getText();
		
//		HtmlUnitDriver driver = new HtmlUnitDriver(true);
//		String baseUrl = "https://login-keats.kcl.ac.uk/";
//
//		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//
//		driver.get(baseUrl);
//
//		driver.findElement(By.id("TextBoxUser")).clear();
//		driver.findElement(By.id("TextBoxUser")).sendKeys("username");
//		driver.findElement(By.id("TextBoxPass")).clear();
//		driver.findElement(By.id("TextBoxPass")).sendKeys("password");
//		driver.findElement(By.id("Button1")).click();
//		
//		String htmlContent = driver.getPageSource();
//		Document document = Jsoup.parse(htmlContent);
		
//		Connection.Response loginForm = Jsoup.connect("https://login-keats.kcl.ac.uk/")
//	            .method(Connection.Method.GET)
//	            .execute();
//
//	    Document document = Jsoup.connect("https://login-keats.kcl.ac.uk/")
//	            .data("cookieexists", "false")
//	            .data("username", username)
//	            .data("password", password)
//	            .data("loginbtn", "Log in")
//	            .cookies(loginForm.cookies())
//	            .post();
//	    System.out.println(document);
//		
//		
//		Connection.Response res = Jsoup.connect("https://login-keats.kcl.ac.uk/")
//			    .data("username", username, "password", password)
//			    .method(Method.POST)
//			    .execute();
//
//			Document doc = res.parse();
//			String sessionId = res.cookie("ModuleSession");
//			
//			Document doc2 = Jsoup.connect("http://keats.kcl.ac.uk/mod/page/view.php?id=886138")
//				    .cookie("ModuleSession", sessionId)
//				    .get();
//			System.out.println(doc2);
//		
//		Connection.Response loginForm = Jsoup.connect("http://keats.kcl.ac.uk/mod/page/view.php?id=886138")
//	            .method(Connection.Method.GET)
//	            .execute();
//
//	           Document document = Jsoup.connect("https://www.desco.org.bd/ebill/authentication.php")
//	            .data("cookieexists", "false")
//	            .data("username", username)
//	            .data("login", "Login")
//	            .cookies(loginForm.cookies())
//	            .post();
//	           System.out.println(document);
	}
}
