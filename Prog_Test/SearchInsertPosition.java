// Search Insert Position
// https://leetcode.com/problems/search-insert-position/description/

// Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

// You may assume no duplicates in the array.

// Example:

// Input: [1,3,5,6], 5
// Output: 2

// Input: [1,3,5,6], 2
// Output: 1

// Input: [1,3,5,6], 7
// Output: 4

// Input: [1,3,5,6], 0
// Output: 0

// Jason's Solution is the BEST !!!
// First Person Beat 100% !!!

class Solution {
    public int searchInsert(int[] nums, int target) {
        int mid = nums.length / 2;
        if (target < nums[mid]) {
            for (int i = 0; i < mid; i++) {
                if (target == nums[i])
                    return i;
            }
        } else if (target > nums[mid]) {
            for (int i = nums.length - 1; i > mid; i--) {
                if (target == nums[i])
                    return i;
            }
        } else
            return mid;
        for (int i = 1; i < nums.length; i++) {
            if (target > nums[i-1] && target < nums[i])
                return i;
        }
        if (target > nums[nums.length - 1])
            return nums.length;
        return 0;
    }
}