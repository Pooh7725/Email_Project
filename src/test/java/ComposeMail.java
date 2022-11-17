import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ComposeMail {

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriver driver;

		Properties p = new Properties();
		FileInputStream fi = new FileInputStream(
				"/Users/proudparselmouth/eclipse-workspace-3/Email_Project/src/test/java/Environment.properties");
		p.load(fi);

		String browsername = "chrome";

		if (browsername.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"/Users/proudparselmouth/eclipse-workspace-3/Email_Project/src/resources/chromedriver");
			driver = new ChromeDriver();
		} else {
			driver = new FirefoxDriver();
		}

		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		// launch url
		driver.get(p.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// click on sign in button
		driver.findElement(By.xpath(p.getProperty("signinbtnxpath"))).click();

		// enter username
		driver.findElement(By.xpath(p.getProperty("usernamexpath"))).sendKeys(p.getProperty("usernamevalue"));

		// click on next
		driver.findElement(By.xpath(p.getProperty("nextbtnxpath"))).click();

		// enter password
		driver.findElement(By.xpath(p.getProperty("passwordxpath"))).sendKeys(p.getProperty("passwordvalue"));

		// click on login
		driver.findElement(By.xpath(p.getProperty("afterpassnextBtnID"))).click();

//		click on checkbox dont show this again
		driver.findElement(By.id(p.getProperty("dontshowcheckboxXpath"))).click();

		// click on yes button
		driver.findElement(By.xpath(p.getProperty("yesBtnxpath"))).click();
		Thread.sleep(1000);

		// printing title
		String title = driver.getTitle();
		System.out.println(title);

		// click on new message
		driver.findElement(By.xpath(p.getProperty("newMsgXpath"))).click();

		// write email id in to
		driver.findElement(By.xpath(p.getProperty("ToXpath"))).sendKeys(p.getProperty("ToValue"));
//		WebElement elem = driver.findElement(By.xpath(p.getProperty("ToXpath")));
//		String script = "arguments[0].innerHTML='poojasaini7725@gmail.com'";
//		((JavascriptExecutor) driver).executeScript(script, elem);
		Thread.sleep(2000);

		// writing something into subject field
		driver.findElement(By.id(p.getProperty("SubjectID"))).sendKeys(p.getProperty("SubjectValue"));

		// click on sendemail button
		driver.findElement(By.xpath(p.getProperty("SendemailBTNXpath"))).click();
		Thread.sleep(6000); // waiting for email to reflect in sent

		// sent items -- step 1(get sent items element )
		driver.findElement(By.xpath(p.getProperty("SentitemsXpath"))).click();

		// verify automated sent email
		WebElement elem2 = driver.findElement(By.xpath(p.getProperty("emailListElemXpath")));
//		WebDriverWait wait = new WebDriverWait(driver, 20);
//		WebElement myele;
//		myele = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(title)));
//		myele.click();
		System.out.println(elem2.getText());
		Thread.sleep(2000);

		driver.quit();

	}

}
