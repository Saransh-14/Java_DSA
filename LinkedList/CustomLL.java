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
//DISPLAYING THE LINKED LIST
    public void display(Node head){
        Node temp = head;
        while (temp!=null){
            System.out.print(temp.data+" -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }
//INSERTING NODE AT THE STARTING OF THE LINKED LIST
    public void insertFirst(int val){
        Node new_node = new Node(val);
        new_node.next = head;
        head = new_node;
        if (tail==null) tail=head;
        size++;
    }
//INSERTING NODE AT THE END OF THE LINKED LIST
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
//INSERTING NEW NODE AT THE GIVEN INDEX
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
//DELETING FIRST NODE FROM THE LINKED LIST
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
//DELETING THE LAST ELEMENT FROM THE LINKED LIST
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
//DELETING A NODE FORM THE GIVEN INDEX
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
//REVERSING THE LINKED LIST
    public Node reverseList(Node head){
        Node prev = null;
        Node curr = head;
        while (curr != null){
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
        return prev;
    }
//FINDING THE MIDDLE OF THE LINKED LIST
    public Node findMiddle(Node head){
        if (head==null || head.next==null){
            return head;
        }
    
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
//FLOYD'S CYCLE FINDING ALGORITHM
    public boolean findCycle(Node head){
        if (head==null || head.next==null) return false;
        Node fast = head;
        Node slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow==fast) return true;
        }
        return false;
    }
    public static void main(String[] args) {
        CustomLL ll = new CustomLL();
        ll.insertLast(10);
        ll.insertLast(20);
        ll.insertLast(30);
        ll.insertLast(38);
        ll.insertLast(43);
        ll.insertLast(48);
        // ll.insertLast(50);
        // ll.insertLast(56);

        System.out.print("Original List: ");
        ll.display(ll.head); // 10 -> 20 -> 30 -> 40 -> 50 -> END

        // System.out.println("Deleted from First: " + ll.deleteFirst()); // 10
        // System.out.println("Deleted from Last:  " + ll.deleteLast());  // 50
        // System.out.println("Deleted from Idx 1: " + ll.deleteAtIndex(1)); // 30 (Kyunki list ab 20->30->40 bachi thi)

        System.out.print("Final List: ");
        // System.out.println("Middle Node: "+ll.findMiddle(ll.head).data); // 20 -> 40 -> END
        ll.display(ll.reverseList(ll.head)); // 10 -> 20 -> 30 -> 40 -> 50 -> END
        
    }
}