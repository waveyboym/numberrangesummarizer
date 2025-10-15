package numberrangesummarizer;

/**
 * @author Michael
 *
 * Creates a comma delimited sequential list
 */
public class RangeUtils {
     /**
     * Makes a range for two given values in the form of `a - b`, or returns a if a == b
     * 
     * @param start the value from which the range will start from
     * @param end the value the range will end at
     * @return String
     */
    public static String buildRangeString(int start, int end) {
        if (start == end) {
            return String.valueOf(start);
        } else if (end == start + 1) {
            return String.valueOf(start) + "," + String.valueOf(end);
        } else {
            return String.valueOf(start) + "-" + String.valueOf(end);
        }
    }
}
