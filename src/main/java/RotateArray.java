import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RotateArray {
    public static void main(String[] args) {
        // YOUR CODE GOES HERE
        // Please take input and print output to standard input/output (stdin/stdout)
        // DO NOT USE ARGUMENTS FOR INPUTS
        // E.g. 'Scanner' for input & 'System.out' for output
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=0; i<t; i++) {
            int l = sc.nextInt();
            List<Integer> list = new ArrayList<>();
            for(int j=0; j<l; j++) {
                list.add(sc.nextInt());
            }
            int b = sc.nextInt();
            rotate(list, b);
            printOutput(list);
        }

    }

    private static void rotate(List<Integer> list, int b) {
        b = b % list.size();
        reverse(list, 0, list.size()-1);
        reverse(list, 0, b-1);
        reverse(list, b, list.size()-1);
    }

    private static void reverse(List<Integer> list, int i, int j) {

        while(i < j) {
            int a = list.get(i);
            int b = list.get(j);
            a = a ^ b;
            b = a ^ b;
            a = a ^ b;
            list.set(i, a);
            list.set(j, b);
            i++;
            j--;
        }
    }

    private static void printOutput(List<Integer> list) {
        for(int v : list)
            System.out.print(v + " ");

        System.out.println("");
    }
}