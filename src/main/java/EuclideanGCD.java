/**
 * Algorithm
 * The algorithm is extremely simple:
 *
 * gcd(a,b)={
 *              a                       if b=0
 *              gcd(b,a mod(%) b)       otherwise
 *          }
 *
 *
 * lcm(a,b)= a⋅b / gcd(a,b)
 *
 * Learn Lame theorem
 *
 */
public class EuclideanGCD {

    public static void main(String[] args) {
        int a = 33, b =99;
        int gcd = gcdR(a, b);
        System.out.println("Greatest Common Divisor : "+ gcd);

        int lcm = lcm(a, b);
        System.out.println("Least Common Multiplier : " + lcm);
    }

    private static int lcm(int a, int b) {
        int lcm = (a/gcdNR(a, b)) * b;
        return lcm;
    }

    private static int gcdR(int a, int b) {
        if (b == 0)
            return a;
        return gcdR(b, a%b);
    }

    private static int gcdNR(int a, int b) {
        while (b > 0) {
            a = a % b;
            int temp = a;
            a = b;
            b = temp;
        }
        return a;
    }
}
