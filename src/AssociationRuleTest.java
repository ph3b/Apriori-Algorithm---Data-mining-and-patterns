import org.junit.Test;
import sun.misc.ASCIICaseInsensitiveComparator;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class AssociationRuleTest {

    @Test
    public void testToString() throws Exception {
        ArrayList<String> item1List = new ArrayList<>();
        item1List.add("beer");
        item1List.add("milk");

        ArrayList<String> item2List = new ArrayList<>();
        item2List.add("diaper");
        item2List.add("eggs");

        ItemSet item1 = new ItemSet(item1List, 5);
        ItemSet item2 = new ItemSet(item2List, 2);

        AssociationRule rule = new AssociationRule(item1, item2);
        assertEquals("beer,milk;diaper,eggs", rule.toString());
    }

    @Test
    public void testEquals() throws Exception {
        ArrayList<String> item1List = new ArrayList<>();
        item1List.add("beer");
        item1List.add("milk");
        ItemSet item1 = new ItemSet(item1List, 5);

        ArrayList<String> item2List = new ArrayList<>();
        item2List.add("diaper");
        item2List.add("eggs");
        ItemSet item2 = new ItemSet(item2List, 2);

        ArrayList<String> item3List = new ArrayList<>();
        item2List.add("diaper");
        item2List.add("whiskey");
        ItemSet item3 = new ItemSet(item3List, 4);

        AssociationRule rule = new AssociationRule(item1, item2);
        AssociationRule rule2 = new AssociationRule(item2, item1);

        AssociationRule rule3 = new AssociationRule(item1, item3);

        assertEquals(rule.equals(rule2), true);
        assertEquals(rule2.equals(rule), true);
        assertEquals(!rule.equals(rule3), true);
    }
}