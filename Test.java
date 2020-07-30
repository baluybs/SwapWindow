package com.baluybs.shop;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Test {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		while(true) {
			System.out.println("Press 1 for List of Products");
			System.out.println("Press 2 to add Products");
			System.out.println("Press 3 to Update Cart");
			System.out.println("Press 4 to remove Products");
			System.out.println("Press 5 to view Cart");
			System.out.println("enter option");
			int option=sc.nextInt();
				select(option);
		}
	}
	@SuppressWarnings("resource")
	public static void select(int option) {
		ShopCartMap cartObj=new ShopCartMap();
		Scanner scn=new Scanner(System.in);
		switch(option)
		{
		case 1: cartObj.showItems();
				break;
		case 2: System.out.println("Enter ProductId:");
				int productId=scn.nextInt();
				if(productId<4) {
					System.out.println("Enter Quantity:");
					try {
					int quantity=scn.nextInt();
					if(quantity>100) {
						System.out.println("Please enter qantity upto 100");
					}else {
						cartObj.addProduct(productId, quantity);
					}
					}catch(InputMismatchException e){
						System.err.println("Please enter valid option");
					}
					break;
				}else {
					System.err.println("Please enter the existing Id");
				}
		case 3: if(cartObj.isEmpty()) {
					System.err.println("Your cart is empty you cant Update your cart");
				}else {
					System.out.println("Enter 1 to add quantity and 2 for remove quantity");
					int updateOption=scn.nextInt();
					cartObj.updateProduct(updateOption);
					break;
				}
		case 4: if(cartObj.isEmpty()) {
					System.err.println("please add items to your cart");
				}else {
					System.out.println("Enter Product Id to remove product:");
					int removeProductId=scn.nextInt();
					cartObj.removeItem(removeProductId);
					break;
				}
		case 5: if(cartObj.isEmpty()) {
					System.err.println("please add items to your cart");
				}else
					cartObj.displayCart();
				break;
		default :System.err.println("Please enter a valid input");
		}
	}
}
