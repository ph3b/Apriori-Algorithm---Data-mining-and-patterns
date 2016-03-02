import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ItemSetSupportLineTest {

    @Test
    public void testGenerateItemSetKey() throws Exception {
        ArrayList<String> itemSet = new ArrayList<>();
        itemSet.add("beer");
        itemSet.add("milk");
        itemSet.add("eggs");

        ItemSetSupportLine itemSetSupportLine = new ItemSetSupportLine(itemSet, 5);
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

        ItemSetSupportLine itemSetSupportLine1 = new ItemSetSupportLine(itemSet1, 5);
        ItemSetSupportLine itemSetSupportLine2 = new ItemSetSupportLine(itemSet2, 5);

        assertEquals("Should return true", itemSetSupportLine1.equals(itemSetSupportLine2), true);
    }
}