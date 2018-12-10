package shoppingBasket;

public class FreeShipping extends Promotion {

	FreeShipping(double[] total) {
		super(total);
		
	}

	@Override
	public boolean promotionApplicable() {
		if(getTotal() > 20) {
			return true;
		}
		else {
			return false;
		}
		
	}

	@Override
	public double[] applyPromotion() {
		double promo[] = new double[2];
		promo[0] = getTotal();
		promo[1] = 0;
		return promo;
	}
	

}
