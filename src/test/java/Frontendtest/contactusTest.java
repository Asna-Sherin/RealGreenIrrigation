package Frontendtest;

import org.testng.annotations.Test;

import Frontend.Contactuspage;
import Utilities.BaseClass;

import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class contactusTest extends BaseClass{
	Contactuspage contact;
  @Test
  public void clickmail() {
	  contact.clickmail();
  }
  @BeforeMethod
  public void beforeMethod() throws InterruptedException {
	  super.contactsetup();
	  contact=new Contactuspage(driver);
  }
@Test()
public void checkphnlink() {
	String phnhref=contact.phnlink();
	  Assert.assertEquals(phnhref,"tel:+97192228080","incorrect phnnumber");
}
@Test()
public void testaddress() throws InterruptedException {
	contact.Checkmap();
}

@Test()
public void rightcrdentials() throws InterruptedException {
	contact.rightcredentials();
}
@Test()
public void wrongmail() throws InterruptedException {
	contact.wrongmail();
}
@Test()
public void invalidphnum() throws InterruptedException {
	contact.ivalidphnum();
}
@Test()
public void submitwithoutchcek() throws InterruptedException {
	contact.withoutcheck();;
}
  @AfterMethod
  public void afterMethod() {
  }

}
