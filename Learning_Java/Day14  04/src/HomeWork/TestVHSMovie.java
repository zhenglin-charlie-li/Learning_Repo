package HomeWork;import  java.io.*;

/**
 * Test driver for class <code>VHSMovie</code>.
 *
 * @author  iCarnegie
 * @version  1.0.0
 * @see VHSMovie
 */
public class TestVHSMovie  {

	/* Standard output stream */
	private static PrintWriter  stdOut =
		new  PrintWriter(System.out, true);

	/* Standard error stream */
	private static PrintWriter  stdErr =
		new  PrintWriter(System.err, true);

	/**
	 * Displays a message in the standard error stream if the value specified
	 * by parameter <code>condition<code> is <code>false</code>.
	 *
	 * @param message  the error message.
	 * @param condition  the test condition.
	 */
	public static void assertTrue(String message, boolean condition) {

		if (! condition) {
			stdErr.print("** Test failure ");
			stdErr.println(message);
		
			System.exit(0);
		}
	}

	/**
	 * Displays a message in the standard error stream.
	 *
	 * @param message  the error message.
	 */
	public static void fail(String message) {

		stdErr.print("** Test failure ");
		stdErr.println(message);

		System.exit(0);
	}

	/**
	 * Test driver for class <code>VHSMovie</code>.
	 *
	 * @param args  not used.
	 */
	public static void  main(String[] args)  {

		stdOut.println("");
		stdOut.println("Testing class VHSMovie...");

		Class classDescriptor = null;

		try {
			classDescriptor  = Class.forName("VHSMovie");
		} catch (ClassNotFoundException cnfe) {
			fail("1: Class VHSMovie not found " +
				"(check the name of the class)");
		}
		
		Class[] arrayInterfaces = classDescriptor.getInterfaces();
		
		assertTrue("2: the class should implement one interface",
			arrayInterfaces.length == 1);
		assertTrue(
			"3: the class should implement the interface VHS",
			arrayInterfaces[0].getName().equals("VHS"));
			
		assertTrue(
			"4: the class should extend class Movie",
			classDescriptor.getSuperclass().getName().equals("Movie"));

		//Testing constructor and accessors
		String title = "title";
		String[] starring = {"name1", "name2", "name3"};
		String director = "director name";
		String format = "format";
		String language = "language";

		VHSMovie vhsMovie = new VHSMovie(title, starring,
			director, format, language);

		assertTrue("5: testing method Movie.getTitle",
			title.equals(vhsMovie.getTitle()));
		assertTrue("6: testing method Movie.getActors",
			starring.equals(vhsMovie.getActors()));
		assertTrue("7: testing method Movie.getDirection",
			director.equals(vhsMovie.getDirector()));
		assertTrue("8: testing method getFormat",
			format.equals(vhsMovie.getFormat()));
		assertTrue("9: testing method getLanguage",
			language.equals(vhsMovie.getLanguage()));
		assertTrue("10: testing method toString",
			vhsMovie.toString().equals(title + "," + format + "," + language));

		stdOut.println("done");
	}
}
