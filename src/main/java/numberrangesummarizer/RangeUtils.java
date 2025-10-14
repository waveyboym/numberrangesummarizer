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
     * @param startNumber the value from which the range will start from
     * @param endNumber the value the range will end at
     * @return String
     */
    public static String makeRange(int startNumber, int endNumber) {
        if(startNumber == endNumber){
            return String.valueOf(startNumber);
        } else if(endNumber == startNumber + 1){
            return String.valueOf(startNumber) + "," + String.valueOf(endNumber);
        } else{
            return String.valueOf(startNumber) + "-" + String.valueOf(endNumber);
        }
    }
}
