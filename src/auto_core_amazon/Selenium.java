package auto_core_amazon;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Selenium {
	
	public static WebDriver driver;
	
	public <T> T get(Class<T> pageClass, Class<? extends WebDriver> class1){
		return (T) get(pageClass, Selenium.driver.getClass());
	}
	//why here selenium is coming
	public <T> T verify_page_title()throw Error{
		verify(ExpectedConditions.titleIs(getTitle()));
	}
	public static void click(By locator){
		driver.findElement(locator).click();
	}
		
	public static void maximizeWindow(){
		driver.manage().window().maximize();
	}
	
	//*********   Doubt Load URL in base URL added parameter in Selenium and Method also. Is it necessary
	public static void loadURL(String baseURL){
		driver.get(baseURL);
	}
	
	public static void mouseHover(By locator){
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(locator)).click().build().perform();
	}
	
	
	public static void openChromme(){
		System.setProperty("webdriver.chrome.driver", "E:/Project/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	}
	
	public static void closeChrome(){
		driver.quit();
		driver = null;
	}

	public static void enterText(By locator, String enterText){
		driver.findElement(locator).sendKeys(enterText);
	}
	
	public static void verifyByText(By locator, String s1){
		String textValue = driver.findElement(locator).getText();
		if (s1.compareTo(textValue)==1){
			System.out.println("String are same");
		}else{
			System.out.println("String are not same ");
		}
	}
}
