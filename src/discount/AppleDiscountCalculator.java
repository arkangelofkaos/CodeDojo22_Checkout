package discount;

import item.Item;

import java.util.function.Predicate;

/**
 * @author Edward Yue Shung Wong
 */
public class AppleDiscountCalculator extends ItemDiscountCalculator {
    public static final long APPLE_DISCOUNT = 100L;
    public static final long NUMBER_OF_APPLES_PER_DISCOUNT = 4L;

    private static final Predicate<? super Item> ITEM_FILTER_PREDICATE =
            x -> x == Item.APPLE || x == Item.POMME || x == Item.MELE;

    AppleDiscountCalculator() {
        super(APPLE_DISCOUNT, NUMBER_OF_APPLES_PER_DISCOUNT,
                ITEM_FILTER_PREDICATE);
    }
}
