class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int total = 0;
        // Total sum
        for (int i = 0; i < n; i++) {
            total += cardPoints[i];
        }
        // Kitne cards nahi lene hain
        int windowSize = n - k;
        // Agar saare cards lene hain
        if (windowSize == 0) {
            return total;
        }
        // First window ka sum
        int windowSum = 0;
        for (int i = 0; i < windowSize; i++) {
            windowSum += cardPoints[i];
        }
        int minWindow = windowSum;
        // Sliding Window
        for (int i = windowSize; i < n; i++) {
            windowSum += cardPoints[i];
            windowSum -= cardPoints[i - windowSize];
            minWindow = Math.min(minWindow, windowSum);
        }
        return total - minWindow;
    }
}