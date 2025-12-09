package Frontendtest;

import org.testng.annotations.Test;

import Frontend.Productpage;
import Utilities.BaseClass;

import org.testng.annotations.BeforeMethod;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class ProductTest extends BaseClass{
	Productpage prod;
	
  @Test
  public void testmodalopens() {
	  prod.modalopen();
  }
  @Test()
  public void clickXbutton() {
	  prod.clickXbutton();
  }
  
  @Test()
  public void countofcards() {
	  prod.cardcount();
  }
  
  
  
 @Test 
  public void verifycategories() throws InterruptedException {
	 prod.verifyAllCategories();
 }  
 
 @Test()
 public void click() throws InterruptedException {
	 prod.testclickmulcsheet();
 }
 @Test()
 public void checkcount() throws InterruptedException {
	 prod.productcount();;
 }
  @BeforeMethod
  public void beforeMethod() throws InterruptedException {
	  
		  super.productsetup();
		  prod=new Productpage(driver);
  }

@Test()
public void countprodinsidecategory() throws InterruptedException
{
	prod.prodcount();
}
@Test()
public void checkcount1() throws InterruptedException {
	prod.checkcount();
}
@Test()
public void TestWishList() throws InterruptedException {
	prod.wishlist();
}
@Test()
public void lefarrow() throws InterruptedException  {
	prod.carousel();
}
@Test()
public void testrightarrow() throws InterruptedException {
	prod.rightarrow();
}
@Test()
public void testimg() throws InterruptedException {
	prod.image();
}
  @AfterMethod
  public void afterMethod() {
  }

}
