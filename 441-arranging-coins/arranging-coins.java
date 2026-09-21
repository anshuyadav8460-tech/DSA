class Solution {
    public int arrangeCoins(int n) {
        if (n == 0) return 0;
        int lo = 1;
        int hi = n;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            long coins = (long) mid * (mid + 1) / 2;
            if (coins == n) {
                return mid;
            }
            else if (coins > n) {
                hi = mid - 1;
            }
            else {
                lo = mid + 1;
            }
        }
        return hi;
    }
}