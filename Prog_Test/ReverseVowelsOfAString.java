import java.util.Arrays;
// Reverse Vowels of a String
// https://leetcode.com/problems/reverse-vowels-of-a-string/description/

// Write a function that takes a string as input and reverse only the vowels of a string.

// Example 1:
// Given s = "hello", return "holle".

// Example 2:
// Given s = "leetcode", return "leotcede".

// Note:
// The vowels does not include the letter "y".

class Solution {
    public String reverseVowels(String s) {
        if(s == null || s.length() == 0) return "";
        char [] c = s.toCharArray();
        String vowels = "aeiouAEIOU";
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            while (start < end && !vowels.contains(c[start] + ""))
                start++;
            while (start < end && !vowels.contains(c[end] + ""))
                end--;
            char t = c[start];
            c[start] = c[end];
            c[end] = t;
            start++;
            end--;
        }
        return String.valueOf(c);
    }
}

// Refer-Best

class Solution {
    public String reverseVowels(String s) {
        boolean[] arr = new boolean[128];
        arr['a'] = true;
        arr['e'] = true;
        arr['i'] = true;
        arr['o'] = true;
        arr['u'] = true;
        arr['A'] = true;
        arr['E'] = true;
        arr['I'] = true;
        arr['O'] = true;
        arr['U'] = true;
        
        char[] str = s.toCharArray();
        int l = 0, r = str.length - 1;
        while (l < r) {
            while (l < r && !arr[str[l]]) {
                l++;
            }
            while (l < r && !arr[str[r]]) {
                r--;
            }
            if (l < r) {
                char t = str[l];
                str[l] = str[r];
                str[r] = t;
            }
            l++;
            r--;
        }
        return String.valueOf(str);
    }
}