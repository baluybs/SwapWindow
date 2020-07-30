package com.baluybs;
import java.util.*;
//class to store all the details related to product
class ProductMap{
	private String itemName;
	private int itemPrice;
	private int quantity;
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public int getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return itemName + itemPrice + quantity+"\n";
	}
}
public class ShopCartMap {
	//creating a map to store products 
	static Map<Integer, ProductMap> productMap=new HashMap<>();
	//creating product type object to store data members and pass it to map
	ProductMap productObj=null;
	double totalPrice=0.0;
	//display the items available
	public void showItems() {
		System.out.println("ProductId\tProductName\tProductPrice(rs)");
		System.out.println("1\t\tkurkure\t\t10");
		System.out.println("2\t\tLays\t\t20");
		System.out.println("3\t\tOreo\t\t40");
	}
	//this method called when we want to add products
	public void addItems(int productId,int quantity,String itemName,int itemPrice) {
		if(!productMap.containsKey(productId))
		{
			productObj=new ProductMap();
			productObj.setItemName(itemName);
			productObj.setItemPrice(itemPrice);
			productObj.setQuantity(quantity);
			productMap.put(productId, productObj);
			System.out.println(productObj.getItemName()+" Added successfully to your Cart");
		}else {
			System.err.println("Product already added in your list");
		}
	}
	//user can add items through this method
	public void addProduct(int productId,int productQuantity) {
		if (productId==1) {
			addItems(productId, productQuantity,"kurkure",10);
			}
		else if (productId==2) {
			addItems(productId, productQuantity,"Lays",20);
		}
		else if (productId==3) {
			addItems(productId, productQuantity,"Oreo",40);
		}else {
			System.err.println("Please enter ProductId in the given list");
		}
	}
	//to remove item from the cart
	public void removeItem(int productId) {
		if(productMap.isEmpty())
			System.err.println("Your cart is empty please add products to your cart");
		else if(productMap.containsKey(productId))
			productMap.remove(productId);
		else
			System.err.println("Please enter the Product present in your Cart");
	}
	//to display the updated cart details
	@SuppressWarnings("rawtypes")
	public void displayCart() {
		System.out.println("Name\tPrice\tqnty");
		System.out.println(".....................");
		Set key=productMap.keySet();
		Iterator itr=key.iterator();
		while(itr.hasNext()) {
			Object k= itr.next();
			System.out.print(productMap.get(k).getItemName()+"\t"+productMap.get(k).getItemPrice()+"\t"+productMap.get(k).getQuantity()+"\n");
			totalPrice+=(int)productMap.get(k).getItemPrice()*(int)productMap.get(k).getQuantity();
			System.out.println(".....................");
		}
		System.out.println();
		System.out.println("Total Price="+totalPrice);
	}
	//method for add or remove quantity from the cart
	@SuppressWarnings("resource")
	public void updateProduct(int inputOption) {
		Scanner scn=new Scanner(System.in);
		if(inputOption==1) {
			System.out.println("Enter ProductId to update");
			try {
				int addProductId=scn.nextInt();
				if (productMap.containsKey(addProductId)) {
					System.out.println("Enter Quantity to update");
					int addProductQuantity=scn.nextInt();
					ProductMap k=(ProductMap)productMap.get(addProductId);
					k.setQuantity(addProductQuantity+(int)k.getQuantity());
					productMap.put(addProductId, k);
				}else {
					System.err.println("Please enter the Id present in your cart");
				}
			}catch(InputMismatchException e){
				System.err.println("Please enter valid option");
				return;
			}
		}
		else if(inputOption==2) {
			System.out.println("Enter ProductId to remove");
			try {
				int removeProductId=scn.nextInt();
				if (productMap.containsKey(removeProductId)) {
					System.out.println("Enter No.of Quantity to remove");
					int removeProductQuantity=scn.nextInt();
					ProductMap k=(ProductMap)productMap.get(removeProductId);
					k.setQuantity((int)k.getQuantity()-removeProductQuantity);
					productMap.put(removeProductId, k);
				}else {
					System.err.println("Please enter existing Id in your cart");
				}
			}catch(InputMismatchException e){
				System.err.println("Please enter valid option");
				return;
			}
		}
		else {
			System.err.println("Sorry Invalid option");
		}
	}
	//to know weather map is empty or not
	public boolean isEmpty() {
		if(productMap.isEmpty())
			return true;
		else
			return false;
	}
}
