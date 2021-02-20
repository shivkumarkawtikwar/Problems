
public class BinaryExponentiation {

    /**
     * 3 ^ 13 = 3 ^ (1101)2 = 3^8 ⋅ 3^4 ⋅ 3^1
     * @param args
     */

    public static void main(String[] args) {

        long a = 7;
        long b = 25;
        double powerExpected = Math.pow(a, b);
        long powerActual = binpow(a, b);
        System.out.println("Expected Power = " + powerExpected);
        System.out.println("Actual Power = " + powerActual);

        isBinaryBitSet(b);
    }

    private static long binpow(long a, long b) {
        long res = 1;
        while (b > 0) {
            if (b % 2 != 0)//binary bit is set here
                res = res * a;

            a = a * a;
            b = b / 2;
        }
        return res;
    }

    //print binary of number in reverse order
    private static void isBinaryBitSet(long b) {
        while( b > 0) {
            if (b % 2 != 0)
                System.out.print("1");
            else
                System.out.print("0");
            b = b /2;
        }
    }

}
