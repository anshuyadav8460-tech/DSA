class Solution {
    public int mySqrt(int n) {
        int lo = 0, hi = n;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            long square = (long) mid * mid;

            if (square == n) {
                return mid;
            } else if (square > n) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return hi; // floor(sqrt(n))
    }
}