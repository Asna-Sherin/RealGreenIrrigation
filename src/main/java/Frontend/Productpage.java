package Frontend;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class Productpage {
	WebDriver driver;
	public Productpage(WebDriver driver) {
		this.driver=driver;
	}
	
	By modal=By.xpath("//*[@id=\"categoryModal\"]/div");
	By xbutton=By.xpath("//*[@id=\"categoryModal\"]/div/div/div[1]/button");
	By cards=By.cssSelector(".col-xl-3.col-sm-6.col-12.mb-3");
	By categoryName=By.cssSelector("h6 a");
	By productLinks=By.cssSelector("ul li a");
	By noProductsMsg=By.cssSelector("p.text-muted");
	By agriculturemulchsheet=By.xpath("//*[@id=\"categoryModal\"]/div/div/div[2]/div/div[1]/div/h6/a");
	By productmenu=By.xpath("//*[@id=\"productsMenu\"]");
	By productsinmodal=By.cssSelector("ul.list-unstyled.mb-2 li");
	By productinsidecat=By.cssSelector(".col-xl-4.col-sm-6.col-6");
	By wishlisticon=By.xpath("/html/body/div[2]/div[6]/div/div/div[1]/div[2]/div/div/div/div[1]/div/div[1]/div[2]/ul/li[3]/a");
	By viewwishlistbutton=By.linkText("View Wishlist");
	By wishlistsuccessmessage=By.xpath("//*[@id=\"wishlist-product-name\"]");
	By prodtitle=By.cssSelector(".product-title");
	By leftarrow=By.xpath("/html/body/div[2]/div[6]/div/button[1]");
	By rightarrow=By.xpath("/html/body/div[2]/div[6]/div/button[2]");
	public void modalopen() {
		Assert.assertTrue(driver.findElement(modal).isDisplayed());
	}
	
	public void cardcount() {
		int count=driver.findElements(cards).size();
		System.out.println("no.of cards:"+count);
	}
	public void clickXbutton() {
		driver.findElement(xbutton).click();
	}
	
	
	public List<WebElement> getCategoryCards() {
        return driver.findElements(cards);
    }

    public WebElement getCategoryName(WebElement card) {
        return card.findElement(By.cssSelector("h6.fw-bold.mb-2 a"));
    }

    public boolean categoryHasNoProducts(WebElement card) {
        return card.findElements(noProductsMsg).size() > 0;
    }

    public List<WebElement> getProducts(WebElement card) {
        return card.findElements(productLinks);
    }
    public void verifyAllCategories() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));

        // Wait for modal to appear
        wait.until(ExpectedConditions.visibilityOfElementLocated(modal));

        // Get number of category cards
        int totalCards = driver.findElements(cards).size();
        System.out.println("Total categories: " + totalCards);

        // Loop through each card by index
        for (int i = 0; i < totalCards; i++) {

            // RE-FIND cards each iteration to avoid stale element
            List<WebElement> freshCards = driver.findElements(cards);
            WebElement card = freshCards.get(i);

            // Get category name
            String catName = card.findElement(categoryName).getText().trim();
            System.out.println("\n---- Category: " + catName + " ----");

            // Check if 'no products' message exists
            List<WebElement> noProd = card.findElements(noProductsMsg);

            if (noProd.size() > 0) {
                System.out.println("No products available.");
                continue; // go to next category
            }

            // Get all products
            List<WebElement> products = card.findElements(productLinks);
            System.out.println("Products count: " + products.size());

            // Iterate through products
            for (int j = 0; j < products.size(); j++) {

                // RE-FIND card + product list again (modal refresh safe)
                freshCards = driver.findElements(cards);
                card = freshCards.get(i);

                products = card.findElements(productLinks);
                WebElement prod = products.get(j);

                String prodName = prod.getText().trim();
                System.out.println("Clicking product: " + prodName);

                // Click product
                prod.click();

                // Wait for product details page to load
                Thread.sleep(2000);

                // Navigate back
                driver.navigate().back();

                // Wait for modal again
                wait.until(ExpectedConditions.visibilityOfElementLocated(modal));
            }
        }
    }
    
    
    
    
    //agricultural mulch sheet
    public void testclickmulcsheet() throws InterruptedException {
    	List<WebElement>card=driver.findElements(cards);
    	List<WebElement>cardname=driver.findElements(categoryName);
    	System.out.println("no.of categories:"+card.size());
    	for(int i=0;i<card.size();i++) {
    		List<WebElement>freshcard=driver.findElements(cards);
        	List<WebElement>freshcardname=driver.findElements(categoryName);

    	
    	WebElement firstcard=freshcard.get(i);
    	WebElement name=freshcardname.get(i);
    	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
    	wait.until(ExpectedConditions.elementToBeClickable(name));
    	System.out.println("clicking category:"+name.getText());
    	name.click();
    	Thread.sleep(5000);
    	driver.navigate().back();
    	Thread.sleep(4000);
    	driver.findElement(productmenu).click();

Thread.sleep(4000);    	
    	}
    }
    
    //verify the prodcts cout fro the modal
    public void productcount() throws InterruptedException {
    	List<WebElement>card=driver.findElements(cards);
    	List<WebElement>cardname=driver.findElements(categoryName);
    	List<WebElement>count=driver.findElements(productsinmodal);
    	System.out.println("no.of categories:"+card.size());
    	for(int i=0;i<card.size();i++) {
    		List<WebElement>freshcard=driver.findElements(cards);
        	List<WebElement>freshcardname=driver.findElements(categoryName);
    	WebElement firstcard=freshcard.get(i);
    	WebElement name=freshcardname.get(i);
    	List<WebElement>freshcount=firstcard.findElements(productsinmodal);

    	System.out.println("no.of products in category "+i+"="+freshcount.size());
    	}
    
    }
    //verify the product count inside each category
    public void prodcount() throws InterruptedException {
    	List<WebElement>card=driver.findElements(cards);
    	List<WebElement>cardname=driver.findElements(categoryName);
    	System.out.println("no.of categories:"+card.size());
    	for(int i=0;i<card.size();i++) {
    		List<WebElement>freshcard=driver.findElements(cards);
        	List<WebElement>freshcardname=driver.findElements(categoryName);
        	WebElement firstcard=freshcard.get(i);
        	WebElement name=freshcardname.get(i);
        	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
        	wait.until(ExpectedConditions.elementToBeClickable(name));
        	System.out.println("clicking category:"+name.getText());
        	name.click();
        	Thread.sleep(5000);
        	int count=driver.findElements(productinsidecat).size();

        	System.out.println("no.of products inside category "+i+":"+count);
        	Thread.sleep(5000);
        	driver.navigate().back();
        	Thread.sleep(4000);
        	driver.findElement(productmenu).click();

    Thread.sleep(4000);    	

}
}
    
    
    public void checkcount() throws InterruptedException {
    	List<WebElement>card=driver.findElements(cards);
    	List<WebElement>cardname=driver.findElements(categoryName);
    	List<WebElement>count=driver.findElements(productsinmodal);
    	System.out.println("no.of categories:"+card.size());
		SoftAssert soft=new SoftAssert();

    	for(int i=0;i<card.size();i++) {
    		List<WebElement>freshcard=driver.findElements(cards);
        	List<WebElement>freshcardname=driver.findElements(categoryName);
    	WebElement firstcard=freshcard.get(i);
    	WebElement name=freshcardname.get(i);
    	List<WebElement>freshcount=firstcard.findElements(productsinmodal);

    	System.out.println("no.of products in category "+i+"="+freshcount.size());
    	
    	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
    	wait.until(ExpectedConditions.elementToBeClickable(name));
    	System.out.println("clicking category:"+name.getText());
    	name.click();
    	Thread.sleep(5000);
    	int count1=driver.findElements(productinsidecat).size();

    	System.out.println("no.of products inside category "+i+":"+count1);
    	soft.assertEquals(freshcount.size(),count1,"Products count not match for category:"+i);
    	Thread.sleep(5000);
    	driver.navigate().back();
    	Thread.sleep(4000);
    	driver.findElement(productmenu).click();
    	}
    	soft.assertAll();


    }
    
    //verify clicking on the heart icon when hovering over the product adds the products to wishlist
    
    public void wishlist() throws InterruptedException {
    	
    	SoftAssert soft=new SoftAssert();
		JavascriptExecutor js=(JavascriptExecutor)driver;
    	Actions act=new Actions(driver);
    	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));

    	List<WebElement>card=driver.findElements(cards);
    	List<WebElement>catname=driver.findElements(categoryName);
		int count=driver.findElements(cards).size();

    	for(int i=0;i<count;i++) {
    		List<WebElement>freshcard=driver.findElements(cards);
        	List<WebElement>freshcatname=driver.findElements(categoryName);
    	WebElement firstcard=freshcard.get(i);
    	WebElement firstcatname=freshcatname.get(i);
    	wait.until(ExpectedConditions.elementToBeClickable(firstcatname));
    	System.out.println("clicking category:"+firstcatname.getText());
    	js.executeScript("arguments[0].click();",firstcatname);
    	wait.until(ExpectedConditions.visibilityOf(driver.findElement(productinsidecat)));
    	Thread.sleep(3000);
    	List<WebElement>prods=driver.findElements(productinsidecat);

    	System.out.println("Category"+(i+1)+"has"+prods.size()+" products");
    	int prodcount=driver.findElements(productinsidecat).size();
    	for(int j=0;j<prodcount;j++) {
    		//reintialize
    		prods=driver.findElements(productinsidecat);
    		WebElement prod=prods.get(j);
    		act.moveToElement(prod).perform();
    		Thread.sleep(5000);
    		WebElement wish=driver.findElement(wishlisticon);
        	js.executeScript("arguments[0].click();",wish);
    		System.out.println(driver.findElement(wishlistsuccessmessage).getText());
    		Thread.sleep(3000);
    		WebElement btn=driver.findElement(viewwishlistbutton);
    		act.moveToElement(btn).perform();
    		Thread.sleep(3000);
//    		wait.until(ExpectedConditions.elementToBeClickable(btn));
    		js.executeScript("arguments[0].click();",btn);
    		Thread.sleep(5000);
    		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("wishlist-items")));
    		boolean productExists = driver.findElements(
    		        By.xpath("//div[@id='wishlist-items']//div[contains(@class, 'col-md-12')]")
    		).size() > 0;    	
    		if(productExists) {
    			System.out.println("products added to the wishlist");

    		}else {
    			soft.fail("product not added to the wishlist");

    		}
    		driver.navigate().back();
//    		wait.until(ExpectedConditions.visibilityOfElementLocated(productinsidecat));
    		Thread.sleep(4000);

    	}
    	driver.navigate().back();
    	driver.findElement(By.xpath("//*[@id=\"productsMenu\"]")).click();
//    	wait.until(ExpectedConditions.visibilityOfElementLocated(cards));
    	}
		soft.assertAll();

}
    
    
    //verify carousel inside each product category
    
    public void carousel() throws InterruptedException {
    	SoftAssert soft=new SoftAssert();
		JavascriptExecutor js=(JavascriptExecutor)driver;
    	Actions act=new Actions(driver);
    	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));

    	List<WebElement>card=driver.findElements(cards);
    	List<WebElement>catname=driver.findElements(categoryName);
		int count=driver.findElements(cards).size();

    	for(int i=0;i<count;i++) {
    		List<WebElement>freshcard=driver.findElements(cards);
        	List<WebElement>freshcatname=driver.findElements(categoryName);
    	WebElement firstcard=freshcard.get(i);
    	WebElement firstcatname=freshcatname.get(i);
    	wait.until(ExpectedConditions.elementToBeClickable(firstcatname));
    	System.out.println("clicking category:"+firstcatname.getText());
    	js.executeScript("arguments[0].click();",firstcatname);
    	wait.until(ExpectedConditions.visibilityOf(driver.findElement(productinsidecat)));
    	Thread.sleep(3000);
    	List<WebElement>prods=driver.findElements(productinsidecat);

    	int prodcount=driver.findElements(productinsidecat).size();
    	for(int j=0;j<prodcount;j++) {
    		//reintialize
    		prods=driver.findElements(productinsidecat);
    		WebElement prod=prods.get(j);
    		act.moveToElement(prod).perform();
    		Thread.sleep(5000);
    		WebElement title=driver.findElement(prodtitle);
    		title.click();
    		JavascriptExecutor js1 = (JavascriptExecutor) driver;

    		js.executeScript("window.scrollBy(0,300)");
    		WebElement list = driver.findElement(By.id("relatedProductsList"));

    		// scroll value before click
    		int before = ((Number) js.executeScript("return arguments[0].scrollLeft;", list)).intValue();

    		// click left arrow
    		Thread.sleep(3000);
    		driver.findElement(leftarrow).click();
    		Thread.sleep(500);

    		// scroll value after click
    		int after = ((Number) js.executeScript("return arguments[0].scrollLeft;", list)).intValue();

    		// check movement
    		if (before != after) {
    		    System.out.println("Left arrow works");
    		} else {
    		    System.out.println("Left arrow NOT working");
    		}
        	driver.navigate().back();
        	Thread.sleep(3000);
    }
    	driver.navigate().back();
    	driver.findElement(By.xpath("//*[@id=\"productsMenu\"]")).click();

}    	
    soft.assertAll();
    }
    public void rightarrow() throws InterruptedException {
    	SoftAssert soft=new SoftAssert();
		JavascriptExecutor js=(JavascriptExecutor)driver;
    	Actions act=new Actions(driver);
    	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));

    	List<WebElement>card=driver.findElements(cards);
    	List<WebElement>catname=driver.findElements(categoryName);
		int count=driver.findElements(cards).size();

    	for(int i=0;i<count;i++) {
    		List<WebElement>freshcard=driver.findElements(cards);
        	List<WebElement>freshcatname=driver.findElements(categoryName);
    	WebElement firstcard=freshcard.get(i);
    	WebElement firstcatname=freshcatname.get(i);
    	wait.until(ExpectedConditions.elementToBeClickable(firstcatname));
    	System.out.println("clicking category:"+firstcatname.getText());
    	js.executeScript("arguments[0].click();",firstcatname);
    	wait.until(ExpectedConditions.visibilityOf(driver.findElement(productinsidecat)));
    	Thread.sleep(3000);
    	List<WebElement>prods=driver.findElements(productinsidecat);

    	int prodcount=driver.findElements(productinsidecat).size();
    	for(int j=0;j<prodcount;j++) {
    		//reintialize
    		prods=driver.findElements(productinsidecat);
    		WebElement prod=prods.get(j);
    		act.moveToElement(prod).perform();
    		Thread.sleep(5000);
    		WebElement title=driver.findElement(prodtitle);
    		title.click();
    		JavascriptExecutor js1 = (JavascriptExecutor) driver;

    		js.executeScript("window.scrollBy(0,300)");
    		WebElement list = driver.findElement(By.id("relatedProductsList"));

    		// scroll value before click
    		int before = ((Number) js.executeScript("return arguments[0].scrollLeft;", list)).intValue();

    		// click left arrow
    		Thread.sleep(3000);
    		driver.findElement(rightarrow).click();
    		Thread.sleep(500);

    		// scroll value after click
    		int after = ((Number) js.executeScript("return arguments[0].scrollLeft;", list)).intValue();

    		// check movement
    		if (before != after) {
    		    System.out.println("Right arrow works");
    		} else {
    		    System.out.println("Right arrow NOT working");
    		}
        	driver.navigate().back();
        	Thread.sleep(3000);
    }
    	driver.navigate().back();
    	driver.findElement(By.xpath("//*[@id=\"productsMenu\"]")).click();

}    	
    soft.assertAll();

    }
    
    
    
    //verify the images
    
    
    public void image() throws InterruptedException {
    	SoftAssert soft=new SoftAssert();
		JavascriptExecutor js=(JavascriptExecutor)driver;
    	Actions act=new Actions(driver);
    	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));

    	List<WebElement>card=driver.findElements(cards);
    	List<WebElement>catname=driver.findElements(categoryName);
		int count=driver.findElements(cards).size();

    	for(int i=0;i<count;i++) {
    		List<WebElement>freshcard=driver.findElements(cards);
        	List<WebElement>freshcatname=driver.findElements(categoryName);
    	WebElement firstcard=freshcard.get(i);
    	WebElement firstcatname=freshcatname.get(i);
    	wait.until(ExpectedConditions.elementToBeClickable(firstcatname));
    	System.out.println("clicking category:"+firstcatname.getText());
    	js.executeScript("arguments[0].click();",firstcatname);
    	wait.until(ExpectedConditions.visibilityOf(driver.findElement(productinsidecat)));
    	Thread.sleep(3000);
    	List<WebElement>prods=driver.findElements(productinsidecat);

    	int prodcount=driver.findElements(productinsidecat).size();
    	for(int j=0;j<prodcount;j++) {
    		//reintialize
    		prods=driver.findElements(productinsidecat);
    		WebElement prod=prods.get(j);
    		act.moveToElement(prod).perform();
    		Thread.sleep(5000);
    		WebElement title=driver.findElement(prodtitle);
    		title.click();
    		JavascriptExecutor js1 = (JavascriptExecutor) driver;

    		js.executeScript("window.scrollBy(0,300)");
    		List<WebElement> products = driver.findElements(By.cssSelector(".related-product-item"));

    		for (WebElement product : products) {
    		    WebElement img = product.findElement(By.tagName("img"));
    		    String productName = product.findElement(By.tagName("h4")).getText();
    		    String src = img.getAttribute("src").toLowerCase();

    		    Boolean isValidImage = (Boolean) js.executeScript(
    		        "return arguments[0].complete && " +
    		        "typeof arguments[0].naturalWidth != 'undefined' && " +
    		        "arguments[0].naturalWidth > 50 && arguments[0].naturalHeight > 50;",
    		        img
    		    );

    		    // Check if it is a placeholder image based on URL
    		    Boolean isPlaceholder =
    		            src.contains("first_image") ||
    		            src.contains("default") ||
    		            src.contains("placeholder") ||
    		            src.contains("noimage");

    		    if (!isValidImage || isPlaceholder) {
    		        System.out.println("❌ Incorrect image detected for: " + productName + " | src = " + src);
    		    } else {
    		        System.out.println("✅ Proper image found for: " + productName);
    		    }
    		
    		   
    		}
    		 driver.navigate().back();
         	Thread.sleep(3000);
    	}
    		driver.navigate().back();
        	driver.findElement(By.xpath("//*[@id=\"productsMenu\"]")).click();
    }
    	soft.assertAll();
}
    }
