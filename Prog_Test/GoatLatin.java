import java.util.Arrays;
import java.util.HashSet;

// Goat Latin
// https://leetcode.com/problems/goat-latin/description/

// A sentence S is given, composed of words separated by spaces. 
// Each word consists of lowercase and uppercase letters only.

// We would like to convert the sentence to "Goat Latin" (a made-up language similar to Pig Latin.)

// The rules of Goat Latin are as follows:

// If a word begins with a vowel (a, e, i, o, or u), append "ma" to the end of the word.
// For example, the word 'apple' becomes 'applema'.

// If a word begins with a consonant (i.e. not a vowel), remove the first letter and append it to the end, then add "ma".
// For example, the word "goat" becomes "oatgma".

// Add one letter 'a' to the end of each word per its word index in the sentence, starting with 1.
// For example, the first word gets "a" added to the end, the second word gets "aa" added to the end and so on.
// Return the final sentence representing the conversion from S to Goat Latin. 

// Example:

// Input: "I speak Goat Latin"
// Output: "Imaa peaksmaaa oatGmaaaa atinLmaaaaa"

// Input: "The quick brown fox jumped over the lazy dog"
// Output: "heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa"

// Notes:

// S contains only uppercase, lowercase and spaces. Exactly one space between each word.
// 1 <= S.length <= 150.

class Solution {
    public static final Character[] vowelsList = new Character[] { 'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U' };
    public static final HashSet<Character> vowels = new HashSet<>(Arrays.asList(vowelsList));

    public String toGoatLatin(String S) {
        if (S == null || S.length() == 0)
            return "";
        StringBuilder res = new StringBuilder();
        int count = 1;
        for (String s : S.split(" ")) {
            if (count != 1)
                res.append(" ");
            char firstChar = s.charAt(0);
            if (vowels.contains(firstChar))
                res.append(s);
            else {
                res.append(s.substring(1));
                res.append(firstChar);
            }
            res.append("ma");
            for (int i = 0; i < count; i++) {
                res.append("a");
            }
            count++;
        }
        return res.toString();
    }
}

// Time Complexity Explanation
// Assume, length of the given string is N and it has K words. 
// Thus, average characters per word will be L = N/K including the space. 
// Time complexity of each for-loop iteration:

// chartAt[0] is O(1)
// HashSet lookup is O(1)
// If first character is a vowel, then O(L-1) to append to StringBuilder. (-1 for the space)
// If first character is not a vowel, then
// a. O(L-1) to find the substring
// b. O(L-2) to append the substring
// c. O(1) to append the first character
// O(2) to append "ma"
// O(K) to append "a"
// Total for each for loop iteration = O(L+K). The for-loop executes K times, once for each word. 
// Thus, the time complexity is O(K*(L+K)) = O(N + K^2).
// Worst Case: Each word is of length 1 and number of words = N/2. 
// The worst case complexity will be O(N^2).

// Space Complexity Explanation
// Assume, length of the given string is N and it has K words.
// Length of the word at index iwill be increased by i+2 characters.
// Thus, there will be 3 + 4 + 5 .... + (K+2) new characters in the final string. 
// Length of the final string = N + 3 + 4 + 5 + .... + (K+2) = N + 2K + 1 + 2 + 3 + .... + K = N + 2K + K(K+1)/2. Thus, the space complexity is O(N + K^2).
// Worst Case: Each word is of length 1 and number of words = N/2. 
// The worst case complexity will be O(N^2).