package nonageshop.controller;

import nonageshop.dto.Product;

public class Test {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		Product p = new Product();
		System.out.println(p);
		
		Class<?> cls = Class.forName("nonageshop.dto.Product");
		Product p2 = (Product) cls.newInstance();
		System.out.println(p2);
	}

}
