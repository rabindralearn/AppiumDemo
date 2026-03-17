package rbsOrg.pageObjects.android;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import rbsOrg.utils.AndroidCommonActions;

public class ProductsPage extends AndroidCommonActions {

	AndroidDriver driver;

	public ProductsPage(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);

	}

	@AndroidFindBy(id = "com.androidsample.generalstore:id/appbar_btn_cart")
	private WebElement carticon;

	@AndroidFindBy(id = "com.androidsample.generalstore:id/productAddCart")
	private List<WebElement> addtocart;

	// Scroll to the element to choose and then click Add To cart
	public void AddToCart(String productname) {
		scrollTotext(productname);
		int productCount = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
		for (int i = 0; i < productCount; i++) {
			String nameofProduct = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i)
					.getText();
			if (nameofProduct.equalsIgnoreCase(productname)) {
				addtocart.get(i).click();
			}
		}

	}

	// Click Cart icon from the top of product page
	public CartPage clickCart() {
		carticon.click();
		return new CartPage(driver);
	}

}
