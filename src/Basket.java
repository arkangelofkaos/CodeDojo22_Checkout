import java.util.LinkedList;
import java.util.List;

/**
 * @author Edward Yue Shung Wong
 */
public class Basket {

    private final List<Item> items = new LinkedList<Item>();

    public void addItem(Item item) {
        items.add(item);
    }

    public List<Item> getItems() {
        return new LinkedList<Item>(items);
    }
}
