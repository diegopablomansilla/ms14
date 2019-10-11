package com.massoftware.b.service.util;

import java.time.ZonedDateTime;

public class Exception500 extends Exception {
	// ---------------------------------------------------------------------------------------------------------------------------

	private Exception exception;

	// ---------------------------------------------------------------------------------------------------------------------------

	private ZonedDateTime time;

	// ---------------------------------------------------------------------------------------------------------------------------

	public Exception500(Exception exception) {

		this.time = ZonedDateTime.now();
		this.exception = exception;

	}

	// ---------------------------------------------------------------------------------------------------------------------------

	public Exception getException() {
		return exception;
	}

	public Throwable getCause() {
		return exception.getCause();
	}

	public String getMessage() {
		return exception.getMessage();
	}

	public StackTraceElement[] getStackTrace() {
		return exception.getStackTrace();
	}

	// ---------------------------------------------------------------------------------------------------------------------------

	public ZonedDateTime getTime() {
		return time;
	}

	// ---------------------------------------------------------------------------------------------------------------------------

	public String toString() {
		String s = "\n\n";

		s += "\n" + "Exception: " + this.getClass().getCanonicalName();
		s += "\n" + "Time: " + this.getTime();
		s += "\n" + "Message: " + this.getMessage();
		s += "\n";
		s += "\n";
		s += "\n" + "Exception:" + this.getException();
		s += "\n";

		return s;
	}

	// ---------------------------------------------------------------------------------------------------------------------------

	/**
	 * 
	 */
	private static final long serialVersionUID = -5504598004204150742L;

} // END CLASS -----------------------------------------------------------------
