class Solution {
    public int[] plusOne(int[] digits) {
        // Start from last digit
        for (int i = digits.length - 1; i >= 0; i--) {
            // If digit < 9, just +1 and done
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            // If digit == 9, make it 0 and carry to next
            digits[i] = 0;
        }

        // If we reach here, all were 9 -> e.g. [9,9,9] -> [1,0,0,0]
        int[] result = new int[digits.length + 1];
        result[0] = 1;
        return result;
    }
}