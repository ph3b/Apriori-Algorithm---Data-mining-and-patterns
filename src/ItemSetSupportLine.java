import java.util.ArrayList;
import java.util.Collections;

public class ItemSetSupportLine {
    private ArrayList<String> itemSet;
    private Integer supportCount;

    public ItemSetSupportLine(ArrayList<String> itemSet, Integer supportCount){
        this.itemSet = itemSet;
        this.supportCount = supportCount;
    }

    public ArrayList<String> getItemSet(){
        return this.itemSet;
    }

    public Integer getSupportCount(){
        return this.supportCount;
    }

    public String generateItemSetKey(){
        Collections.sort(itemSet, String.CASE_INSENSITIVE_ORDER);
        return itemSet.toString();
    }

    public boolean equals(ItemSetSupportLine itemSetSupportLine){
        return itemSetSupportLine.generateItemSetKey().equals(this.generateItemSetKey()) &&
                itemSetSupportLine.getSupportCount().equals(this.getSupportCount());
    }



}
