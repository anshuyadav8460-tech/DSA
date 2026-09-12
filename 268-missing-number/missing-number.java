class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;

        int totalSum = n * (n + 1) /2 ;
        int arrSum = 0 ;

        for(int ele : nums){
            arrSum += ele;
        }
        return totalSum - arrSum ; 
    }
    
}