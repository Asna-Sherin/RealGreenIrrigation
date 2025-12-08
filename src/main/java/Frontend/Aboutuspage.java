package Frontend;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Aboutuspage {
	WebDriver driver;
	WebDriverWait wait;
	public Aboutuspage(WebDriver driver) {
		this.driver=driver;
		this.wait=new WebDriverWait(driver,Duration.ofSeconds(5));
	}
	By cardheadings=By.className("ltn__card-title");
	By plusbutton=By.xpath("//*[@id=\"accordion_2\"]/div[1]/h6");
	By card=By.cssSelector("#accordion_2.card");
	By cardbody=By.className("card-body");
	By mailfield=By.xpath("//*[@id=\"email_input\"]");
	By subbutton=By.xpath("/html/body/div[2]/div[12]/div/div/div/div/form/div/button");
	By successmsg=By.xpath("//*[@id=\"confirmation-modal\"]/div/p");
	By closebutton=By.xpath("//*[@id=\"close-modal-button\"]");
	By blogtitles=By.cssSelector(".blog-title a");
	By viewallButton=By.xpath("/html/body/div[2]/section/div/div[3]/div/a");
	
	
	public void verifyAllServices() {

        List<WebElement> headings = driver.findElements(cardheadings);

        for (int i = 0; i < headings.size(); i++) {

            // Re-locate to avoid stale element
            WebElement titleElement = driver.findElements(cardheadings).get(i);
            String title = titleElement.getText().trim();

            // Scroll
            ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,700)");
            
            // Click title to expand
            JavascriptExecutor js=(JavascriptExecutor)driver;
            js.executeScript("arguments[0].scrollIntoView({block:'center'});", title);
            js.executeScript("arguments[0].click()",title);
            // Get panel id
            String target = titleElement.getAttribute("data-target");  // "#faq-item-2-x"
            String panelId = target.substring(1);

            WebElement panel = driver.findElement(By.id(panelId));

            // Wait for panel to show
            wait.until(ExpectedConditions.attributeContains(panel, "class", "show"));

            // Validate content
            WebElement body = panel.findElement(cardbody);
            String text = body.getText().trim();

            if (text.length() == 0) {
                throw new AssertionError("❌ Description empty for service: " + title);
            }

            System.out.println("✔ Verified service: " + title);
        }
    }

	
	public void testcard() throws InterruptedException {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1600)");
		List<WebElement>cardslist=driver.findElements(card);

		int size=driver.findElements(card).size();
		System.out.println("no.of cards"+size);
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		for(int i=0;i<size;i++) {
			Thread.sleep(3000);
			List<WebElement>titles=driver.findElements(plusbutton);
			titles.get(i).click();
			List<WebElement>info=driver.findElements(cardbody);
			boolean cardbodydisplays=info.get(i).isDisplayed();
			Assert.assertTrue(cardbodydisplays,"info is not displayed for card:"+i);

		}
	}
	
	
	//free estimation
	
	public void rightmail() {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,2300)");
		driver.findElement(mailfield).sendKeys("asna@gmail.com");
		driver.findElement(subbutton).click();
		Assert.assertTrue(driver.findElement(successmsg).isDisplayed());
		driver.findElement(closebutton).click();
	}
	
	public void invalidmail() throws InterruptedException {
		Thread.sleep(5000);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,2300)");
		driver.findElement(mailfield).sendKeys("asna.co,");
		driver.findElement(subbutton).click();
		Assert.assertFalse(driver.findElement(successmsg).isDisplayed(),"Bug founded");
		driver.findElement(closebutton).click();

	}
	public void scrolldown() throws InterruptedException {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,2300)");
		Thread.sleep(5000);
	}
	public void invalidmail(String mail) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(mailfield)).sendKeys(mail);
	}
	public void clicksub() {
		wait.until(ExpectedConditions.elementToBeClickable(subbutton)).click();
	}
	public boolean issuccessmsgvisible() {
		try{
			return driver.findElement(successmsg).isDisplayed();
		}catch(Exception e) {
			return false;
		}
	}
	public List<WebElement> getblogs(){
		return driver.findElements(blogtitles);
	}
	
	public void clickblog(int index) {
		driver.findElements(blogtitles).get(index).click();
	}
	By sqlerror=By.xpath("//*[contains(text(),'SQL syntax') or contains(text(),'mysqli_sql_exception')]");
	 public boolean isSqlerrorshow() {
		 return driver.findElements(sqlerror).size()>0;
	 }
	 
	 public void clickviewall(){
	 JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,2700)");
		String currenturl=driver.getCurrentUrl();
		driver.findElement(viewallButton).click();
		String currenturl1=driver.getCurrentUrl();
		Assert.assertNotEquals(currenturl,currenturl1,"not redirected proprly");
}
}