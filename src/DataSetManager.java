import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataSetManager {
    public static String getDataSet(){
        return "#bread,milk\n" +
                "#bread,diapers,beer,eggs\n" +
                "#milk,diapers,beer,cola\n" +
                "#bread,milk,diapers,beer\n" +
                "#bread,milk,diapers,cola\n" +
                "#bread,diapers,milk";
    }

    public static ArrayList<ArrayList<String>> convertToTransactionList(String dataSetString){

        String[] stringArray = dataSetString.replace("#", "").split("[\n]");
        ArrayList<String> dataSetArray = new ArrayList<>(Arrays.asList(stringArray));

        ArrayList<ArrayList<String>> transactionList = new ArrayList<>();

        for (String itemsString : dataSetArray){
            ArrayList<String> itemLine = new ArrayList<>(Arrays.asList(itemsString.split(",")));
            transactionList.add(itemLine);
        }
        return transactionList;
    }

    public static ArrayList<String> getDistinctItemsFromTransactionList(ArrayList<ArrayList<String>> transactionList){
        ArrayList<String> distinctItemsList = new ArrayList<>();
        for(ArrayList<String> items : transactionList){
            for(String item : items){
                if(!distinctItemsList.contains(item)){
                    distinctItemsList.add(item);
                }
            }
        }
        return distinctItemsList;
    }
    public static Integer getItemCountInTransactionList(ArrayList<ArrayList<String>> transactionList, String item){
        Integer counter = 0;
        for(ArrayList<String> itemSet : transactionList){
            for(String itemInSet : itemSet){
                if(itemInSet.equals(item)){
                    counter++;
                }
            }
        }
        return counter;
    }
}
