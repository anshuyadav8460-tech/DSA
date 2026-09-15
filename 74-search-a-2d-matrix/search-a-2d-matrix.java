class Solution {
    public boolean searchMatrix(int[][] arr, int target) {

        int rows = arr.length;
        int cols = arr[0].length;

        int left = 0;
        int right = rows * cols - 1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            // 1D index ko 2D index mein convert
            int row = mid / cols;
            int col = mid % cols;

            if (arr[row][col] == target) {
                return true;
            }
            else if (arr[row][col] < target) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }

        return false;
    }
}