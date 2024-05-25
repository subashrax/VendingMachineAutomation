package vendingMachine;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;

public class LoginTest {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://192.168.1.58/VendingL_UI/");

		Thread.sleep(2000);
		WebElement logo = driver.findElement(By.xpath("//a[@href='/VendingL_UI/']/img"));
		if (logo.isDisplayed()) {
			System.out.println("Logo is Present");
		} else {
			System.out.println("Logo is Not Displayed");
		}

		WebElement UserNameTExtField = driver.findElement(By.id("Username"));
		if (UserNameTExtField.isDisplayed()) {
			UserNameTExtField.sendKeys("ibrew");
		} else {
			System.out.println("User Name Text Field is Not Enabled");
		}

		WebElement passwordTextField = driver.findElement(By.id("Password"));
		if (passwordTextField.isDisplayed()) {
			passwordTextField.sendKeys("ibrew");
		} else {
			System.out.println("Password Text Field is Not Enabled");
		}

		WebElement LoginButton = driver.findElement(By.xpath("//button[@class='login100-form-btn']"));
		if (LoginButton.isEnabled()) {
			LoginButton.click();
		} else {
			System.out.println("Login Button is not Enabled");
		}

		WebElement Dashboard = driver.findElement(By.xpath("//span[.='My Dashboard']"));
		if (Dashboard.isDisplayed()) {
			Reporter.log("Login Successfully Completed", true);
		} else {
			System.out.println("Dashboard is Not Displayed");
		}

		driver.quit();

	}
}
