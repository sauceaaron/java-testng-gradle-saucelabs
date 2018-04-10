import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;

public class SauceTestBase
{
	ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();

	public DesiredCapabilities getDesiredCapabilities()
	{
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("platform", "Windows 10");
		capabilities.setCapability("browserName", "Firefox");
		capabilities.setCapability("version", "latest");

		return capabilities;
	}

	public URL getSauceURL()
	{
		String SAUCE_USERNAME = System.getenv("SAUCE_USERNAME");
		System.out.println("SAUCE_USERNAME: " + SAUCE_USERNAME);

		String SAUCE_ACCESS_KEY = System.getenv("SAUCE_ACCESS_KEY");

		String SAUCE_URL = "https://" + SAUCE_USERNAME + ":" + SAUCE_ACCESS_KEY + "@ondemand.saucelabs.com:443/wd/hub";
		System.out.println("SAUCE_URL: " + SAUCE_URL);

		try
		{
			return new URL(SAUCE_URL);
		}
		catch (MalformedURLException e)
		{
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public String getTestName(Method method)
	{
		return (this.getClass().getSimpleName() + " " + method.getName()).replace("_", " ");
	}

	public RemoteWebDriver webdriver()
	{
		return driver.get();
	}

	@BeforeMethod
	public void setup(Method method)
	{
		String testName = (this.getClass().getSimpleName() + " " + method.getName()).replace("_", " ");

		URL url = getSauceURL();
		DesiredCapabilities capabilities = getDesiredCapabilities();
		capabilities.setCapability("name", testName);

		RemoteWebDriver driver = new RemoteWebDriver(url, capabilities);

		this.driver.set(driver);

		webdriver().executeScript("sauce:context=" +testName);
	}

	@AfterMethod
	public void teardown()
	{
		this.driver.get().quit();
		this.driver.remove();
	}
}
