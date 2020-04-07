package Hausaufgaben.HA02;

import java.util.ArrayList;

/**
 * Instanzen dieser Klasse repaesentieren ein HashSet.
 * 
 * Das HashSet ist mit dynamisch hashing implementiert.
 * 
 * @author Lukas Kesselburg
 * 
 * @param <K> Typ der Elemente die in der HashMap gespeichert werden.
 */
public class MyHashSet<K> {
    /** Anzahl der Elemente in dem HashSet */
    private int anzahlElemente = 0;

    /**
     * Diese ArrayList enthaelt, spaeter ArrayLists,deren enthaltene Elemente alle
     * den selben Hash haben. Wenn nach dem Hinzufuegen eines Elements die Anzahl
     * der Elemente mehr alss doppelt so groß ist wie Anzahl der TeilListen, wird
     * die Anzahl der TeilListen verdoppelt und alle Elemente neu einsortiert.
     * Startgroesse der Hashtabelle: 5
     */
    private ArrayList<K>[] hash = new ArrayList[5];
    // .. = new ArrayList<T>[5]; waere hier logisch,
    // funktioniert aber in Java nicht

    /**
     * Fuegt ein neues Element in die Hashtabelle ein.
     * 
     * Wenn nach dem Hinzufuegen von "element" die Anzahl der Elemente mehr alss
     * doppelt so groß ist wie Anzahl der TeilListen, wird die Anzahl der TeilListen
     * verdoppelt und alle Elemente neu einsortiert.
     * 
     * @param element Das neue Element
     */
    public void add(K element) {
        int x = getHash(element);
        // Eventuell steht an der Stelle x noch null anstatt einer ArrayList.
        if (hash[x] == null) {
            hash[x] = new ArrayList<K>();
        }
        // Nur einfuegen, wenn das Element nicht vorhanden ist.
        ArrayList<K> list = hash[x];
        if (!list.contains(element)) {
            list.add(element);
            this.anzahlElemente++;
            // Erstellen von doppelt so vielen TeilListen und kopieren der Elemente
            if (this.anzahlElemente / this.hash.length > 2) {
                ArrayList<K>[] oldHash = this.hash;
                this.hash = new ArrayList[this.hash.length * 2];

                for (int i = 0; i < oldHash.length; i++) {
                    if (hash[i] != null) {
                        for (int j = 0; j < oldHash[i].size(); j++) {
                            this.add(oldHash[i].get(j));
                        }
                    }
                }
            }
        }
    }

    /**
     * Berechnet der Hashwert eines neuen Elements
     * 
     * @param element Das neue Element
     * @return der zugehoerige Hashwert
     */
    private int getHash(K element) {
        // return 0;
        return Math.abs(element.hashCode()) % hash.length;
    }

    /**
     * Loescht das angegebene Element falls vorhanden und gibt dann true zurueck,
     * ist das Element nicht vorhanden bleibt das HashSet unveraendert und es wird
     * false zurueckgegeben.
     * 
     * @param element Das zu loeschende Element.
     * @return true falls das Element vorhanden war, sonst false
     */
    public boolean delete(K element) {
        int x = getHash(element);

        if (hash[x] == null || !hash[x].contains(element)) {
            return false;

        }

        if (hash[x].remove(element)) {
            this.anzahlElemente--;
            return true;
        } else {
            return false;
        }
    }

    /**
     * Gibt true zurueck falls das Element im HashSet enthalten ist, sonst false.
     * 
     * @param element Das zu pruefende Element.
     * @return Ob das ELement enthalten ist oder nicht.
     */
    public boolean contains(K element) {
        int x = getHash(element);
        if (hash[x] == null) {
            return false;
        }
        return hash[x].contains(element);
    }

    /**
     * Erzeugt einen String im Format "[Element1, Element2, ...]"
     * 
     * @return Ein String im oben erwaehnten Format.
     */
    public String toString() {
        String ausgabe = "";
        for (int i = 0; i < hash.length; i++) {
            if (hash[i] != null && hash[i].size() > 0) {
                ausgabe = ausgabe.concat(hash[i].toString());
                ausgabe = ausgabe.replace("][", ", ");
            }
        }
        return ausgabe;
    }

    /**
     * Diese Funktion dient dem Testen.
     * 
     * Im ersten Schritt werden ein paar Beipiel Elemente eingefuegt. 3, 7, 8 wird
     * versucht zu loeschen. Es wird geprueft ob die vorhanden ist.
     * 
     * Im zweiten Schritt werden 100.000 Random Elemente erzeugt und hinzugefuegt,
     * dabei wird die Laufzeit gemessen.
     */
    public static void hashTest() {
        MyHashSet<Integer> h = new MyHashSet<Integer>();
        for (int i = 0; i < 20; i++) {
            int x = (int) (Math.random() * 10);
            h.add(x);
            System.out.println(x + ": " + h);
        }
        System.out.println("h delete 3: " + h.delete(3));
        System.out.println("h delete 7: " + h.delete(7));
        System.out.println("h delete 8: " + h.delete(8));
        System.out.println("h contains 4: " + h.contains(4));
        System.out.println(h);

        MyHashSet<Double> t = new MyHashSet<Double>();
        long zeit = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            t.add(Math.random());
        }
        System.out.println("Zeit[s]: " + (System.nanoTime() - zeit) / 1000000000.);
    }

    /**
     * Main Methode, hier wird die Testmethode aufgerufen.
     * 
     * @param args Hier nicht genutzt.
     */
    public static void main(String[] args) {
        hashTest();
    }

}