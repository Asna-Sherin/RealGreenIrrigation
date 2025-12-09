package Utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public WebDriver driver;
	public WebDriverWait wait;
		public  void setup() {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://riyoceline.com/projects/green/");
		}
		public void loginsetup() throws InterruptedException {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
			driver.manage().window().maximize();
			driver.get("https://riyoceline.com/projects/green/");

			Thread.sleep(5000);
			WebElement element=driver.findElement(By.xpath("//*[@id=\"userDropdown\"]"));
			element.click();
			WebElement login=driver.findElement(By.className("dropdown-item"));
			login.click();

		}
		public void aboutussetup() throws InterruptedException {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));

			driver.manage().window().maximize();
			driver.get("https://riyoceline.com/projects/green/");
			Thread.sleep(5000);
			WebElement aboutus=driver.findElement(By.linkText("About Us"));
			
			aboutus.click();
			Thread.sleep(3000);

		}
		
		public void productsetup() throws InterruptedException {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));

			driver.manage().window().maximize();
			driver.get("https://riyoceline.com/projects/green/");
			Thread.sleep(5000);
//			WebElement element=driver.findElement(By.xpath("//*[@id=\"userDropdown\"]"));
//			element.click();
//			WebElement login=driver.findElement(By.className("dropdown-item"));
//			login.click();
//
//	    	driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("asna@gmail.com");
//			driver.findElement(By.xpath("//*[@id=\"passwordField\"]")).sendKeys("~!@#$%^&*()_+~");
//			driver.findElement(By.xpath("/html/body/div[2]/div[6]/div/div[2]/div/div/form/div[2]/div[1]/button")).click();
//			Thread.sleep(3000);
//
			WebElement product=driver.findElement(By.xpath("//*[@id=\"productsMenu\"]"));
			product.click();
			Thread.sleep(3000);


		}
		
		public void contactsetup() throws InterruptedException {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));

			driver.manage().window().maximize();
			driver.get("https://riyoceline.com/projects/green/");
			Thread.sleep(5000);
			WebElement contact=driver.findElement(By.xpath("/html/body/div[2]/header/div[2]/div/div/div[2]/div/nav/div/ul/li[4]/a"));
			contact.click();
			Thread.sleep(3000);

		}
}
