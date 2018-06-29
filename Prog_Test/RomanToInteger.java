// Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
// https://leetcode.com/problems/roman-to-integer/description/ 

// Symbol       Value
// I             1
// V             5
// X             10
// L             50
// C             100
// D             500
// M             1000
// For example, two is written as II in Roman numeral, just two one's added together. 
// Twelve is written as, XII, which is simply X + II. The number twenty seven is written as XXVII, 
// which is XX + V + II.

// Roman numerals are usually written largest to smallest from left to right. 
// However, the numeral for four is not IIII. Instead, the number four is written as IV. 
// Because the one is before the five we subtract it making four. 
// The same principle applies to the number nine, which is written as IX. 
// There are six instances where subtraction is used:

// I can be placed before V (5) and X (10) to make 4 and 9. 
// X can be placed before L (50) and C (100) to make 40 and 90. 
// C can be placed before D (500) and M (1000) to make 400 and 900.
// Given a roman numeral, convert it to an integer. Input is guaranteed to be within the range from 1 to 3999.

// Example 1:

// Input: "III"
// Output: 3

// Input: "IV"
// Output: 4

// Input: "IX"
// Output: 9

// Input: "LVIII"
// Output: 58
// Explanation: C = 100, L = 50, XXX = 30,  III = 3.

// Input: "MCMXCIV"
// Output: 1994
// Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.

// Jason's Method

import java.util.HashMap;
import java.util.Map;

class Solution {
    
    private static Map<Character, Integer> romanMap = createMap();
    
    public int romanToInt(String s) {
        int result = 0;

        for (int i = 0; i < s.length(); i ++) {
            int current = romanMap.get(s.charAt(i));
            if (i < s.length() - 1 && current < romanMap.get(s.charAt(i+1))) {
                result += romanMap.get(s.charAt(i+1)) - current;
                i++; // Two characters combine to make one Integer; Eg: IV-4
            } else {
                result += current;
            }
        }

        return result;
    }

    private static Map<Character, Integer> createMap(){
        final Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        return map;
    }
}

// Refer-1

class Solution {
    public int romanToInt(String s) {
        int result = 0;
        int prev = 1001;
        
        for (char c : s.toCharArray()) {
            int curr = 0;
            switch (c) {
                case 'I':
                    curr = 1;
                    break;
                case 'V':
                    curr = 5;
                    break;
                case 'X':
                    curr = 10;
                    break;
                case 'L':
                    curr = 50;
                    break;
                case 'C':
                    curr = 100;
                    break;
                case 'D':
                    curr = 500;
                    break;
                case 'M':
                    curr = 1000;
                    break;
            }
            if (prev < curr) {
                result = result - 2 * prev;
            }
            result += curr;
            prev = curr;
        }
        
        return result;
    }
}

// Refer-2-Best

class Solution {
    public int romanToInt(String s) {
     int nums[]=new int[s.length()];
     for(int i=0;i<s.length();i++){
         switch (s.charAt(i)){
             case 'M':
                 nums[i]=1000;
                 break;
             case 'D':
                 nums[i]=500;
                 break;
             case 'C':
                 nums[i]=100;
                 break;
             case 'L':
                 nums[i]=50;
                 break;
             case 'X' :
                 nums[i]=10;
                 break;
             case 'V':
                 nums[i]=5;
                 break;
             case 'I':
                 nums[i]=1;
                 break;
         }
     }
     int sum=0;
     for(int i=0;i<nums.length-1;i++){
         if(nums[i]<nums[i+1])
             sum-=nums[i];
         else
             sum+=nums[i];
     }
     return sum+nums[nums.length-1];
 }
 }

