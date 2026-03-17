package rbsOrg.pageObjects.android;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import rbsOrg.utils.AndroidCommonActions;

public class CartPage extends AndroidCommonActions {

	AndroidDriver driver;

	public CartPage(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);

	}

	@AndroidFindBy(id = "com.androidsample.generalstore:id/productPrice")
	private WebElement productName;

	@AndroidFindBy(id = "com.androidsample.generalstore:id/totalAmountLbl")
	private WebElement totalpurchaseAmount;

	@AndroidFindBy(id = "com.androidsample.generalstore:id/termsButton")
	private WebElement termsAndCondition;

	@AndroidFindBy(id = "com.androidsample.generalstore:id/toolbar_title")
	private WebElement toolbarTitle;

	@AndroidFindBy(id = "android:id/button1")
	private WebElement close;

	// Getting Product price from Cart Page
	public String getProductPrice() throws InterruptedException {
		Thread.sleep(1000);
		return productName.getText();

	}

	// Getting price from totalpurchase amount from cartpage
	public String gettotalpurchaseAmount() {
		return totalpurchaseAmount.getText();

	}

	public WebElement waitForToolBarCart() {
		return toolbarTitle;
	}

	// Long click on Please read our terms of condition
	public void clickTermsAndCondition() {
		longPressGesture(termsAndCondition);

	}

	// Click Close button
	public void clickClose() {
		close.click();
	}

}
