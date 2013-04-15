package discount;

import basket.Basket;

/**
 * @author Edward Yue Shung Wong
 */
public class DiscountCalculator {

    private final CherryDiscountCalculator cherryDiscountCalculator = new CherryDiscountCalculator();

    public long totalDiscountFor(Basket basket) {
        int discount = 0;
        discount += cherryDiscountCalculator.discountForCherries(basket);
        return discount;
    }

}
