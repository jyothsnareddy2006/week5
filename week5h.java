import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> result = new ArrayList<>();
        
        for (String word : words) {
            if (matches(word, pattern)) {
                result.add(word);
            }
        }
        
        return result;
    }
    
    private boolean matches(String word, String pattern) {
        if (word.length() != pattern.length()) {
            return false;
        }
        
        HashMap<Character, Character> wordToPattern = new HashMap<>();
        HashMap<Character, Character> patternToWord = new HashMap<>();
        
        for (int i = 0; i < word.length(); i++) {
            char w = word.charAt(i);
            char p = pattern.charAt(i);
            
            if (!wordToPattern.containsKey(w)) {
                wordToPattern.put(w, p);
            }
            if (!patternToWord.containsKey(p)) {
                patternToWord.put(p, w);
            }
            
            if (wordToPattern.get(w) != p || patternToWord.get(p) != w) {
                return false;
            }
        }
        
        return true;
    }
}