// Longest Common Prefix
// https://leetcode.com/problems/longest-common-prefix/description/

// Write a function to find the longest common prefix string amongst an array of strings.

// If there is no common prefix, return an empty string "".

// Example:

// Input: ["flower","flow","flight"]
// Output: "fl"

// Input: ["dog","racecar","car"]
// Output: ""
// Explanation: There is no common prefix among the input strings.


class Solution {

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0 || strs == null)
            return "";
        return LCP(strs, 0, strs.length - 1);
    }

    String LCP(String[] strs, int l, int r) {
        if (l == r) {
            return strs[l];
        } else {
            int mid = (l + r) / 2;
            String lcpLeft = LCP(strs, l, mid);
            String lcpRight = LCP(strs, mid + 1, r);
            return commonPrefix(lcpLeft, lcpRight);
        }
    }

    String commonPrefix(String l, String r) {
        int min = Math.min(l.length(), r.length());
        for (int i = 0; i < min; i++) {
            if(l.charAt(i) != r.charAt(i))
                return l.substring(0, i);
        }
        return l.substring(0,min);
    }

}