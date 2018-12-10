package shoppingBasket;

public abstract class Promotion extends ShoppingBasket{
	private double total;
	private double shipping;

	Promotion(double[] total){
		this.total = total[0];
		this.shipping = total[1];
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public double getShipping() {
		return shipping;
	}

	public void setShipping(double shipping) {
		this.shipping = shipping;
	}
	
	public abstract boolean promotionApplicable();
	
	public abstract double[] applyPromotion();
	
	
}
