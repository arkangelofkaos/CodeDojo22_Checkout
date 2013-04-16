package basket;

import item.Item;
import item.ItemParser;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Edward Yue Shung Wong
 */
public class BasketTotalCalculatorTest {

    private BasketTotalCalculator calculator = new BasketTotalCalculator();

    private ItemParser itemParser = new ItemParser();

    private Item addItemToBasket(Basket basket, String itemName) {
        Item apple = itemParser.parse(itemName);
        basket.addItem(apple);
        return apple;
    }

    @Test
    public void shouldGetTotalOf4Apples() {
        Basket basket = new Basket();
        addItemToBasket(basket, "pomme");
        addItemToBasket(basket, "pomme");
        addItemToBasket(basket, "apple");
        Item apple = addItemToBasket(basket, "mele");

        assertEquals(apple.getPrice() * 4, calculator.totalPriceOf(basket));
    }
}
