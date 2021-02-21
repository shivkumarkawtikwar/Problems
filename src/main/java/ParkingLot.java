import java.util.Scanner;

/**
 * I. Parking Lot
 * time limit per test0.5 seconds
 * memory limit per test64 megabytes
 * inputstandard input
 * outputstandard output
 * To quickly hire highly skilled specialists one of the new IT City companies made an unprecedented move. Every employee was granted a car, and an employee can choose one of four different car makes.
 *
 * The parking lot before the office consists of one line of (2n - 2) parking spaces. Unfortunately the total number of cars is greater than the parking lot capacity. Furthermore even amount of cars of each make is greater than the amount of parking spaces! That's why there are no free spaces on the parking lot ever.
 *
 * Looking on the straight line of cars the company CEO thought that parking lot would be more beautiful if it contained exactly n successive cars of the same make. Help the CEO determine the number of ways to fill the parking lot this way.
 *
 * Input
 * The only line of the input contains one integer n (3 ≤ n ≤ 30) — the amount of successive cars of the same make.
 *
 * Output
 * Output one integer — the number of ways to fill the parking lot by cars of four makes using the described way.
 *
 * Examples
 * inputCopy
 * 3
 * outputCopy
 * 24
 * Note
 * Let's denote car makes in the following way: A — Aston Martin, B — Bentley, M — Mercedes-Maybach, Z — Zaporozhets. For n = 3 there are the following appropriate ways to fill the parking lot: AAAB AAAM AAAZ ABBB AMMM AZZZ BBBA BBBM BBBZ BAAA BMMM BZZZ MMMA MMMB MMMZ MAAA MBBB MZZZ ZZZA ZZZB ZZZM ZAAA ZBBB ZMMM
 *
 * Originally it was planned to grant sport cars of Ferrari, Lamborghini, Maserati and Bugatti makes but this idea was renounced because it is impossible to drive these cars having small road clearance on the worn-down roads of IT City.
 */
public class ParkingLot {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.next());
        long numOfWays = n == 3 ? 24 : numberOfWays(n);
        System.out.println(numOfWays+"");
    }

    private static long numberOfWays(int n) {
        int m = n - 2;
        long numWays = 12;
        long fl = 2 * (long)(Math.pow(4, m-1));
        long mid = (m-1)* 3 * (long) (Math.pow(4, m-2));

        numWays *= (fl + mid);

        return numWays;
    }
}
