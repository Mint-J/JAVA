// Pow(x, n)
// https://leetcode.com/problems/powx-n/description/

// Implement pow(x, n), which calculates x raised to the power n (xn).

// Example:

// Input: 2.00000, 10
// Output: 1024.00000

// Input: 2.10000, 3
// Output: 9.26100

// Input: 2.00000, -2
// Output: 0.25000
// Explanation: 2-2 = 1/22 = 1/4 = 0.25

// Note:
// -100.0 < x < 100.0
// n is a 32-bit signed integer, within the range [−231, 231 − 1]


// 5 different choices when talk with interviewers

// nest myPow
class Solution {
    double myPow(double x, int n) {
        if (n < 0)
            return 1 / x * myPow(1 / x, -(n + 1));
        if (n == 0)
            return 1;
        if (n == 2)
            return x * x;
        if (n % 2 == 0)
            return myPow(myPow(x, n / 2), 2);
        else
            return x * myPow(myPow(x, n / 2), 2);
    }
}

// double myPow
class Solution {
    double myPow(double x, int n) {
        if (n == 0)
            return 1;
        double t = myPow(x, n / 2);
        if (n % 2)
            return n < 0 ? 1 / x * t * t : x * t * t;
        else
            return t * t;
    }
}

// double x
class Solution {
    double myPow(double x, int n) {
        if (n == 0)
            return 1;
        if (n < 0) {
            x = 1 / x;
            return n % 2 == 0 ? myPow(x * x, -(n/2)) : x * myPow(x * x, -(n/2));
        }
        return n % 2 == 0 ? myPow(x * x, n / 2) : x * myPow(x * x, n / 2);
    }
}
// As we know MAX_INT32 < -MIN_INT32, so if we directly write like this n = -n 
// then overflow will happen. However, if we write n = n/2, n = -n or just n = -(n/2), 
// then we will avoid overflow :-)

// iterative one
class Solution {
    double myPow(double x, int n) {
        if (n == 0)
            return 1;
        if (n < 0) {
            n = -n;
            x = 1 / x;
        }
        double ans = 1;
        while (n > 0) {
            if (n & 1)
                ans *= x;
            x *= x;
            n >>= 1;
        }
        return ans;
    }
}
// bit operation