package Hausaufgaben.HA05;

import java.util.Arrays;

public class BinarySearchTree {
    private TreeNode root;

    public boolean contains(int data) {
        TreeNode temp = root;
        while (temp != null) {
            if (temp.value == data) {
                return true;
            }
            if (temp.value > data) {
                temp = temp.left;
            } else {
                temp = temp.right;
            }
        }
        return false;

    }

    /**
     * 
     * @param Einzufuegender Datensatz
     * @return true: Datensatz wurde eingefuegt; false: Datensatz war schon
     *         vorhanden.
     */
    public boolean insert(int data) {
        if (root == null) {
            root = new TreeNode(data);
            return true;
        }

        TreeNode temp = root;
        while (temp.value != data) {
            if (temp.value > data) {
                if (temp.left == null) {
                    temp.left = new TreeNode(data);
                    return true;
                }
                temp = temp.left;
            } else {
                if (temp.right == null) {
                    temp.right = new TreeNode(data);
                    return true;
                }
                temp = temp.right;
            }
        }
        return false;

    }

    /**
     * Diese Methode bietet nach aussen die Moeglichkeit die ELemente des Baums in
     * geordneter Folge als String zu erhalten.
     */
    public String toString() {
        return this.toString(this.root);
    }

    /**
     * Diese Methode erledigt die eigentliche Arbeit für toString(). Sie geht
     * rekursiv alle Elemente durch und erzeugt einen String der die Elemente des
     * Baums in geordneter Reihenfolge enthaelt. Die Methode ruft zwei neue
     * Instanzen von sich auf, jeweils eine für jedes der Kinderelemente. Und setzt
     * den eigenen Wert dann zwischen die beiden Teilstrings.
     * 
     * @param node Der Knoten für den der Teil des Strings erstellt werden soll.
     * @return Ein String der alle Elemente des Baums in geordneter Reihe enthaellt.
     */
    private String toString(TreeNode node) {
        if (node == null) {
            return "";
        }
        return toString(node.left) + node.value + ", " + toString(node.right);
    }

    /**
     * Diese Methode bietet nach aussen die Moeglichkeit die Anzahl der ELemente des
     * Baums zu erhalten.
     * 
     * @return Die Anzahl aller Elemente im Baum.
     */
    public int getElementCount() {
        return this.getElementCount(this.root);
    }

    /**
     * Diese Methode erledigt die eigentliche Arbeit für getElementCount(). Sie geht
     * rekursiv alle Elemente durch und für jeden Teilbaum node wird die Anzahl der
     * Elemente ermittelt.
     * 
     * @param node Der Knoten für den die Anzahl der Elemente ermittelt werden soll.
     * @return Die Anzahl aller Elemente im Teilbaum node.
     */
    private int getElementCount(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return getElementCount(node.left) + 1 + getElementCount(node.right);
    }

    /**
     * Diese Methode bietet nach aussen die Moeglichkeit die Summe aller ELemente
     * des Baums zu erhalten.
     * 
     * @return Die Summe aller Elemente des Baums.
     */
    public int getSum() {
        return this.getSum(this.root);
    }

    /**
     * Diese Methode erledigt die eigentliche Arbeit für getSum(). Sie geht
     * rekursiv alle Elemente durch und addiert die Werte aller Elemente. 
     * 
     * @param node Der Teilbaum für den die Summe aller Elemente errechnet werden soll.
     * @return Die Summe aller Elemente des Teilbaums.
     */
    private int getSum(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return getSum(node.left) + node.value + getSum(node.right);
    }

    /**
     * Diese Methode bietet nach aussen die Moeglichkeit die Hoehe des Baums zu
     * erhalten.
     * 
     * @return Die Hoehe des Baums.
     */
    public int getHeight() {
        return this.getHeight(this.root);
    }

    /**
     * Diese Methode erledigt die eigentliche Arbeit für getHeight(). Sie geht
     * rekursiv alle Elemente durch und ermittelt die Hoehe des Baums.
     * 
     * @param node Der Teilbaum für den die Hoehe des Teilbaums ermittelt werden soll.
     * @return Die Hoehe des Teilbaums.
     */
    private int getHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return Math.max(getHeight(node.left), getHeight(node.right)) + 1;
    }

    /**
     * Diese Methode bietet nach aussen die Moeglichkeit die Anzahl der Blaetter des
     * Baums zu erhalten.
     * 
     * @return Die Anzahl der Blaetter in diesem Baum.
     */
    public int getLeafCount() {
        return this.getLeafCount(this.root);
    }

    /**
     * Diese Methode erledigt die eigentliche Arbeit für getLeafCount(). Sie geht
     * rekursiv alle Elemente durch und ermittelt die Anzahl der Blaetter.
     * 
     * @param node Der Teilbaum für den die Anzahl der Blaetter ermittelt werden soll.
     * @return Die Anzahl der Blaetter des Teilbaums.
     */
    private int getLeafCount(TreeNode node) {
        if (node == null) {
            return 0;
        }
        if (node.left == null && node.right == null) {
            return 1;
        } else {
            return getLeafCount(node.left) + getLeafCount(node.right);
        }

    }

    /**
     * Diese Methode bietet nach aussen die Moeglichkeit zu erfahren ob es Nodes mit
     * nur einem Kind gibt.
     * 
     * @return true wenn es eine Node mit nur einem Kind gibt, sonst false.
     */
    public boolean hasNodesWithOneChild() {
        return this.hasNodesWithOneChild(this.root);
    }

    /**
     * Diese Methode erledigt die eigentliche Arbeit für hasNodesWithOneChild(). Sie geht
     * rekursiv alle Elemente durch und prueft ob eine Node mit nur einem Kind existiert.
     * 
     * @param node Der Teilbaum für den ermittelt werden soll ob eine Node mit nur einem Kind existiert.
     * @return true, wenn dieser Teilbaum eine Node mit nur einem Kind enthaellt.
     */
    private boolean hasNodesWithOneChild(TreeNode node) {
        if (node.left == null && node.right == null) {
            return false;
        } else if (node.left == null || node.right == null) {
            return true;
        } else {
            return hasNodesWithOneChild(node.left) || hasNodesWithOneChild(node.right);
        }
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        for (int i = 0; i < 20; i++) {
            int x = (int) (Math.random() * 50);
            System.out.println(x);
            tree.insert(x);
        }

        // Fuer praezieseres/einfacheres testen
        // for (int i = 0; i < 10; i++) {
        // int x = (int) (Math.random() * 10);
        // System.out.println(x);
        // tree.insert(x);
        // }

        // tree.insert(4);
        // tree.insert(2);
        // tree.insert(6);
        // tree.insert(1);
        // tree.insert(3);
        // tree.insert(5);
        // tree.insert(7);

        for (int i = 0; i < 50; i++) {
            System.out.println(i + ": " + tree.contains(i));
        }

        System.out.println(tree.toString());
        System.out.println(tree.getElementCount());
        System.out.println(tree.getSum());
        System.out.println(tree.getHeight());
        System.out.println(tree.getLeafCount());
        System.out.println(tree.hasNodesWithOneChild());

    }

}
