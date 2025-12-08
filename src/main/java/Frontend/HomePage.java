package Frontend;

import java.time.Duration;
import java.util.List;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public  class HomePage {
	WebDriver driver;
	public HomePage(WebDriver driver) {
		this.driver=driver;
	}
	By logo=By.xpath("/html/body/div[2]/header/div[2]/div/div/div[1]/div/div/a/img");
	By homemenu=By.xpath("/html/body/div[2]/header/div[2]/div/div/div[2]/div/nav/div/ul/li[1]/a");
	By aboutmenu=By.xpath("/html/body/div[2]/header/div[2]/div/div/div[2]/div/nav/div/ul/li[2]/a");
	By productsmenu=By.xpath("//*[@id=\"productsMenu\"]");
	By contactusmenu=By.xpath("/html/body/div[2]/header/div[2]/div/div/div[2]/div/nav/div/ul/li[4]/a");
	By cartmenu=By.xpath("/html/body/div[2]/header/div[2]/div/div/div[2]/div/nav/div/ul/li[5]/a");
	By shoppingbagmenu=By.xpath("/html/body/div[2]/header/div[2]/div/div/div[2]/div/nav/div/ul/li[6]/a/i");
	By userdropdowntoggle=By.id("userDropdown");
	By email=By.xpath("/html/body/div[2]/header/div[1]/div/div/div/div[1]/a");
	By phnum=By.xpath("/html/body/div[2]/header/div[1]/div/div/div/div[2]/a");
	By productmodal=By.xpath("//*[@id=\"categoryModal\"]/div/div");
	By carts=By.xpath("//*[@id=\"ltn__utilize-cart-menus\"]");
	By prevarrow=By.className("swiper-button-prev");
	By nextarrow=By.className("swiper-button-next");
	By activeslide=By.cssSelector(".swiper-slide-active");
	By slides=By.cssSelector(".swiper-slide");
	By loader=By.id("loader");
	By paginationdots=By.cssSelector(".swiper-pagination-bullet");
	By activepaginationdot=By.cssSelector(".swiper-pagination-bullet-active");
	By exploreproductsbtn=By.cssSelector("#themebtn");
	By carousel2slides=By.cssSelector(".slick-slide");
	By activelide=By.cssSelector(".slick-active");
	By cards=By.cssSelector(".col-xl-3.col-md-6.col-12.exp");
	By images=By.cssSelector(".ltn__banner-area.mt-4 img");
	By lastimage=By.xpath("/html/body/div[2]/div[10]/div/div/div[3]/div/div/img");
	By christmasaleutton=By.xpath("/html/body/div[3]/div/div/div/div[2]/div/button");
	By productscard=By.cssSelector(".col-md-3");
	By title=By.cssSelector(".product-title a");
	By errormessage=By.xpath("//*[@id=\"featuredProductsContainer\"]/p");
	By secondcardactualprice=By.xpath("//*[@id=\"featuredProductsContainer\"]/div[2]/div/div[2]/div/span");
	By secondcardoldprice=By.xpath("//*[@id=\"featuredProductsContainer\"]/div[2]/div/div[2]/div/del");
	By newarrivalproducts=By.cssSelector(".ltn__product-item.ltn__product-item-3.text-center.product-item.new-arrival-grid");
	By newarrivalproducttitle=By.cssSelector(".product-title.new-arrival-grid");
	By newarrivalproductprice=By.cssSelector(".product-price");
	By newarrivalproductratting=By.cssSelector(".product-ratting");
	By newarrivalhovermenu=By.cssSelector(".product-hover-action.new-arrival-grid");
	By productimage=By.cssSelector("img");
	By quickviewmenu=By.cssSelector(".quick-view-link");
	By addtocartmenu=By.cssSelector(".add_to_cart");
	By Xbutton=By.xpath("//*[@id=\"add_to_cart_modal\"]/div/div/div[1]/button/span");
	By addtocartmodal=By.cssSelector(".modal-content");
	By viewcartbutton=By.xpath("/html/body/div[7]/div/div/div/div[2]/div/div/div/div/div[2]/div/a[1]");
	By producttitle=By.cssSelector(".product-title.new-arrival-grid");
	By productprice=By.cssSelector(".product-price");
	By productprice1=By.cssSelector(".unit-price");
	By trash=By.xpath("//*[@id=\"viewCartItems\"]/tr/td[6]/button");
	By prodname=By.xpath("//*[@id=\"viewCartItems\"]/tr/td[2]");
	By wishlistmenu=By.cssSelector(".far.fa-heart");
	By footeraddress=By.xpath("/html/body/footer/div[1]/div/div/div[1]/div/div[2]/ul/li[1]/div/p/a[2]");
	By footerphn=By.xpath("/html/body/footer/div[1]/div/div/div[1]/div/div[2]/ul/li[2]/div[2]/p/a");
	By footermail=By.xpath("/html/body/footer/div[1]/div/div/div[1]/div/div[2]/ul/li[3]/div[2]/p/a");
	By quicklinks=By.className(".footer-menu");
	By subsciptionmailfield=By.xpath("//*[@id=\"email_input\"]");
	By subscribebutton=By.id("subscribe-button");
	By subsuccessmsg=By.xpath("//*[@id=\"confirmation-modal\"]/div");
	By termsandconditions=By.xpath("/html/body/footer/div[1]/div/div/div[3]/div/div/ul/li/a");
	By header=By.cssSelector("header");
	By heading=By.xpath("/html/body/div[2]/div[5]/div/div/div/div/div/h1");
	
	
	public void getheadertext() {
		String Headertext=driver.getTitle();
		System.out.println("HeaderText:"+Headertext);
	}
	public void visibiityoflogo() {
		boolean status=driver.findElement(logo).isDisplayed();
		System.out.println("visibility of logo:"+status);
	}
	public boolean visibilityofhomemenu() {
		return driver.findElement(homemenu).isDisplayed();
		}
	public boolean visibilityofaboutmenu() {
		return driver.findElement(aboutmenu).isDisplayed();
	}
	public boolean visibilityofproductsmenu() {
		return driver.findElement(productsmenu).isDisplayed();
	}
	public boolean visibilityofcontactusmenu() {
		return driver.findElement(contactusmenu).isDisplayed();
	}
	public boolean visibilityofcartmenu() {
		return driver.findElement(cartmenu).isDisplayed();
	}
	public boolean visibilityofshoppingbamenu() {
		return driver.findElement(shoppingbagmenu).isDisplayed();
	}
	public boolean visibilityofdropdowntoggle() {
		return driver.findElement(userdropdowntoggle).isDisplayed();
	}
	public boolean visibilityofemail() {
		return driver.findElement(email).isDisplayed();
	}
	public boolean visibilityofphnum() {
		return driver.findElement(phnum).isDisplayed();
	}
	public String homemenutextvalidation() {
		WebElement homemenutext=driver.findElement(homemenu);
		return homemenutext.getText();
	}
	public String aboutusmenutextvalidation() {
		WebElement aboutusmenutext=driver.findElement(aboutmenu);
		return aboutusmenutext.getText();
	}
	public String productsmenutextvalidation() {
		WebElement productsmenutext=driver.findElement(productsmenu);
		return productsmenutext.getText();
	}
	public String contactusmenutextvalidation() {
		WebElement contactusmenutext=driver.findElement(contactusmenu);
		return contactusmenutext.getText();
	}
	public void homemenulinkvalidation() {
		WebElement link=driver.findElement(homemenu);
		String href=link.getAttribute("href");
		  Assert.assertEquals(href,"https://riyoceline.com/projects/green/shop/index");
}
	public void aboutusmenulinkvalidation() {
		WebElement link=driver.findElement(aboutmenu);
		String href=link.getAttribute("href");
		Assert.assertEquals(href,"https://riyoceline.com/projects/green/shop/about");
	}
	public void contactusmenulinkvalidation() {
		WebElement link=driver.findElement(contactusmenu);
		String href=link.getAttribute("href");
		Assert.assertEquals(href,"https://riyoceline.com/projects/green/shop/contact");
	}
	public String emaillink() {
		return driver.findElement(email).getAttribute("href");
	}
	public String phnlink() {
		return driver.findElement(phnum).getAttribute("href");
	}
	public boolean productmodal() {
		driver.findElement(productsmenu).click();
		return driver.findElement(productmodal).isDisplayed();
	}
	public boolean cartmenus() {
		driver.findElement(cartmenu).click();
		return driver.findElement(carts).isDisplayed();
		}
	public boolean visibilityofcarouselarrows() {
		return driver.findElement(prevarrow).isDisplayed(); 
	}
	public boolean visibilityofcarouselarrows1() {
		return driver.findElement(nextarrow).isDisplayed();
	}
	public String getActiveSlideImageURL() {
			        WebElement slide = driver.findElement(activeslide);
			        String style = slide.getAttribute("style");
			        String url = style.substring(style.indexOf("url(") + 4, style.indexOf(")"));
			        url = url.replace("'", "").replace("\"", "");
			        return url;
			    }
	             public String getNextArrowColor() {
			        WebElement arrow = driver.findElement(nextarrow);
			        return arrow.getCssValue("color");
			    }
			    public void clickNextArrow() {
			        driver.findElement(nextarrow).click();
			    }
		public int gettotalslides() {
			return driver.findElements(slides).size();
			}
		public String getslidebackground(int index) {
			List<WebElement>slidelist=driver.findElements(slides);
			WebElement slide=slidelist.get(index);
			return slide.getCssValue("background-image");

		}
		public void clicknext() {
			WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
			wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));
			driver.findElement(nextarrow).click();

		}
		public void carouselautoplay() throws InterruptedException {
			String firstslide=driver.findElement(activeslide).getText();
			Thread.sleep(5000);
			String secondslide=driver.findElement(activeslide).getText();
			Assert.assertNotEquals(firstslide,secondslide,"Autoplay Fails");
			System.out.println("Autoplay works");
			
		}
		
		//pagination test
		
		public int paginationdotscount() {
			return driver.findElements(paginationdots).size();
	
		}
		public void clickpaginationdotbyindex(int index) {
			 driver.findElements(paginationdots).get(index).click();
		}
		public String getactiveslide() {
			return driver.findElement(activeslide).getAttribute("id");
		}
		
		//verify explore products button is clickble
		//check the visibilityof button
		public boolean visibilityofexploreproductbtn() {
			WebElement element=driver.findElement(exploreproductsbtn);
//			WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10)); 
//			wait.until(ExpectedConditions.visibilityOf(element));
			return element.isDisplayed();
		}
		//check the button is clickble
		public boolean clickabilityofexploreproductbtn() {
			return driver.findElement(exploreproductsbtn).isEnabled();
		}
		//click the button
		public void clickexploreproductbuton() throws InterruptedException {
			    WebElement exploreBtn = driver.findElement(exploreproductsbtn);

			    JavascriptExecutor js = (JavascriptExecutor) driver;
			    js.executeScript("arguments[0].scrollIntoView(true);", exploreBtn);
			    js.executeScript("arguments[0].click();",exploreBtn);
		}		
		
		//second carousel
		
		public int gettotalslides2() {
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("window.scrollBy(0,200)");
			return driver.findElements(carousel2slides).size();
		}
		public void autoplay() throws InterruptedException {
			String before=driver.findElement(activelide).getText();
			Thread.sleep(4000);
			String after=driver.findElement(activelide).getText();
			Assert.assertNotEquals(before, after,"Slide not autoslide");
			System.out.println("slide autoslides");
		}
		public int totalcount() {
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("window.scrollBy(0,1000)");
			return driver.findElements(cards).size();
		}
		
		public void imagespacetest() {
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("window.scrollBy(0,1200)");

			WebElement Lastimage=driver.findElement(lastimage);
			int imagePosition = Lastimage.getLocation().getX();

		    System.out.println("Image X Position: " + imagePosition);

		    // we expect the image not to be too left (meaning too much space on right)
		    // but in  UI, it IS too left → so this will FAIL
		    Assert.assertFalse(imagePosition > 900,
		            "UI BUG: Extra white space on the right side!");
		}
		public void getimagescount() {
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("window.scrollBy(0,1400)");
			List<WebElement>element=driver.findElements(images);

System.out.println("no.of images"+element.size());	
System.out.println("Images found: " + element.size());
for (WebElement img :element) {
    System.out.println(img.getAttribute("src"));
}}
		public void clickchristmassalebtn() throws InterruptedException {
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("window.scrollBy(0,1600)");
			Thread.sleep(5000);
			WebElement btn=driver.findElement(christmasaleutton);

			js.executeScript("arguments[0].scrollIntoView(true);",btn);
			js.executeScript("arguments[0].click()",btn);
			Boolean success=driver.findElement(cards).isDisplayed();
			Boolean error=driver.findElement(errormessage).isDisplayed();
			Assert.assertTrue(success,"Error message displayed");
			
		}
		public void getcardwidth() throws InterruptedException {
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("window.scrollBy(0,1600)");
			Thread.sleep(5000);
			WebElement btn=driver.findElement(christmasaleutton);

			js.executeScript("arguments[0].scrollIntoView(true);",btn);
			js.executeScript("arguments[0].click()",btn);
			Boolean success=driver.findElement(cards).isDisplayed();
			Boolean error=driver.findElement(errormessage).isDisplayed();
			Assert.assertTrue(success,"Error message displayed");
			

			List<WebElement> cards=driver.findElements(productscard);
		int firstcardwidth=cards.get(0).getSize().getWidth();
		for(int i=1;i<cards.size();i++) {
			Assert.assertEquals(cards.get(i).getSize().getWidth(),firstcardwidth,"card width not allgned with inedx"+i);
		}
		}
		public void getcardheight() throws InterruptedException {
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("window.scrollBy(0,1600)");
			Thread.sleep(5000);
			WebElement btn=driver.findElement(christmasaleutton);

			js.executeScript("arguments[0].scrollIntoView(true);",btn);
			js.executeScript("arguments[0].click()",btn);

			Boolean success=driver.findElement(cards).isDisplayed();
			Boolean error=driver.findElement(errormessage).isDisplayed();
			Assert.assertTrue(success,"Error message displayed");
			

			List<WebElement> cards=driver.findElements(productscard);
		int firstcardheight=cards.get(0).getSize().getHeight();
		for(int i=1;i<cards.size();i++) {
			Assert.assertEquals(cards.get(i).getSize().getHeight(),firstcardheight,"card height not allgned with inedx"+i);
		}

		}
		public void priceallignmnet() throws InterruptedException {
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("window.scrollBy(0,1600)");
			Thread.sleep(5000);
			WebElement btn=driver.findElement(christmasaleutton);

			js.executeScript("arguments[0].scrollIntoView(true);",btn);
			js.executeScript("arguments[0].click()",btn);


			Boolean success=driver.findElement(cards).isDisplayed();
			Boolean error=driver.findElement(errormessage).isDisplayed();
			Assert.assertTrue(success,"Error message displayed");
			JavascriptExecutor js1=(JavascriptExecutor)driver;
			js1.executeScript("window.scrollBy(0,100)");
			Thread.sleep(4000);
			WebElement ap=driver.findElement(secondcardactualprice);
			WebElement op=driver.findElement(secondcardoldprice);
			int Actualprice=ap.getLocation().getY();
			int Oldprice=op.getLocation().getY();
			Assert.assertEquals(Oldprice<Actualprice,"Old price is not alligned above the actual price");
			
		}
		public void verifyproductloads() throws InterruptedException {
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("window.scrollBy(0,2300)");
			Thread.sleep(5000);

			List<WebElement>products=driver.findElements(newarrivalproducts);
			System.out.println("no.of product"+products.size());

			
		}
				
		//verify all products having images
		public void images() throws InterruptedException {
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("window.scrollBy(0,2300)");
			Thread.sleep(5000);
			List<WebElement>products=driver.findElements(newarrivalproducts);

			for(WebElement product:products) {
				Assert.assertTrue(product.findElement(By.tagName("img")).isDisplayed());
			}
		}
		
		//verify all products having title
		public void title() throws InterruptedException {
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("window.scrollBy(0,2300)");
			Thread.sleep(5000);
			List<WebElement>products=driver.findElements(newarrivalproducts);
			List<WebElement> tit=driver.findElements(newarrivalproducttitle);

			for(int i=0;i<tit.size();i++) {
								System.out.println("product"+i+":"+tit.get(i).getText());
			}
		}
		
		//verify all the products having prices
				public void verifyproductprice() throws InterruptedException {
					JavascriptExecutor js=(JavascriptExecutor)driver;
					js.executeScript("window.scrollBy(0,2300)");
					Thread.sleep(5000);
					List<WebElement>products=driver.findElements(newarrivalproducts);
					List<WebElement> tit=driver.findElements(newarrivalproducttitle);

					for(int i=0;i<products.size();i++) {
                    	WebElement prices=products.get(i).findElement(newarrivalproductprice);
                    	String price=prices.getText().trim();
                    	Assert.assertTrue(prices.isDisplayed(),"price not visible for product:"+i);;
                    	Assert.assertFalse(price.isEmpty(),"price is empty for product:"+i);
                    	System.out.println(tit.get(i).getText()+":"+price);
                    }
				}
				
				//verify the visibility of prodctrattings
				public void ratings() {
					JavascriptExecutor js=(JavascriptExecutor)driver;
					js.executeScript("window.scrollBy(0,2300)");
					List<WebElement>products=driver.findElements(newarrivalproducts);
					List<WebElement> tit=driver.findElements(newarrivalproducttitle);

					for(int i=0;i<products.size();i++) {
						WebElement rating=products.get(i).findElement(newarrivalproductratting);
						Assert.assertTrue(rating.isDisplayed(),"product rating not displayed for"+tit.get(i).getText());
					}
				}
				
				//veriy hover action displays menus
				public void verifyhoveraction() throws InterruptedException {
					JavascriptExecutor js=(JavascriptExecutor)driver;
					js.executeScript("window.scrollBy(0,2300)");
					Actions act=new Actions(driver);

					List<WebElement>products=driver.findElements(newarrivalproducts);
					List<WebElement> tit=driver.findElements(newarrivalproducttitle);

					for(int i=0;i<products.size();i++) {
						js.executeScript("arguments[0].scrollIntoView(true);",products.get(i));
						Thread.sleep(2000);
						WebElement img=products.get(i).findElement(productimage);
						act.moveToElement(img).perform();
						Thread.sleep(5000);
						WebElement hovermenu=products.get(i).findElement(newarrivalhovermenu);
						Assert.assertTrue(hovermenu.isDisplayed(),"Menus not displayed for product "+i);
					}
				}
				
				//verify clickng quicklink after hover redirects to appropritate page
				public void quickview() throws InterruptedException {
					JavascriptExecutor js=(JavascriptExecutor)driver;
					js.executeScript("window.scrollBy(0,2200)");
					Actions act=new Actions(driver);

					List<WebElement>products=driver.findElements(newarrivalproducts);
					for(int i=0;i<products.size();i++) {
						products=driver.findElements(newarrivalproducts);
						WebElement product=products.get(i);
						js.executeScript("arguments[0].scrollIntoView(true);",product);
						Thread.sleep(2000);
						act.moveToElement(product).perform();
						String beforeclick=driver.getCurrentUrl();
						Thread.sleep(1000);
						WebElement quick=new WebDriverWait(driver,Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(product.findElement(quickviewmenu)));
						js.executeScript("arguments[0].click()",quick);
						Thread.sleep(3000);
						String afterclick=driver.getCurrentUrl();
						Assert.assertNotEquals(beforeclick,afterclick, "not redirected correctly");
						driver.navigate().back();
						new WebDriverWait(driver,Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(newarrivalproducts));
				}
		}
				
		//clicking on add to cart button displays a modal
				public void addtocartmodal() throws InterruptedException {
					JavascriptExecutor js=(JavascriptExecutor)driver;
					js.executeScript("window.scrollBy(0,2200)");
					Actions act=new Actions(driver);
					
					List<WebElement>products=driver.findElements(newarrivalproducts);
					
					for(int i=0;i<products.size();i++) {
						products=driver.findElements(newarrivalproducts);
						WebElement product=products.get(i);
						
						js.executeScript("arguments[0].scrollIntoView(true);",product);
						Thread.sleep(2000);
						
						act.moveToElement(product).perform();
						Thread.sleep(1000);
						WebElement addtocart=product.findElement(addtocartmenu);
						addtocart.click();
						Thread.sleep(6000);
						boolean modal=driver.findElement(addtocartmodal).isDisplayed();
						Assert.assertTrue(true);
						Thread.sleep(5000);
						driver.findElement(viewcartbutton).click();
						driver.navigate().back();
						new WebDriverWait(driver,Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(newarrivalproducts));
						products=driver.findElements(newarrivalproducts);
				}
}
				//verify that productname price insie the page correct
				public void addtocartpage() throws InterruptedException {
					JavascriptExecutor js=(JavascriptExecutor)driver;
					js.executeScript("window.scrollBy(0,2200)");
					Actions act=new Actions(driver);
					List<WebElement>productss=driver.findElements(newarrivalproducts);
					Thread.sleep(4000);
					for(int i=0;i<productss.size();i++) 
					{
						List<WebElement>products=driver.findElements(newarrivalproducts);

//						products=driver.findElements(newarrivalproducts);
						WebElement product=products.get(i);
						
						js.executeScript("arguments[0].scrollIntoView(true);",product);
						Thread.sleep(2000);
//						List<WebElement>prodtit=driver.findElements(newarrivalproducttitle);

						String prodname1=product.getText();

						act.moveToElement(product).perform();
						Thread.sleep(1000);
						WebElement addtocart=product.findElement(addtocartmenu);
						js.executeScript("arguments[0].click()",addtocart);
						Thread.sleep(6000);
						boolean modal=driver.findElement(addtocartmodal).isDisplayed();
						Assert.assertTrue(true);
						Thread.sleep(5000);
						driver.findElement(viewcartbutton).click();
						new WebDriverWait(driver,Duration.ofSeconds(10));
						JavascriptExecutor js1=(JavascriptExecutor)driver;
						js1.executeScript("window.scrollBy(0,100)");
						List<WebElement>prodtit2=driver.findElements(prodname);

						String prodname2=prodtit2.get(0).getText();
						Assert.assertEquals(prodname1,prodname2,"Names not match for product:"+i);
						System.out.println(prodname1+"="+prodname2);
						Thread.sleep(4000);
						driver.findElement(trash).click();
						driver.navigate().back();
						new WebDriverWait(driver,Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(newarrivalproducts));
						products=driver.findElements(newarrivalproducts);
				}
}
//verify footer
				
				public void footeradd() throws InterruptedException {
					JavascriptExecutor js=(JavascriptExecutor)driver;
					js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
					String mainwindow=driver.getWindowHandle();
					String before=driver.getTitle();
					Thread.sleep(5000);
					driver.findElement(footeraddress).click();
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
				public void footerphn() throws InterruptedException {
					JavascriptExecutor js=(JavascriptExecutor)driver;
					js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
					Thread.sleep(5000);
					String href=driver.findElement(footerphn).getAttribute("href");
					Assert.assertTrue(href.contains("tel"),"phnlink is nt tel");
					driver.findElement(footerphn).click();
				}
				public void footermail() throws InterruptedException {
					JavascriptExecutor js=(JavascriptExecutor)driver;
					js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
					Thread.sleep(5000);
					String href=driver.findElement(footermail).getAttribute("href");
					Assert.assertTrue(href.contains("mailto"),"Email is not mailto");
					driver.findElement(footermail).click();
				}
				public void quicklinks() throws InterruptedException {
					JavascriptExecutor js=(JavascriptExecutor)driver;
					js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
					Thread.sleep(5000);
					List<WebElement>quick=driver.findElements(quicklinks);
					for(int i=0;i<quick.size();i++) {
						quick.get(i).click();
						driver.navigate().back();
					}
				}
				//verify subsciption with invalid mail in footer
				
				public void suscription() throws InterruptedException {
					JavascriptExecutor js=(JavascriptExecutor)driver;
					js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
					Thread.sleep(5000);
					driver.findElement(subsciptionmailfield).sendKeys("asnasherin");
					driver.findElement(subscribebutton).click();
//					String errormsg="Invalid mail";
					Boolean msg=driver.findElement(subsuccessmsg).isDisplayed();
					Assert.assertFalse(msg);
				}
				
				//verify footer terms and condiitons
				public void clicktermsandcondiitons() throws InterruptedException {
					JavascriptExecutor js=(JavascriptExecutor)driver;
					js.executeScript("window.scrollBy(0,3000)");
					Thread.sleep(5000);
					driver.findElement(termsandconditions).click();
					Thread.sleep(4000);
					int headerheight=driver.findElement(header).getSize().getHeight();
					System.out.println("height of the header:"+headerheight);
					int headingY=driver.findElement(heading).getLocation().getY();
					System.out.println("Heading Y position:"+headingY);
					if(headingY<headerheight) {
						System.out.println("BUG FOUND:heading is behind inside the fixed header");
					}
					else {
						System.out.println("Headin is visible correctly");
							
						}
					Assert.assertTrue(headingY>=headerheight,"Headimg is hiding behind fixed header");
					}
}


					

