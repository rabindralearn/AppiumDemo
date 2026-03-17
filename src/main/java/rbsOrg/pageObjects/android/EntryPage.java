package rbsOrg.pageObjects.android;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import rbsOrg.utils.AndroidCommonActions;

public class EntryPage extends AndroidCommonActions {

	AndroidDriver driver;

	public EntryPage(AndroidDriver driver) {
		super(driver);
		this.driver = driver;

		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(id = "com.androidsample.generalstore:id/nameField")
	private WebElement enterName;

	@AndroidFindBy(id = "com.androidsample.generalstore:id/radioFemale")
	private WebElement rdbtnFemale;

	@AndroidFindBy(id = "com.androidsample.generalstore:id/radioMale")
	private WebElement rdbtnMale;

	@AndroidFindBy(id = "android:id/text1")
	private WebElement dropdownCountry;

	@AndroidFindBy(id = "com.androidsample.generalstore:id/btnLetsShop")
	private WebElement btnShop;

	// Entering Name
	public void enterName(String name) {
		enterName.sendKeys(name);
		driver.hideKeyboard();
	}

	// Choose Gender
	public void chooseGender(String gender) {
		if (gender.contains("female")) {
			rdbtnFemale.click();
		}

		else {
			rdbtnMale.click();
		}

	}

	// Choose Country
	public void selectCountry(String countryname) throws InterruptedException {
		dropdownCountry.click();
		scrollTotext(countryname);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//android.widget.TextView[@text='" + countryname + "']")).click();

	}

	// Click letsshop button
	public ProductsPage clickLetsShop() {
		btnShop.click();
		return new ProductsPage(driver);
	}

}
