package classroom;

public class CheckIfANumberIsPalindrome {

    public boolean isPalindrome(int x) {
        if(x < 0)
            return false;
        int t = x;
        int y = 0;
        while(t > 0) {
            y = y*10 + t%10;
            t = t/10;
        }
        return x == y;
    }
}