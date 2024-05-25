package vendingMachine;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FailLogin {
	static WebDriver driver;
	public static void main(String []args) throws InterruptedException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://192.168.1.58/VendingL_UI/");

		// click on login button without entering valid userName and password	
		driver.findElement(By.xpath("//button[@class='login100-form-btn']")).click();
		String ErrorMessage = driver.findElement(By.xpath("//div[@class='alert alert-danger m-t-20']")).getText();
		System.out.println(ErrorMessage);
		Thread.sleep(2000);


		// Enter Only userName and Click on login button
		driver.findElement(By.id("Username")).sendKeys("ibrew");
		driver.findElement(By.xpath("//button[@class='login100-form-btn']")).click();
		String ErrorMessage1 = driver.findElement(By.xpath("//div[@class='alert alert-danger m-t-20']")).getText();
		System.out.println(ErrorMessage1);
		Thread.sleep(2000);


		// click on login button by entering only password	
		driver.findElement(By.id("Username")).clear();
		Thread.sleep(500);
		driver.findElement(By.id("Password")).sendKeys("ibrew");
		driver.findElement(By.xpath("//button[@class='login100-form-btn']")).click();
		String ErrorMessage2 = driver.findElement(By.xpath("//div[@class='alert alert-danger m-t-20']")).getText();
		System.out.println(ErrorMessage2);
		driver.findElement(By.id("Password")).clear();
		Thread.sleep(1000);
		driver.findElement(By.id("Username")).sendKeys("dasckje");
		driver.findElement(By.id("Password")).sendKeys("idsr");
		driver.findElement(By.xpath("//button[@class='login100-form-btn']")).click();
		Thread.sleep(3000);
		String ErrorTextMessage = driver.findElement(By.xpath("//div[@class='alert alert-danger m-t-20']")).getText();
		System.out.println(ErrorTextMessage);

		Thread.sleep(500);
		// Login with valid UserName and Password

		driver.findElement(By.id("Username")).clear();
		driver.findElement(By.id("Username")).sendKeys("ibrew");
		driver.findElement(By.id("Password")).sendKeys("ibrew");
		driver.findElement(By.xpath("//button[@class='login100-form-btn']")).click();
		driver.quit();
	}
}
