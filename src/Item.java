/**
 * @author Edward Yue Shung Wong
 */
public enum Item {
    APPLE(100), BANANA(150), CHERRY(75);

    private final int price;

    private Item(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}
