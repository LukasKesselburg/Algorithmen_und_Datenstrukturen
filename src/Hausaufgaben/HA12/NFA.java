package Hausaufgaben.HA12;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class NFA {

    private int startknoten;
    private int zielknoten;
    private ArrayList<Kante>[] adjazenzliste;

    public NFA(int knotenanzahl, int startknoten, int zielknoten) {
        adjazenzliste = new ArrayList[knotenanzahl + 1]; // Knoten 0 ist Dummy
        for (int i = 0; i <= knotenanzahl; i++) {
            adjazenzliste[i] = new ArrayList<>();
        }
        this.startknoten = startknoten;
        this.zielknoten = zielknoten;
    }

    public void addKante(int start, int ziel, char zeichen) {
        adjazenzliste[start].add(new Kante(zeichen, ziel));
    }

    public boolean testString(String s) {
        ArrayDeque<Integer> a = new ArrayDeque<>();
        ArrayDeque<Integer> b = new ArrayDeque<>();
        ArrayDeque<Integer> tmp;
        a.add(this.startknoten);

        for (int i = 0; i < s.length(); i++) {
            while (!a.isEmpty()) {
                ArrayList<Kante> current = adjazenzliste[a.pop()];
                for (int j = 0; j < current.size(); j++) {
                    if (current.get(j).c == s.charAt(i)) {
                        b.add(current.get(j).ziel);
                    }
                }
            }
            tmp = a;
            a = b;
            b = tmp;
        }

        while (!a.isEmpty()) {
            if (a.pop().equals(zielknoten)) {
                return true;
            }
        }
        
        return false;
    }

    public static void main(String[] args) {
        NFA nfa_test = new NFA(3, 1, 3);
        nfa_test.addKante(1, 2, 'a');
        nfa_test.addKante(1, 3, 'a');
        nfa_test.addKante(2, 2, 'a');
        nfa_test.addKante(2, 2, 'b');
        nfa_test.addKante(2, 3, 'a');
        System.out.println(nfa_test.testString("abba")); // true
        System.out.println(nfa_test.testString("a")); // true
        System.out.println(nfa_test.testString("ab")); // false

    }
}

class Kante {
    public char c;
    public int ziel;

    public Kante(char c, int ziel) {
        this.c = c;
        this.ziel = ziel;
    }
}
