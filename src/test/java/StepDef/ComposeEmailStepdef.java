package StepDef;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class ComposeEmailStepdef {
	WebDriver driver;
	Properties p;

	public void setUp() {
		p = new Properties();
		try {
			FileInputStream fi = new FileInputStream(
					"/Users/proudparselmouth/eclipse-workspace-3/Email_Project/src/test/java/Environment.properties");
			p.load(fi);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String browsername = "chrome";

		if (browsername.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"/Users/proudparselmouth/eclipse-workspace-3/Email_Project/src/resources/chromedriver");
			driver = new ChromeDriver();
		} else {
			driver = new FirefoxDriver();
		}

		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// launch url
		driver.get(p.getProperty("url"));
		driver.manage().window().maximize();
	}

	@Given("^user is already on login page user clicks on login link$")
	public void user_is_already_on_login_page() throws Throwable {
		setUp();

		driver.findElement(By.xpath(p.getProperty("signinbtnxpath"))).click();

	}

	@And("^user enter username$")
	public void user_enter_username() throws Throwable {

		driver.findElement(By.xpath(p.getProperty("usernamexpath"))).sendKeys(p.getProperty("usernamevalue"));

	}

	@Then("^user clicks on next button$")
	public void user_clicks_on_next_button() throws Throwable {

		driver.findElement(By.xpath(p.getProperty("nextbtnxpath"))).click();

	}

	@And("^user enters password$")
	public void user_enters_password() throws Throwable {
		driver.findElement(By.xpath(p.getProperty("passwordxpath"))).sendKeys(p.getProperty("passwordvalue"));

	}

	@Then("^Click on login button$")
	public void click_on_login_button() throws Throwable {

		driver.findElement(By.xpath(p.getProperty("afterpassnextBtnID"))).click();

	}

	@And("^clicks on DoNotShowThisMessageAgain Checkbox$")
	public void clicks_on_DoNotShowThisMessageAgain_Checkbox() throws Throwable {
		driver.findElement(By.id(p.getProperty("dontshowcheckboxXpath"))).click();

	}

	@And("^Clicks on yes button$")
	public void clicks_on_yes_button() throws Throwable {
		driver.findElement(By.xpath(p.getProperty("yesBtnxpath"))).click();

	}

	@Then("^match title of the page$")
	public void match_title_of_the_page() throws Throwable {
		String title = driver.getTitle();
		System.out.println(title);
	}

}
