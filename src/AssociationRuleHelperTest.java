import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class AssociationRuleHelperTest {

    @Test
    public void testGenerateAllSubSets() throws Exception {
        ArrayList<String> itemArray = new ArrayList<>();
        itemArray.add("beer");
        itemArray.add("milk");

        ItemSet item = new ItemSet(itemArray, 1);
        ItemSetList list = AssociationRuleHelper.generateAllSubSets(item);
        assertEquals(3, list.getItemSetSupportList().size());
    }

    @Test
    public void testGenerateAllSubSets2() throws Exception {
        ArrayList<String> itemArray = new ArrayList<>();
        itemArray.add("beer");
        itemArray.add("milk");
        itemArray.add("diapers");

        ItemSet item = new ItemSet(itemArray, 1);
        ItemSetList list = AssociationRuleHelper.generateAllSubSets(item);
        assertEquals(7, list.getItemSetSupportList().size());
    }
}