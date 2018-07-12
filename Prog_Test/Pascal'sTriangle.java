import java.util.List;

// Pascal's Triangle
// https://leetcode.com/problems/pascals-triangle/description/

// Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.
// In Pascal's triangle, each number is the sum of the two numbers directly above it.

// Example:

// Input: 5
// Output:
// [
//      [1],
//     [1,1],
//    [1,2,1],
//   [1,3,3,1],
//  [1,4,6,4,1]
// ]

// Refer-Better-Understanding

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new List<>();
        List<Integer> now, pre = null;
        for (int i = 0; i < numRows; i++) {
            now = new List<Integer>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i)
                    now.add(1);
                else
                    now.add(pre.get(j-1) + pre.get(j));
            }
            pre = now;
            res.add(now);
        }
        return res;
    }
}