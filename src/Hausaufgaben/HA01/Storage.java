package Hausaufgaben.HA01;

import java.util.Arrays;

/**
 * Diese Klasse implementiert im Ansatz den Abstrakten Datentyp Liste, dazu wird
 * 
 * Diese Klasse implementiert im Ansatz eine dynamische Liste. Konkret wird nur
 * die Abfrage, on die Liste leer ist, das hinzufuegen von Elementen (add), das
 * Auslesen von Elementen und eine toString Konvertierung unterstuetzt.
 * 
 * @param <T> Die Klasse der Elemente, die diese Liste enthaelt.
 */
public class Storage<T> {
    /** Feld, enthaelt Objekte vom Typ T, wird dynamisch vergroessert. */
    private T[] speicher = (T[]) new Object[10];

    /** Zeigt auf das erste unbesetzte Element */
    private int zeiger = 0;

    /**
     * Prueft ob die Instanz der Klasse Storage bereits ein oder mehr Elemente
     * enthaelt.
     * 
     * @return true wenn noch kein Element hinzugefuegt wurde, sonst false.
     */
    public boolean isEmpty() {
        return this.speicher.length == 0;
    }

    /**
     * Diese Methode fuegt der dyynamischen Liste hinten das Objekt item an.
     * 
     * @param item Das anzuhaengende Objekt.
     */
    public void add(T item) {
        if (this.zeiger == this.speicher.length) {
            T[] tempArray = (T[]) new Object[this.speicher.length * 2];
            for (int i = 0; i < this.speicher.length; i++) {
                tempArray[i] = this.speicher[i];
            }
            this.speicher = tempArray;
        }
        this.speicher[this.zeiger] = item;
        this.zeiger++;
    }

    /**
     * Diese Methode liesst das Element an der Position i aus und gibt es zurueck.
     * 
     * @param i Die Position / der index des abgefragten Elements.
     * @return Das gesuchte Element an der Position i.
     */
    public T get(int i) {
        if (0 <= i && i < this.zeiger) {
            return this.speicher[i];
        } else {
            throw new ArrayIndexOutOfBoundsException("Index " + i + " out of bounds for length " + zeiger);
        }
    }

    /**
     * Diese Methode erzeugt eine Stringrepraesentation der Liste im Stil von
     * Arrays.toString.
     * 
     * @return Eine Stringrepraesentation der Liste.
     */
    public String toString() {
        return Arrays.toString(Arrays.copyOf(this.speicher, zeiger));
    }

    /**
     * Nur eine kleine Testmethode.
     * 
     * @param args Hier ungenutzt.
     */
    public static void main(String[] args) {
        Storage st = new Storage();
        for (int i = 0; i < 30; i++) {
            st.add(i * 2);
            System.out.println(st);
        }
        for (int i = -1; i < 32; i++) {
            try {
                System.out.println(st.get(i));                
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
