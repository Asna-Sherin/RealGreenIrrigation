package Frontendtest;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Frontend.Aboutuspage;
import Utilities.BaseClass;

import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class AboutusTest extends BaseClass {
	Aboutuspage abt;
	  SoftAssert soft=new SoftAssert();

	@BeforeMethod
	  public void beforeMethod() throws InterruptedException {
		  super.aboutussetup();
		  abt=new Aboutuspage(driver);
	  }

  @Test
  public void verifytestcards() throws InterruptedException {
//	  abt.testcard();
	  abt.verifyAllServices();
  }
  @Test(priority=2)
  public void correctmail() {
	  abt.rightmail();
  }
  @Test(priority=3)
  public void wrongmal() throws InterruptedException {
//	  abt.wrongmail();
  }
  @Test(priority=3)
	  public void wrongmail() throws InterruptedException {
		  abt.scrolldown();
		  abt.invalidmail("asna");
		  abt.clicksub();
		  boolean success=abt.issuccessmsgvisible();
		  Assert.assertFalse(success,"Success message is shown for invalid email");
	  }
  
  @Test(priority=4)
  public void openeachblog() throws InterruptedException
  {
	  int totalblogs=abt.getblogs().size();
	  System.out.println("total blogs"+totalblogs);
	  for(int i=0;i<totalblogs;i++) {
		  abt=new Aboutuspage(driver);
		  System.out.println("Clicking blog"+(i+1));
		  abt.clickblog(i);
		  Thread.sleep(5000);
		  
		  boolean error=abt.isSqlerrorshow();
		  
		  
		  soft.assertFalse(error,"SQL error on blog index "+i+"url :"+driver.getCurrentUrl());
		  
		  driver.navigate().back();
		  Thread.sleep(5000);
		  
		  driver.navigate().refresh();
		 
	  }
	 soft.assertAll();
  }

  
  @Test(priority=5)
  public void testviewall() {
	  abt.clickviewall();
  }
  @AfterMethod
  public void afterMethod() {
  }

}
