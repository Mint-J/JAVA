// Maximum Product Subarray
// https://leetcode.com/problems/maximum-product-subarray/description/

// Given an integer array nums, find the contiguous subarray within an array 
// (containing at least one number) which has the largest product.

// Example:

// Input: [2,3,-2,4]
// Output: 6

// Input: [-2,0,-1]
// Output: 0
// Explanation: The result cannot be 2, because [-2,-1] is not a subarray.

class Solution {
    public int maxProduct(int[] nums) {
        int r = nums[0];
        for (int i = 1, tmax = r, tmin = r; i < nums.length; i++) {
            if (nums[i] < 0) {
                tmax = tmax + tmin;
                tmin = tmax - tmin;
                tmax = tmax - tmin;
            }
            tmax = Math.max(tmax * nums[i], nums[i]);
            tmin = Math.min(tmin * nums[i], nums[i]);
            r = Math.max(r, tmax);
        }
        return r;
    }
}