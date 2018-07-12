import java.util.Arrays;

// Maximum Product of Three Numbers
// https://leetcode.com/problems/maximum-product-of-three-numbers/description/

// Given an integer array, find three numbers whose product is maximum and output the maximum product.

// Example:
// Input: [1,2,3]
// Output: 6

// Input: [1,2,3,4]
// Output: 24

// Note:
// The length of the given array will be in range [3,104] and all elements are in the range [-1000, 1000].
// Multiplication of any three numbers in the input won't exceed the range of 32-bit signed integer.

class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        return Math.max(nums[n-1]*nums[n-2]*nums[n-3], nums[n-1]*nums[0]*nums[1]);
    }
}

// Refer-Best

class Solution {
    public int maximumProduct(int[] nums) {
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num < min1) {
                if (num < min2) {
                    min1 = min2;
                    min2 = num;
                } else {
                    min1 = num;
                }
            }
            if (num > max1) {
                if (num > max2) {
                    if (num > max3) {
                        max1 = max2;
                        max2 = max3;
                        max3 = num;
                    } else {
                        max1 = max2;
                        max2 = num;
                    }
                } else {
                    max1 = num;
                }
            }
        }
        return Math.max(min1 * min2 * max3, max1 * max2 * max3);
    }
}