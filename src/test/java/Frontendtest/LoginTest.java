package Frontendtest;

import org.testng.annotations.Test;

import Frontend.Login;
import Utilities.BaseClass;

import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class LoginTest extends BaseClass {
	Login log;
	@BeforeMethod
	  public void beforeMethod() throws InterruptedException {
		  super.loginsetup();
		  log=new Login(driver);
	  }

  @Test(priority=1)
  public void visibilitiyofelements() {
	  Assert.assertTrue(log.visibilityofemailfield());

  }
  @Test(priority=2)
  public void visibilityofpass() {
	  Assert.assertTrue(log.visibilityofpasswordfield());

  }
  @Test(priority=3)
  public void visibilityofsignin() {
	  Assert.assertTrue(log.visibilityoflogin());

  }
  @Test(priority=4)
  public void visibilityofforgetpass() {
	  Assert.assertTrue(log.visibilityofforgetpass());

  }
  @Test(priority=5)
  public void visibilityofcreateacc() {
	  Assert.assertTrue(log.visibilityofcreateacc());

  }@Test
  public void testloginwithoutsignup() {
	  log.loginwithoutcreatingacc();
  }
  @Test(priority=7)
  public void testsignupwithvalidcrdentials() throws InterruptedException   {
	  log.signupwithvalidcredentials();
  }
  @Test(priority=8)
  public void testsigninwithvalidcrdentials() {
	  log.validcredentials();
  }
  @Test(priority=9)
  public void updateprofile() {
	  log.updateprofile();
  }
  @Test(priority=10)
  public void changepass() {
	  log.changepassword();
  }
  @AfterMethod
  public void afterMethod() {
//	  driver.quit();
  }

}
