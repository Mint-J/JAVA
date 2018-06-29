// Plus One
// https://leetcode.com/problems/plus-one/description/

// Given a non-empty array of digits representing a non-negative integer, plus one to the integer.

// The digits are stored such that the most significant digit is at the head of the list, 
// and each element in the array contain a single digit.

// You may assume the integer does not contain any leading zero, except the number 0 itself.

// Example:

// Input: [1,2,3]
// Output: [1,2,4]
// Explanation: The array represents the integer 123.

// Input: [4,3,2,1]
// Output: [4,3,2,2]
// Explanation: The array represents the integer 4321.

// Refer-1

class Solution{
    public int[] plusOne(int[] digits) {
            
        int n = digits.length;
        for(int i=n-1; i>=0; i--) {
            if(digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            
            digits[i] = 0;
        }
        
        int[] newNumber = new int [n+1];
        newNumber[0] = 1;
        
        return newNumber;
    }
}

// Refer-Best

class Solution {
    public int[] plusOne(int[] digits) {
        int l = digits.length - 1;
        if(digits[l] < 9) {
            digits[l]++;
            return digits;
        }
        
        while(l >= 0 && digits[l] == 9) {
            digits[l] = 0;
            l--;
        }
        if(l < 0) {
            int[] res = new int[digits.length + 1];
            res[0] = 1;
            for (int i = 0; i < digits.length; i++) {
                res[i + 1] = digits[i];
            }
            digits = res;
        } else {
            digits[l]++;
        }
        return digits;
    }
}