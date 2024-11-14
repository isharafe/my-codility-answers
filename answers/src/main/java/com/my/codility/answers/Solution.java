package com.my.codility.answers;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Hello world!
 *
 */
public class Solution {

    public int add(String numbers) {
        if(numbers == null || numbers.isEmpty()) {
            return 0;
        }
        int invalidCharSeq = numbers.indexOf("\n,");
        if(invalidCharSeq>=0) {
            throw new RuntimeException("invalid number sequence - \\n,");
        }

        String delim = DEFAULT_DELIM;
        if(numbers.startsWith(DELIM_STARTER)) {
            int delimEndIndex = numbers.indexOf(DELIM_END);
            delim = numbers.substring(2, delimEndIndex);
            delim = Arrays.stream(delim.split(DELIM_SEPARATOR))
                    .map(Pattern::quote) // Escape special characters
                    /* make sure longer strings comes first.
                     * otherwise "1**2***3" will split as 1 2 *3
                     */
                    .sorted()
                    .collect(Collectors.joining(DELIM_COMBINER)); // Join with |
            numbers = numbers.substring(delimEndIndex + 1);
        }

        String[] numberArray = numbers.split(delim);
        List<Integer> negatives = new ArrayList<>();
        int sum = 0;
        for(String numStr : numberArray) {
            int num = Integer.parseInt(numStr.replace("\n", "").trim());
            if(num < 0) {
                negatives.add(num);
            }
            if(num <= MAX_VALUE) {
                sum += num;
            }
        }

        if(!negatives.isEmpty()) {
            throw new RuntimeException("negatives not allowed - " + negatives);
        }

        return sum;
    }	
}
