package Uebung.Boyer_Moore;

import Hausaufgaben.HA11.LastTabelle;

public class Bananensaft {
    LastTabelle tabelle;

    public Bananensaft(LastTabelle lastTabelle) {
        this.tabelle = lastTabelle;
    }

    public static int search(String pattern, String word) {
        int count = 0;
        LastTabelle l = new LastTabelle(pattern);
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == pattern.charAt(count)) {
                count++;
                if (count == pattern.length()) {
                    return i - pattern.length() + 1;
                }
            } else {
                int nextCharIndex = i + pattern.length() - count;
                count = 0;
                if (l.get(word.charAt(nextCharIndex)) == -1) {
                    i = nextCharIndex;
                } else {
                    i += pattern.length() - l.get(word.charAt(nextCharIndex)) - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(search("aft", "Bananensaft")); // 8
        System.out.println(search("lij", "Testbistdulijhatkeins")); // 10
        System.out.println(search("blub", "blablababbelblabberblubbabbel")); // 19
    }
}