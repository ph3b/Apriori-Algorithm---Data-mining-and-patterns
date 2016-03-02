import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ItemSetSupportListTest {

    @Test
    public void testContainsItemSetSupportLine() throws Exception {
        ItemSetSupportList list = new ItemSetSupportList();

        ArrayList<String> itemSet = new ArrayList<>();
        itemSet.add("beer");
        itemSet.add("milk");
        itemSet.add("eggs");

        ItemSetSupportLine itemSetSupportLine1 = new ItemSetSupportLine(itemSet, 5);
        list.addItemSetSupportLine(itemSetSupportLine1);
        boolean actualValue = list.containsItemSetSupportLine(itemSetSupportLine1);

        assertEquals("Should be true", actualValue, true);
    }
}