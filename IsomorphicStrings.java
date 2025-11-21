import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// Using 1 HashMap and 1 HashSet
// Time complexity: O(N); N = s.length() = t.length()
// Space complexity: O(1) because in the map and set at max of 95 printable ASCII characters can be stored
class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false; // already covered in constraints
        }
        int length = s.length();
        Map<Character, Character> sMap = new HashMap<>();
        Set<Character> tSet = new HashSet<>();
        for (int i = 0; i < length; i ++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);
            // Check if sChar maps to tChar in sMap
            if (sMap.containsKey(sChar)) {
                if (sMap.get(sChar) != tChar) {
                    return false;   
                }
            } else {
                // If t char is already present in tSet, return false.
                if (tSet.contains(tChar)) {
                    return false;
                }
                sMap.put(sChar, tChar);
                tSet.add(tChar);
            }
        }
        return true;
    }
}