package numberrangesummarizer;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Michael
 *
 * Creates a comma-delimited sequential list
 */
public class SequentialList implements NumberRangeSummarizer {

    /**
     * Collects the comma-delimited string input into an Integer collection
     * 
     * @param input
     * @return Collection<Integer>
     */
    public Collection<Integer> collect(String input) {
        if (input == null) {
            return Collections.emptyList();
        } else {
            return Arrays
                .stream(input.trim().split(","))
                .filter(part -> !part.trim().isEmpty())
                .map(part -> Integer.parseInt(part.trim()))
                .collect(Collectors.toList());
        }
    }

    /**
     * Filters out the first element from the collection
     * 
     * @param collection
     * @return Collection<Integer>
     */
    public Collection<Integer> dropFirst(Collection<Integer> collection) {
        if (collection == null) {
            return Collections.emptyList(); 
        } else if (collection.isEmpty() || collection.size() == 1) {
            return collection;
        } else {
            return collection
                .stream()
                .skip(1)
                .collect(Collectors.toList()); 
        }
    }

    /**
     * Checks if collection is strictly in ascending order
     * 
     * @param collection
     * @return Boolean
     */
    public Boolean isCollectionInOrder(Collection<Integer> collection){
        if (collection == null) {
            return false; 
        } else{
            Integer largest = Integer.MIN_VALUE;
    
            for(Integer current : collection){
                if(current > largest){
                    largest = current;
                } else{
                    return false;
                }
            }
    
            return true;
        }
    }

    /**
     * Checks if collection has any duplicates
     * 
     * @param collection
     * @return Boolean
     */
    public Boolean areThereDuplicatesInCollection(Collection<Integer> collection){
        if (collection == null) {
            return false; 
        } else {
            Set<Integer> collectionValues = new HashSet<>();
    
            for(Integer current : collection){
                if(collectionValues.contains(current)){
                    return true;
                } else{
                    collectionValues.add(current);
                }
            }
    
            return false;
        }
    }

    /**
     * Makes a comma-delimited string of numbers and groups a sequential collection of 
     * numbers into a range
     * 
     * @param collection
     * @return String
     */
    private String buildCommaDelimitedSequentialList(Collection<Integer> collection) {
        int start = 0, previous = 0;
        start = previous = collection.iterator().next();
        StringBuilder builder = new StringBuilder();
        Collection<Integer> collectionFromSecondElementOnwards = dropFirst(collection);
         
        for (Integer current : collectionFromSecondElementOnwards) {
            if (current == previous + 1) {
                previous = current;
            } else {
                builder.append(RangeUtils.buildRangeString(start, previous)).append(", ");
                start = current;
                previous = current;
            }
        }

        builder.append(RangeUtils.buildRangeString(start, previous));
        return builder.toString();
    }

    /**
     * Makes a comma-delimited string containing a list of numbers and groups numbers into a range when they
     * are sequential. Returns an empty string if list is null or empty. Returns a string containing an element
     * if it is the only element in the list
     * 
     * @return String
     */
    public String summarizeCollection(Collection<Integer> input) {
        if (input == null || input.isEmpty()) {
            return "";
        } else if (input.size() == 1) {
            return String.valueOf(input.iterator().next());
        } else if (!this.isCollectionInOrder(input)) {
            return "";
        } else if (this.areThereDuplicatesInCollection(input)) {
            return "";
        } else {
            return this.buildCommaDelimitedSequentialList(input);
        }
    }
}
