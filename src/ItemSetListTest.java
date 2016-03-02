import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ItemSetListTest {

    @Test
    public void testContainsItemSetSupportLine() throws Exception {
        ItemSetList list = new ItemSetList();

        ArrayList<String> itemSet = new ArrayList<>();
        itemSet.add("beer");
        itemSet.add("milk");
        itemSet.add("eggs");

        ItemSet itemSetSupportLine1 = new ItemSet(itemSet, 5);
        list.addItemSetSupportLine(itemSetSupportLine1);
        boolean actualValue = list.containsItemSetSupportLine(itemSetSupportLine1);
        assertEquals("Should be true", actualValue, true);
    }
}