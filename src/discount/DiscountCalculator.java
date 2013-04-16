package discount;

import basket.Basket;

/**
 * @author Edward Yue Shung Wong
 */
public class DiscountCalculator {

    private final CherryDiscountCalculator cherryDiscountCalculator = new CherryDiscountCalculator();
    private final BananaDiscountCalculator bananaDiscountCalculator = new BananaDiscountCalculator();
    private final AppleDiscountCalculator appleDiscountCalculator = new AppleDiscountCalculator();

    public long totalDiscountFor(Basket basket) {
        int discount = 0;
        discount += cherryDiscountCalculator.discountFor(basket);
        discount += bananaDiscountCalculator.discountFor(basket);
        discount += appleDiscountCalculator.discountFor(basket);
        return discount;
    }

}
