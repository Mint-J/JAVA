// Reverse String II
// https://leetcode.com/problems/reverse-string-ii/description/

// Given a string and an integer k, you need to reverse the first k characters 
// for every 2k characters counting from the start of the string. 
// If there are less than k characters left, reverse all of them. 
// If there are less than 2k but greater than or equal to k characters, 
// then reverse the first k characters and left the other as original.

// Example:
// Input: s = "abcdefg", k = 2
// Output: "bacdfeg"

// Restrictions:
// The string consists of lower English letters only.
// Length of the given string and k will in the range [1, 10000]

class Solution {
    public String reverseStr(String s, int k) {
        char[] c = s.toCharArray();
        char t;
        for (int left = 0; left < c.length; left += 2 * k) {
            for (int i = 0, j = Math.min(left + k - 1, c.length - 1); i < j ; i++, j--) {
            t = c[i];
            c[i] = c[j];
            c[j] = t;
            }
        }
        return String.valueOf(c);
    }
}

// Refer-Best

class Solution {
    boolean check = false;
    public String reverseStr(String s, int k) { //testin 2
        char[] c = s.toCharArray(); //t e s t i n
        int i = 0;
        while(!check) {
             reverse(i, i + k - 1, c);
             i += 2*k;
        }
        return new String(c);
    }
    
    public void reverse(int from, int to, char[] c) {
            int start = from; //4
            int end = to;
            if(end >= c.length) {
              check = true;  
              end = c.length - 1;  
            } 
             while(start < end) { 
                 char temp = c[start];
                 c[start] = c[end];
                 c[end] = temp;
                 start++;
                 end--;
             }
    }
}