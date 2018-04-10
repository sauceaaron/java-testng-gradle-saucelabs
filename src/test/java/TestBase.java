public class TestBase
{

	public void printThreadInfo()
	{
		Thread thread = Thread.currentThread();
		StringBuilder s = new StringBuilder();

		log(
				"test: " + thread.getStackTrace()[2],
				"thread: " + thread.getId()
		);

		pause(5);
	}

	public void log(String... message)
	{
		StringBuilder s = new StringBuilder();
		s.append("[log] ");
		for(String m : message) {
			s.append(m);
			s.append(" ");
		}

		System.out.println(s);
	}

	public void pause(int seconds)
	{
		try {
			Thread.sleep(seconds * 1000);
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}


}
