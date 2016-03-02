import java.util.ArrayList;

public class FrequentItemSets {
    public static void main(String[] args) {
        String unformattedDataSet = DataSetManager.getDataSet();
        ArrayList<ArrayList<String>> transactionList = DataSetManager.convertToTransactionList(unformattedDataSet);

        AprioriHelper apriori = new AprioriHelper(0.5, transactionList);

        ItemSetList initialCandidateList = apriori.getInitialCandidateList();
        ItemSetList frequentList = apriori.generateFrequentListFromCandidateList(initialCandidateList);

        System.out.print("size;items \n");
        for(ItemSet itemSet : frequentList.getItemSetSupportList()){
            System.out.print(itemSet.getItemSet().size() + ";" + itemSet + "\n");
        }

        while(frequentList.getItemSetSupportList().size() > 0){
            frequentList = apriori.generateFrequentListFromCandidateList(apriori.generateNextCandidateList(frequentList));

            for(ItemSet itemSet : frequentList.getItemSetSupportList()){
                System.out.print(itemSet.getItemSet().size() + ";" + itemSet + "\n");
            }
        }
    }
}