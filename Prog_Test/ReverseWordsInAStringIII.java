// Reverse Words in a String III
// https://leetcode.com/problems/reverse-words-in-a-string-iii/description/

// Given a string, you need to reverse the order of characters in each word 
// within a sentence while still preserving whitespace and initial word order.

// Example 1:
// Input: "Let's take LeetCode contest"
// Output: "s'teL ekat edoCteeL tsetnoc"
// Note: In the string, each word is separated by single space and there will 
// not be any extra space in the string.


class Solution {
    public String reverseWords(String s) {
        String res = "";
        String[] sa = s.split(" ");
        for (int i = 0; i < sa.length; i++) {
            char[] temp = sa[i].toCharArray();
            char t;
            int min = (temp.length + 1) / 2;
            for (int j=0, last=temp.length-1; j < min; j++, last--) {
                t = temp[last];
                temp[last] = temp[j];
                temp[j] = t;
            }
            if (i == sa.length - 1)
                res += new String(temp);
            else
                res += new String(temp) + " ";
            
        }
        return res;
        
    }
}

// Refer-Best

class Solution {
    public static void reverseword2(char [] ch, int l, int r){
        if(ch == null || ch.length == 0)
            return;
        while(l < r){
            char temp = ch[l];
            ch[l] = ch[r];
            ch[r] = temp;
            l++;
            r--;
        }
    }
    
    public String reverseWords(String s) {
        if(s == null || s.length() == 0)
            return s;
            
        char [] ch = s.toCharArray();
        int i = 0;
        while(i < ch.length){
            int index = s.indexOf(' ', i);
              if(index == -1){
                reverseword2(ch, i, ch.length - 1);
                break;
            }
            reverseword2(ch, i, index - 1);
            i = index + 1;
        }
        return new String(ch);
    }
}