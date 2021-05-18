package classroom.recursion;

import java.util.HashSet;
import java.util.Set;

public class AllCombinationOfAString {


    public static void main(String[] args) {

        String val = "abcd";
        Set<String> set = new HashSet<>();
        set.add(val);
        allCombination(val, set, 0, val.length()-1);

        for (String str : set)
            System.out.println(str);

        System.out.println(set.size());
    }


    private static void allCombination(String val, Set<String> set, int l, int r) {

        if(l == r)
            set.add(val);
        if (l > r)
            return;

        StringBuilder sb = new StringBuilder(val);
        for(int i=l; i<r; i++) {
            char fc = sb.charAt(i);
            for(int j=i; j<val.length(); j++) {
                char sc = sb.charAt(j);
                if(fc == sc)
                    continue;

                sb.setCharAt(i, sc);
                sb.setCharAt(j, fc);
                set.add(sb.toString());
                allCombination(sb.toString(), set, i+1, r);

                sb.setCharAt(i, fc);
                sb.setCharAt(j, sc);

            }
        }
    }


}
