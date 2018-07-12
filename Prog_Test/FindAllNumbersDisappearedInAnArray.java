import java.util.ArrayList;
import java.util.List;

// Find All Numbers Disappeared in an Array
// https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/description/

// Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear 
// twice and others appear once.

// Find all the elements of [1, n] inclusive that do not appear in this array.

// Could you do it without extra space and in O(n) runtime? You may assume the returned list 
// does not count as extra space.

// Example:

// Input:
// [4,3,2,7,8,2,3,1]

// Output:
// [5,6]

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int [] temp = new int[nums.length];
        for (int i = 0; i < nums.length; i++)
            temp[nums[i] - 1]++;
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < temp.length; i++){
            if (temp[i] == 0)
                res.add(i + 1);
        }
        return res;
    }
}

// Refer-Best

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) 
    {
		List<Integer> ans= new ArrayList<Integer>();
		boolean arr[]=new boolean[nums.length+1];
		for(int i=0;i<nums.length;i++)
		{
			arr[nums[i]]=true;
		}
		for(int i=1;i<arr.length;i++)
		{
			if(arr[i]==false)
				ans.add(i);
		}
		return ans;
    }
}