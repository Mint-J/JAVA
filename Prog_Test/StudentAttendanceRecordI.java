// Student Attendance Record I
// https://leetcode.com/problems/student-attendance-record-i/description/

// You are given a string representing an attendance record for a student. 
// The record only contains the following three characters:
// 'A' : Absent.
// 'L' : Late.
// 'P' : Present.
// A student could be rewarded if his attendance record doesn't contain more than one 'A' (absent)
//  or more than two continuous 'L' (late).

// You need to return whether the student could be rewarded according to his attendance record.

// Example:

// Input: "PPALLP"
// Output: True

// Input: "PPALLL"
// Output: False

// Jason's Best. Beat 100% !!!

class Solution {
    public boolean checkRecord(String s) {
        if (s.indexOf("LLL") != -1)
            return false;
        int countA = 0;
        int len = s.length();
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == 'A')
                countA++;
            if (countA > 1)
                return false;
        }
        return true;
    }
}

// Refer-Best

class Solution {
    public boolean checkRecord(String s) {

        char[] chars = s.toCharArray();
        int abnum = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 'A')
                abnum++;
            if (abnum > 1)
                return false;
            if (chars[i] == 'L')
                if (i > 1 && chars[i - 1] == 'L' && chars[i - 2] == 'L')
                    return false;
        }

        return true;
    }
}

// Refer-1-line

class Solution {
    public boolean checkRecord(String s) {
        return !s.matches(".*LLL.*|.*A.*A.*");
    }
}