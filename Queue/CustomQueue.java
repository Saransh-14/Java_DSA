public class CustomQueue{
    protected int[] queue;
    protected int front = 0;
    protected int rear = 0;
    protected int size = 0;

    public CustomQueue(int capacity){
        this.queue = new int[capacity];
    }

    public boolean add(int val){
        if (size==queue.length){
            System.out.println("Queue 0verflow");
            return false;
        }
        queue[rear]=val;
        rear++;
        size++;
        return true;
    }

    public int remove(){
        if (size==0){
            System.out.println("Queue Underflow");
            return -1;
        }
        int removed = queue[front];
        for (int i = 1; i<rear; i++){
            queue[i-1] = queue[i];
        }
        rear--;
        size--;
        return removed;
    }

    public int peek(){
        if (size==0) return -1;
        return queue[front];
    }
}