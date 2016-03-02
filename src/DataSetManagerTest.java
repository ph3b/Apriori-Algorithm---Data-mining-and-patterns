import org.junit.Test;


import java.util.ArrayList;

import static org.junit.Assert.*;

public class DataSetManagerTest {

    @Test
    public void testConvertDataSetToTransactionList(){
        String dataSetString = DataSetManager.getDataSet();
        ArrayList<ArrayList<String>> dataSetArray = DataSetManager.convertToTransactionList(dataSetString);

        assertEquals("Shoud be x long", 6, dataSetArray.size());
        assertEquals(dataSetArray.get(0).get(0), "bread");
        assertEquals(dataSetArray.get(0).get(1), "milk");
    }

    @Test
    public void testgetDistinctItemsFromTransactionList(){
        String dataSetString = DataSetManager.getDataSet();
        ArrayList<ArrayList<String>> dataSetArray = DataSetManager.convertToTransactionList(dataSetString);
        ArrayList<String> distinctItems = DataSetManager.getDistinctItemsFromTransactionList(dataSetArray);
        assertEquals(distinctItems.size(), 6);
    }

    @Test
    public void testgetItemCountInTransactionList(){
        String dataSetString = DataSetManager.getDataSet();
        ArrayList<ArrayList<String>> dataSetArray = DataSetManager.convertToTransactionList(dataSetString);
        Integer countForEggs = DataSetManager.getItemCountInTransactionList(dataSetArray, "eggs");
        Integer countForBread = DataSetManager.getItemCountInTransactionList(dataSetArray, "bread");
        Integer expectedCountForEggs = 1;
        Integer expectedCountForBread = 5;

        assertEquals(expectedCountForEggs, countForEggs);
        assertEquals(expectedCountForBread, countForBread);
    }



}