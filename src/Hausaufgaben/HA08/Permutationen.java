package Hausaufgaben.HA08;

import java.security.InvalidParameterException;
import java.security.KeyStore.Entry.Attribute;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

public class Permutationen {

    public static void printPermutationen(int n) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        printPermutationen(res, n, n);

    }

    private static void printPermutationen(ArrayList<Integer> res, int n, int x) {
        if (x == 0) {
            System.out.println(Arrays.toString(res.toArray()));
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (!res.contains(i)) {
                res.add(i);
                printPermutationen(res, n, x - 1);
                res.remove(res.size() - 1);
            }
        }
    }

    public static void printPermutationen2(int n, int ges) {
        if (n > ges) {
            throw new InvalidParameterException("n darf nicht groesser sein als ges.");
        }
        printPermutationen2("", n, ges);
    }

    private static void printPermutationen2(String res, int n, int ges) {
        if (ges == 0) {
            if (n == 0) {
                System.out.println(res);
            }
            return;
        }
        printPermutationen2(res + "0", n, ges - 1);
        if (n != 0) {
            printPermutationen2(res + "1", n - 1, ges - 1);
        }
    }

    public static void printPermutationen3(int n, int ges) {
        ArrayDeque<String> strings = new ArrayDeque<String>();
        ArrayDeque<Integer> ones = new ArrayDeque<Integer>();
        strings.addLast("");
        ones.addLast(0);

        while (!strings.isEmpty()) {
            String currentString = strings.removeFirst();
            int currentOnes = ones.removeFirst();
            if (currentString.length() == ges) {
                if (currentOnes == n) {
                    System.out.println(currentString);
                }
                continue;
            }
            strings.addLast(currentString + "0");
            ones.addLast(currentOnes);
            if (currentOnes != n) {
                strings.addLast(currentString + "1");
                ones.addLast(currentOnes + 1);
            }
        }

    }

    public static void main(String[] args) {
        printPermutationen(3);
        System.out.println();
        printPermutationen2(2, 4);
        System.out.println();
        printPermutationen3(2, 4);
    }

}