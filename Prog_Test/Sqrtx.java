// Sqrt(x)
// https://leetcode.com/problems/sqrtx/description/

// Implement int sqrt(int x).

// Compute and return the square root of x, where x is guaranteed to be a non-negative integer.

// Since the return type is an integer, the decimal digits are truncated and only the integer 
// part of the result is returned.

// Example:

// Input: 4
// Output: 2

// Input: 8
// Output: 2
// Explanation: The square root of 8 is 2.82842..., and since 
//              the decimal part is truncated, 2 is returned.

// Jason's 99.97% !!

class Solution {
    public int mySqrt(int x) {
        return (int)Math.sqrt(x);
    }
}

// Refer-Best

class Solution {
    public int mySqrt(int x) {
        long left = 1, right = x;
        while (left + 1 < right) {
            long mid = (left + right) / 2;
            long m = mid * mid;
            if (m > x) right = mid;
            else if (m < x) left = mid;
            else return (int)mid;
        }
        return (int)(right * right > x? left : right);
    }
}