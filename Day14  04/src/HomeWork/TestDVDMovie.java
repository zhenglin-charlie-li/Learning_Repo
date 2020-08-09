package HomeWork;import  java.io.*;

/**
 * Test driver for class <code>DVDMovie</code>.
 *
 * @author  iCarnegie
 * @version  1.0.0
 * @see DVDMovie
 */
public class TestDVDMovie  {

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
	 * Test driver for class <code>DVDMovie</code>.
	 *
	 * @param args  not used.
	 */
	public static void  main(String[] args)  {

		stdOut.println("");
		stdOut.println("Testing class DVDMovie...");

		Class classDescriptor = null;

		try {
			classDescriptor  = Class.forName("DVDMovie");
		} catch (ClassNotFoundException cnfe) {
			fail("1: Class DVDMovie not found " +
				"(check the name of the class)");
		}
		
		Class[] arrayInterfaces = classDescriptor.getInterfaces();
		
		assertTrue("2: the class should implement one interface",
			arrayInterfaces.length == 1);
		assertTrue(
			"3: the class does should implement the interface DVD",
			arrayInterfaces[0].getName().equals("DVD"));
			
		assertTrue(
			"4: the class should extend class Movie",
			classDescriptor.getSuperclass().getName().equals("Movie"));

		//Testing constructor and accessors
		String title = "title";
		String[] starring = {"name1", "name2", "name3"};
		String director = "director name";
		int regionCode = 1;
		String[] audioTracks = {"audio1", "audio2"};
		String[] subtitles = {"subtitle1", "subtitle2"};

		DVDMovie dvdMovie = new DVDMovie(title, starring,
			director, regionCode, audioTracks, subtitles);

		assertTrue("5: testing method Movie.getTitle",
			title.equals(dvdMovie.getTitle()));
		assertTrue("6: testing method Movie.getActors",
			starring.equals(dvdMovie.getActors()));
		assertTrue("7: testing method Movie.getDirection",
			director.equals(dvdMovie.getDirector()));
		assertTrue("8: testing method getRegionCode",
			regionCode == dvdMovie.getRegionCode());
		assertTrue("9: testing method getAudioTracks",
			audioTracks.equals(dvdMovie.getAudioTracks()));
		assertTrue("10: testing method getSubtitles",
			subtitles.equals(dvdMovie.getSubtitles()));
		assertTrue("11: testing method toString",
			dvdMovie.toString().equals(title + "," + regionCode));

		stdOut.println("done");
	}
}
