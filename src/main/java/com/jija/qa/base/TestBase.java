package com.jija.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.jija.qa.util.TestUtil;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;

	public TestBase() {
		try {
			prop = new Properties();

			FileInputStream ip = new FileInputStream("F:\\new eclips\\testing\\jijaartPOMnaveen\\src\\main"
					+ "\\java\\com\\jija\\qa\\config\\config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.getStackTrace();
		} catch (IOException e) {
			e.getStackTrace();
		}

	}

	
	public static void initialization(){
		
		String b=prop.getProperty("browser");
		
		if(b.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Rajat\\Downloads\\80.chrome\\chromedriver.exe");
			driver= new ChromeDriver();
			
		}
		else if(b.equals("FF")){
			
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\Rajat\\Downloads\\80.chrome\\64bit\\geckodriver.exe");

			driver= new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("URL"));
	}
}
