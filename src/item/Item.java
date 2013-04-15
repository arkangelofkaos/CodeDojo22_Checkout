package item;

/**
 * @author Edward Yue Shung Wong
 */
public enum Item {
    APPLE(100L), BANANA(150L), CHERRY(75L);

    private final long price;

    private Item(long price) {
        this.price = price;
    }

    public long getPrice() {
        return price;
    }
}
