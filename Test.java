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
			int opt=sc.nextInt();
			select(opt);
		}
	}
	public static void select(int opt) {
		ShopCartMap c=new ShopCartMap();
		Scanner scn=new Scanner(System.in);
		switch(opt)
		{
		case 1: c.showItems();
				break;
		case 2: System.out.println("Enter Product Id and quantity");
				int pid=scn.nextInt();
				int qty=scn.nextInt();
				c.addProduct(pid, qty);
				break;
		case 3: System.out.println("Enter Product Id to remove product");
				int id=scn.nextInt();
				c.removeItem(id);
				break;
		case 4: c.displayCart();
				break;
		default :System.err.println("Please enter a valid input");
		}
	}
}
