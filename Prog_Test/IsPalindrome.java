// Palindrome
// https://leetcode.com/problems/palindrome-number/description/

// Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.

// Example:

// Input: 121
// Output: true

// Input: -121
// Output: false
// Explanation: From left to right, it reads -121. From right to left, it becomes 121-.

// Jason's

class Solution {
    public boolean isPalindrome(int x) {
        int palindrome = 0, origin = x;
        while (x > 0) {
            palindrome = palindrome * 10 + x % 10;
            x /= 10;
        }
        return palindrome == origin;
    }
}

// Refer-Best

class Solution {
    public boolean isPalindrome(int x) {
        long y =x;
        long a =0;
        boolean flag = true;
        if(x<0)
        {
            flag = false;
            x= -x;
        }
        while(x>0)
        {
            a= a*10 + x%10;
            x = x/10;
        }
        if (a > Integer.MAX_VALUE)
        {
            return false;
        }
        if (a == y)
            return  true;
        return false;
    }
}

// Python

// class Solution(object):
//     def isPalindrome(self, x):
//         """
//         :type x: int
//         :rtype: bool
//         """
//         return str(x)[::-1]==str(x)