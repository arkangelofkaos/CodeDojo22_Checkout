package discount;

import basket.Basket;
import item.Item;

public class CherryDiscountCalculator {

    public static final int CHERRY_DISCOUNT = 20;

    public static final int NUMBER_OF_CHERRIES_PER_DISCOUNT = 2;

    public long discountForCherries(Basket basket) {
        long totalNumberOfCherries = basket.getItems()
                .parallelStream()
                .filter(x -> x == Item.CHERRY)
                .count();

        long numberOfDiscountsToApply = totalNumberOfCherries / NUMBER_OF_CHERRIES_PER_DISCOUNT;

        return numberOfDiscountsToApply * CHERRY_DISCOUNT;
    }
}