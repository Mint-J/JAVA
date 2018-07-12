// Sum of Square Numbers
// https://leetcode.com/problems/sum-of-square-numbers/description/

// Given a non-negative integer c, your task is to decide whether 
// there're two integers a and b such that a2 + b2 = c.

// Example:

// Input: 5
// Output: True
// Explanation: 1 * 1 + 2 * 2 = 5

// Input: 3
// Output: False

class Solution {
    public boolean judgeSquareSum(int c) {
        if (c < 0)
            return false;
        int l = 0, r = (int) Math.sqrt(c);
        while (l <= r) {
            int s = l * l + r * r;
            if (s < c) {
                l++;
            } else if (s > c) {
                r--;
            } else {
                return true;
            }
        }
        return false;
    }
}

// Solutions :https://leetcode.com/articles/sum-of-square-numbers/