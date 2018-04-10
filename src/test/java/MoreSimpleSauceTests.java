
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class MoreSimpleSauceTests extends SauceTestBase
{
	String site = "https://saucelabs-sample-test-frameworks.github.io/training-test-page";

	@Test
	public void testC(Method method)
	{
		webdriver().get(site);
	}

	@Test
	public void testD(Method method)
	{
		webdriver().get(site);
	}
}
