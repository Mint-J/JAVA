// Reverse String
// https://leetcode.com/problems/reverse-string/description/

// Write a function that takes a string as input and returns the string reversed.

// Example:
// Given s = "hello", return "olleh".

class Solution {
    public String reverseString(String s) {
        char[] res = s.toCharArray();
        int i = res.length - 1;
        int j = 0;
        while (i < j) {
            char temp = res[i];
            res[i] = res[j];
            res[j] = temp;
            i--;
            j++;
        }
        return res.toString();
    }
}

// Refer-Best

class Solution {
    public String reverseString(String s) {
        char[] c = s.toCharArray();
        int l = c.length-1;
        int mid = (l+1)/2;
        char t;
        for(int i=0; i<mid; i++){
            t = c[i];
            c[i] = c[l-i]; // Soooo Clever !!!
            c[l-i] = t;
        }
        return String.valueOf(c);
    }
}