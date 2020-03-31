package Hausaufgaben.HA01;

/**
 * Diese Vorlage dieser Klasse stammt aus folgender Quelle:
 * https://alvinalexander.com/java/simple-java-generics-example-class-tutorial/
 * 
 * @param <K> Der Typ des Keys.
 * @param <V> Der Typ des Values.
 */
class Tuple<K, V> {
    private final K k;
    private final V v;

    public Tuple(K key, V value) {
        k = key;
        v = value;
    }

    /**
     * Diese Methode ist der Getter fuer den Key des Tuples.
     * 
     * @return Der Key dieses Tuples.
     */
    public K getKey() {
        return this.k;
    }

    /**
     * Diese Methode ist der Getter fuer den Value des Tuples.
     * 
     * @return Der Value dieses Tuples.
     */
    public V getValue() {
        return this.v;
    }

    public String toString() {
        return String.format("KEY: '%s', VALUE: '%s'", k, v);
    }

    /**
     * Eine kleine Testmethode.
     * 
     * @param args Wird hier nicht verwendet.
     */
    public static void main(String[] args) {
        Tuple<String, Integer> t = new Tuple<String, Integer>("foo", 1);
        System.out.println(t);
        System.out.println(t.getKey() + ": " + t.getValue());
    }

}