package rbsOrg.TestCase;


import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;
import rbsOrg.TestComponent.BaseTest;
import rbsOrg.pageObjects.android.CartPage;
import rbsOrg.pageObjects.android.EntryPage;
import rbsOrg.pageObjects.android.ProductsPage;

public class ValidatePurchaseProduct extends BaseTest {
	

	@Test(dataProvider="getData")
	public void purchaseProduct(HashMap<String,String> inputdata) throws InterruptedException {

		// EntryPage
		EntryPage entrypage = new EntryPage(driver);
		
		// Entering name
		entrypage.enterName(inputdata.get("user"));
		
		// Selecting round button for male or female
		entrypage.chooseGender(inputdata.get("gender"));
		Thread.sleep(2000);
		
		// SelectingCountry
		entrypage.selectCountry(inputdata.get("country"));
		// entrypage.clickLetsShop();

		// ProductPage		
		ProductsPage productpage = entrypage.clickLetsShop();
		
		//Supply brandname
		productpage.AddToCart(inputdata.get("nameOfShoe"));

		// Cart Page
		CartPage cartpage = productpage.clickCart();

		// Explicit wait for cart page to load			
		explicitWait(cartpage.waitForToolBarCart(),inputdata.get("cartPage"),driver);		
		
		
		//Saving price of product to string for assertion
		String getproductprice = cartpage.getProductPrice();
		getproductprice=getproductprice.replaceAll("\\s", "");		
		
		//Saving totalpurchaseamount  of product to string for assertion
		String totalpurchaseamount = cartpage.gettotalpurchaseAmount();
		totalpurchaseamount=totalpurchaseamount.replaceAll("\\s", "");
	
		//Putting assertion on the displayed price of product are same
		 Assert.assertEquals(getproductprice, totalpurchaseamount);

		cartpage.clickTermsAndCondition();

		
		cartpage.clickClose();

	}
	

}// end of class
