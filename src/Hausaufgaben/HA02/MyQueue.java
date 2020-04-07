package Hausaufgaben.HA02;

public class MyQueue<T> {
    private QNode<T> front, rear;

    public MyQueue() {
        this.front = this.rear = null;
    }

    public T getFirst() {
        return this.front.key;
    }

    public T getLast() {
        return this.rear.key;
    }

    // Method to add an key to the queue.
    public void enqueue(T key) {

        // Create a new LL node
        QNode<T> temp = new QNode<T>(key);

        // If queue is empty, then new node is front and rear both
        if (this.rear == null) {
            this.front = this.rear = temp;
            return;
        }

        // Add the new node at the end of queue and change rear
        this.rear.next = temp;
        this.rear = temp;
    }

    public void enqueueAtFront(T key) {
        // Create a new LL node
        QNode<T> temp = new QNode<T>(key);

        // If queue is empty, then new node is front and rear both
        if (this.front == null) {
            this.front = this.rear = temp;
            return;
        }

        // Add the new node at the end of queue and change rear
        temp.next = this.front;
        this.front = temp;
    }

    // Method to remove an key from queue.
    public T dequeue() {
        // If queue is empty, return NULL.
        if (this.front == null) {
            return null;
        }

        // Store previous front and move front one node ahead
        QNode<T> temp = this.front;
        this.front = this.front.next;

        // If front becomes NULL, then change rear also as NULL
        if (this.front == null) {
            this.rear = null;
        }

        return temp.key;
    }

    public void clear() {
        this.front = this.rear = null;
    }

    public String toString() {
        if (this.front == null)
        {
            return "[]";
        }
        StringBuilder res = new StringBuilder("[");
        for (QNode node = this.front; node != null; node = node.next) {
            res.append(node.key.toString() + ", ");
        }
        return res.delete(res.length() - 2, res.length()).append("]").toString();
    }

}