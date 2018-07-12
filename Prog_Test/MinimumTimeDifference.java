// Minimum Time Difference
// https://leetcode.com/problems/minimum-time-difference/description/

// Given a list of 24-hour clock time points in "Hour:Minutes" format, 
// find the minimum minutes difference between any two time points in the list.
// Example:
// Input: ["23:59","00:00"]
// Output: 1
// Note:
// The number of time points in the given list is at least 2 and won't exceed 20000.
// The input time is legal and ranges from 00:00 to 23:59.

// Refer

// Thinking process
// Transform every time point into minutes (an int)
// The problem becomes to find minimum difference between 2 ints

// Straight Forward Solution
// Sort the int array first, and traverse the array to get difference minimum
// Time complexity: O(NlogN)
// Space complexity: O(1)

// Can We Do Better?
// The range of each int is 0~24*60 (1440). Therefore, can do the bucket sort.

// Final solution:
// Turn Time Points into minutes and put them into buckets
// Travese the buckets to get min difference
// Time complexity: O(N) (put minutes into bucket)
// Space complexity: O(1) (use a boolean bucket[1440])

// Special case
// Difference of time points is not just difference of two int; 
// need to consider the case like ["23:59", "00:00"] which becomes 1439,0. 
// The int difference is 1439, but correct time point difference is 1.

// How to Calculate it?
// Consider time point difference between x and y, below graph shows 2 days timeline in minutes, 
// day2 is the right part, that each of the minutes in day2 is day1's minutes plus 1440;
// 0__y________x__1439 | 1440__y+1440________x+1440__2879
// So for time point difference between x and y might be x - y or y+1440-x
// Difference of x and y: min(x - y, y+1440-x), x > y
// For the case 30,300,1300 the answer is 170 (difference of 30 and 1300). 
// If only compare difference between neighbor ints, this case fails. 
// So also need to compare the difference between the fist and the last int to check if it's minimum.

// Tuning
// When putting minutes into buckets, we can get the first minutes and the last minutes, 
// and we only traverse buckets from first minutes to last minutes rather than 0~1440 (this speeds up 2ms)

class Solution{
    public static final int DAY = 1440;
    public int findMinDifference(List<String> timePoints){
        boolean [] b = new boolean[DAY];
        int first = DAY + 1;
        int last = 0;
        for (String t : timePoints) {
            int mins = Integer.parseInt(t.substring(0, 2)) * 60
                        + Integer.parseInt(t.substring(3, 5));
            if (b[mins]) return 0;
            b[mins] = true;
            if (first > mins) first = mins;
            if (last < mins) last = mins;
            
        }
        int minDif = Math.min(last - first, first + 1440 - last);
        int mins = first + 1;
        int pre = first;
        while (mins <= last){
            while (!b[mins]) mins++;
            int cur = mins;
            minDif = Math.min(minDif, Math.min(cur - pre, cur + 1440 - pre));
            pre = mins++;
        }
        return minDif;
    }
}
