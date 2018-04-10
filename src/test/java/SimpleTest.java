import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SimpleTest extends TestBase
{
	@Test
	public void sanityTest()
	{
		Boolean fact = true;

		printThreadInfo();

		assertThat(fact).isTrue();
	}

	@Test
	public void insanityTest()
	{
		Boolean fact = false;

		printThreadInfo();

		assertThat(fact).isFalse();
	}

}
