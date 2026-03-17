package rbsOrg.TestCase;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import rbsOrg.TestComponent.BaseTest;
import rbsOrg.pageObjects.android.EntryPage;

public class SubmitForm extends BaseTest {

	@Test
	public void validateEmptySubmitForm() throws InterruptedException {
		// EntryPage
		EntryPage entrypage = new EntryPage(driver);
		
		// Selecting round button for male or female
		entrypage.chooseGender("female");
		
		//Thread.sleep(2000);
		// Clicking Lets Shop button
		entrypage.clickLetsShop();
		
	
		// validating toast message
		String toastMessage = driver.findElement(By.xpath("(//android.widget.Toast)[1]")).getAttribute("name");
		Assert.assertEquals(toastMessage, "Please enter your name");

	}

}
