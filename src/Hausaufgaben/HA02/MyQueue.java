package Hausaufgaben.HA02;

/**
 * Eine Instanz dieser Klasse bildet eine Queue.
 * 
 * Diese Klasse ist mit Hilfe einer Queue implementiert.
 * 
 * @param <T> Der Typ der Elemente die in diese Queue kommen.
 */
public class MyQueue<T> {
    /** Zeiger auf das erste und das letzte Element der Queue. */
    private QNode<T> front, rear;

    /**
     * Konstruktor.
     * 
     * Setzt this.front und this.rear auf null.
     */
    public MyQueue() {
        this.front = this.rear = null;
    }

    /**
     * Diese Methode ist getter fuer das erste Element der Queue.
     * 
     * @return Das erste Elemente der Queue.
     */
    public T getFirst() {
        return this.front.key;
    }

    /**
     * Diese Methode ist getter fuer das letzte Element der Queue.
     * 
     * @return Das letzte Element der Queue.
     */
    public T getLast() {
        return this.rear.key;
    }

    /**
     * Diese Methode fuegt das uebergebene ELement am Ende der Queue ein.
     * 
     * @param key Das anzufuegene Element.
     */
    public void enqueue(T key) {
        // Erstellen einer neuen QNode für die interne Liste.
        QNode<T> temp = new QNode<T>(key);

        // Wenn die Queue leer ist, ist das neue ELement sowohl das erste als auch das
        // letzte.
        if (this.rear == null) {
            this.front = this.rear = temp;
            return;
        }

        // Füge das neue Element am Ende der Queue ein.
        this.rear.next = temp;
        this.rear = temp;
    }

    /**
     * Diese Methode fuegt das uebergebene Element am Anfang der Queue ein.
     * 
     * @param key Das einzufuegende Element.
     */
    public void enqueueAtFront(T key) {
        // Erstellen einer neuen QNode fuer die interne Liste.
        QNode<T> temp = new QNode<T>(key);

        // Wenn die Queue leer ist, ist das neue ELement sowohl das erste als auch das
        // letzte.
        if (this.front == null) {
            this.front = this.rear = temp;
            return;
        }

        // Fuege das neue Element an erster Stelle ein.
        temp.next = this.front;
        this.front = temp;
    }

    /**
     * Diese Methode nimmt das erste Element aus der Queue und gibt es zurueck.
     * 
     * @return Das bis zum Aufruf dieser Methode erste Element in der Queue.
     */
    public T dequeue() {
        // Wenn die Queue leer ist, gib null zurueck.
        if (this.front == null) {
            return null;
        }

        // Merke dir das erste Element und schiebe den Zeiger auf das zweite Element.
        QNode<T> temp = this.front;
        this.front = this.front.next;

        // Wenn nur ein ELement in der Liste war, setzte auch this.rear auf null.
        if (this.front == null) {
            this.rear = null;
        }

        return temp.key;
    }

    /**
     * Diese Methode loescht alle Elemente aus der Liste.
     */
    public void clear() {
        this.front = this.rear = null;
    }

    /**
     * Diese Methode erzeugt einen String der Form "[Element1, Element2, ...]"
     * 
     * @return Ein String im oben genannten Format.
     */
    public String toString() {
        if (this.front == null) {
            return "[]";
        }
        StringBuilder res = new StringBuilder("[");
        for (QNode<T> node = this.front; node != null; node = node.next) {
            res.append(node.key.toString() + ", ");
        }
        if (res.length() > 2) {
            res.delete(res.length() - 2, res.length());
        }
        return res.append("]").toString();
    }

}