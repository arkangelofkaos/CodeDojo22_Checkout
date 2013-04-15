import java.util.List;

/**
 * @author Edward Yue Shung Wong
 */
public class BasketTotalCalculator {

    public int getTotalPrice(Basket basket) {
        List<Item> basketItems = basket.getItems();

        int totalPrice = basketItems.parallelStream()
                .map(Item::getPrice)
                .sum();

        return totalPrice;
    }
}
