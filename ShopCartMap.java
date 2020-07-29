package com.baluybs.shop;
import java.util.*;

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
	static Map<Integer, ProductMap> m=new HashMap<>();
	//creating product type object to store data members and pass it to map
	ProductMap p=null;
	double totalPrice=0.0;
	//display the items available
	public void showItems() {
		System.out.println("ProductId\tProductName\tProductPrice(rs)");
		System.out.println("1\tkurkure\t10");
		System.out.println("2\tLays\t20");
		System.out.println("3\tOreo\t40");
	}
	//this method called when we want to add or update products
	public void addItems(int productId,int quantity,String itemName,int itemPrice) {
		if (m.containsKey(productId)) {
			ProductMap k=(ProductMap)m.get(productId);
			k.setQuantity(quantity+(int)k.getQuantity());
			m.put(productId, k);
		}else {
		p=new ProductMap();
		p.setItemName(itemName);
		p.setItemPrice(itemPrice);
		p.setQuantity(quantity);
		m.put(productId, p);
		}
		System.out.println(p.getItemName()+" Added successfully to your Cart");
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
		if(m.isEmpty())
			System.err.println("Your cart is empty please add products to your cart");
		else if(m.containsKey(productId))
			m.remove(productId);
		else
			System.err.println("Please enter the Product present in your Cart");
	}
	//to display the updated cart details
	public void displayCart() {
		System.out.println("Name\tPrice\tqnty");
		System.out.println(".....................");
		Set key=m.keySet();
		Iterator itr=key.iterator();
		while(itr.hasNext()) {
			Object k= itr.next();
			System.out.print(m.get(k).getItemName()+"\t"+m.get(k).getItemPrice()+"\t"+m.get(k).getQuantity()+"\n");
			totalPrice+=(int)m.get(k).getItemPrice()*(int)m.get(k).getQuantity();
			System.out.println(".....................");
		}
		System.out.println();
		System.out.println("Total Price="+totalPrice);
	}
	//to know weather map is empty or not
	public boolean isEmpty() {
		if(m.isEmpty())
			return true;
		else
			return false;
	}
}
