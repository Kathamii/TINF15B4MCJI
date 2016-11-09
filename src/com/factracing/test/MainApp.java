package com.factracing.test;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * Short description.
 * <p>
 * Long description.
 *
 * @author Michael Buchwald
 * @date 9 Nov 2016
 */
public class MainApp
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");

		HelloWorld obj = (HelloWorld) context.getBean("helloWorld");

		obj.getMessage();
	}

}
