package Hausaufgaben.HA02;

/**
 * Dies ist ein kleine Testklassse fuer die Klasse MyQueue.
 * 
 * @author Lukas Kesselburg
 */
public class MyQueueTest {

    public static void main(String[] args) {
        MyQueue<Integer> q = new MyQueue<Integer>();
        System.out.println(q.toString());
        q.enqueue(10);
        q.enqueue(20);
        System.out.println(q.toString());
        q.clear();
        System.out.println(q.toString());
        q.enqueue(30);
        q.enqueue(40);
        q.enqueue(50);
        System.out.println(q.toString());
        q.enqueueAtFront(20);
        System.out.println(q.toString());
        q.dequeue();
        q.dequeue();
        System.out.println(q.toString());
        System.out.println("Queue Front : " + q.getFirst());
        System.out.println("Queue Rear : " + q.getLast());
    }

}