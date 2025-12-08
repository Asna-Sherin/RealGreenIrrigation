package Frontend;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Login {
	WebDriver driver;
	public Login(WebDriver driver) {
		this.driver=driver;
	}
	By email=By.xpath("//*[@id=\"email\"]");
	By password=By.xpath("//*[@id=\"passwordField\"]");
	By signinbutton=By.xpath("/html/body/div[2]/div[6]/div/div[2]/div/div/form/div[2]/div[1]/button");
	By forgetpass=By.xpath("//*[@id=\"forgot-password-link\"]/small");
	By createacc=By.xpath("/html/body/div[2]/div[6]/div/div[2]/div/div/form/div[2]/div[2]/a[2]");
	By fnamefield=By.id("firstname");	
	By lnamefield=By.id("lastname");
	By contactnumfield=By.id("contactnumber");
	By emailfield=By.id("emailField");
	By createaccbutton=By.xpath("/html/body/div[2]/div[5]/div[5]/div/div[2]/div/div/form/div[6]/button");
	By login=By.xpath("/html/body/div[2]/div[5]/div[5]/div/div[2]/div/div/div/div/a");
	By email2=By.xpath("/html/body/div[2]/div[7]/div/div[2]/div/div/form/input[1]");
	By mobnumfield=By.xpath("/html/body/div[2]/div[7]/div/div[2]/div/div/form/input[2]");
	By generateotpbtn=By.xpath("/html/body/div[2]/div[7]/div/div[2]/div/div/form/div[1]/button");
	By createaccbutton1=By.xpath("/html/body/div[2]/div[7]/div/div[2]/div/div/form/div[2]/a");
	By errormsg=By.xpath("/html/body/div[2]/div[6]/div/div[2]/div/div/form/div[1]/div/div/span[2]");	
	By registersuccessmsg=By.xpath("/html/body/div[2]/div[5]/div[5]/div/div[2]/div/div/form/div[1]/div/div/span[2]");
	By profile=By.xpath("/html/body/div[2]/header/div[2]/div/div/div[2]/div/nav/div/ul/li[7]/div/a[1]");
	By updatebutton=By.xpath("/html/body/div[2]/div[6]/div/div[2]/div/div/form/div/button");
	By updatesuccessmsg=By.xpath("/html/body/div[2]/div[6]/div/div[2]/div/div/form/div[1]/div/div/span[2]");
	By profileicon=By.xpath("//*[@id=\"userDropdown\"]");
	By contactnumfield1=By.xpath("/html/body/div[2]/div[6]/div/div[2]/div/div/form/input[4]");
	By changepassword=By.xpath("/html/body/div[2]/header/div[2]/div/div/div[2]/div/nav/div/ul/li[7]/div/a[2]");
	By newpass=By.xpath("//*[@id=\"password\"]");
	By confrmnewpass=By.xpath("//*[@id=\"confirm_password\"]");
	By changepassbutton=By.xpath("/html/body/div[2]/div[6]/div[1]/div[2]/div/div/form/div[3]/button");
	By changepasssuccessmsg=By.xpath("/html/body/div[2]/div[6]/div/div[2]/div/div/form/div[1]/div/div/span[2]");
	By logoutbutton=By.xpath("/html/body/div[2]/header/div[2]/div/div/div[2]/div/nav/div/ul/li[7]/div/a[3]");
	
	public boolean visibilityofemailfield() {
		return driver.findElement(email).isDisplayed();

	}
	public boolean visibilityofpasswordfield() {
		return driver.findElement(password).isDisplayed();

	}
	public boolean visibilityoflogin() {
		return driver.findElement(signinbutton).isDisplayed();
	}
	public boolean visibilityofforgetpass() {
		return driver.findElement(forgetpass).isDisplayed();
	}
	public boolean visibilityofcreateacc() {
		return driver.findElement(createacc).isDisplayed();
	}
	public void loginwithoutcreatingacc() {
		driver.findElement(email).sendKeys("asna@gmail.com");
		driver.findElement(password).sendKeys("12345");
		driver.findElement(signinbutton).click();
		String expectederrormesg="Invalid email or password";
		  String actualerrormesg=driver.findElement(errormsg).getText();
		  Assert.assertEquals(expectederrormesg,actualerrormesg,"test fails");
}
	public void signupwithvalidcredentials() throws InterruptedException  {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,75)");
		Thread.sleep(5000);;
		driver.findElement(createacc).click();
		driver.findElement(fnamefield).sendKeys("asna");
		driver.findElement(lnamefield).sendKeys("sherin");
		driver.findElement(contactnumfield).sendKeys("1234567890");
		driver.findElement(emailfield).sendKeys("asna@gmail.com");
		driver.findElement(password).sendKeys("asna123");
		js.executeScript("window.scrollBy(0,100)");
		driver.findElement(createaccbutton).click();
		Boolean successmsg=driver.findElement(registersuccessmsg).isDisplayed();
		Assert.assertTrue(successmsg);
	}
	
	//signin with valid crdentials
	public void validcredentials() {
		driver.findElement(email).sendKeys("asna@gmail.com");
		driver.findElement(password).sendKeys("!@#$%^&*()");
		driver.findElement(signinbutton).click();

	}
	public void updateprofile() {
		driver.findElement(email).sendKeys("asna@gmail.com");
		driver.findElement(password).sendKeys("!@#$%^&*()");
		driver.findElement(signinbutton).click();
		driver.findElement(profileicon).click();
		driver.findElement(profile).click();
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)");
		driver.findElement(contactnumfield1).clear();
		driver.findElement(contactnumfield1).sendKeys("9826481974");
		driver.findElement(updatebutton).click();
		Boolean msg=driver.findElement(updatesuccessmsg).isDisplayed();
		Assert.assertTrue(msg);
	}
	public void changepassword() {
		driver.findElement(email).sendKeys("asna@gmail.com");
		driver.findElement(password).sendKeys("~!@#$%^&*()_+");
		driver.findElement(signinbutton).click();
		driver.findElement(profileicon).click();
		driver.findElement(changepassword).click();
		driver.findElement(newpass).sendKeys("~!@#$%^&*()_+~");
		driver.findElement(confrmnewpass).sendKeys("~!@#$%^&*()_+~");
		driver.findElement(changepassbutton).click();
		Boolean msg=driver.findElement(changepasssuccessmsg).isDisplayed();
		Assert.assertTrue(msg);
	}
	
	public void logout() {
		driver.findElement(email).sendKeys("asna@gmail.com");
		driver.findElement(password).sendKeys("~!@#$%^&*()_+");
		driver.findElement(signinbutton).click();
		driver.findElement(profileicon).click();
		driver.findElement(logoutbutton).click();
		
		
		
		
	}
}
