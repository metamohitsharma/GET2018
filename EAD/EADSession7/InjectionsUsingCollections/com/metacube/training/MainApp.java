package com.metacube.training;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * This class Implements Collections
 * 
 * @author Mohit Sharma
 *
 */
public class MainApp {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"Beans.xml");
		CollectionInjection collection = (CollectionInjection) context
				.getBean("collectionInjection");
		collection.getAddressList();
		collection.getAddressSet();
		collection.getAddressMap();
	}
}
