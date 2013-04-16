package discount;

import basket.Basket;
import item.Item;

import java.util.function.Predicate;

/**
 * @author Edward Yue Shung Wong
 */
abstract class ItemDiscountCalculator {

    private final long discount;

    private final long numberPerDiscount;

    private final Predicate<? super Item> itemFilterPredicate;

    ItemDiscountCalculator(long discount, long numberPerDiscount, Predicate<? super Item> itemFilterPredicate) {
        this.discount = discount;
        this.numberPerDiscount = numberPerDiscount;
        this.itemFilterPredicate = itemFilterPredicate;
    }

    public long discountFor(Basket basket) {
        long totalNumberOfCherries = basket.getItems()
                .parallelStream()
                .filter(itemFilterPredicate)
                .count();

        long numberOfDiscountsToApply = totalNumberOfCherries / numberPerDiscount;

        return numberOfDiscountsToApply * discount;
    }
}
