import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
// Approach: Prime product
// Prime product of only anagrams will be same.
// Time complexity: O(NK); N = number of strings, K = maximum length of a string in strs.
// Space complexity: O(NK)

class Solution {
    // Initialize prime array with 26 primes.
    private static final int[] prime = new int[] {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101};
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<BigInteger, List<String>> primeProductMap = new HashMap<>();
        for (String str: strs) {
            BigInteger primeProduct = getPrimeProduct(str);
            // Add strs[i] to the list mapped to primeProduct in primeProductMap.
            primeProductMap.computeIfAbsent(primeProduct, k -> new ArrayList<String>()).add(str);
        }
        // Return the values of the primeProductMap as list.
        return new ArrayList<>(primeProductMap.values());
    }

    private BigInteger getPrimeProduct(String str) {
        BigInteger product = BigInteger.ONE;
        for (int i = 0; i < str.length(); i ++) {
            char ch = str.charAt(i);
            // multiply the product with the value at ch - 'a' index.
            product = product.multiply(BigInteger.valueOf(prime[ch - 'a']));
        }
        return product;
    }
}