package rbsOrg.utils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.appium.java_client.AppiumDriver;

public class CommonAction {

//	AppiumDriver driver;
//	public CommonAction(AppiumDriver driver)
//	{
//
//		this.driver=driver;
//	}

	// Code for explicit wait
	public void explicitWait(WebElement webelement, String carttitle, AppiumDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.attributeContains(webelement, "text", carttitle));

	}

	// Converting the json file to hashmap for getting data

	public List<HashMap<String, String>> getJsonData(String JsonFilepath) throws IOException {
		// convert json file to string
		String jsonContent = FileUtils.readFileToString(new File(JsonFilepath), StandardCharsets.UTF_8);

		// convert json string to hashmap
		ObjectMapper mapper = new ObjectMapper();

		// create a list of hashmap

		List<HashMap<String, String>> data = mapper.readValue(jsonContent,
				new TypeReference<List<HashMap<String, String>>>() {
				});
		return data;

	}

	// this will return the path for screenshot if test fails
	public String getScreenshotPath(String testCaseName, AppiumDriver driver) throws IOException {

		File source = driver.getScreenshotAs(OutputType.FILE);

		String destinationFile = "location of \\reports" + testCaseName + ".png";

		FileUtils.copyFile(source, new File(destinationFile));

		return destinationFile;
	}

}
