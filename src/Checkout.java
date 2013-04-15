/**
 * @author Edward Yue Shung Wong
 */
public class Checkout {

    private BasketTotalCalculator basketTotalCalculator = new BasketTotalCalculator();

    public int calculatePriceOf(Basket basket) {
        int totalPrice = basketTotalCalculator.getTotalPrice(basket);
        return totalPrice;
    }
}
