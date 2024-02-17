package LongestConsecutiveSequence;

import java.util.Arrays;
import java.util.Set;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

public class LongestConsecutiveSequence {
    public static int longestConsecutive(int[] nums) {
        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        ToIntFunction<Integer> consecutiveLengthMapper = num -> {
            int count = 1;
            while (set.contains(++num)) count++;
            return count;
        };
        return set.stream().filter(r -> !set.contains(r - 1)).parallel().mapToInt(consecutiveLengthMapper).max().orElse(0);
    }
    public static void main(String[] args) {
        int [] nums = {100,4,200,1,3,2};
        System.out.println(longestConsecutive(nums));
    }
}