package discount;

import item.Item;

/**
 * @author Edward Yue Shung Wong
 */
public final class BananaDiscountCalculator extends ItemDiscountCalculator {
    public static final long BANANA_DISCOUNT = 150L;

    public static final long NUMBER_OF_BANANAS_PER_DISCOUNT = 2L;

    public BananaDiscountCalculator() {
        super(BANANA_DISCOUNT, NUMBER_OF_BANANAS_PER_DISCOUNT, x -> x == Item.BANANA);
    }
}
