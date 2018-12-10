package shoppingBasket;

import java.util.ArrayList;

public class ShoppingBasket {
	
	protected ArrayList<Product> catalog = new ArrayList<Product>();
	protected ArrayList<Promotion> promotion = new ArrayList<Promotion>();
	protected ArrayList<Product> basket = new ArrayList<Product>();
	
	ShoppingBasket() {
		createCatalog();
	}

	public void createCatalog() {
		
		Product banana = new Banana();
		catalog.add(banana);
		Product orange = new Orange();
		catalog.add(orange);
		Product apple = new Apple();
		catalog.add(apple);
	}
	
	

}
