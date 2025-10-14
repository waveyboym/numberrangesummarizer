package numberrangesummarizer;

import java.util.Collection;

public class Main {
    public static void main(String[] args) {
        String input = "1,3,6,7,8,12,13,14,15,21,22,23,24,31";
        SequentialList sequentialList = new SequentialList();
        Collection<Integer> collection = sequentialList.collect(input);
        System.out.println(sequentialList.summarizeCollection(collection));
    }
}