package test;import  java.io.*;
import java.lang.reflect.*;

/**
 * Test driver for class <code>VHS</code>.
 *
 * @author  iCarnegie
 * @version  1.0.0
 * @see VHS
 */
public class TestVHS  {

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
	 * Test driver for interface <code>VHS</code>.
	 *
	 * @param args  not used.
	 */
	public static void  main(String[] args)  {

		stdOut.println("");
		stdOut.println("Testing interface VHS...");

		VHS vhs;

		Class interfaceDescriptor = null;

		try {
			interfaceDescriptor  = Class.forName("VHS");
		} catch (ClassNotFoundException cnfe) {
			fail("1: Interface VHS not found " +
				"(check the name of the interface)");
		}

		assertTrue("2: VHS is not an Interface",
			interfaceDescriptor.isInterface());

		Method[] methods = interfaceDescriptor.getMethods();

		assertTrue("3: VHS should contain two methods",
			methods.length == 2);

		try {
			Method method =
				interfaceDescriptor.getMethod("getFormat", new Class[0]);
			Class returnType = method.getReturnType();

			assertTrue(
				"4: the return type of method getFormat is incorrect",
				returnType.getName().equals("java.lang.String"));
			
		} catch (NoSuchMethodException nsme) {
			fail("5: Method getFormat not found " +
				"(check the name of the method)");
		}
		
		try {
			Method method =
				interfaceDescriptor.getMethod("getLanguage", new Class[0]);
			Class returnType = method.getReturnType();
			
			assertTrue(
				"6: the return type of method getLanguage is incorrect",
				returnType.getName().equals("java.lang.String"));
			
		} catch (NoSuchMethodException nsme) {
			fail("7: Method getLanguage not found " +
				"(check the name of the method)");
		}

		stdOut.println("done");
	}
}
