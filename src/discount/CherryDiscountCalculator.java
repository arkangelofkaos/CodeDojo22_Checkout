package discount;

import item.Item;

public class CherryDiscountCalculator extends ItemDiscountCalculator {

    public static final int CHERRY_DISCOUNT = 20;

    public static final int NUMBER_OF_CHERRIES_PER_DISCOUNT = 2;

    public CherryDiscountCalculator() {
        super(CHERRY_DISCOUNT, NUMBER_OF_CHERRIES_PER_DISCOUNT, x -> x == Item.CHERRY);
    }
}