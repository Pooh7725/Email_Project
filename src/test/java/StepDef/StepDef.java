package StepDef;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class StepDef {

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

	@Given("^user has logged in and clicks on new message$")
	public void user_has_logged_in_and_clicks_on_new_message() {
		driver.findElement(By.xpath(p.getProperty("newMsgXpath"))).click();

	}

	@Given("^write email id in to textbox$")
	public void write_email_id_in_to_textbox() {
		driver.findElement(By.xpath(p.getProperty("ToXpath"))).sendKeys(p.getProperty("ToValue"));

	}

	@Given("^write something into subject field$")
	public void write_something_into_subject_field() {
		driver.findElement(By.id(p.getProperty("SubjectID"))).sendKeys(p.getProperty("SubjectValue"));

	}

	@Then("^click on sendemail button$")
	public void click_on_sendemail_button() {
		driver.findElement(By.xpath(p.getProperty("SendemailBTNXpath"))).click();

	}

	@Then("^click on sent items$")
	public void click_on_sent_items() {
		driver.findElement(By.xpath(p.getProperty("SentitemsXpath"))).click();

	}

	@Then("^verify automated sent email and quit browser$")
	public void verify_automated_sent_email_and_quit_browser() throws InterruptedException {
		Thread.sleep(6000); // giving hard wait, so that mail reflects in sent
		WebElement elem2 = driver.findElement(By.xpath(p.getProperty("emailListElemXpath")));
		System.out.println(elem2.getText());
		Thread.sleep(2000);

		driver.quit();

	}
}
