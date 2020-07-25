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
	static Map<Integer, ProductMap> m=new HashMap<>();
	ProductMap p=null;
	double totalPrice=0.0;
	public void showItems() {
		System.out.println("Pid    Products    Price(rs)");
		System.out.println("1      kurkure     10");
		System.out.println("2      Lays        20");
		System.out.println("3      Oreo        40");
	}
	public void addProduct(int pid,int qnty) {
		if (pid==1) {
			if (m.containsKey(pid)) {
				ProductMap k=(ProductMap)m.get(pid);
				k.setQuantity(qnty+(int)k.getQuantity());
				m.put(pid, k);
			}else {
			p=new ProductMap();
			p.setItemName("kurkure");
			p.setItemPrice(10);
			p.setQuantity(qnty);
			m.put(1, p);
			}
		}
		else if (pid==2) {
			if (m.containsKey(pid)) {
				ProductMap k=(ProductMap)m.get(pid);
				k.setQuantity(qnty+(int)k.getQuantity());
				m.put(pid, k);
			}else {
			p=new ProductMap();
			p.setItemName("Lays");
			p.setItemPrice(20);
			p.setQuantity(qnty);
			m.put(2, p);
			}
		}
		else if (pid==3) {
			if (m.containsKey(pid)) {
				ProductMap k=(ProductMap)m.get(pid);
				k.setQuantity(qnty+(int)k.getQuantity());
				m.put(pid, k);
			}else {
			p=new ProductMap();
			p.setItemName("Oreo");
			p.setItemPrice(40);
			p.setQuantity(qnty);
			m.put(3, p);
			}
		}else {
			System.err.println("Please enter ProductId in the given list");
		}
		System.out.println(p.getItemName()+" Added successfully to your Cart");
	}
	public void removeItem(int pid) {
		m.remove(pid);
	}
	public void displayCart() {
		System.out.println("Name\tPrice\tqnty");
		System.out.println("..................");
		Set key=m.keySet();
		Iterator itr=key.iterator();
		while(itr.hasNext()) {
			Object k= itr.next();
			System.out.print(m.get(k).getItemName()+"\t"+m.get(k).getItemPrice()+"\t"+m.get(k).getQuantity()+"\n");
			totalPrice+=(int)m.get(k).getItemPrice()*(int)m.get(k).getQuantity();
			System.out.println("..................");
		}
		System.out.println();
		System.out.println(totalPrice);
	}
}
