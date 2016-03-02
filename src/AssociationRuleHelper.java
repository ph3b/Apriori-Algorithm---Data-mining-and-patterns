import java.lang.reflect.Array;
import java.util.ArrayList;

public class AssociationRuleHelper {

    public static ItemSetList generateAllSubSets(ItemSet itemSet){
        ArrayList<String> itemArray = itemSet.getItemSet();
        Integer setSize = itemArray.size();
        ItemSetList allSubSets = new ItemSetList();

        for(Integer setSizeCounter = 1; setSizeCounter < setSize + 1; setSizeCounter++){


            for(Integer itemCounter = 0; itemCounter < itemArray.size(); itemCounter++){
                ArrayList<String> newItemSet = new ArrayList<>();
                newItemSet.add(itemArray.get(itemCounter));
            }

        }
        return allSubSets;
    }
}
