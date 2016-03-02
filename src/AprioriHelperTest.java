import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class AprioriHelperTest {

    @Test
    public void testgetInitialCandidateList(){
        ArrayList<ArrayList<String>> transactionList = DataSetManager.convertToTransactionList(DataSetManager.getDataSet());

        AprioriHelper aprioriSolver = new AprioriHelper(0.16, transactionList);
        ItemSetList candidateList = aprioriSolver.getInitialCandidateList();
        ItemSet item = candidateList.getItemAtIndex(0);

        Integer expectedCount = 5;

        assertEquals("Should be bread", "bread", item.getItemSet().get(0));
        assertEquals("Should have count 5", expectedCount, item.getFrequency());
    }

    @Test
    public void testgenerateFrequentListFromCandidateList(){
        ArrayList<ArrayList<String>> transactionList = DataSetManager.convertToTransactionList(DataSetManager.getDataSet());

        AprioriHelper aprioriSolver = new AprioriHelper(0.833, transactionList);
        ItemSetList candidateList = aprioriSolver.getInitialCandidateList();
        ItemSetList frequentList = aprioriSolver.generateFrequentListFromCandidateList(candidateList);

        Integer expectedFrequentListSize = 3;
        Integer actualFrequentListSize = frequentList.getItemSetSupportList().size();

        assertEquals("FrequentList should only contain 3 items", expectedFrequentListSize, actualFrequentListSize);
    }

    @Test
    public void testgenerateNextCandidateList(){
        ArrayList<ArrayList<String>> transactionList = DataSetManager.convertToTransactionList(DataSetManager.getDataSet());

        AprioriHelper aprioriSolver = new AprioriHelper(0.30, transactionList);

        // 1. iteration
        ItemSetList candidateList = aprioriSolver.getInitialCandidateList();
        ItemSetList frequentList = aprioriSolver.generateFrequentListFromCandidateList(candidateList);

        // 2.iteration
        ItemSetList secondCandidateList = aprioriSolver.generateNextCandidateList(frequentList);
        ItemSetList secondFrequentList = aprioriSolver.generateFrequentListFromCandidateList(secondCandidateList);

        // 3.Iteration
        ItemSetList thirdCandidateList = aprioriSolver.generateNextCandidateList(secondFrequentList);
        ItemSetList thirdFrequentList = aprioriSolver.generateFrequentListFromCandidateList(thirdCandidateList);

        assertEquals("Should have a list size of 4", thirdFrequentList.getItemSetSupportList().size(), 4);
    }

    @Test
    public void testgenerateNextCandidateList2(){
        ArrayList<ArrayList<String>> transactionList = DataSetManager.convertToTransactionList(DataSetManager.getDataSet());

        AprioriHelper aprioriSolver = new AprioriHelper(0.50, transactionList);

        // 1. iteration
        ItemSetList candidateList = aprioriSolver.getInitialCandidateList();
        ItemSetList frequentList = aprioriSolver.generateFrequentListFromCandidateList(candidateList);

        // 2.iteration
        ItemSetList secondCandidateList = aprioriSolver.generateNextCandidateList(frequentList);
        ItemSetList secondFrequentList = aprioriSolver.generateFrequentListFromCandidateList(secondCandidateList);

        // 3.Iteration
        ItemSetList thirdCandidateList = aprioriSolver.generateNextCandidateList(secondFrequentList);
        ItemSetList thirdFrequentList = aprioriSolver.generateFrequentListFromCandidateList(thirdCandidateList);

        // 4.Iteration
        ItemSetList fourthCandidateList = aprioriSolver.generateNextCandidateList(thirdFrequentList);
        ItemSetList fourthFrequentList = aprioriSolver.generateFrequentListFromCandidateList(fourthCandidateList);
    }

}