package numberrangesummarizer;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class SequentialListTest {
    @Test
    public void emptyListCollection() {
        String input = "";
        SequentialList sequentialList = new SequentialList();
        assertEquals("The expected value is ", Arrays.asList(), sequentialList.collect(input));
    }

    @Test
    public void whitespaceListCollection() {
        String input = "  ";
        SequentialList sequentialList = new SequentialList();
        assertEquals("The expected value is ", Arrays.asList(), sequentialList.collect(input));
    }

    @Test
    public void nullListCollection() {
        String input = null;
        SequentialList sequentialList = new SequentialList();
        assertEquals("The expected value is ", Arrays.asList(), sequentialList.collect(input));
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
            sequentialList.summarizeCollection(Arrays.asList())
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
    public void filtersOutFirstElement(){
        SequentialList sequentialList = new SequentialList();
        assertEquals(
            "The expected value is \"2\"", 
            Arrays.asList(2), 
            sequentialList.filterOutFirstElementFromCollection(Arrays.asList(1,2))
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
