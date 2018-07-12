// Length of Last Word
// https://leetcode.com/problems/length-of-last-word/description/

// Given a string s consists of upper/lower-case alphabets and empty space characters ' ', 
// return the length of last word in the string.

// If the last word does not exist, return 0.

// Note: A word is defined as a character sequence consists of non-space characters only.

// Example:
// Input: "Hello World" Output: 5

class Solution {
    public int lengthOfLastWord(String s) {
        return s.trim().length() - s.trim().lastIndexOf(" ") - 1;
    }
}

// Refer-Best

class Solution {
    public int lengthOfLastWord(String s) {
        
        int count = 0;
        boolean lastword = false;
        for(int i = s.length() - 1; i >= 0; i--){
            if(s.charAt(i) != ' '){
                lastword = true;
                count++;
            }
            else{
                
                if(lastword == true){
                    break;
                }
                
            }
        }
        return count;
    }
}