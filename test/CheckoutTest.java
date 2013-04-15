import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Edward Yue Shung Wong
 */
public class CheckoutTest {

    @Test
    public void shouldCalculatePriceOfAppleBasketAs100() {
        Checkout checkout = new Checkout();

        Basket basket = new Basket();

        ItemParser itemParser = new ItemParser();
        Item item = itemParser.parse("apple");

        basket.addItem(item);

        int price = checkout.calculatePriceOf(basket);

        assertEquals("checkout total is not the price of an apple", item.getPrice(), price);
    }

}
