import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ObjectClass{

	// Login Page Locators:-
	static By sign_in_hover = By.xpath("//*[@id='nav-link-yourAccount']");
	static By sign_in_btn = By.xpath("(//span[@class='nav-action-inner' and text()='Sign in'])[1]");
	static By enter_email_or_phone_field = By.xpath("//input[@type='email']");
	static By continue_btn = By.xpath("//input[@id='continue']");
	
	
	static String expectedPageTitle = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "E:/Project/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		System.out.println("Amazon URL is open successfully.");
		
		
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
		/*
		WebElement ele1 = driver.findElement(By.xpath("//*[@id='nav-your-amazon']//following::a"));
		List<WebElement> eles = driver.findElements(By.xpath("//*[@id='nav-your-amazon']//following::a"));
		for (int i = 0; i < 4; i++) {
			System.out.println(eles.get(i).getText());
			
		}
		
		System.out.println("Ele1 is: "+ele1.getText());
		
		System.out.println("Size is : - " +eles.size());
		
		System.out.println("1st ele is : "+ eles.get(0).getText());
		*/
		
		
		
		//driver.close();

		
		
		String actualTitle = driver.getTitle();
		// System.out.println(actualTitle);

		if (expectedPageTitle.equals(actualTitle)) {
			System.out.println("Test Case Passed");
		} else {
			System.out.println("Test Case Failed");
		}

		WebElement element = driver.findElement(sign_in_hover);
		WebElement sign_in_ele = driver.findElement(sign_in_btn);
		
		Actions action = new Actions(driver);
		action.moveToElement(element).click(sign_in_ele).build().perform();
		
		driver.findElement(enter_email_or_phone_field).sendKeys("value");
		driver.findElement(continue_btn).click(); 
		
		// Check the error
		
		
		
	}

}
