import java.util.ArrayList;

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

    public ItemSetList getInitialCandidateList(){
        ItemSetList candidateList = new ItemSetList();

        for(String distinctItem: this.distinctItems){
            ArrayList<String> itemSet = new ArrayList<>();
            itemSet.add(distinctItem);
            Integer supportCount = DataSetManager.getItemCountInTransactionList(this.transactionList, distinctItem);
            ItemSet item = new ItemSet(itemSet, supportCount);
            candidateList.addItemSetSupportLine(item);
        }
        return candidateList;
    }

    public ItemSetList generateFrequentListFromCandidateList(ItemSetList candidateList){
        ArrayList<ItemSet> itemLineList = candidateList.getItemSetSupportList();
        ItemSetList frequentList = new ItemSetList();

        for(ItemSet item : itemLineList){
            if((double) (item.getFrequency())/(double) (this.transactionList.size()) >= this.supportThreshold){
                frequentList.addItemSetSupportLine(item);
            }
        }
        return frequentList;
    }

    public ItemSetList generateNextCandidateList(ItemSetList currentCandidateList){

        ItemSetList nextCandidateList = new ItemSetList();

        ArrayList<ItemSet> currentItemSetList = currentCandidateList.getItemSetSupportList();
        Integer setSize = currentItemSetList.get(0).getItemSet().size();

        for(ItemSet itemSet : currentItemSetList){
            ArrayList<String> itemSetArray = itemSet.getItemSet();

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

                    ItemSet newItemSet = new ItemSet(newItemSetArray, supportCount);

                    if(!nextCandidateList.containsItemSetSupportLine(newItemSet)){
                        nextCandidateList.addItemSetSupportLine(newItemSet);
                    }
                }
            }
        }

        return nextCandidateList;
    };

}
