package numberrangesummarizer;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collections;

import org.junit.Test;

public class SequentialListTest {
    @Test
    public void emptyListCollection() {
        String input = "";
        SequentialList sequentialList = new SequentialList();
        assertEquals("The expected value is ", Collections.emptyList(), sequentialList.collect(input));
    }

    @Test
    public void whitespaceListCollection() {
        String input = "  ";
        SequentialList sequentialList = new SequentialList();
        assertEquals("The expected value is ", Collections.emptyList(), sequentialList.collect(input));
    }

    @Test
    public void nullListCollection() {
        String input = null;
        SequentialList sequentialList = new SequentialList();
        assertEquals("The expected value is ", Collections.emptyList(), sequentialList.collect(input));
    }

    @Test
    public void oneElementCollection() {
        String input = "1";
        SequentialList sequentialList = new SequentialList();
        assertEquals("The expected value is ", Arrays.asList(1), sequentialList.collect(input));
    }

    @Test
    public void listCollection() {
        String input = "1,2,3,4,5,6";
        SequentialList sequentialList = new SequentialList();
        assertEquals(
            "The expected value is 1,2,3,4,5,6", 
            Arrays.asList(1, 2, 3, 4, 5, 6), 
            sequentialList.collect(input)
        );
    }

    @Test
    public void listCollectionWithInputThatHasLeadingAndTrailingSpaces() {
        String input = "    1,2,3,4,5,6   ";
        SequentialList sequentialList = new SequentialList();
        assertEquals(
            "The expected value is 1,2,3,4,5,6", 
            Arrays.asList(1, 2, 3, 4, 5, 6), 
            sequentialList.collect(input)
        );
    }

    @Test
    public void listCollectionWithInputThatHasSpaces() {
        String input = "1,2  ,3,  4,5,6";
        SequentialList sequentialList = new SequentialList();
        assertEquals(
            "The expected value is 1,2,3,4,5,6", 
            Arrays.asList(1, 2, 3, 4, 5, 6), 
            sequentialList.collect(input)
        );
    }

    @Test
    public void listIsNull() {
        SequentialList sequentialList = new SequentialList();
        assertEquals(
            "The expected value is \"\"", 
            "", 
            sequentialList.summarizeCollection(null)
        );
    }

    @Test
    public void listIsEmpty() {
        SequentialList sequentialList = new SequentialList();
        assertEquals(
            "The expected value is \"\"", 
            "", 
            sequentialList.summarizeCollection(Collections.emptyList())
        );
    }

    @Test
    public void listHasOneElementOnly() {
        SequentialList sequentialList = new SequentialList();
        assertEquals(
            "The expected value is \"1\"", 
            "1", 
            sequentialList.summarizeCollection(Arrays.asList(1))
        );
    }

    @Test
    public void filtersOutFirstElementButListIsNull(){
        SequentialList sequentialList = new SequentialList();
        assertEquals(
            "The expected value is \"\"", 
            Collections.emptyList(), 
            sequentialList.dropFirst(null)
        );
    }

    @Test
    public void filtersOutFirstElementButListIsEmpty(){
        SequentialList sequentialList = new SequentialList();
        assertEquals(
            "The expected value is \"\"", 
            Collections.emptyList(), 
            sequentialList.dropFirst(Collections.emptyList())
        );
    }

    @Test
    public void filtersOutFirstElementButListHasOneElement(){
        SequentialList sequentialList = new SequentialList();
        assertEquals(
            "The expected value is \"1\"", 
            Arrays.asList(1), 
            sequentialList.dropFirst(Arrays.asList(1))
        );
    }

    @Test
    public void filtersOutFirstElement(){
        SequentialList sequentialList = new SequentialList();
        assertEquals(
            "The expected value is \"2\"", 
            Arrays.asList(2), 
            sequentialList.dropFirst(Arrays.asList(1,2))
        );
    }

    @Test
    public void checkIfCollectionIsInOrderButCollectionIsNull(){
        SequentialList sequentialList = new SequentialList();
        assertEquals(
            "The expected value is \"false\"", 
            false, 
            sequentialList.isCollectionInOrder(null)
        );
    }

    @Test
    public void checkIfCollectionIsInOrder(){
        SequentialList sequentialList = new SequentialList();
        assertEquals(
            "The expected value is \"true\"", 
            true, 
            sequentialList.isCollectionInOrder(Arrays.asList(1,2,3,4,5,6,7,8,9,10))
        );
    }

    @Test
    public void checkIfCollectionIsNotInOrder(){
        SequentialList sequentialList = new SequentialList();
        assertEquals(
            "The expected value is \"false\"", 
            false, 
            sequentialList.isCollectionInOrder(Arrays.asList(10,5,3,2,1))
        );
    }

    @Test
    public void checkIfCollectionHasDuplicatesButCollectionIsNull(){
        SequentialList sequentialList = new SequentialList();
        assertEquals(
            "The expected value is \"false\"", 
            false, 
            sequentialList.areThereDuplicatesInCollection(null)
        );
    }

    @Test
    public void checkIfCollectionHasDuplicates(){
        SequentialList sequentialList = new SequentialList();
        assertEquals(
            "The expected value is \"false\"", 
            false, 
            sequentialList.areThereDuplicatesInCollection(Arrays.asList(1,2,3,4,5,6,7,8,9,10))
        );
    }

    @Test
    public void checkIfCollectionHasDuplicatesWithDuplicates(){
        SequentialList sequentialList = new SequentialList();
        assertEquals(
            "The expected value is \"true\"", 
            true, 
            sequentialList.areThereDuplicatesInCollection(Arrays.asList(1,2,3,4,4,4,5))
        );
    }

    @Test
    public void listIsSequentialOnly() {
        SequentialList sequentialList = new SequentialList();
        assertEquals(
            "The expected value is \"1-10\"", 
            "1-10", 
            sequentialList.summarizeCollection(Arrays.asList(1,2,3,4,5,6,7,8,9,10))
        );
    }

    @Test
    public void listIsNotSeqentialAtAll() {
        SequentialList sequentialList = new SequentialList();
        assertEquals(
            "The expected value is \"1,3,5,7,9\"", 
            "1, 3, 5, 7, 9", 
            sequentialList.summarizeCollection(Arrays.asList(1,3,5,7,9))
        );
    }

    @Test
    public void listIsMixOfSeqentialAndNotSeqential() {
        SequentialList sequentialList = new SequentialList();
        assertEquals(
            "The expected value is \"1,3,5,7,9,21-25,30\"", 
            "1, 3, 5, 7, 9, 21-25, 30", 
            sequentialList.summarizeCollection(Arrays.asList(1,3,5,7,9,21,22,23,24,25,30))
        );
    }
}
