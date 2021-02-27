package spoj;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * PALIN - The Next Palindrome
 * #ad-hoc-1
 * A positive integer is called a palindrome if its representation in the decimal system is the same when read from left to right and from right to left. For a given positive integer K of not more than 1000000 digits, write the value of the smallest palindrome larger than K to output. Numbers are always displayed without leading zeros.
 *
 * Input
 * The first line contains integer t, the number of test cases. Integers K are given in the next t lines.
 *
 * Output
 * For each K, output the smallest palindrome larger than K.
 *
 * Example
 * Input:
 * 2
 * 808
 * 2133
 *
 * Output:
 * 818
 * 2222
 */
public class TheNextPalindrome {

    public static void main (String[] args) throws java.lang.Exception
    {
        // your code goes here

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        List<String> list = new ArrayList<>();
        for(int i=0; i<t; i++) {
            String m = sc.next();
            list.add(m);
        }

        for(int i =0; i < t; i++) {
            String val = list.get(i);
            String palan = palan(val);
            System.out.println(palan);
        }
    }

    private static String palan(String val) {
        String palan = null;
        boolean isAll9 = isAll9(val);
        if(val.length() == 1 && !val.equals("9")) {
            palan = ( Integer.parseInt(val) + 1) + "";
        }
        else if (isAll9) {
            palan = palanForAll9(val);
        } else {
            palan = palanForOthers(val);
        }
        return palan;

    }

    private static String palanForOthers(String val) {
        int length = val.length();
        boolean isOdd = !(length % 2 == 0);
        StringBuilder first = new StringBuilder(val.substring(0, length/2));
        StringBuilder second = new StringBuilder(isOdd ? val.substring((length/2) +1) : val.substring(length/2));
        String middle = isOdd ? val.charAt(((length/2))) +"" : "";

        length = first.length();
        boolean isIncreased = false;
        for (int i=0; i < length; i++ ){
            char fc = first.charAt(i);
            char sc = second.charAt(length-i-1);
            if (fc != sc) {
                second.setCharAt(length-i-1, fc);
                if (fc > sc)
                    isIncreased = true;
                else if (fc < sc)
                    isIncreased = false;
            }
        }
        if (!isIncreased) {
            if (middle.length() > 0) {
                if (middle.equals("9"))
                    middle = "0";
                else {
                    middle = Integer.parseInt(middle) + 1 + "";
                    isIncreased = true;
                }
            }
        }

        if (!isIncreased) {
            for (int i=length-1; i >= 0; i--) {
                char fc = first.charAt(i);
                if (fc == '9') {
                    first.setCharAt(i, '0');
                    second.setCharAt(length-i-1, '0');
                    continue;
                }
                fc += 1;
                first.setCharAt(i, fc);
                second.setCharAt(length-i-1, fc);
                break;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(first);
        sb.append(middle);
        sb.append(second);
        return sb.toString();
    }

    private static String palanForAll9(String val) {
        StringBuilder sb = new StringBuilder();
        sb.append("1");
        for (int i=0; i<val.length()-1; i++)
            sb.append("0");
        sb.append("1");
        return sb.toString();
    }

    private static boolean isAll9(String val) {
        for (int i =0; i < val.length(); i++)
            if (val.charAt(i) != '9')
                return false;
        return true;
    }
}
