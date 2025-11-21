import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// Pattern is same as isomorphic strings. Using 1 HashMap and 1 HashSet.
// Time complexity: O(N); N = pattern.length();
// Space complexity: O(N) for sStrs array. For patternMap and sSet, we can store at max of 26 entries.
class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] sStrs = s.split("\\s+");
        if (sStrs.length != pattern.length()) {
            return false;
        }
        Map<Character, String> patternMap = new HashMap<>();
        Set<String> sSet = new HashSet<>();
        for (int i = 0; i < pattern.length(); i ++) {
            char patternChar = pattern.charAt(i);
            // Check if patternChar maps to sStrs[i] in patternMap
            if (patternMap.containsKey(patternChar)) {
                if (!patternMap.get(patternChar).equals(sStrs[i])) {
                    return false;
                }
            } else {
                // If sStrs[i] is already present in sSet, return false.
                if (sSet.contains(sStrs[i])) {
                    return false;
                }
                patternMap.put(patternChar, sStrs[i]);
                sSet.add(sStrs[i]);
            }
        }
        return true;
    }
}