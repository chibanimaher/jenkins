package util;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class UntitledTestCase {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
	  ChromeOptions options=new ChromeOptions();
	  options.addArguments("--headless");
	  options.addArguments("window-size=1280,800");
    driver = new ChromeDriver(options);
    baseUrl = "https://www.katalon.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testUntitledTestCase() throws Exception {
    driver.get("https://www.amazon.fr/");
    driver.findElement(By.id("twotabsearchtextbox")).click();
    driver.findElement(By.id("twotabsearchtextbox")).clear();
    driver.findElement(By.id("twotabsearchtextbox")).sendKeys("galaxy");
    driver.findElement(By.id("twotabsearchtextbox")).sendKeys(Keys.DOWN);
    driver.findElement(By.id("twotabsearchtextbox")).sendKeys(Keys.ENTER);
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='demain le 22 octobre'])[1]/following::img[1]")).click();
    driver.findElement(By.id("buy-now-button")).click();
    
    driver.close();
  
  }

  @AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
