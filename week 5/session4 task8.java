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
        HashMap<Character, Character> pToW = new HashMap<>();
        HashMap<Character, Character> wToP = new HashMap<>();

        for (int i = 0; i < word.length(); i++) {
            char pChar = pattern.charAt(i);
            char wChar = word.charAt(i);

            if (!pToW.containsKey(pChar)) {
                pToW.put(pChar, wChar);
            }
            if (!wToP.containsKey(wChar)) {
                wToP.put(wChar, pChar);
            }

            if (pToW.get(pChar) != wChar || wToP.get(wChar) != pChar) {
                return false;
            }
        }

        return true;
    }
}