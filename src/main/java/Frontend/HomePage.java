package Frontend;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
	By userdropdowntoggle=By.xpath("//*[@id=\"userDropdown\"]");
	By email=By.xpath("/html/body/div[2]/header/div[1]/div/div/div/div[1]/a");
	By phnum=By.xpath("/html/body/div[2]/header/div[1]/div/div/div/div[2]/a");
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

}
