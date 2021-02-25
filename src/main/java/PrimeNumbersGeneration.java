import java.util.ArrayList;
import java.util.List;

public class PrimeNumbersGeneration {

    public static void main(String[] args) {

        long n = 1000;

        primeNumbersTillN(n);

        long m = 97;
        primeNumbersInRange(m, n);

    }

    private static void primeNumbersInRange(long m, long n) {
        int sqrrt = (int) Math.sqrt(n);
        List<Integer> primeNumbersTillN = primeNumbersTillN(sqrrt);

        boolean[] mToN = new boolean[(int)(n - m + 1)];
        for (int i =0; i< n - m + 1; i++)
            mToN[i] = true;

        for (Integer i : primeNumbersTillN) {
            long j = Math.max(i*i, m -(m%i)) ;
            for (; j<=n ; j = j+i){
                if(j >= m){
                    mToN[(int)(j-m)] = false;
                }
            }
        }

        for (int i=0; i<mToN.length; i++) {
            if (mToN[i])
                System.out.println(m+i);
        }
    }


    private static List<Integer> primeNumbersTillN(long n) {
        boolean[] primes = new boolean[(int)(n+1)];

        //set all numbers as potential prime numbers
        for (int i =0; i < n+1; i++)
            primes[i] = true;
        primes[0] = primes[1] = false;

        //start checking from 2
        //check each number till sqr root of n
        for (int i = 2; (long) (i * i) <= n; i++) {
            //check only if it is a prime number
            if (primes[i]) {
                //start from (i*i) mark all numbers as composite in multiple of i
                for (int j = i * i; j <= n; j = j+i)
                    primes[j] = false;
            }
        }

        List<Integer> primeTillN = new ArrayList<>();
        //print all prime numbers
        //System.out.println("Prime numbers till " + n);
        for (int i = 2; i <= n; i++) {
            if (primes[i])
                primeTillN.add(i);
        }
        return primeTillN;
    }
}
