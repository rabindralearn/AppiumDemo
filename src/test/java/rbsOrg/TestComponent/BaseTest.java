package rbsOrg.TestComponent;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import rbsOrg.utils.CommonAction;

public class BaseTest extends CommonAction {

	public AndroidDriver driver;
	public AppiumDriverLocalService service;

	// this will start android server and invoke the application
	@BeforeClass
	public void configureAppium() throws URISyntaxException, IOException {

		Properties prop = new Properties();

		FileInputStream fis = new FileInputStream("//serverdata.properties");

		prop.load(fis);
		String ipAdress = prop.getProperty("ipAdress");
		String port = prop.getProperty("port");
		String androidphone = prop.getProperty("androidPhone");

		// this will start appium server automatically
		service = new AppiumServiceBuilder()
				.withAppiumJS(new File("address of appium inside appdata\\main.js"))
				.withIPAddress(ipAdress).usingPort(Integer.parseInt(port)).build();

		service.start();

		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName(androidphone);

		options.setApp("application resources here");

		driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), options);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

	@AfterClass
	public void tearDown() {
		driver.quit();
		service.stop();

	}

//getting hashmap for input data
	@DataProvider
	public Object[][] getData() throws IOException {

		List<HashMap<String, String>> data = getJsonData(" location of testdata.json");

		return new Object[][] { { data.get(0) } };

	}

}// end of class
