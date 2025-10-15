package numberrangesummarizer;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class RangeUtilsTest {
    @Test
    public void testSameStartAndEnd() {
        assertEquals("The expected value is 2", "2", RangeUtils.buildRangeString(2, 2));
    }

    @Test
    public void testCorrectRangeCreationWithSequentialNumbers() {
        assertEquals("The range should 2,3", "2,3", RangeUtils.buildRangeString(2, 3));
    }

    @Test
    public void testCorrectRangeCreationWithNonSequentialNumbers() {
        assertEquals("The range should 2-5", "2-5", RangeUtils.buildRangeString(2, 5));
    }
}
