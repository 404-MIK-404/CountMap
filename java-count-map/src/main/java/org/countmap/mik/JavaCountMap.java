package org.countmap.mik;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class JavaCountMap {


    public Map<Integer,Integer> countMap(int[] inputArray) {
        Map<Integer,Integer> counter = new HashMap<Integer, Integer>();
        for (int i : inputArray) {
            counter.put(i, counter.getOrDefault(i, 0) + 1);
        }
        return counter;
    }


    public Map<Integer,Integer> countMap(List<Integer> inputArray) {
        return inputArray.stream()
                .collect(Collectors.toMap(
                        element -> element,
                        element -> 1,
                        (oldValue, newValue) -> oldValue + 1
                ));
    }


}
