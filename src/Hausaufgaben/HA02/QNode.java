package Hausaufgaben.HA02;

/**
 * Eine Instanz dieser Klasse repraesentiert einen Eintrag in der LinkedList die
 * genutzt wird um MyQueue zu implementieren.
 * 
 * Ich moechte anmerken, dass ich dieses Klasse als innnere Klasse von MyQueue
 * implementiert haette um Probleme in Hinsicht auf Kapselung zu vermeiden, aber
 * ich sehe den Spielraum dafuer nicht in der Aufgabe.
 * 
 * @author Lukas Kesselburg
 */
public class QNode<T> {
    /** Das eigentliche Element, das diese Node enthaelt. */
    public T key;

    /** Die nachfolgende Node. */
    public QNode<T> next;

    /**
     * Der Konstruktor fuer diese Klasse.
     * 
     * Es wird ein Element uebergeben, dass dann in dieser Node enthalten ist.
     * 
     * @param key Das eigentliche Element dieser Node.
     */
    public QNode(T key) {
        this.key = key;
        this.next = null;
    }

}