package Frontend;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Contactuspage {
		WebDriver driver;
		public Contactuspage(WebDriver driver) {
			this.driver=driver;
		
		}
		By mail=By.xpath("/html/body/div[2]/div[6]/div/div/div[1]/div/p/a");
		By phnum=By.xpath("/html/body/div[2]/div[6]/div/div/div[2]/div/p/a");
		By add=By.xpath("/html/body/div[2]/div[6]/div/div/div[3]/div/p/a");
		By namefield=By.xpath("//*[@id=\"contact-form\"]/div[1]/div[1]/div/input");
		By mailfield=By.xpath("//*[@id=\"contact-form\"]/div[1]/div[2]/div/input");
		By phnumfield=By.xpath("//*[@id=\"contact-form\"]/div[1]/div[4]/div/input");
		By messagefield=By.xpath("//*[@id=\"contact-form\"]/div[2]/textarea");
		By submitbutton=By.xpath("//*[@id=\"contact-form\"]/div[3]/button");
		By checkbox=By.xpath("//*[@id=\"contact-form\"]/p[1]/label/input");
		By servicetype=By.xpath("//*[@id=\"contact-form\"]/div[1]/div[3]/div/div");
		By servicetypedropdown=By.cssSelector(".list");
		By service=By.xpath("//*[@id=\"contact-form\"]/div[1]/div[3]/div/div/ul/li[5]");
		By errormsg=By.className("error-msg");
		By msg=By.xpath("//*[@id=\"contact-form\"]/p[2]");
		
		
		public void clickmail() {
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("window.scrollBy(0,400)");
			driver.findElement(mail).click();
			String href=driver.findElement(mail).getAttribute("href");
			  Assert.assertEquals(href,"mailto:sales@realgreenirrigation.com","Email is Incorrect");
		}
		
		public String phnlink() {
		JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("window.scrollBy(0,400)");
			driver.findElement(phnum).click();
	
			return driver.findElement(phnum).getAttribute("href");

		}
		
		public void Checkmap() throws InterruptedException {
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("window.scrollBy(0,400)");
			driver.findElement(add).click();

			String mainwindow=driver.getWindowHandle();
			String before=driver.getTitle();
			Thread.sleep(5000);
			driver.findElement(add).click();
			Thread.sleep(5000);
			for(String window:driver.getWindowHandles()) {
				if(!window.equals(mainwindow)) {
					driver.switchTo().window(window);
					break;
				}
			}
			String after=driver.getTitle();
			Assert.assertNotEquals(before,after,"not redirects properly");

		}
		public void rightcredentials() throws InterruptedException {
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("window.scrollBy(0,700)");
			driver.findElement(namefield).sendKeys("asna");
			driver.findElement(mailfield).sendKeys("asna@gmail.com");
			driver.findElement(phnumfield).sendKeys("1234567890");
			driver.findElement(servicetype).click();
			driver.findElement(service).click();
			Thread.sleep(4000);
			driver.findElement(messagefield).sendKeys("hellooooo Real Green Irrigation");
			driver.findElement(checkbox).click();
			driver.findElement(submitbutton).click();
		}
		
		public void wrongmail() throws InterruptedException {
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("window.scrollBy(0,700)");
			driver.findElement(namefield).sendKeys("asna");
			driver.findElement(mailfield).sendKeys("asnagmail.com");
			driver.findElement(phnumfield).sendKeys("1234567890");
			driver.findElement(servicetype).click();
			driver.findElement(service).click();
			Thread.sleep(4000);
			driver.findElement(messagefield).sendKeys("hellooooo Real Green Irrigation");
			driver.findElement(checkbox).click();
			driver.findElement(submitbutton).click();
			Boolean errormessage=driver.findElement(errormsg).isDisplayed();
			Assert.assertTrue(true);
		}
		public void ivalidphnum() throws InterruptedException {
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("window.scrollBy(0,700)");
			driver.findElement(namefield).sendKeys("asna");
			driver.findElement(mailfield).sendKeys("asna@gmail.com");
			driver.findElement(phnumfield).sendKeys("1237890");
			driver.findElement(servicetype).click();
			driver.findElement(service).click();
			Thread.sleep(4000);
			driver.findElement(messagefield).sendKeys("hellooooo Real Green Irrigation");
			driver.findElement(checkbox).click();
			driver.findElement(submitbutton).click();
			Boolean errormessage=driver.findElement(errormsg).isDisplayed();
			Assert.assertTrue(true);

		}
		public void withoutcheck() throws InterruptedException {
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("window.scrollBy(0,700)");
			driver.findElement(namefield).sendKeys("asna");
			driver.findElement(mailfield).sendKeys("asna@gmail.com");
			driver.findElement(phnumfield).sendKeys("1234567890");
			driver.findElement(servicetype).click();
			driver.findElement(service).click();
			Thread.sleep(4000);
			driver.findElement(messagefield).sendKeys("hellooooo Real Green Irrigation");
			driver.findElement(submitbutton).click();
			Boolean errormesg=driver.findElement(errormsg).isDisplayed();
			Assert.assertTrue(errormesg);
		}
}