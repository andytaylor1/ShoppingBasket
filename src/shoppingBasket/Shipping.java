package shoppingBasket;

public class Shipping extends ShoppingBasket{
	
	public double getShipping() {
		double totalWeight = 0;
		for(Product current: catalog) {
			totalWeight+= current.getWeight();
		}
		if(totalWeight < 2) {
			return 1.00;
		}
		else if(totalWeight < 4) {
			return 2.00;
		}
		else {
			return 3.00;
		}
	}

}
