import java.util.ArrayList;

public class ItemSetList {
    private ArrayList<ItemSet> itemSetSupportList = new ArrayList<>();

    public void addItemSetSupportLine(ItemSet itemSet){
        this.itemSetSupportList.add(itemSet);
    }

    public ArrayList<ItemSet> getItemSetSupportList(){
        return this.itemSetSupportList;
    }

    public ItemSet getItemAtIndex(Integer index){
        return itemSetSupportList.get(index);
    }

    public boolean containsItemSetSupportLine(ItemSet itemSet1){
        for(ItemSet itemSet2 : this.itemSetSupportList){
            if(itemSet2.equals(itemSet1)){
                return true;
            }
        }
        return false;
    }

    public String toString(){
        String output   = "========================================\n";
        output         += "| Item set                     Support |\n";
        output         += "| ==================================== |\n";
        for(ItemSet itemSet : this.itemSetSupportList){
            output += "| " + itemSet.generateItemSetKey();
            Integer length = itemSet.generateItemSetKey().length();
            for(Integer i = 0; i < 35-length; i++){
                output += " ";
            }
            output += itemSet.getFrequency() + " |\n";
        }
        output += "| =====================================|\n\n";
        return output;
    }

}
