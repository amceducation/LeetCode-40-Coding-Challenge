class Solution {
    public int mySqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }

        int left = 1;
        int right = x;
        int ans = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Use long to avoid overflow: mid * mid can exceed int
            // Instead check mid == x / mid
            if (mid == x / mid) {
                return mid;
            } else if (mid < x / mid) {
                ans = mid; // mid could be answer, try bigger
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return ans;
    }
}