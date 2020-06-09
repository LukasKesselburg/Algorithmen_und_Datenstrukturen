package Hausaufgaben.HA11;

import java.util.HashMap;

public class LastTabelle {
    private HashMap<Character, Integer> map = new HashMap<Character, Integer>();

    public LastTabelle(String s) {
        for (int i = 0; i < s.length(); i++) {
            this.map.put(s.charAt(i), i);
        }
    }

    public int get(char c) {
        try {
            return this.map.get(c);
        } catch (Exception e) {
            return -1;
        }
    }

    public static void main(String[] args) {
        String test = "test";
        LastTabelle tabelle = new LastTabelle(test);
        for (int i = 0; i < test.length(); i++) {
            System.out.println(test.charAt(i) + ": " + tabelle.get(test.charAt(i)));
        }
        System.out.println('c' + ": " + tabelle.get('c'));        
    }
}