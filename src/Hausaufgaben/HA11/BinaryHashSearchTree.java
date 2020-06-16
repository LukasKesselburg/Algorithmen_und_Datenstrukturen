package Hausaufgaben.HA11;

import java.util.HashMap;

public class BinaryHashSearchTree<T extends Comparable> {

    private final HashMap<Integer, T> hash = new HashMap<Integer, T>();

    /**
     * Fuegt element zum Binaerbaum hinzu. Falls element schon vorhanden ist,
     * passiert nichts.
     * 
     * @param element Wird in den Binaerbuam eingefuegt.
     */
    public void add(final T element) {
        T current;
        int index = 1;
        while (true) {
            current = this.hash.get(index);
            if (current == null) {
                this.hash.put(index, element);
                return;
            }
            if (element.compareTo(current) < 0) {
                index *= 2;
            }
            if (element.compareTo(current) == 0) {
                return;
            }
            if (element.compareTo(current) > 0) {
                index = index * 2 + 1;
            }
        }
    }

    /**
     * Gibt true zurueck, falls element im Binaerbaum vorhanden ist, sonst false.
     * 
     * @param element Das Element, welches auf Vorhandenheit geprueft wird. 
     * @return true wenn element vorhanden ist, sonst false.
     */
    public boolean contains(final T element) {
        T current;
        int index = 1;
        while (true) {
            current = this.hash.get(index);
            if (current == null) {
                this.hash.put(index, element);
                return false;
            }
            if (element.compareTo(current) < 0) {
                index *= 2;
            }
            if (element.compareTo(current) == 0) {
                return true;
            }
            if (element.compareTo(current) > 0) {
                index = index * 2 + 1;
            }
        }
    }

    public static void main(String[] args) {
        int[] test = {1, 2, 3, 17, -4};
        BinaryHashSearchTree<Integer> tree = new BinaryHashSearchTree<>();
        for (int i = 0; i < test.length; i++) {
            tree.add(test[i]);
        }
        for (int i = 0; i < 6; i++) {
            System.out.println(i + ": " + String.valueOf(tree.contains(i)));
        }
        System.out.println(17 + ": " + String.valueOf(tree.contains(17)));
        System.out.println(-4 + ": " + String.valueOf(tree.contains(-4)));

    }

}