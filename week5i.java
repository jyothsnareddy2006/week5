import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Solution {
    public List<String> stringMatching(String[] words) {
        // Sort words by length in ascending order
        Arrays.sort(words, Comparator.comparingInt(String::length));
        
        List<String> result = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            // Only compare with words that appear after (longer strings)
            for (int j = i + 1; j < words.length; j++) {
                if (words[j].contains(words[i])) {
                    result.add(words[i]);
                    break;
                }
            }
        }

        return result;
    }
}