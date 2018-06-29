// Two Sum
// https://leetcode.com/problems/two-sum/description/

// Given an array of integers, return indices of the two numbers such that they add up to a specific target.

// You may assume that each input would have exactly one solution, and you may not use the same element twice.

// Example:

// Given nums = [2, 7, 11, 15], target = 9,

// Because nums[0] + nums[1] = 2 + 7 = 9,
// return [0, 1].

// Jason's

class Solution {
  
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1 ; j < nums.length; j++) {
                if (nums[i] == target - nums[j]) {
                    return new int[] {i,j};
                }
            }
        }
        throw new IllegalArgumentException("NoTwoSumException");
    }
}

// Refer-Best

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] map = new int [20050];
        int diff, d, size = 4; 
        for (int i = 0; i < nums.length; i++) {
            map[nums[i] + size] = i + 1;
            diff = target - nums [i + 1] + size;
            if (diff < 0) continue; 
            d = map[diff];
            if (d > 0) 
                return new int[] {d-1, i+1};
        }
        return null;
    }
}

