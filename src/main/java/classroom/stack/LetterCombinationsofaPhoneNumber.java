package classroom.stack;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsofaPhoneNumber {

    public List<String> letterCombinations(String digits) {

        List<String> res = new ArrayList<>();

        String[] init =  {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> list = new ArrayList<>();
        for(int i=0; i<digits.length(); i++) {
            list.add(init[digits.charAt(i) - '2']);
        }


        addRes(res, list, "", 0);

        return res;
    }

    private void addRes(List<String> res, List<String> list, String s, int ind) {
        if(ind >= list.size())
            return;

        String val = list.get(ind);
        for(int i=0; i<val.length(); i++) {
            if(ind == (list.size()-1))
                res.add(s+val.charAt(i));
            else
                addRes(res, list, s+val.charAt(i), ind+1);
        }
    }
}
