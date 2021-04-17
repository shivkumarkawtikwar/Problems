class GFG
{

    // Function to find the length of the  
    // longest Fibonacci-like subarray  
    static int longestFibonacciSubarray(int n, int a[])
    {
        // Any 2 terms are Fibonacci-like  
        if (n <= 2)
            return n;

        int len = 2;

        int mx = Integer.MIN_VALUE;

        for (int i = 2; i < n; i++)
        {

            // If previous subarray can be extended  
            if (a[i] == a[i - 1] + a[i - 2])
                len++;

                // Any 2 terms are Fibonacci-like
            else
                len = 2;

            // Find the maximum length  
            mx = Math.max(mx, len);
        }
        return mx;
    }

    // Driver Code  
    public static void main (String[] args)
    {
        Solution s = new Solution();

        System.out.println(s.solve(10000, 100, 10000));
    }

    static class Solution {

        //nCr = n-1Cr-1 + n-1Cr.
        public int solve(int A, int B, int C) {

            return nCr(A, B, C);
        }

        private int nCr(int n, int r, int m) {
            if(r == 0 || n == r)
                return 1;

            return (nCr(n-1, r-1, m) + nCr(n-1, r, m)) % m;
        }


        /*public int solve(int A, int B) {

            int mod = 1000000007;
            long f = fact(B, mod);
            System.out.println(f);
            return (int)power((long)A, f, mod);
        }

        private long fact(int a, int mod) {
            long res = 1;
            for(int i =1; i<=a; i++) {
                res = (res * i);
            }
            return res;
        }

        private long power(long a, long r, int mod) {
            if(r == 0)
                return 1;

            a = a % mod;
            if((r & 1) ==0)
                return power((a*a)%mod, r/2, mod);
            else
                return (a * power((a*a)%mod, r/2, mod))%mod;

        }*/
    }
} 