import basket.Basket;
import discount.AppleDiscountCalculator;
import discount.BananaDiscountCalculator;
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
        Item cherry = addItemToBasket(basket, "cherry");

        int numberOfDiscounts = 2;
        for (int i = 1; i < CherryDiscountCalculator.NUMBER_OF_CHERRIES_PER_DISCOUNT * numberOfDiscounts; i++) {
            addItemToBasket(basket, "cherry");
        }

        long price = checkout.calculatePriceOf(basket);

        long expectedTotal = (cherry.getPrice() * 4) -
                (CherryDiscountCalculator.CHERRY_DISCOUNT * numberOfDiscounts);
        assertEquals("checkout total is not the discounted price of cherries", expectedTotal, price);
    }

    @Test
    public void shouldCalculatePriceOfPairsOfBananasFactoringInDiscount() {
        Basket basket = new Basket();

        Item banana = addItemToBasket(basket, "banana");

        int numberOfDiscounts = 2;
        for (int i = 1; i < BananaDiscountCalculator.NUMBER_OF_BANANAS_PER_DISCOUNT * numberOfDiscounts; i++) {
            addItemToBasket(basket, "banana");
        }

        long price = checkout.calculatePriceOf(basket);

        long expectedTotal = (banana.getPrice() * 4) -
                (BananaDiscountCalculator.BANANA_DISCOUNT * numberOfDiscounts);
        assertEquals("checkout total is not the discounted price of bananas", expectedTotal, price);
    }

    @Test
    public void shouldCalculatePriceOfApplesFactoringInDiscount() {
        Basket basket = new Basket();
        addItemToBasket(basket, "pomme");
        addItemToBasket(basket, "pomme");
        addItemToBasket(basket, "apple");
        Item apple = addItemToBasket(basket, "mele");

        long price = checkout.calculatePriceOf(basket);

        long expectedTotal = (apple.getPrice() * 4) -
                (AppleDiscountCalculator.APPLE_DISCOUNT);
        assertEquals("checkout total is not the discounted price of apples", expectedTotal, price);
    }

}
