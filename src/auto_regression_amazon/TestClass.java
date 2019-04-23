package auto_regression_amazon;

import auto_page_amazon.LoginAmazonPage;
import auto_page_amazon.WrapperClass;

public class TestClass extends WrapperClass {
	
public static void main(String[] args) {
	
		getLoginAmazonPage()
			.openChromeBrowser()
			.clickContinueButton(continue_btn);
			
	
		//This is to add product in Cart : 
		openChromeBrowser();
		loadURL("https://www.amazon.in");
		//loginToAmazon();
		mouseHover(sign_in_hover);
		enterUserName(enter_email_or_phone_field, user_name);
		clickContinueButton(continue_btn);
		enterPassword(enter_password, pass);
		click(login_btn);
		addProduct("Apple iPhone X (64GB) - Silver");
		addToCart();
		
		//This is to remove product from Cart :
		click(cartIcon);
		verifyProduct("Apple iPhone X (64GB) - Silver");
		clickDeletelink();
		verifyNoProduct("Your Shopping Cart is empty.");
		closeChrome();

	}

}
