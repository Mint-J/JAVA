// Move Zeros
// https://leetcode.com/problems/move-zeroes/description/

// Given an array nums, write a function to move all 0's to the end of it 
// while maintaining the relative order of the non-zero elements.

// Example:

// Input: [0,1,0,3,12]
// Output: [1,3,12,0,0]
// Note:

// You must do this in-place without making a copy of the array.
// Minimize the total number of operations.

class Solution {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int inputIndex = 0;
        for (int n : nums) {
            if ( n != 0)
                nums[inputIndex++] = num;
        }
        while (inputIndex < nums.length)
            nums[inputIndex++] = 0;
    }
}