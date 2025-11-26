package Frontendtest;

import org.testng.annotations.Test;

import Frontend.HomePage;
import Utilities.BaseClass;

import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class HomePageTests extends BaseClass {
	HomePage home;
	@BeforeMethod
	  public void beforeMethod() {
		  super.setup();

		  home=new HomePage(driver);
	  }

  @Test(priority=1)
  public void Testgetheadertext() {
	  home.getheadertext();
  }
  @Test(priority=2)
  public void testvisibilityoflogo() {
	  home.visibiityoflogo();
  }
  @Test(priority=2)
  public void testvisibilityofhomemenu() {
	  Assert.assertTrue(home.visibilityofhomemenu());
  }
  @Test(priority=3)
  public void testvisibilityofaboutmenu() {
	 Assert.assertTrue(home.visibilityofaboutmenu());
  }
  @Test(priority=4)
  public void testvisibilityofproductsmenu() {
	  Assert.assertTrue(home.visibilityofproductsmenu());
  }
  @Test(priority=5)
  public void testvisibilityofcontactusmenu() {
	  Assert.assertTrue(home.visibilityofcontactusmenu());
  }
  @Test(priority=6)
  public void testvisibilityofcart() {
	  Assert.assertTrue(home.visibilityofcartmenu());
  }
  @Test(priority=7)
  public void testvisibilityofshoppingbagmenu() {
	  Assert.assertTrue(home.visibilityofshoppingbamenu());
  }
  @Test(priority=8)
  public void testvisibilityofdropdowntogglemenu() {
	  Assert.assertTrue(home.visibilityofdropdowntoggle());
  }
  @Test(priority=9)
  public void testvisibilityofemail() {
	  Assert.assertTrue(home.visibilityofemail());
  }
  @Test(priority=10)
  public void testvisibilityofphnum() {
	  Assert.assertTrue(home.visibilityofphnum());
  }
  @Test(priority=11)
  public void testtextvalidationhomemenu() {
	  String expectedtext="Home";
	  String Actualtext=home.homemenutextvalidation();
	  Assert.assertEquals(expectedtext, Actualtext, "Spelling mistake");
	  System.out.println("text:"+Actualtext);
  }
  @Test(priority=12)
  public void testtextvalidationaboutusmenu() {
	  String expectedtext="About Us";
	  String Actualtext=home.aboutusmenutextvalidation();
	  Assert.assertEquals(expectedtext, Actualtext, "Spelling mistake:"+Actualtext);
  }
  @Test(priority=13)
  public void testtextvalidationproductsmenu() {
	  String expectedtext="Products";
	  String Actualtext=home.productsmenutextvalidation();
	  Assert.assertEquals(expectedtext, Actualtext, "Spelling mistake:"+Actualtext);
  }
  @Test(priority=14)
  public void testtextvalidationcontactusmenu() {
	  String expectedtext="Contact Us";
	  String Actualtext=home.contactusmenutextvalidation();
	  Assert.assertEquals(expectedtext, Actualtext, "Spelling mistake:"+Actualtext);
  }
  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
