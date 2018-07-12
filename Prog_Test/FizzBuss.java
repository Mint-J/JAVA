import java.awt.List;

// Fizz Buzz
// https://leetcode.com/problems/fizz-buzz/description/

// Write a program that outputs the string representation of numbers from 1 to n.

// But for multiples of three it should output “Fizz” instead of the number and 
// for the multiples of five output “Buzz”. For numbers which are multiples of 
// both three and five output “FizzBuzz”.

// Example:

// n = 15,

// Return:
// [
//     "1",
//     "2",
//     "Fizz",
//     "4",
//     "Buzz",
//     "Fizz",
//     "7",
//     "8",
//     "Fizz",
//     "Buzz",
//     "11",
//     "Fizz",
//     "13",
//     "14",
//     "FizzBuzz"
// ]

// Jason's - Beat 99.39% !!

class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> res = new ArrayList<>();
        int i = 1;
        while (i < 3 && i <= n){
            res.add(Integer.toString(i));
            i++;
        }
        while (i > 2 && i <= n) {
            if (i % 3 == 0 && i % 5 == 0) {
                res.add("FizzBuzz");
                i++;
            } else if (i % 3 == 0) {
                res.add("Fizz");
                i++;
            } else if (i % 5 == 0) {
                res.add("Buzz");
                i++;
            } else {
                res.add(Integer.toString(i));
                i++;
            }
        }
        return res;
    }
}

// Refer-Best

class Solution {
    public  List<String> fizzBuzz(int n) {
        final int size = n;
        return new java.util.AbstractList<String>() {
            public static final String FIZZ_BUZZ = "FizzBuzz";
            public static final String FIZZ = "Fizz";
            public static final String BUZZ = "Buzz";

            @Override
            public String get(int index) {
                index ++;
                if (index % 3 == 0) {
                    if (index % 5 == 0) {
                        return FIZZ_BUZZ;
                    }
                    return FIZZ;
                } else if (index % 5 == 0) {
                    return BUZZ;
                }
                return index + "";
            }
            @Override
            public int size() {
                return size;
            }
        };
    }
}