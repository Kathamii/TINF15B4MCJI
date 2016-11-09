package com.factracing.test;


/**
 * Short description.
 * <p>
 * Long description.
 *
 * @author Michael Buchwald
 * @date 9 Nov 2016
 */
public class HelloWorld
{

	private String message;


	/**
	 * @return the message
	 */
	public void getMessage()
	{
		System.out.println("Your message: " + message);
	}


	/**
	 * @param message the message to set
	 */
	public void setMessage(String message)
	{
		this.message = message;
	}

}
