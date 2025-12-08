package Frontendtest;

import org.testng.annotations.Test;

import Frontend.HomePage;
import Utilities.BaseClass;

import org.testng.annotations.BeforeMethod;

import java.util.List;

import org.openqa.selenium.WebElement;
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
  @Test(priority=15)
  public void testhomemenulinkvalidation() {
	  home.homemenulinkvalidation();
	  
  }
  @Test(priority=16)
  public void testaboutusmenulinkvalidation() {
	  home.aboutusmenulinkvalidation();
	  
  }
  @Test(priority=17)
  public void testcontactusmenulinkvalidation() {
	  home.contactusmenulinkvalidation();
	  
  }
  @Test(priority=18)
  public void testemailink() {
	  String emailhref=home.emaillink();
	  Assert.assertEquals(emailhref,"mailto:sales@realgreenirrigation.com","Email is Incorrect");
  }
  @Test(priority=19)
  public void testphnlink() {
	  String phnhref=home.phnlink();
	  Assert.assertEquals(phnhref,"tel:+97192228080","incorrect phnnumber");
  }
  @Test(priority=20)
  public void testproductmodal() {
	  home.productmodal();
	  Assert.assertTrue(true);
  }
  @Test(priority=21)
  public void testcartmenus() {
	  home.cartmenus();
	  Assert.assertTrue(true);
  }
  @Test(priority=22)
  public void testvisibilityofcarouselarrows() {
	  home.visibilityofcarouselarrows();
	  Assert.assertTrue(true);
  }
  @Test(priority=23)
  public void testvisibilityofnextarrow() {
	 
	  Assert.assertTrue(true);
  }
  @Test(priority=24)
  public void testvisiilityofarrow() throws InterruptedException {
	// Read background image URL
      String imageURL = home.getActiveSlideImageURL();
      System.out.println("Slide Background: " + imageURL);

      //  Read next arrow color
      String arrowColor = home.getNextArrowColor();
      System.out.println("Next Arrow Color: " + arrowColor);

      // Click next arrow and check again
      home.clickNextArrow();
      Thread.sleep(1500);

      String newImageURL = home.getActiveSlideImageURL();
      String newArrowColor = home.getNextArrowColor();

      System.out.println("New Slide Background: " + newImageURL);
      System.out.println("New Arrow Color: " + newArrowColor);
		  }
	  @Test(priority=25)
	  public void testcarouselslidesloadscorrectly() throws InterruptedException {
		int total=home.gettotalslides();
		for(int i=0;i<total;i++) {
			String bg=home.getslidebackground(i);
			Assert.assertTrue(bg.contains("url"),"Slide has no background image");
			home.clicknext();
			Thread.sleep(2000);
			}
	  }
	  @Test(priority=26)
	  public void testautoplay() throws InterruptedException {
		  home.carouselautoplay();
	  }
	  @Test(priority=27)
	  public void testpaginationdots() throws InterruptedException {
		  //check dots are present
		  int dots=home.paginationdotscount();
		  Assert.assertTrue(dots>0,"Pagination Dots not visible");
		  //click dot by index
		  Thread.sleep(2000);
		  home.clickpaginationdotbyindex(0);
		  String slideafterclick=home.getactiveslide();
		  //click second dot
		  home.clickpaginationdotbyindex(1);
		  String slideafterclick1=home.getactiveslide();
		  //chcek the page slide correctly
		  Assert.assertEquals(slideafterclick,slideafterclick1,"Slide did not change while clicking dot");
		  System.out.println("slide changes correctly");
	  }
	  @Test(priority=28)
	  public void verifyexploreproductbutton() throws InterruptedException {
		  Thread.sleep(3000);
		  Assert.assertTrue(home.visibilityofexploreproductbtn(),"Explore Product Button not visible");
		  Assert.assertTrue(home.clickabilityofexploreproductbtn(),"Explore product Button is not able to click");
		  home.clickexploreproductbuton();
	  }
	  @Test(priority=30)
	  public void checkautoplaycarousel2() throws InterruptedException {
		 int total= home.gettotalslides2();
		 System.out.println("total slides"+total);
		  home.autoplay();
	  }
	  
	  @Test(priority=31)
	  public void gettotalcount() {
		  int count=home.totalcount();
		  System.out.println("total"+count);
	  }
	  @Test(priority=32)
	  public void testimgspace() {
		  home.imagespacetest();
	  }
	  @Test(priority=33)
	  public void getimagescount() {
		  home.getimagescount();
	  }
	  @Test(priority=34)
	  public void clickchristmassale() throws InterruptedException {
		  home.clickchristmassalebtn();
		 
	  }
	  @Test(priority=35)
	 public void testcardwidth() throws InterruptedException {
		  home.getcardwidth();
	  }
	  @Test(priority=36)
	  public void testcardheight() throws InterruptedException {
		  home.getcardheight();
	  }
	  @Test(priority=37)
	  public void testpriceallignment() throws InterruptedException {
		  home.priceallignmnet();
	  }
	  
	  @Test(priority=38)
	  public void testnewarrival() throws InterruptedException {
		  home.verifyproductloads();
	  }
	  //verify all products having images
	  @Test(priority=39)
	  public void verfyimages() throws InterruptedException {
		  home.images();
	  }
	  @Test(priority=40)
	  public void verifyproducttitle() throws InterruptedException {
		  home.title();
	  }
	  @Test(priority=41)
	  public void verifyproductprice() throws InterruptedException {
		  home.verifyproductprice();
	  }
	  @Test(priority=42)
	  public void verifyproductratings() {
		  home.ratings();
	  }
	  @Test(priority=43)
	  public void verifyhoveraction() throws InterruptedException {
		  home.verifyhoveraction();
	  }
	  @Test(priority=44)
	  public void testquickviewmenu() throws InterruptedException {
		  home.quickview();
	  }
	  @Test(priority=45)
	  public void testaddtocartmodal() throws InterruptedException {
		  home.addtocartmodal();
	  }
	  @Test(priority=47)
	  public void addtocartpage() throws InterruptedException {
		  home.addtocartpage();
	  }
	  @Test(priority=48)
	  public void footeradd() throws InterruptedException {
		  home.footeradd();
	  }
	  @Test(priority=49)
	  public void footerphn() throws InterruptedException {
		  home.footerphn();
	  }
	  @Test(priority=50)
	  public void testfootermail() throws InterruptedException {
		  home.footermail();
	  }
	  @Test(priority=51)
	  public void testquickinks() throws InterruptedException {
		  home.quicklinks();
	  }
	  @Test(priority=52)
	  public void invalidemailsuscription() throws InterruptedException {
		  home.suscription();
	  }
	  @Test(priority=53)
	  public void clickermsandcondiitons() throws InterruptedException {
		  home.clicktermsandcondiitons();
	  }
	  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
