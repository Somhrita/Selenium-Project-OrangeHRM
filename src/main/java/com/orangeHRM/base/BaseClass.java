package com.orangeHRM.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;


public class BaseClass {

    protected WebDriver driver;
    protected static Properties prop;
    
    @BeforeSuite
    public void loadConfig() throws IOException {
    	// Load config.properties file
    	prop = new Properties();
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"src/main/resources/config.properties");
        prop.load(fis);
    }
    
    @BeforeMethod
    public void setup() throws IOException {
    	System.out.println("Setting up WebDriver for:"+this.getClass().getSimpleName());
    	launchBrowser();
    	configureBrowser();
    	staticWait(2);
    }
     
    
    private void launchBrowser() {
    	String browser = prop.getProperty("browser");

        // Initialize WebDriver based on browser defined in config.properties file
        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        } else {
            throw new IllegalArgumentException("Browser not supported: " + browser);
        }
    }
    
    
    // Configure Browser Settings such as implicit wait,maximize browser and navigate to the url
    private void configureBrowser() {
    	// Maximize browser window
        driver.manage().window().maximize();
        
     // Open application URL
        try {
			driver.get(prop.getProperty("url"));
		} catch (Exception e) {
			System.out.println("Failed to Navigate to the URL:"+e.getMessage());
		}

        // Implicit wait
        int implicitWait = Integer.parseInt(prop.getProperty("implicitWait"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWait));

        
    }  

    @AfterMethod
    public void tearDown() {

        if (driver != null) {
            try {
				driver.quit();
			} catch (Exception e) {
				System.out.println("Unable to quit the driver:"+e.getMessage());
			}
        }
    }
    
    //Getter method for prop
    public static Properties getProp() {
    	return prop;
    }
    
    //Driver getter method
    public WebDriver getDriver() {
    	return driver;	
    }
    
    //Driver setter method
    public void setDriver(WebDriver driver) {
    	this.driver=driver;
    }
    
    //Static Wait for pause
    public void staticWait(int seconds) {
    	LockSupport.parkNanos(TimeUnit.SECONDS.toNanos(seconds));
    }
}


	



