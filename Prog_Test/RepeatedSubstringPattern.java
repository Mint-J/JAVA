// Repeated Substring Pattern
// https://leetcode.com/problems/repeated-substring-pattern/description/

// Given a non-empty string check if it can be constructed by taking a substring of it 
// and appending multiple copies of the substring together. 
// You may assume the given string consists of lowercase English letters only and 
// its length will not exceed 10000.

// Example:
// Input: "abab"   Output: True
// Explanation: It's the substring "ab" twice.
// Input: "aba"    Output: False
// Input: "abcabcabcabc"   Output: True
// Explanation: It's the substring "abc" four times. (And the substring "abcabc" twice.)


class Solution {
    public boolean repeatedSubstringPattern(String s) {
        String str = s + s;
        return str.substring(1, str.length() - 1).contains(s);
    }
}

// Explanation:
// The program first copies the original str and makes it twice longer. 
// Let's say the given str = "abab". We will have s = "abab abab" 
// (I put a blank space in the middle to make it clear). 
// Then we get the substring of s by dropping the first and last character, 
// which is "a(bab aba)b" (string inside parenthesis is the substring we get). 
// If the original str is repeated, we can construct it from the substring we just get. 
// This is because we can get some part of str from the first pattern ("bab") and 
// get the other part from the second pattern ("aba"). This works only if 
// str consisted of its repeated substring, otherwise we cannot get str from the s.

// Refer-Best

class Solution {
    public boolean repeatedSubstringPattern(String s) {
        if (s.length() == 1) return false;

        int len = s.length(), mid = len / 2; // half
        if (s.substring(0, mid).equals(s.substring(mid))) return true;

        int one_third = len/3; // 1/3
        String sub = s.substring(0, one_third);
        if (sub.equals(s.substring(one_third, one_third * 2))
                && sub.equals(s.substring(one_third * 2))) return true;

        if (len % 2 == 1) { // odd number of characters
            char c = s.charAt(0);
            for (int i = 1; i < len; i++) {
                if (s.charAt(i) != c) return false;
            }
            return true;
        }

        return false;
    }
}