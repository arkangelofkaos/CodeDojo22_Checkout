import basket.Basket;
import item.Item;
import item.ItemParser;

import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * @author Edward Yue Shung Wong
 */
public class CheckoutMain {

    private static ItemParser itemParser = new ItemParser();

    private static Basket basket = new Basket();

    private static Checkout checkout = new Checkout();

    public static void main(String... ignored) {
        System.out.println("Hello, welcome to the checkout, please enter your items.");

        try (Scanner inputScanner = new Scanner(System.in)) {
            boolean running = true;

            while (running) {
                try {
                    String input = inputScanner.next();
                    Item item = itemParser.parse(input);

                    if (item == null) {
                        System.out.println("Invalid input.");
                    } else {
                        basket.addItem(item);
                    }

                    System.out.println("Running total is: " + checkout.calculatePriceOf(basket));
                } catch (NoSuchElementException | IllegalStateException ex) {
                    System.out.println("Goodbye!");
                    running = false;
                }
            }
        }
    }

}
