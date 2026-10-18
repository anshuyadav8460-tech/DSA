class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(
                distance(b), distance(a)
            )
        );
        for (int[] point : points) {
            pq.add(point);
            if (pq.size() > k) {
                pq.remove();
            }
        }
        int[][] ans = new int[k][2];
        for (int i = 0; i < k; i++) {
            ans[i] = pq.remove();
        }
        return ans;
    }
    public int distance(int[] point) {
        return point[0] * point[0]
             + point[1] * point[1];
    }
}
