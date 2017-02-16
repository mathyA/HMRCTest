package com.hotel.test.steps;

import java.net.MalformedURLException;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;

import com.hotel.test.driver.manager.WebDriverManager;
import com.hotel.test.pages.hotel.HotelEntryCreationPage;
import com.hotel.test.utils.config.ConfigUtils;
import com.hotel.test.utils.prettyreport.CreatePrettyReport;


public class CommonSteps {
	
	public static boolean initialiseOnce = false;
	public static RemoteWebDriver driver;
    public static Dimension dimension;
	public static String url;


	public static final String LOCATION_SCREENSHOTS = "./screenshots/";
	
	//Pages
	public static HotelEntryCreationPage hotelEntryCreationPage;

	public static Logger log = null;
	public static CreatePrettyReport pr = null;
	
	public CommonSteps() {
		if (driver == null) {
			log = ConfigUtils.getLogger(CommonSteps.class);
			url = ConfigUtils.getWebEndPoint();

			log.info("URL : " + url);
			try {
				driver = (RemoteWebDriver) WebDriverManager.getDriverDynamic();
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//driver.manage().window().maximize();
			
			//generate pretty report on the go
			generatePrettyReportOnTheGo();
			
			//set hook to shut down driver
			addShutdownHook();
		}
	}

	/**
	 * Add shutdown hook
	 */
	private void addShutdownHook() {
		if(!initialiseOnce){
			log.info("Initialise shutdown hook");
			initialiseOnce = true;
			//This should only run when JVM shutsdown
	        Runtime.getRuntime().addShutdownHook(new Thread() {
	            public void run() {
	            	if(driver != null && ConfigUtils.CLOSE_BROWSER_AFTER_TEST){
		            	log.info("Shutting down jvm");
		            	if(pr!=null){
		            		//give time to generate pretty report
			            	try {
								Thread.sleep(15000);
							} catch (InterruptedException e) {
								log.info("Problem quiting driver : " + e.getMessage());
							}
		            	}
		                driver.quit();
		                log.info("Shutdown complete");
	            	}
	            }
	        });
		}
	}

	/**
	 * This will generate pretty report on the go
	 */
	private void generatePrettyReportOnTheGo() {
		String generateReport = ConfigUtils.getGeneratePrettyReport("report.generate.pretty.report");
		if(pr == null && generateReport.equals("yes")){
			log.info("Will Create Pretty Report On The Go");
			pr = new CreatePrettyReport();
			pr.monitorFolder("prettyreport");
		}
		
	}
	
	
	/**
	 * Go to specified url
	 * @param pageUrl
	 */
	public void goToPage(String pageUrl) {
		driver.get(pageUrl);
	}


}