package util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TesnGT {
	WebDriver driver;
	String path=System.getProperty("user.dir");
	@BeforeTest
	@Parameters("browser")
	public void setup(@Optional String browser) {
		System.out.println("browser is"+browser);
		System.out.println("thred id:"+Thread.currentThread().getId());
		if(browser.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver", path+"//drivers//chromedriver.exe");
			ChromeOptions options=new ChromeOptions();
			  options.addArguments("headless");
			 driver=new ChromeDriver();
		}
		else if (browser.equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.firefox.driver", path+"//drivers//geckodriver.exe");
			ChromeOptions options=new ChromeOptions();
			  options.addArguments("headless");
			 driver=new FirefoxDriver();}
	}
	@Test
	public void test() throws Exception {
		driver.get("http://www.google.com");
		Thread.sleep(3000);
	}
	@AfterTest
	public void teardown() {
		driver.close();
	}

}
