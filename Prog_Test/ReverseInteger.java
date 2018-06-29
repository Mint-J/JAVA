// Reverse Integer
// https://leetcode.com/problems/reverse-integer/description/

// Given a 32-bit signed integer, reverse digits of an integer.

// Example:

// Input: 123
// Output: 321

// Input: -123
// Output: -321

// Input: 120
// Output: 21

// Note:
// Assume we are dealing with an environment which could only store integers
// within the 32-bit signed integer range: [−231,  231 − 1]. 
// For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.

class Solution {
    
// 方法一: 字符串

// 将一个整形倒置，就其形状而言，可以看作是将一个数字字符串倒置，由此便可以得出一种解决方法，
// 即先将整形 num 转化为一个字符串 A ，然后将字符串中前后两个位置i和len(A) - i - 1的字符交换即可，
// 此时只需要遍历len(A) / 2次，完了之后只要再将字符串转换成整形就 Ok 了。

// 使用这种方法的时候需要注意一点，因为整形的符号不参与倒置，所以可以采用单独保存整形的符号的方式，
// 将所有的数字都变成正数然后倒置完成之后再把符号添加上去。

// 还有一点，因为题目限制整形为 32 位的数字，所以对于数字x^31 - 1 = 2147483647来说，
// 它的倒置是7463847412显然超出表示范围，这种情况的解决方法是就是，在字符串转整形的代码上try到异常然后返回 0 ，代码如下：

public static int reverseOne(int x) {
    boolean negative = x < 0;
    if (negative) {
        x = -x;
    }
    int result;
    char[] origin = String.valueOf(x).toCharArray();
    int length = origin.length;
    int max = length / 2;
    for (int i = 0; i < max; i++) {
        char t = origin[i];
        origin[i] = origin[length - 1 - i];
        origin[length - 1 - i] = t;
    }
    try {
        result = Integer.valueOf(new String(origin));
    } catch (NumberFormatException ignored) {
        return 0;
    }
    return negative ? -result : result;
}
// 方法二: 取模

// 另一种方法就是直接对整形以取模的方式倒置，为了判断上的方便，仍然可以先将数字的符号保存下来，
// 只计算正数。然后每次使用rem = num % 10对方式取出数字的最后一位，然后放到另一个数字上。

// 这种方式里，因为是通过对整形进行操作，一位一位地得到结果，所以就可以直接对结果进行判断以确保结果的范围：

public static int reverseTwo(int x) {
    boolean negative = x < 0;
    if (negative) {
        x = -x;
    }
    long result = 0;
    for(; x != 0; x /= 10){
        result = result * 10 + x % 10;
    }
    
    if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) { return 0; }
    return negative ? -result : result;
}
// 如上，每次都会判断 result 是否大于 maxNum ，当这个不等式成立的时候，
// 必然有result * 10 > Integer.MAX_VALUE成立，所以直接返回 0 。
}