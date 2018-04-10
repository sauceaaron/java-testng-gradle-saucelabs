import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class SimpleSauceTests extends SauceTestBase
{
	String site = "https://saucelabs-sample-test-frameworks.github.io/training-test-page";

	@Test
	public void testA(Method method)
	{
		webdriver().get(site);
	}

	@Test
	public void testB(Method method)
	{
		webdriver().get(site);
	}
}
