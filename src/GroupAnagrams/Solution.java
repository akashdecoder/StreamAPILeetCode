package GroupAnagrams;

import java.util.*;
import java.util.stream.*;

public class Solution {
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<String> words = Arrays.asList(strs);

        Map<String, List<String>> anagrams = words.stream().collect(Collectors.groupingBy(word -> {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            return new String(chars);
        }));
        return new ArrayList<>(anagrams.values());
    }

    public static void main(String[] args) {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};

        List<List<String>> groups = groupAnagrams(strs);
        groups.stream()
                .map(group -> String.join(", ", group))
                .forEach(System.out::println);
    }
}
