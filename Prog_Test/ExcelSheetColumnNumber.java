// Excel Sheet Column Number
// https://leetcode.com/problems/excel-sheet-column-number/description/

// Given a column title as appear in an Excel sheet, return its corresponding column number.

// For example:

//     A -> 1
//     B -> 2
//     C -> 3
//     ...
//     Z -> 26
//     AA -> 27
//     AB -> 28 
//     ...

// Example:

// Input: "A"
// Output: 1

// Input: "ZY"
// Output: 701

class Solution {
    public int titleToNumber(String s) {
        int res = 0;
        int len = s.length();
        for (int i = 0; i < s.length(); i++) {
            res += ((char)(s.charAt(i)-64) * Math.pow(26, len-- - 1));
        }
        return res;
    }
}

// Refer-Best

class Solution {
    public int titleToNumber(String s) {
        int num = 0;
        int exp = 1;
        
        for(int i = s.length() - 1; i >= 0; --i){
            num += (s.charAt(i) - 'A' + 1) * exp;
            exp *= 26;
        }
        
        return num;
    }
}