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

//MERGING TWO SORTED LINKED LIST TOGETHER USING A DUMMY NODE
    public Node mergeList(Node head1, Node head2){
        Node dummy = new Node(-1);
        Node tail = dummy;
        Node p1 = head1, p2 = head2;
        while (p1 != null && p2 != null){
            if (p1.data <= p2.data){
                tail.next = p1;
                p1 = p1.next;
            }
            else {
                tail.next = p2;
                p2 = p2.next;
            }
            tail = tail.next;
        }

        if (p1 != null){
            tail.next = p1;
        }
        else {
            tail.next = p2;
        }

        return dummy.next;
    }
    public static void main(String[] args) {
        CustomLL list1 = new CustomLL();
        list1.insertLast(1);
        list1.insertLast(3);
        list1.insertLast(5);

        CustomLL list2 = new CustomLL();
        list2.insertLast(2);
        list2.insertLast(4);
        list2.insertLast(6);

        System.out.print("List 1: "); 
        list1.display(list1.head); // 1 -> 3 -> 5 -> END
        System.out.print("List 2: "); 
        list2.display(list2.head); // 2 -> 4 -> 6 -> END

        CustomLL resultList = new CustomLL();
        // mergeList call kiya aur return wale head ko resultList ke head mein daal diya
        resultList.head = resultList.mergeList(list1.head, list2.head);

        System.out.print("Merged Sorted List: ");
        resultList.display(resultList.head); // Expected Output: 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> END
    }
    
}