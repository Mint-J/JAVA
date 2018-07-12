// Judge Route Circle
// https://leetcode.com/problems/judge-route-circle/description/

// Initially, there is a Robot at position (0, 0). Given a sequence of its moves, judge if this robot makes a circle, 
// which means it moves back to the original place.

// The move sequence is represented by a string. And each move is represent by a character. 
// The valid robot moves are R (Right), L (Left), U (Up) and D (down). 
// The output should be true or false representing whether the robot makes a circle.

// Example:
// Input: "UD"
// Output: true

// Input: "LL"
// Output: false

// Jason's Solution Beats 99.81% !!

class Solution {
    public boolean judgeCircle(String moves) {
        if (moves == "" || moves.length() == 0)
            return true;
        int h = 0, v = 0;
        for (char c : moves.toCharArray()) {
            if (c == 'R')
                h++;
            else if (c == 'L')
                h--;
            else if (c == 'U')
                v++;
            else
                v--;
        }
        return h==0 && v == 0 ? true : false;
    }
}

// Refer-Best

class Solution {
    
    // 7/8/18, goog onsite - HT
    public boolean judgeCircle(String moves) {
        if (moves == null || moves.length() == 0) {
            return true;
        }
        if (moves.length() % 2 == 1) { // prunning
            return false;
        }
        
        int[] cache = new int[26];
        for (char c : moves.toCharArray()) {
            cache[c - 'A']++;
        }
        
        return cache['U' - 'A'] == cache['D' - 'A'] && cache['L' - 'A'] == cache['R' - 'A'];
    }
}