package item;

/**
 * @author Edward Yue Shung Wong
 */
public class ItemParser {

    public Item parse(String itemName) {
        try {
            return Item.valueOf(itemName.toUpperCase());
        } catch (IllegalArgumentException ex) {
            return null;
        }
    }
}
