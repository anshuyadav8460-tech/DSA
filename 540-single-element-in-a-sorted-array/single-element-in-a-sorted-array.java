class Solution {
    public int singleNonDuplicate(int[] arr) {
        int lo = 0;
        int hi = arr.length - 1;

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;

            // Make mid even
            if (mid % 2 == 1) {
                mid--;
            }

            // If the pair is intact, single element is to the right
            if (arr[mid] == arr[mid + 1]) {
                lo = mid + 2;
            } 
            // Otherwise, single element is at mid or to the left
            else {
                hi = mid;
            }
        }

        return arr[lo];
    }
}
