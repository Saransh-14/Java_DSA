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

    public int deleteFirst(){
        if (head==null){
            System.out.println("Linked List is empty");
            return -1;
        }
        int val = head.data;
        head = head.next;
        if (head==null) tail=null;
        size--;
        return val;
    }

    public int deleteLast(){
        if (size<=1) return deleteFirst();
        Node temp = head;
        while (temp.next != tail){
            temp = temp.next;
        }
        int val = tail.data;
        temp.next = null;
        tail = temp;
        size--;
        return val;
    }

    public int deleteAtIndex(int idx){
        if (idx>=size || idx<0){
            System.out.println("Index out of bounds");
            return -1;
        }

        if (idx==0) return deleteFirst();
        if (idx==size-1) return deleteLast();
        Node temp = head;
        while (idx>1){
            temp = temp.next;
            idx--;
        }
        Node target = temp.next;
        int val = target.data;
        temp.next = target.next;
        size--;
        return val;
    }


    public static void main(String[] args) {
        CustomLL ll = new CustomLL();
        ll.insertLast(10);
        ll.insertLast(20);
        ll.insertLast(30);
        ll.insertLast(40);
        ll.insertLast(50);

        System.out.print("Original List: ");
        ll.display(); // 10 -> 20 -> 30 -> 40 -> 50 -> END

        System.out.println("Deleted from First: " + ll.deleteFirst()); // 10
        System.out.println("Deleted from Last:  " + ll.deleteLast());  // 50
        System.out.println("Deleted from Idx 1: " + ll.deleteAtIndex(1)); // 30 (Kyunki list ab 20->30->40 bachi thi)

        System.out.print("Final List: ");
        ll.display(); // 20 -> 40 -> END
    }
}