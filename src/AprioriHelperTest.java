import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class AprioriHelperTest {

    @Test
    public void testgetInitialCandidateList(){
        ArrayList<ArrayList<String>> transactionList = DataSetManager.convertToTransactionList(DataSetManager.getDataSet());

        AprioriHelper aprioriSolver = new AprioriHelper(1.0, transactionList);
        ItemSetSupportList candidateList = aprioriSolver.getInitialCandidateList();
        ItemSetSupportLine item = candidateList.getItemAtIndex(0);

        Integer expectedCount = 5;

        assertEquals("Should be bread", "bread", item.getItemSet().get(0));
        assertEquals("Should have count 5", expectedCount, item.getSupportCount());
    }

    @Test
    public void testgenerateFrequentListFromCandidateList(){
        ArrayList<ArrayList<String>> transactionList = DataSetManager.convertToTransactionList(DataSetManager.getDataSet());

        AprioriHelper aprioriSolver = new AprioriHelper(5.0, transactionList);
        ItemSetSupportList candidateList = aprioriSolver.getInitialCandidateList();
        ItemSetSupportList frequentList = aprioriSolver.generateFrequentListFromCandidateList(candidateList);

        Integer expectedFrequentListSize = 3;
        Integer actualFrequentListSize = frequentList.getItemSetSupportList().size();

        assertEquals("FrequentList should only contain 3 items", expectedFrequentListSize, actualFrequentListSize);
    }

    @Test
    public void testgenerateNextCandidateList(){
        ArrayList<ArrayList<String>> transactionList = DataSetManager.convertToTransactionList(DataSetManager.getDataSet());

        AprioriHelper aprioriSolver = new AprioriHelper(0.5, transactionList);

        // 1. iteration
        ItemSetSupportList candidateList = aprioriSolver.getInitialCandidateList();
        ItemSetSupportList frequentList = aprioriSolver.generateFrequentListFromCandidateList(candidateList);

        // 2.iteration
        ItemSetSupportList secondCandidateList = aprioriSolver.generateNextCandidateList(frequentList);
        ItemSetSupportList secondFrequentList = aprioriSolver.generateFrequentListFromCandidateList(secondCandidateList);

        // 3.Iteration
        ItemSetSupportList thirdCandidateList = aprioriSolver.generateNextCandidateList(secondFrequentList);
        ItemSetSupportList thirdFrequentList = aprioriSolver.generateFrequentListFromCandidateList(thirdCandidateList);
        System.out.print("hello");
    }

}