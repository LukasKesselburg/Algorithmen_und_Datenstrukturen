package Hausaufgaben.HA05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class HeapUtils {

    /**
     * getLargestKElements hat die Laufzeitkomplexitaet O (n log n)
     * O (k * log n + (n - k) * 2 * log n)
     * 
     * @param list Die Liste aus der die K groessten Elemente ermittelt werden sollen.
     * @param k Die Anzahl der groessten Elemente die ermittelt werden sollen.
     * @return Die k groessten Elemente der Liste list.
     */
    public static int[] getLargestKElements(int[] list, int k) {
        // Der Konstruktor erstellt eine leere PriorityQueue, dann bekommt er einen
        // lambda Ausdruck uebergeben, der dafuer sorgt, dass eine die PriorityQueue an
        // erster Stelle immer das kleinste Element enthaelt. Will man, dass die Methode
        // die k kleinsten Elemente zurueckgibt muss man statt x-y y-x verwenden,
        // zusatzlich muss man den groesser Operator in der If-Bedingung in der zweiten
        // for Schleife umkehren.
        PriorityQueue<Integer> q = new PriorityQueue<>((Integer x, Integer y) -> x - y);
        // Nach dem Durchlauf dieser Schleife beinhaltet die PriorityQueue die drei
        // groessten Elemente. Dabei ist zu beachten, dass sich das kleinste dieser drei
        // ELemente immer "vorne" befindet.
        for (int i = 0; i < k; i++) {
            q.add(list[i]);
            System.out.println(q.toString());
        }
        // In dieser Schleife wird immer geprueft ob das i-te ELement groesser als das
        // kleinste der k groessten Elemente ist, wenn ja wird das kleinste der k
        // groessten Elemente aus der PriorityQueue entfernt und das i-te Element in die
        // PriorityQueue eingefuegt. Nach jedem Durchlauf dieser Schleife enthaelt p die
        // k groessten Elemente der ersten i Elemente der Liste.
        for (int i = k; i < list.length; i++) {
            if (list[i] > q.peek()) {
                q.poll();
                q.add(list[i]);

            }
            System.out.println(q.toString());
        }
        // Um die k groessten Elemente zurueckzugeben wird p erst in einen Stream
        // verwandelt um die Integer in ints zu casten und um dann ein Array aus aus dem
        // Stream zu erstellen.
        return q.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        int[] test = new int[20];
        for (int i = 0; i < test.length; i++) {
            test[i] = (int) (Math.random() * 100);
        }
        System.out.println(Arrays.toString(test));
        System.out.println(Arrays.toString(getLargestKElements(test, 3)));
    }

}
