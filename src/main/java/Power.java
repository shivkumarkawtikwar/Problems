public class Power {


    public static void main(String[] args) {
        Power p = new Power();
        int myPow = p.power(2, 72747805, 1000000007);
        System.out.println("myPow - " + myPow);

        int gfgPow = p.gfgpower(2, 72747805, 1000000007);
        System.out.println("gfgPow - " + gfgPow);

    }

    private int power(int a, int r, int m) {
        if(r == 0)
            return 1;
        a = a%m;
        if((r & 1) == 0) {
            return power((a*a)%m, r/2, m);
        } else {
            return (a * power((a*a)%m, r/2, m))%m;
        }
    }

    private int gfgpower(int x, int y, int p)
    {
        int res = 1; // Initialize result

        x = x % p; // Update x if it is more than or
        // equal to p

        if (x == 0)
            return 0; // In case x is divisible by p;

        while (y > 0)
        {

            // If y is odd, multiply x with result
            if ((y & 1) != 0)
                res = (res * x) % p;

            // y must be even now
            y = y >> 1; // y = y/2
            x = (x * x) % p;
        }
        return res;
    }
}
