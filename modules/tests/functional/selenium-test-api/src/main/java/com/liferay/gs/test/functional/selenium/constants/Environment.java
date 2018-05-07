package com.liferay.gs.test.functional.selenium.constants;

/**
 * @author Andrew Betts
 */
public class Environment {

	public enum OSName {
		WINDOWS, LINUX, MAC
	}

	public static OSName getOSName() {
		String osName = System.getProperty("os.name");

		if (osName.contains("WIN") ||
			osName.contains("win") ||
			osName.contains("Win")) {

			return OSName.WINDOWS;
		}

		if (osName.contains("MAC") ||
			osName.contains("Mac") ||
			osName.contains("mac")) {

			return OSName.MAC;
		}

		return OSName.LINUX;
	}

	public static boolean is64Bit() {
		String bit = System.getProperty("sun.arch.data.model");

		switch (bit) {
			case "32":
				return false;
			case "64":
				return true;
			default:
				throw new IllegalStateException(
					"unknown environment; please set \"sun.arch.data.model\"");
		}
	}

}
