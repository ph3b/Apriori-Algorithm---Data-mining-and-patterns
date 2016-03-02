import java.util.ArrayList;
import java.util.Iterator;

public class ItemSetSupportList{
    private ArrayList<ItemSetSupportLine> itemSetSupportList = new ArrayList<>();

    public void addItemSetSupportLine(ItemSetSupportLine itemSetSupportLine){
        this.itemSetSupportList.add(itemSetSupportLine);
    }

    public ArrayList<ItemSetSupportLine> getItemSetSupportList(){
        return this.itemSetSupportList;
    }

    public ItemSetSupportLine getItemAtIndex(Integer index){
        return itemSetSupportList.get(index);
    }
    public boolean containsItemSetSupportLine(ItemSetSupportLine itemSetSupportLine1){
        for(ItemSetSupportLine itemSetSupportLine2 : this.itemSetSupportList){
            if(itemSetSupportLine2.equals(itemSetSupportLine1)){
                return true;
            }
        }
        return false;
    }

}
