package Hausaufgaben.HA02;

import java.util.ArrayList;

public class MyHashSet<K> {

    private int anzahlElemente = 0;
    
    // Startgroesse der Hashtabelle: 5
	private ArrayList<K>[] hash = new ArrayList[5];
	// .. = new ArrayList<T>[5]; waere hier logisch,
	// funktioniert aber in Java nicht


	/**
	 * Fuegt ein neues Element in die Hashtabelle ein.
	 * 
	 * @param element Das neue Element
	 */
	public void add(K element) {
		int x = getHash(element); // eigene Methode (siehe unten)
		// Eventuell steht an der Stelle x noch null anstatt einer ArrayList.
		if (hash[x] == null) {
			hash[x] = new ArrayList<K>();
		}
		// Nur einfuegen, wenn das Element nicht vorhanden ist.
		ArrayList<K> list = hash[x];
		if (!list.contains(element)) {
            list.add(element);
            this.anzahlElemente++;
        }
        
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



    public boolean contains(K element) {
        int x = getHash(element);
		if (hash[x] == null) {
			return false;
        }
        return hash[x].contains(element);
    }



    public String toString() {
        String ausgabe = "";
        for (int i = 0; i < hash.length; i++) {
            if (hash[i] != null) {
                ausgabe = ausgabe.concat(hash[i].toString());
                ausgabe = ausgabe.replace("][", ", ");
            }
        }
        return ausgabe;
    }



    public static void hashTest() {
		MyHashSet<Integer> h = new MyHashSet<Integer>();
		for (int i = 0; i < 20; i++) {
			int x = (int) (Math.random() * 10);
			h.add(x);
			System.out.println(x + ": " + h);
		}
		MyHashSet<Double> t = new MyHashSet<Double>();

		long zeit = System.nanoTime();
		for (int i = 0; i < 100000; i++) {
			t.add(Math.random());
		}
        System.out.println("Zeit[s]: " + (System.nanoTime() - zeit) / 1000000000.);
    }



	public static void main(String[] args) {
		hashTest();
	}

}