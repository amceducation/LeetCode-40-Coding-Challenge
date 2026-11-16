class Solution {
    public boolean isPalindrome(int x) {
        // Negative numbers are never palindrome
        // Numbers ending with 0 (except 0 itself) are never palindrome
        // Example: 10 -> 01
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int reversedHalf = 0;
        // Reverse only half of the number
        while (x > reversedHalf) {
            reversedHalf = reversedHalf * 10 + x % 10;
            x = x / 10;
        }

        // For even length: x == reversedHalf
        // For odd length: x == reversedHalf / 10 (ignore middle digit)
        // Example: 121 -> x=12, reversedHalf=12 -> after loop x=12, reversedHalf=12
        // Actually: 121 -> x=1, reversedHalf=12 -> 1 == 12/10 = 1 -> true
        return x == reversedHalf || x == reversedHalf / 10;
    }
}