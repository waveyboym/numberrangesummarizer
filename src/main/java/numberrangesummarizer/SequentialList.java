package numberrangesummarizer;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

/**
 * @author Michael
 *
 * Creates a comma delimited sequential list
 */
public class SequentialList implements NumberRangeSummarizer {

    /**
     * Collects the comma delimited string input into an Integer collection
     * 
     * @param input
     * @return Collection<Integer>
     */
    public Collection<Integer> collect(String input) {
        if(input == null){
            return Arrays.asList();
        } else{
            return Arrays
                .stream(input.trim().split(","))
                .filter(part -> !part.trim().equals("") && !part.isEmpty())
                .map(part -> Integer.parseInt(part.trim()))
                .collect(Collectors.toList());
        }
    }

    /*
     * Filters out the first element from the collection
     * 
     * @param collection
     * @return Collection<Integer>
     */
    public Collection<Integer> filterOutFirstElementFromCollection(Collection<Integer> collection) {
        return collection
            .stream()
            .skip(1)
            .collect(Collectors.toList()); 
    }

    /**
     * Makes a comma delimited string of numbers and groups a sequential collection of 
     * numbers into a range
     * 
     * @param collection
     * @return StringBuilder
     */
    private StringBuilder buildCommaDelimitedSequentialList(Collection<Integer> collection) {
        int start = 0, previous = 0;
        start = previous = collection.iterator().next();
        StringBuilder builder = new StringBuilder();
        Collection<Integer> collectionFromSecondElementOnwards = filterOutFirstElementFromCollection(collection);
         
        for (Integer current : collectionFromSecondElementOnwards) {
            if(current == previous + 1){
                previous = current;
            } else {
                builder.append(RangeUtils.makeRange(start, previous)).append(", ");
                start = current;
                previous = current;
            }
        };

        builder.append(RangeUtils.makeRange(start, previous));

        return builder;
    }

    /**
     * Makes a comma delimited string containing a list of numbers and groups numbers into a range when they
     * are sequential. Returns an empty string if list is null or empty. Returns a string containing an element
     * if it is the only element in the list
     * 
     * @return String
     */
    public String summarizeCollection(Collection<Integer> input) {
        if (input == null || input.isEmpty()) {
            return "";
        } else if(input.size() == 1) {
            return String.valueOf(input.iterator().next());
        } else {
            return this.buildCommaDelimitedSequentialList(input).toString();
        }
    }
}
