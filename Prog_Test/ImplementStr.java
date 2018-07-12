// Implement strStr()
//  https://leetcode.com/problems/implement-strstr/description/

// Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

// Example:

// Input: haystack = "hello", needle = "ll"
// Output: 2

// Input: haystack = "aaaaa", needle = "bba"
// Output: -1

// Clarification:

// What should we return when needle is an empty string? 
// This is a great question to ask during an interview.

// For the purpose of this problem, we will return 0 when needle is an empty string. 
// This is consistent to C's strstr() and Java's indexOf().




class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0)
            return 0;
        if (haystack.length() < needle.length())
            return -1;
        if (needle.length() == haystack.length())
            return needle.equals(haystack) ? 0 : -1;
        for (int i = 0; i< haystack.length(); i++){
            int h = i;
            int n = 0;
            while (h < haystack.length() && n < needle.length() && haystack.charAt(h) == needle.charAt(n)){
                h++;
                n++;
            }
            if (n == needle.length())
                return i;
        }
        return -1;
        
    }
}

// Refer

class Solution{
    public int strStr(String haystack, String needle) {
        for (int i = 0; ; i++) {
            for (int j = 0; ; j++) {
                if (j == needle.length()) return i;
                if (i + j == haystack.length()) return -1;
                if (needle.charAt(j) != haystack.charAt(i + j)) break;
            }
        }
    }
}

// Refer-Best

class Solution {
    public int strStr(String haystack, String needle) {
         return haystack.indexOf(needle);
    }
}