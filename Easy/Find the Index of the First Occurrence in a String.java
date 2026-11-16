class Solution {
    public int strStr(String haystack, String needle) {
        // Java has built-in method, but let's do manual logic for interview
        // You can also just return haystack.indexOf(needle);
        
        int n = haystack.length();
        int m = needle.length();

        // If needle longer than haystack, impossible
        if (m > n) {
            return -1;
        }

        // Check every possible starting position
        for (int i = 0; i <= n - m; i++) {
            // Check if substring starting at i matches needle
            if (haystack.substring(i, i + m).equals(needle)) {
                return i;
            }
        }

        return -1;
    }
}