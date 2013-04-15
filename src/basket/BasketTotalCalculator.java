package basket;

import item.Item;

import java.util.List;

/**
 * @author Edward Yue Shung Wong
 */
public class BasketTotalCalculator {

    public long totalPriceOf(Basket basket) {
        List<Item> basketItems = basket.getItems();

        long totalPrice = basketItems.parallelStream()
                .map(item -> item.getPrice())
                .sum();

        return totalPrice;
    }
}
