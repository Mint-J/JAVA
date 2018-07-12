// House Robber II
// https://leetcode.com/problems/house-robber-ii/description/

// You are a professional robber planning to rob houses along a street. 
// Each house has a certain amount of money stashed. All houses at this place are arranged in a circle. 
// That means the first house is the neighbor of the last one. 
// Meanwhile, adjacent houses have security system connected and it will automatically contact the police 
// if two adjacent houses were broken into on the same night.

// Given a list of non-negative integers representing the amount of money of each house, 
// determine the maximum amount of money you can rob tonight without alerting the police.

// Example:

// Input: [2,3,2]
// Output: 3
// Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2),
//              because they are adjacent houses.

// Input: [1,2,3,1]
// Output: 4
// Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
//              Total amount you can rob = 1 + 3 = 4.

// Refer-Better-Understanding

class Solution {
    public int rob(int[] nums) {
        if (nums.length < 1)
            return 0;
        if (nums.length < 2)
            return nums[0];
        return Math.max(rob(new int[nums.length], nums, 0, nums.length - 1),
                rob(new int[nums.length], nums, 1, nums.length));
    }

    private int rob(int[] robb, int[] nums, int l, int r) {
        if (l == 0) {
            robb[0] = nums[0];
            robb[1] = Math.max(nums[0], nums[1]);
        } else
            robb[1] = nums[1];
        for (int i = 2; i < r; i++) {
            robb[i] = Math.max(robb[i - 2] + nums[i], robb[i - 1]);
        }
        return robb[r - 1];
    }
}

// Refer-Best

class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int first = -1, last = -1;
        for (int i = 0; i < 2; i++) {
            int prev = 0, curr = 0, temp = 0;
            for (int j = i; j < nums.length - 1 + i; j++, prev = temp) {
                temp = curr;
                if (prev + nums[j] > curr) {
                    curr = prev + nums[j];
                }
            }
            if (i == 0) {
                first = curr;
            } else {
                last = curr;
            }
        }
        return first > last ? first : last;
    }
}
