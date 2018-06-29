// Single Number
// https://leetcode.com/problems/single-number/description/

// Given a non-empty array of integers, every element appears twice except for one. Find that single one.

// Note:
// Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

// Example:

// Input: [2,2,1]
// Output: 1

// Input: [4,1,2,1,2]
// Output: 4

// Refer-Best

class Solution {
    public int singleNumber(int[] nums) {
        int ans=0;
        for(int i:nums)
            ans = ans^i;
        return ans;
    }
}

// A^B^C^B^C = A^B^B^C^C=A