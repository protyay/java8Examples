package com.protyay.java7;

public class Java7ResourceManagement {
	public static void main(String[] args) throws Exception {
		try {
			tryWithResourceException();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("----------------------------------------");
		try {
			normalTryException();
		} catch (Exception e) {
			System.out.println("Printing from main..........");
			System.out.println(e.getMessage());
		}
	}

	private static void normalTryException() throws Exception {
		MyResource mr = null;
		try {
			mr = new MyResource();
			System.out.println("MyResource created in try block");
				throw new Exception("Exception in try");
		}
		finally {
			System.out.println("Inside finally block of normalTryException");
			if (mr != null)
				mr.close();
		}

	}

	private static void tryWithResourceException() throws Exception {
		try (MyResource mr = new MyResource()) {
			System.out.println("MyResource created in try-with-resources");
     		throw new Exception("Exception in try");
		}
	}

	static class MyResource implements AutoCloseable {

		@Override
		public void close() throws Exception {
			System.out.println("Closing MyResource");
			throw new Exception("Exception in Closing");
		}

	}

}
