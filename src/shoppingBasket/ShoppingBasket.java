package shoppingBasket;

import java.util.ArrayList;

public class ShoppingBasket {
	
	protected static ArrayList<Product> catalog = new ArrayList<Product>();
	protected static ArrayList<Promotion> promotion = new ArrayList<Promotion>();

	public void createCatalog(String[] args) {
		
		Product banana = new Banana();
		catalog.add(banana);
		Product orange = new Orange();
		catalog.add(orange);
		Product apple = new Apple();
		catalog.add(apple);
	}
	
	public void calculateTotal() {
		for(Product current: catalog) {
			System.out.println("Item: "+current.getName()+" -  Price: "+current.getPrice()+" - Weight: "+current.getWeight());
		}
		double total[] = new double[2];
		total[0] = 0;
		for(Product current: catalog) {
			total[0]+= Math.round(current.getPrice() * 100) / 100;
		}
		
		Shipping shipping = new Shipping();
		total[1] = Math.round(shipping.getShipping() * 100) / 100;
		System.out.println("Total weight: : "+total[1]);
		
		Promotion freeShipping = new FreeShipping(total);
		promotion.add(freeShipping);
		
		for(Promotion current: promotion) {
			if(current.promotionApplicable()) {
				total = current.applyPromotion();
			}
		}
		double finalPrice = total[0] + total[1];
		finalPrice = Math.round(finalPrice * 100.0) / 100.0;
		System.out.println("Subtotal: "+ total[0]);
		System.out.println("Shipping: "+ total[1]);
		System.out.println("Total: "+ finalPrice);
		
		

	}

}
