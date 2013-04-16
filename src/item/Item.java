package item;

/**
 * @author Edward Yue Shung Wong
 */
public enum Item {
    APPLE(100L), BANANA(150L), CHERRY(75L), POMME(100), MELE(100);

    private final long price;

    private Item(long price) {
        this.price = price;
    }

    public long getPrice() {
        return price;
    }
}
