package org.example;

import java.util.*;

public class RemoveDuplicates {
    public static List<Integer> removeDuplicates(List<Integer> numbers) {
        List<Integer> result = new ArrayList<>();
        Set<Integer> seen = new HashSet<>();

        for (Integer num : numbers) {
            if (seen.add(num)) { // add возвращает true если элемента не было
                result.add(num);
            }
        }
        return result;
    }
}