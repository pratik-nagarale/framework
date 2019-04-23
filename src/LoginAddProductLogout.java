import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class LoginAddProductLogout {

	private static By sign_in_hover = By.xpath("//*[@id='nav-link-yourAccount']");
	static By sign_in_btn = By.xpath("(//span[@class='nav-action-inner' and text()='Sign in'])[1]");
	static By enter_email_or_phone_field = By.xpath("//input[@type='email']");
	static By continue_btn = By.xpath("//input[@id='continue']");
	static By enter_password = By.xpath("//input[@id='ap_password']");
	static By login_btn = By.xpath("//input[@id='signInSubmit']");
	static By verify_login_messgae= By.xpath("(//span[@class='nav-line-1'])[3]");
	static By category_hover = By.xpath("//span[text()='Category']");
	static By nav_mobiles_computers = By.xpath("//*[text()='Mobiles, Computers']");
	static By all_mobile = By.xpath("//*[text()='All Mobile Phones']");
	static By search_box = By.xpath("//input[@id='twotabsearchtextbox']");
	static By search_btn = By.xpath("//input[@type='submit']");
	static By click_product = By.xpath("//*[@title='Apple iPhone X (256GB) - Space Grey']");
	static By add_to_cart_btn = By.xpath("//input[@id='add-to-cart-button']");
	static By proceed_to_buy = By.xpath("//a[@id='hlb-ptc-btn-native']");
	
	static String pass = "Pp123$$$";
	static String user_name = "pratiknagrale11@gmail.com";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","E:/Project/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		WebElement element = driver.findElement(sign_in_hover);
		
		WebElement signinBtn = driver.findElement(sign_in_btn);
		Actions action = new Actions(driver);
		action.moveToElement(element).click(signinBtn).build().perform();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		WebElement emailAddress = driver.findElement(enter_email_or_phone_field);
		emailAddress.sendKeys(user_name);
		WebElement continueBtn = driver.findElement(continue_btn);
		continueBtn.click();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		WebElement password = driver.findElement(enter_password);
		password.sendKeys(pass);
		WebElement loginBtn = driver.findElement(login_btn);
		loginBtn.click();
		
		WebElement move_category = driver.findElement(category_hover);
		WebElement select_mobiles_computer = driver.findElement(nav_mobiles_computers);
		action.moveToElement(move_category).click(select_mobiles_computer).build().perform();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.findElement(all_mobile).click();
		driver.findElement(search_box).click();
		driver.findElement(search_box).sendKeys("Apple iPhone X (256GB) - Space Grey");
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.findElement(search_btn).click();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.findElement(click_product).click();
		//code copy
		String MainWindow=driver.getWindowHandle();	
		Set<String> s1=driver.getWindowHandles();		
        Iterator<String> i1=s1.iterator();		
        		
        while(i1.hasNext())			
        {		
            String ChildWindow=i1.next();			
            if(!MainWindow.equalsIgnoreCase(ChildWindow))			
            {    		
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
		
		
		//driver.close();
		
	}

}
