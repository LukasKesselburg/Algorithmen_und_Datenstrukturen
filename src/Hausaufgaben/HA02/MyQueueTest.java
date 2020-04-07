package Hausaufgaben.HA02;

public class MyQueueTest {

    public static void main(String[] args) 
    { 
        MyQueue<Integer> q = new MyQueue<Integer>(); 
        q.enqueue(10); 
        q.enqueue(20); 
        q.dequeue(); 
        q.dequeue(); 
        q.enqueue(30); 
        q.enqueue(40); 
        q.enqueue(50); 
        q.dequeue(); 
        System.out.println("Queue Front : " + q.getFirst()); 
        System.out.println("Queue Rear : " + q.getLast());
        System.out.println(q.toString());
    } 


}