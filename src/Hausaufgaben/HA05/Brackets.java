package Hausaufgaben.HA05;

import java.util.ArrayDeque;

public class Brackets {

    public static boolean isValid(String s) {
        ArrayDeque<Character> b = new ArrayDeque<Character>();
        try {
            for (int i = 0; i < s.length(); i++) {
                switch (s.charAt(i)) {
                    case '(':
                        b.addFirst('(');
                        break;
                    case ')':
                        if ('(' != b.poll()) {
                            return false;
                        }
                        break;
                    case '{':
                        b.addFirst('{');
                        break;
                    case '}':
                        if ('{' != b.poll()) {
                            return false;
                        }
                        break;
                    case '[':
                        b.addFirst('[');
                        break;
                    case ']':
                        if ('[' != b.poll()) {
                            return false;
                        }
                        break;
                }
            }
        } catch (NullPointerException e) {
            return false;
        }

        return b.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("(([[]]))"));
        System.out.println(isValid("([)]"));
        System.out.println(isValid("([]])"));
        System.out.println(isValid("(()))"));
        System.out.println(isValid("(()"));
        System.out.println(isValid("({[])}"));
        System.out.println(isValid(""));

        System.out.println("\n");

        System.out.println(isValid("(){}[]"));
        System.out.println(isValid("( () () (()) () ) { {} {{}} } [ [[] []] ]"));
        System.out.println(isValid("({}[]){([])}[()]"));
        System.out.println(isValid("()}[]"));
        System.out.println(isValid("(){(})[]"));

    }

}