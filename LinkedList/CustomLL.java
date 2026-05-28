public class CustomLL{
    //DEFINING NODE CLASS
    private class Node{
        int data; 
        Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public CustomLL(){
        this.size = 0;
    }

    public void display(){
        Node temp = head;
        while (temp!=null){
            System.out.print(temp.data+" -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }

    public void insertFirst(int val){
        Node new_node = new Node(val);
        new_node.next = head;
        head = new_node;
        if (tail==null) tail=head;
        size++;
    }

    public void insertLast(int val){
        if (tail==null){
            insertFirst(val) ;
            return;
        }
        Node new_node = new Node(val);
        tail.next = new_node;
        tail = new_node;
        size++;
    }

    public void insertAtIdx(int val, int index){
        if (size<index || index<0){
            System.out.println("Index out of bounds");
            return;
        }
        else if (tail==null || index==0){
            insertFirst(val);
            return;
        }
        else if (index==size){
            insertLast(val);
            return;
        }
        int idxCount = 0;
        Node temp = head;
        while (idxCount!=index-1){
            temp = temp.next;
            idxCount++;
        }
        Node new_node = new Node(val);
        new_node.next = temp.next;
        temp.next = new_node;
        size++;
    }


    public static void main(String[] args) {
        CustomLL list = new CustomLL();
        list.insertFirst(20);
        list.insertFirst(10);
        list.insertLast(30);
        list.insertLast(40);

        System.out.print("Custom Linked List: ");
        list.display(); // Expected Output: 10 -> 20 -> 30 -> 40 -> END
    }
}