import basket.Basket;
import discount.CherryDiscountCalculator;
import item.Item;
import item.ItemParser;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Edward Yue Shung Wong
 */
public class CheckoutTest {

    private Checkout checkout = new Checkout();
    private ItemParser itemParser = new ItemParser();

    private Item addItemToBasket(Basket basket, String itemName) {
        Item apple = itemParser.parse(itemName);
        basket.addItem(apple);
        return apple;
    }

    @Test
    public void shouldCalculatePriceOfAppleBasketAs100() {
        Basket basket = new Basket();

        Item item = addItemToBasket(basket, "apple");

        long price = checkout.calculatePriceOf(basket);

        assertEquals("checkout total is not the price of an apple", item.getPrice(), price);
    }

    @Test
    public void shouldCalculatePriceOfMultipleItemBasketAsTotalPrice() {
        Basket basket = new Basket();

        Item apple = addItemToBasket(basket, "apple");

        Item banana = addItemToBasket(basket, "banana");

        Item cherry = addItemToBasket(basket, "cherry");

        long price = checkout.calculatePriceOf(basket);

        long expectedTotal = apple.getPrice() + banana.getPrice() + cherry.getPrice();
        assertEquals("checkout total is not the price of an apple", expectedTotal, price);
    }

    @Test
    public void shouldCalculatePriceOfPairsOfCherriesFactoringInDiscount() {
        Basket basket = new Basket();
        addItemToBasket(basket, "cherry");
        addItemToBasket(basket, "cherry");
        addItemToBasket(basket, "cherry");
        Item cherry = addItemToBasket(basket, "cherry");

        long price = checkout.calculatePriceOf(basket);

        long expectedTotal = (cherry.getPrice() * 4) -
                (CherryDiscountCalculator.CHERRY_DISCOUNT * CherryDiscountCalculator.NUMBER_OF_CHERRIES_PER_DISCOUNT);
        assertEquals("checkout total is not the discounted price of cherries", expectedTotal, price);
    }

}
