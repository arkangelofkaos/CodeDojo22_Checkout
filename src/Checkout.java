import basket.Basket;
import basket.BasketTotalCalculator;
import discount.DiscountCalculator;

/**
 * @author Edward Yue Shung Wong
 */
public class Checkout {

    private BasketTotalCalculator basketTotalCalculator = new BasketTotalCalculator();
    private DiscountCalculator discountCalculator = new DiscountCalculator();

    public long calculatePriceOf(Basket basket) {
        long totalPrice = basketTotalCalculator.totalPriceOf(basket);
        long discount = discountCalculator.totalDiscountFor(basket);
        return totalPrice - discount;
    }
}
