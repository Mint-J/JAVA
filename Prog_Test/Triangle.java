import java.util.ArrayList;

// Triangle
// https://leetcode.com/problems/triangle/description/

// Given a triangle, find the minimum path sum from top to bottom.
// Each step you may move to adjacent numbers on the row below.

// For example, given the following triangle

// [
//      [2],
//     [3,4],
//    [6,5,7],
//   [4,1,8,3]
// ]
// The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

// Note:

// Bonus point if you are able to do this using only O(n) extra space, 
// where n is the total number of rows in the triangle.

// Ideology

// [                   
//        [2],                 [2],              
//       [3,4],              [3, 4],              [2],
//      [6,5,7],      ==>   [7, 6, 10]     ==>  [9, 10]   ==>     [11]
//     [4,1,8,3]
//  ]

// Jason's - ArrayList

class Solution {
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        ArrayList<ArrayList<Integer>> a = new ArrayList<>();
        a.addAll(triangle);
        for (int i = a.size() - 2; i >= 0; i--) {
            for (int j=0; j < a.get(i+1).size() - 1; j++) {
                int min = Math.min(a.get(i+1).get(j), a.get(i+1).get(j+1));
                a.get(i).set(j, a.get(i).get(j) + min);
            }
        }
        return a.get(0).get(0);
    }
}

// Jason's - List

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        for (int i = triangle.size() - 2; i >= 0; i--) {
            for (int j=0; j < triangle.get(i+1).size() - 1; j++) {
                int min = Math.min(triangle.get(i+1).get(j), triangle.get(i+1).get(j+1));
                triangle.get(i).set(j, triangle.get(i).get(j) + min);
            }
        }
        return triangle.get(0).get(0);
    }
}

// Refer-Best

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        
        int len = triangle.size();
        int[] sums = new int[len];
        Arrays.fill(sums, Integer.MAX_VALUE);
        sums[0] = triangle.get(0).get(0);
        helper(triangle, 1, sums);
        
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            res = Math.min(res, sums[i]);
        }
        return res;
    }
    private void helper(List<List<Integer>> triangle, int level, int[] sums) {
        if (level >= triangle.size()) {
            return;
        }
        for (int i = level; i >= 0; i--) {
            if (i == 0) {
                sums[i] = sums[0];
            } else {
                sums[i] = Math.min(sums[i], sums[i - 1]);
            }
            sums[i] += triangle.get(level).get(i);
        }
        helper(triangle, level + 1, sums);
    }
}

// Refer-2

// assume triangle is ArrayList<ArrayList<Integer>>, so list.get(index) will be O(1) operation
// 不要纠结 List 的 get 操作可能是 O(n) runtime; 既然是实现某项功能，使用正确的数据结构是很重要的；如果是该function是用来作 api 使用的，那么数据结构可能是json，需要做预处理。
// 面试的时候，List 数据结构不同，所需要的runtime 也不同就可以了。

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] dp = new int[triangle.size() + 1];
        
        for (int i = triangle.size() - 1; i >= 0; i--) {
            List<Integer> list = triangle.get(i);
            for (int j = 0; j < list.size(); j++) {
                dp[j] = list.get(j) + Math.min(dp[j], dp[j + 1]);
            }
        }
        return dp[0];
    }
}