// Perfect Number
// https://leetcode.com/problems/perfect-number/description/

// We define the Perfect Number is a positive integer that is equal to the sum of 
// all its positive divisors except itself.

// Now, given an integer n, write a function that returns true when it is a perfect 
// number and false when it is not.
// Example:
// Input: 28
// Output: True
// Explanation: 28 = 1 + 2 + 4 + 7 + 14
// Note: The input number n will not exceed 100,000,000. (1e8)

class Solution {
    public boolean checkPerfectNumber(int num) {
        if (num == 1) return false;
        int sum = 0;
        for (int i = 2; i < Math.sqrt(num); i++) {
            if (num % i == 0)
                sum += i + num/i;
        }
        sum++;
        return sum == num;
    }
}

// Refer-Best

class Solution {
    public boolean checkPerfectNumber(int num) {
        int[] primes=new int[]{2,3,5,7,13,17,19,31};
        for (int prime: primes) {
            if (pn(prime) == num)
                return true;
        }
        return false;
    }
    private static int pn(int p) {
        return (1 << (p - 1)) * ((1 << p) - 1);
    }
}