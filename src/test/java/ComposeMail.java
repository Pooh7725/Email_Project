import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ComposeMail {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"/Users/proudparselmouth/eclipse-workspace-3/Email_Project/src/resources/chromedriver");

		WebDriver driver = new ChromeDriver();
//	WebDriverManager.chromedriver().browserVersion("107.0.5304.87").setup();
//		driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);
		// launch url
		driver.get("https://outlook.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		// click on sign in button
		driver.findElement(By.xpath("/html/body/header/div/aside/div/nav/ul/li[2]/a")).click();
		// enter username
		driver.findElement(By.xpath("//*[@id=\"i0116\"]")).sendKeys("sainipoojait@outlook.com");
		// click on next
		driver.findElement(By.xpath("//*[@id=\"idSIButton9\"]")).click();
		// enter password
		driver.findElement(By.xpath("//*[@id=\"i0118\"]")).sendKeys("pooh@7725");
		String nextButtonFullXpath = "/html/body/div/form[1]/div/div/div[2]/div[1]/div/div/div/div/div/div[3]/div/div[2]/div/div[4]/div[2]/div/div/div/div/input";

//		Thread.sleep(10000);
//		 click on login
		driver.findElement(By.xpath(nextButtonFullXpath)).click();
		// click on checkbox dont show this again
		driver.findElement(By.id("KmsiCheckboxField")).click();

		// click on yes button
		String yesLoginButtonXpath = "/html/body/div/form/div/div/div[2]/div[1]/div/div/div/div/div/div[3]/div/div[2]/div/div[3]/div[2]/div/div/div[2]/input";
		driver.findElement(By.xpath(yesLoginButtonXpath)).click();
		Thread.sleep(1000);
//printing title
		String title = driver.getTitle();
		System.out.println(title);

		// click on new message

		driver.findElement(By.xpath(
				"/html/body/div[2]/div/div[2]/div[2]/div[1]/div/div/div/div/div/div[1]/div[2]/div/div/button/span"))
				.click();
		// write email id in to
		String relPath = "//*[@id=\"docking_InitVisiblePart_0\"]/div/div[1]/div[1]/div/div[3]/div/div/div[1]";
		WebElement elem = driver.findElement(By.xpath(relPath));
		String script = "arguments[0].innerHTML='poojasaini7725@gmail.com'";
		((JavascriptExecutor) driver).executeScript(script, elem);

		Thread.sleep(2000);
		// writing something into subject
		String subjectRelPath = "/html/body/div[2]/div/div[2]/div[2]/div[2]/div[2]/div/div/div[1]/div/div[3]/div[3]/div[1]/div/div/div/div[1]/div[2]/div[2]/div/div/div/input";
		driver.findElement(By.id("TextField79")).sendKeys("this is an automated email");
//click on sendemail button 
		String sendEmailButtonXPath = "//*[@id=\"docking_InitVisiblePart_0\"]/div/div[3]/div[3]/div[1]/div/div/span/button[1]/span";
		driver.findElement(By.xpath(sendEmailButtonXPath)).click();

		Thread.sleep(6000); // waiting for email to reflect in sent
		// verify sent email -- step 1(get sent items element )
		String sentItemsXpath = "//*[@id=\"MainModule\"]/div/div/div[1]/div/div/div[1]/div/div[1]/div[3]/div";
		driver.findElement(By.xpath(sentItemsXpath)).click();
//verify automated sent email
		String emailListElemXpath = "//div[contains(@aria-label, 'poojasaini7725@gmail.com this is an automated email')]";
		WebElement elem2 = driver.findElement(By.xpath(emailListElemXpath));
		System.out.println(elem2.getText());
		Thread.sleep(2000);

		driver.quit();

	}

}
