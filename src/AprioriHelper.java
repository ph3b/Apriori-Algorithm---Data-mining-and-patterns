import java.util.ArrayList;
import java.util.Arrays;

public class AprioriHelper {
    Double supportThreshold;
    ArrayList<ArrayList<String>> transactionList;
    ArrayList<String> distinctItems;
    Integer iteration = 1;

    public AprioriHelper(Double supportThreshold, ArrayList<ArrayList<String>> transactionList){
        this.supportThreshold = supportThreshold;
        this.transactionList = transactionList;
        this.distinctItems = DataSetManager.getDistinctItemsFromTransactionList(this.transactionList);
    }

    public ItemSetSupportList getInitialCandidateList(){
        ItemSetSupportList candidateList = new ItemSetSupportList();

        for(String distinctItem: this.distinctItems){
            ArrayList<String> itemSet = new ArrayList<>();
            itemSet.add(distinctItem);
            Integer supportCount = DataSetManager.getItemCountInTransactionList(this.transactionList, distinctItem);
            ItemSetSupportLine item = new ItemSetSupportLine(itemSet, supportCount);
            candidateList.addItemSetSupportLine(item);
        }
        return candidateList;
    }

    public ItemSetSupportList generateFrequentListFromCandidateList(ItemSetSupportList candidateList){
        ArrayList<ItemSetSupportLine> itemLineList = candidateList.getItemSetSupportList();
        ItemSetSupportList frequentList = new ItemSetSupportList();

        for(ItemSetSupportLine item : itemLineList){
            if(item.getSupportCount() >= this.supportThreshold){
                frequentList.addItemSetSupportLine(item);
            }
        }
        return frequentList;
    }

    public ItemSetSupportList generateNextCandidateList(ItemSetSupportList currentCandidateList){

        ItemSetSupportList nextCandidateList = new ItemSetSupportList();

        ArrayList<ItemSetSupportLine> currentItemSetList = currentCandidateList.getItemSetSupportList();
        Integer setSize = currentItemSetList.get(0).getItemSet().size();

        for(ItemSetSupportLine itemSetSupportLine : currentItemSetList){
            ArrayList<String> itemSetArray = itemSetSupportLine.getItemSet();

            for(String distinctItem : this.distinctItems){

                if(!itemSetArray.contains(distinctItem)){
                    ArrayList<String> newItemSetArray = new ArrayList<>();

                    for(String existingItem : itemSetArray){
                        newItemSetArray.add(existingItem);
                    }
                    newItemSetArray.add(distinctItem);

                    Integer supportCount = 0;
                    for(ArrayList<String> transaction : this.transactionList){
                        if(transaction.containsAll(newItemSetArray)){
                            supportCount++;
                        }
                    }

                    ItemSetSupportLine newItemSet = new ItemSetSupportLine(newItemSetArray, supportCount);

                    if(!nextCandidateList.containsItemSetSupportLine(newItemSet)){
                        nextCandidateList.addItemSetSupportLine(newItemSet);
                    }
                }
            }
        }

        return nextCandidateList;
    };

}
