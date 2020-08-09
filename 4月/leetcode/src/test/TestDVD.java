package test;import  java.io.*;
import java.lang.reflect.*;

/**
 * Test driver for class <code>DVD</code>.
 *
 * @author  iCarnegie
 * @version  1.0.0
 * @see DVD
 */
public class TestDVD  {

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
	 * Test driver for interface <code>DVD</code>.
	 *
	 * @param args  not used.
	 */
	public static void  main(String[] args)  {

		stdOut.println("");
		stdOut.println("Testing interface DVD...");

		DVD dvd;

		Class interfaceDescriptor = null;

		try {
			interfaceDescriptor  = Class.forName("DVD");
		} catch (ClassNotFoundException cnfe) {
			fail("1: Interface DVD not found " +
				"(check the name of the interface)");
		}

		assertTrue("2: DVD is not an Interface",
			interfaceDescriptor.isInterface());

		Method[] methods = interfaceDescriptor.getMethods();

		assertTrue("3: DVD should contain three methods",
			methods.length == 3);

		try {
			Method method =
				interfaceDescriptor.getMethod("getRegionCode", new Class[0]);
			Class returnType = method.getReturnType();

			assertTrue(
				"4: the return type of method getRegionCode is incorrect",
				returnType.getName().equals("int"));
			
		} catch (NoSuchMethodException nsme) {
			fail("5: Method getRegionCode not found " +
				"(check the name of the method)");
		}
		
		try {
			Method method =
				interfaceDescriptor.getMethod("getAudioTracks", new Class[0]);
			Class returnType = method.getReturnType();
			
			assertTrue(
				"6: the return type of method getAudioTracks is incorrect",
				returnType.getName().equals("[Ljava.lang.String;"));
			
		} catch (NoSuchMethodException nsme) {
			fail("7: Method getAudioTracks not found " +
				"(check the name of the method)");
		}
		
		try {
			Method method =
				interfaceDescriptor.getMethod("getSubtitles", new Class[0]);
			Class returnType = method.getReturnType();
			
			assertTrue("8: the return type of method getSubtitles is incorrect",
				returnType.getName().equals("[Ljava.lang.String;"));
			
		} catch (NoSuchMethodException nsme) {
			fail("9: Method getSubtitles not found " +
				"(check the name of the method)");
		}

		stdOut.println("done");
	}
}
