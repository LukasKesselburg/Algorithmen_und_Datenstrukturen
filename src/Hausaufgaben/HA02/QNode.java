package Hausaufgaben.HA02;

public class QNode<T> {
    public T key; 
    public QNode next; 
  
    // constructor to create a new linked list node 
    public QNode(T key) 
    { 
        this.key = key; 
        this.next = null; 
    }

}