// Three Sum
// https://leetcode.com/problems/3sum/description/

// Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

// Note:

// The solution set must not contain duplicate triplets.

// Example:

// Given array nums = [-1, 0, 1, 2, -1, -4],

// A solution set is:
// [
//   [-1, 0, 1],
//   [-1, -1, 2]
// ]

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// Jason's

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        Arrays.sort(nums);
        
        List<List<Integer>> res = new ArrayList<>();
        
        for (int i=0 ; i < nums.length - 2 ; i ++) {
            if (i == 0 || nums[i] != nums[i-1]) {
                int low = i + 1;
                int high = nums.length - 1;
                int sum = 0 - nums[i];
                while (low < high) {
                    if ((nums[low] + nums[high]) == sum) {
                        res.add(Arrays.asList(nums[i], nums[low], nums[high]));
                        while (low < high && nums[low] == nums[low + 1]) low++;
                        while (low < high && nums[high] == nums[high - 1]) high--;
                        low++;
                        high--;
                    } else if ((nums[low] + nums[high]) < sum) {
                        low++;
                    } else {
                        high--;
                    }
                    
                }
            }
        }
        return res;
    }
}

// Refer-Best

public final class Solution {
	static final class ResultList extends AbstractList<List<Integer>>
	{
		final int[][] values = new int[1<<14][3];
		int size;
		void add(int a, int b, int c){
			int[] r = values[size++];
			r[0] = a;
			r[1] = b;
			r[2] = c;
		}
		void reset(){
			size = 0;
		}
		public int size(){
			return size;
		}
		public List<Integer> get(int index){
			final int[] r = values[index];
			return new AbstractList<Integer>(){
				public int size(){return 3;}
				public Integer get(int index){return r[index];}
			};
		}
	}
	private static ResultList rs = new ResultList();
	private static int[] __negs = new int[2048];
	private static int[] __poses = new int[2048];
	private static int[] __map = new int[1<<18];
	public static List<List<Integer>> threeSum(int[] nums) {
		if(nums.length<3) return Collections.emptyList();
		rs.reset();
		int minValue = Integer.MAX_VALUE;
		int maxValue = Integer.MIN_VALUE;
		int negSize = 0;
		int posSize = 0;
		int zeroSize = 0;
		for(int v :nums){
			if(v<minValue) minValue = v;
			if(v>maxValue) maxValue = v;
			if(v > 0) posSize ++;
			else if(v<0) negSize ++;
			else zeroSize ++;
		}
		if(zeroSize >= 3)
			rs.add(0,0,0);
		if(negSize==0 || posSize==0)
			return rs;
		if(minValue*2 + maxValue > 0)
			maxValue = -minValue*2;
		else if(maxValue*2 + minValue<0)
			minValue = -maxValue*2;
		int[] map = __map;
		Arrays.fill(map, 0, maxValue-minValue+1, 0);
		int[] negs = __negs;
		int[] poses = __poses;
		negSize = 0;
		posSize = 0;
		for(int v : nums){
			if(v >= minValue && v <= maxValue){
				if(map[v-minValue] ++ == 0){
					if(v > 0)
						poses[posSize++] = v;
					else if(v < 0)
						negs[negSize++] = v;
				}
			}
		}
		Arrays.sort(poses,0,posSize);
		Arrays.sort(negs,0,negSize);
		int basej = 0;
		for(int i=negSize-1; i>=0;i--){
			int nv = negs[i];
			int minp = (-nv)>>>1;
			while(basej<posSize && poses[basej]<minp) basej++;
			for(int j=basej; j<posSize; j++){
				int pv = poses[j];
				int cv = 0 - nv - pv;
				if(cv >= nv && cv <= pv){
					if(cv == nv){
						if(map[nv-minValue]>1)
							rs.add(nv,nv,pv);
					} else if(cv == pv){
						if(map[pv-minValue]>1)
							rs.add(nv,pv,pv);
					} else {
						if(map[cv-minValue]>0)
							rs.add(nv,cv,pv);
					}
				} else if(cv < nv)
					break;
			}
		}
        
		//System.out.println(rs.size);
		return rs;
	}
}