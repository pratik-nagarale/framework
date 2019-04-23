package auto_page_amazon;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import auto_core_amazon.Selenium;

public class LoginAmazonPage extends Selenium {

	public static By sign_in_hover = By.id("nav-link-yourAccount");
	//static By sign_in_btn = By.xpath("(//span[contains(text(),'Sign in')]");
	public static By enter_email_or_phone_field = By.xpath("//input[@type='email']");
	public static By continue_btn = By.xpath("//input[@id='continue']");
	public static By enter_password = By.xpath("//input[@id='ap_password']");
	public static By login_btn = By.xpath("//input[@id='signInSubmit']");
	public static By verify_login_messgae = By.xpath("(//span[@class='nav-line-1'])[3]");
	public static By category_hover = By.xpath("//span[text()='Category']");
	public static By nav_mobiles_computers = By.xpath("//*[text()='Mobiles, Computers']");
	public static By all_mobile = By.xpath("//*[text()='All Mobile Phones']");
	public static By search_box = By.xpath("//input[@id='twotabsearchtextbox']");
	public static By search_btn = By.xpath("//input[@type='submit']");
	//static By click_product = By.xpath("//*[@title='Apple iPhone X (256GB) - Space Grey']");
	public static By add_to_cart_btn = By.xpath("//input[@id='add-to-cart-button']");
	public static By proceed_to_buy = By.xpath("//a[@id='hlb-ptc-btn-native']");
	//static By selectIphoneX = By.xpath("//a[contains(text(),'iPhone X')]");
	public static By clickSeeMoreLink = By.xpath("//span[contains(text(),'See more')]");
	public static By selectACategoryPhone =By.linkText("A");
	public static By selectApplePhones = By.xpath("//a[contains(@title,'Apple')]");
	public static By enterLowPrice = By.xpath("//input[contains(@id,'low-price')]");
	public static By enterHighPrice = By.xpath("//input[contains(@id,'high-price')]");
	public static By goButton = By.xpath("//input[@aria-labelledby='a-autoid-1-announce']");
	
	//Locators for Remove item from Cart
	public static By cartIcon = By.xpath("//a[@id='nav-cart']");
	public static By verifyProduct = By.xpath("//span[@class='a-size-medium sc-product-title a-text-bold']");
	public static By deleteLink= By.xpath("//input[@value='Delete']");
	public static By verifyEmptyCart= By.xpath("//div[@class='a-row sc-cart-header']");
	
	
	public static String pass = "Pp123$$$";
	public static String user_name = "pratiknagrale11@gmail.com";

	public LoginAmazonPage openChromeBrowser() {
		openChromme();
		maximizeWindow();
		return this;
	}

	public static void loginToAmazon() {
		//WebElement element = driver.findElement(sign_in_hover);
		//WebElement signinBtn = driver.findElement(sign_in_btn);
		//Actions action = new Actions(driver);
		//action.moveToElement(element).click(signinBtn).build().perform();
		//WebElement emailAddress = driver.findElement(enter_email_or_phone_field);
		//emailAddress.sendKeys(user_name);
		//click(continue_btn);
		//WebElement password = driver.findElement(enter_password);
		//password.sendKeys(pass);
		//WebElement loginBtn = driver.findElement(login_btn);
		//loginBtn.click();
	}
	public static void enterUserName(By locator,String enterText){
		Selenium.enterText(locator, enterText);
	}
	
	public static void enterPassword(By locator,String enterText){
		Selenium.enterText(locator, enterText);
	}
	
	public static void addProduct(String product) {
		
		
		WebElement move_category = driver.findElement(category_hover);
		
		WebElement select_mobiles_computer = driver.findElement(nav_mobiles_computers);
		
		Actions action = new Actions(driver);
		
		action.moveToElement(move_category).click(select_mobiles_computer).build().perform();
		driver.findElement(all_mobile).click();
		
		driver.findElement(clickSeeMoreLink).click();
	
		driver.findElement(selectACategoryPhone).click();
		driver.findElement(selectApplePhones).click();
		driver.findElement(enterLowPrice).sendKeys("20000");
		driver.findElement(enterHighPrice).sendKeys("100000");
		driver.findElement(goButton).click();
		//driver.findElement(search_box).click();
		//driver.findElement(search_box).sendKeys(product);
		//driver.findElement(search_btn).click();
		driver.findElement(By.partialLinkText(product)).click();
	}

	public static void addToCart() {
		String MainWindow = driver.getWindowHandle();
		Set<String> s1 = driver.getWindowHandles();
		Iterator<String> i1 = s1.iterator();

		while (i1.hasNext()) {
			String ChildWindow = i1.next();
			if (!MainWindow.equalsIgnoreCase(ChildWindow)) {
				// Switching to Child window
				driver.switchTo().window(ChildWindow);
				driver.findElement(add_to_cart_btn).click();
				driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				driver.findElement(proceed_to_buy).click();

				// Closing the Child Window.
				driver.close();
			}
		}
		driver.switchTo().window(MainWindow);
	}

	public static void searchProduct(String product) {
		driver.findElement(search_box).sendKeys(product);
		driver.findElement(search_btn).click();
	}

	public static void selectProduct(String product) {
		driver.findElement(By.linkText(product)).click();
	}
	
	public static void clickContinueButton(By continue_btn){
	Selenium.click(continue_btn);
	}
	
	public static void verifyProduct(String s1){
		String textValue = driver.findElement(verifyProduct).getText();
		
		if (s1.equals(textValue)){
			System.out.println("Product is same");
		}else{
			System.out.println("Product is not same ");
		}
	}
	
	public static void clickDeletelink(){
		driver.findElement(deleteLink).click();
		}
	public static void verifyNoProduct(String s1){
		String textValue = driver.findElement(verifyEmptyCart).getText();
		System.out.println(s1);
		System.out.println(textValue);
		if (s1.equals(textValue)){
			
			System.out.println("No Item in Cart");
		}else{
			System.out.println("Item in Cart");
		}
	}
}
