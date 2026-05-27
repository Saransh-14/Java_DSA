public class CircularQueue{
    protected int[] circularQueue;
    protected int front = 0;
    protected int rear = 0;
    protected int size = 0;

    public CircularQueue(int capacity){
        this.circularQueue = new int[capacity];
    }

    public boolean add(int val){
        if (size==circularQueue.length){
            System.out.println("Queue 0verflow");
            return false;
        }
        circularQueue[rear] = val;
        rear = (rear+1)%circularQueue.length;
        size++;
        return true;
    }

    public int remove(){
        if (size==0){
            System.out.println("Queue underflow");
            return -1;
        }
        int removed = circularQueue[front];
        front = (front+1)%circularQueue.length;
        size--;
        return removed;
    }

    public int peek(){
        if (size==0) return -1;
        return circularQueue[front];
    }
}