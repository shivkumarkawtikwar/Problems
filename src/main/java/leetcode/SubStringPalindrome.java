package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string s, we make queries on substrings of s.
 *
 * For each query queries[i] = [left, right, k], we may rearrange the substring s[left], ..., s[right], and then choose up to k of them to replace with any lowercase English letter.
 *
 * If the substring is possible to be a palindrome string after the operations above, the result of the query is true. Otherwise, the result is false.
 *
 * Return an array answer[], where answer[i] is the result of the i-th query queries[i].
 *
 * Note that: Each letter is counted individually for replacement so if for example s[left..right] = "aaa", and k = 2, we can only replace two of the letters.  (Also, note that the initial string s is never modified by any query.)
 *
 *
 *
 * Example :
 *
 * Input: s = "abcda", queries = [[3,3,0],[1,2,0],[0,3,1],[0,3,2],[0,4,1]]
 * Output: [true,false,false,true,true]
 * Explanation:
 * queries[0] : substring = "d", is palidrome.
 * queries[1] : substring = "bc", is not palidrome.
 * queries[2] : substring = "abcd", is not palidrome after replacing only 1 character.
 * queries[3] : substring = "abcd", could be changed to "abba" which is palidrome. Also this can be changed to "baab" first rearrange it "bacd" then replace "cd" with "ab".
 * queries[4] : substring = "abcda", could be changed to "abcba" which is palidrome.
 *
 *
 * Constraints:
 *
 * 1 <= s.length, queries.length <= 10^5
 * 0 <= queries[i][0] <= queries[i][1] < s.length
 * 0 <= queries[i][2] <= s.length
 * s only contains lowercase English letters.
 */
public class SubStringPalindrome {

    /**
     *
     * 1. Find freq of each character starting from 0 till that index keep in n*26 2-d array
     *       With this we are able to query num of chars from end index to start index
     *       with formula -> freq[j][c] - freq[i][c]
     * 2. For each query Find freq of each char from starting point till end point
     * 3. Find number of out of the order char (ood)
     */

    public List<Boolean> canMakePaliQueries(String str, int[][] queries) {

        int[][] freq = new int[str.length()][26];

        /**
         *    a b c a
         * 0  1
         * 1    1
         * 2       1
         * 3  1
         */

        //set freq to 1 for that char at that index
        for(int i=0; i< str.length(); i++) {
            freq[i][str.charAt(i) -'a'] = 1;
        }

        /**
         * String is abca
         *    a b c
         * 0  1 0 0
         * 1  1 1 0
         * 2  1 1 1
         * 3  2 1 1
         */

        // copy freq from prev index
        for(int i=1; i<str.length(); i++) {
            for(int j = 0; j<26; j++) {
                freq[i][j] = freq[i][j] + freq[i-1][j];
            }
        }

            /*for(int i=0; i<str.length(); i++) {
                for(int j = 0; j<26; j++) {
                    System.out.print(freq[i][j] + " ");// = freq[i][j] + freq[i-1][j];
                }
                System.out.println("");
            }*/

        //to query freq of any character c from i to j is -> freq[j][c] - freq[i][c]
        List<Boolean> res =new ArrayList<>();
        for(int i=0; i < queries.length; i++) {

            int[] q = queries[i];
            int s = q[0];
            int e = q[1];
            int k = q[2];
            int ooc = 0;
            boolean isOddL = (((e-s) + 1) %2 != 0);
            if(e > s) {
                for(int j=0; j<26; j++) {
                    ooc = ooc + (freq[e][j] - (((s-1) >= 0) ? freq[s-1][j] : 0))%2;
                }
            } else {
                ooc = 1;
            }

            if(isOddL)
                ooc = ooc -1;

            ooc = ooc/2;

            res.add(ooc <= k);
        }
        return res;
    }
}
