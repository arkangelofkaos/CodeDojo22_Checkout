import org.junit.Test;

import static org.junit.Assert.assertNull;


/**
 * @author Edward Yue Shung Wong
 */
public class ItemParserTest {

    @Test
    public void shouldReturnNullGivenBadInput() {
        ItemParser itemParser = new ItemParser();
        assertNull("item expected to be null when passed bad input", itemParser.parse("badInput"));
    }
}
