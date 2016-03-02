import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ItemSetTest {

    @Test
    public void testGenerateItemSetKey() throws Exception {
        ArrayList<String> itemSet = new ArrayList<>();
        itemSet.add("beer");
        itemSet.add("milk");
        itemSet.add("eggs");

        ItemSet itemSetSupportLine = new ItemSet(itemSet, 5);
        String actualKey = itemSetSupportLine.generateItemSetKey();

        assertEquals("Should generate key", actualKey, "[beer, eggs, milk]");
    }

    @Test
    public void testEquals(){
        ArrayList<String> itemSet1 = new ArrayList<>();
        itemSet1.add("beer");
        itemSet1.add("milk");
        itemSet1.add("eggs");

        ArrayList<String> itemSet2 = new ArrayList<>();
        itemSet2.add("eggs");
        itemSet2.add("milk");
        itemSet2.add("beer");

        ItemSet itemSetSupportLine1 = new ItemSet(itemSet1, 5);
        ItemSet itemSetSupportLine2 = new ItemSet(itemSet2, 5);

        assertEquals("Should return true", itemSetSupportLine1.equals(itemSetSupportLine2), true);
    }
}