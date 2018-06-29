// Four Sum
// https://leetcode.com/problems/4sum/description/

// Given an array nums of n integers and an integer target, are there elements a, b, c, 
// and d in nums such that a + b + c + d = target? 
// Find all unique quadruplets in the array which gives the sum of target.
// Note:

// The solution set must not contain duplicate quadruplets.

// Example:

// Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.

// A solution set is:
// [
//   [-1,  0, 0, 1],
//   [-2, -1, 1, 2],
//   [-2,  0, 0, 2]
// ]

// Jason's Method

import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    // Not available for [0,0,0,0] and a target 0;
    // For ideal one, refer to fourSumRefer();
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null) {
            return res;
        }
        for (int i = 0; i < nums.length - 4; i++) {
            if (i == 0 || nums[i] != nums[i-1]) {
                for (int j = i+1; j < nums.length - 3; j++) {
                    if (j == i+1 || nums[j] != nums[j-1]) {
                        int l = j+1;    int r = nums.length - 1;
                        int sumOfPostTwoInt = target - nums[i] - nums[j];
                        while(l < r){
                            if((nums[l] + nums[r]) == sumOfPostTwoInt){
                                res.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                                while(l < r && nums[l] == nums[l+1]) l++;
                                while(l < r && nums[r] == nums[r-1]) r--;
                                l++; r--;
                            } else if ((nums[l] + nums[r]) < sumOfPostTwoInt) {
                                l++;
                            } else {
                                r--;
                            }
                        }
                    }
                }
            }
        }
        return res;
    }
}

// Refer-Best

class Solution {
    public List<List<Integer>> fourSum(int[] num, int target) {
        ArrayList<List<Integer>> ans = new ArrayList<>();
        if(num.length<4)return ans;
        Arrays.sort(num);
        for(int i=0; i<num.length-3; i++){
            if(num[i]+num[i+1]+num[i+2]+num[i+3]>target)break; //first candidate too large, search finished
            if(num[i]+num[num.length-1]+num[num.length-2]+num[num.length-3]<target)continue; //first candidate too small
            if(i>0&&num[i]==num[i-1])continue; //prevents duplicate result in ans list
            for(int j=i+1; j<num.length-2; j++){
                if(num[i]+num[j]+num[j+1]+num[j+2]>target)break; //second candidate too large
                if(num[i]+num[j]+num[num.length-1]+num[num.length-2]<target)continue; //second candidate too small
                if(j>i+1&&num[j]==num[j-1])continue; //prevents duplicate results in ans list
                int low=j+1, high=num.length-1;
                while(low<high){
                    int sum=num[i]+num[j]+num[low]+num[high];
                    if(sum==target){
                        ans.add(Arrays.asList(num[i], num[j], num[low], num[high]));
                        while(low<high&&num[low]==num[low+1])low++; //skipping over duplicate on low
                        while(low<high&&num[high]==num[high-1])high--; //skipping over duplicate on high
                        low++; 
                        high--;
                    }
                    //move window
                    else if(sum<target)low++; 
                    else high--;
                }
            }
        }
        return ans;
    }
}

// Refer-2

class Solution {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        int len = nums.length;
        if (nums == null || len < 4)
            return res;

        Arrays.sort(nums);

        int max = nums[len - 1], i, z;
        if (nums[0] * 4 > target || max * 4 < target)
            return res;
        for (i = 0; i < len; i++) {
            z = nums[i];
            if (i > 0 && z == nums[i - 1])
                continue; // Duplicate
            if (z + 3 * max < target)
                continue; // Too small
            if (z * 4 > target)
                break; // Too big
            if (z * 4 == target) {
                if (i + 3 < len && nums[i + 3] == z) 
                    res.add(Arrays.asList(z, z, z, z));
                break;
            }
            threeSumForFourSum(nums, target - z, i + 1, len - 1, res, z);

        }
        return res;
    }

/*
 * Find all possible distinguished three numbers adding up to the target
 * in sorted array nums[] between indices low and high. If there are,
 * add all of them into the ArrayList fourSumList, using
 * fourSumList.add(Arrays.asList(z1, the three numbers))
 */

    public void threeSumForFourSum(int[] nums, int target, int low, int high, List<List<Integer>> res, int prez) {
        if (low + 1 >= high)
            return;
        int max = nums[high];
        if (3 * nums[low] > target || 3 * max < target)
            return;

        int i, z;
        for (i = low; i < high - 1; i++) {
            z = nums[i];
            if (i > low && z == nums[i - 1])
                continue; // Duplicate
            if (z + 2 * max < target)
                continue; // Too small
            if (3 * z > target)
                break; // Too big
            if (3 * z == target) {
                if (i + 1 < high && nums[i + 2] == z) 
                    res.add(Arrays.asList(prez, z, z, z));
                break;
            }
            twoSumForFourSum(nums, target - z, i + 1, high, res, prez, z);
        }
    }

/*
 * Find all possible distinguished two numbers adding up to the target
 * in sorted array nums[] between indices low and high. If there are,
 * add all of them into the ArrayList fourSumList, using
 * fourSumList.add(Arrays.asList(z1, z2, the two numbers))
 */

    public void twoSumForFourSum(int[] nums, int target, int low, int high, List<List<Integer>> res, int z1, int z2) {
        if (low >= high)
            return;
        int max = nums[high];
        if (2 * nums[low] > target || 2 * max < target)
            return;

        int i = low, j = high, sum, temp;
        while (i < j) {
            sum = nums[i] + nums[j];
            if (sum == target) {
                res.add(Arrays.asList(z1, z2, nums[i], nums[j]));
                temp = nums[i];
                while (++i < j && temp == nums[i]);
                temp = nums[j];
                while (i < --j && temp == nums[j]);
            }
            if (sum < target)
                i++;
            if (sum > target)
                j--;
        }
        return;
    }
}