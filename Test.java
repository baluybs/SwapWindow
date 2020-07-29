package com.baluybs.shop;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		while(true) {
			System.out.println("Press 1 for List of Products");
			System.out.println("Press 2 to add Products");
			System.out.println("Press 3 to remove Products");
			System.out.println("Press 4 to view Cart");
			System.out.println("enter option");
			int option=sc.nextInt();
			select(option);
		}
	}
	public static void select(int option) {
		ShopCartMap c=new ShopCartMap();
		Scanner scn=new Scanner(System.in);
		switch(option)
		{
		case 1: c.showItems();
				break;
		case 2: System.out.println("Enter Product:");
				int productId=scn.nextInt();
				System.out.println("Enter Quantity:");
				int quantity=scn.nextInt();
				c.addProduct(productId, quantity);
				break;
		case 3: if(c.isEmpty()) {
					System.err.println("please add items to your cart");
				}else {
				System.out.println("Enter Product Id to remove product:");
				int removeProductId=scn.nextInt();
				c.removeItem(removeProductId);
				}
				break;
		case 4: if(c.isEmpty()) {
					System.err.println("please add items to your cart");
				}else
				c.displayCart();
				break;
		default :System.err.println("Please enter a valid input");
		}
	}
}
