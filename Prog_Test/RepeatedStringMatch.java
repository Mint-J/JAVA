// Repeated String Match
// https://leetcode.com/problems/repeated-string-match/description/

// Given two strings A and B, find the minimum number of times A has to be repeated 
// such that B is a substring of it. If no such solution, return -1.

// For example, with A = "abcd" and B = "cdabcdab".

// Return 3, because by repeating A three times (“abcdabcdabcd”), B is a substring of it; 
// and B is not a substring of A repeated two times ("abcdabcd").

// Note: The length of A and B will be between 1 and 10000.

class Solution {
    public int repeatedStringMatch(String A, String B) {
        int times = 1;
        String t = A;
        for (; times * t.length() <= 10000; times++) {
            if (A.contains(B))
                return times;
            else
                A = A.concat(t);
        }
        return -1;
    }
}

// Refer-Best

class Solution {
    public int repeatedStringMatch(String A, String B) {
        
        int bLen = B.length();
        int aLen = A.length();
        if(bLen < aLen){
            return  A.contains(B)? 1 : (A+A).contains(B) ? 2 : -1;
        }
        int firstOccur = B.indexOf(A);
        if(firstOccur < 0)
            return (A+A).contains(B)? 2 : -1;
        
        if(firstOccur >= aLen)
            return -1;
        int k = (bLen - firstOccur)/aLen;
        if(aLen * k < (bLen - firstOccur)){
            int newStart = firstOccur+aLen * k;
            int lenLeft = bLen - newStart;
            if(!A.substring(0, lenLeft).equals(B.substring(newStart)))
                return -1;
            k++;
        }
        if(firstOccur > 0){
            if(!A.substring(aLen - firstOccur).equals(B.substring(0, firstOccur)))
                return -1;
            k++;
        }
        while(firstOccur+aLen < bLen){
            if(!A.equals(B.substring(firstOccur, firstOccur+aLen)))
                return -1;
            firstOccur+=aLen;
        }
        return k;
    }
}