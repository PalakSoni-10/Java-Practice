public class LL {
    Node head;
    private int size;

    LL() {
        size = 0;
    }

    public class Node {
        String data;
        Node next;

        Node(String data) {
            this.data=data;
            this.next=null;
            size++;
        }
    }

    public void addFirst(String data) {
        Node newNode = new Node(data);
        newNode.next=head;
        head=newNode;
    }

    public void addLast(String data) {
        Node newNode = new Node(data);
        if(head==null) {
            head=newNode;
            return;
        }

        Node lastNode = head;
        while(lastNode.next!=null) {
            lastNode=lastNode.next;
        }
        lastNode.next=newNode;
    }

    public void printList() {
        Node currNode = head;
        while(currNode!=null) {
            System.out.print(currNode.data+" -> ");
            currNode=currNode.next;
        }
        System.out.println("null");
    }

    public void removeFirst() {
        if(head==null) {
            System.out.println("Empty list, nothing to remove");
            return;
        }

        head=this.head.next;
        size--;
    }

    public void removeLast() {
        if(head==null) {
            System.out.println("Empty list, nothing to remove");
            return;
        }

        size--;
        if(head.next==null) {
            head=null;
            return;
        }

        Node currNode=head;
        Node lastNode=head.next;

        while(lastNode.next!=null) { 
            currNode = currNode.next;
            lastNode =lastNode.next;
        }

        currNode.next=null;
    }

    public int getSize() {
        return size;
    }

    public void addInMiddle(int index, String data) {
        if(index>size || index<0) {
            System.out.println("invalid index value");
            return;
        }

        size++;
        Node newNode = new Node(data);
        if(head==null || index==0) {
            newNode.next=head;
            head=newNode;
            return;
        }

        Node currNode= head;
        for(int i=1; i<size; i++) {
            if(i==index) {
                Node nextNode = currNode.next;
                currNode.next=newNode;
                newNode.next=nextNode;
                break;
            }
            else 
            currNode= currNode.next;

        }
    }

    public void reverseIterate() {
        if(head==null || head.next==null)
        {
            return;
        }

        Node prevNode=head;
        Node currNode=head.next;
        while(currNode!=null) {
            Node nextNode=currNode.next;
            currNode.next=prevNode;

            //update
            prevNode=currNode;
            currNode=nextNode;
        }

        head.next=null;
        head=prevNode;
    }

    public Node reverseRecursive(Node head)
    {
        if(head==null || head.next==null)
        return head;
        
        Node newHead= reverseRecursive(head.next);
        head.next.next=head;
        head.next=null;
        return newHead;
    }

    public Node removeNthFromEnd(Node head, int n) {
        if(head.next==null)
        return null;

        int size=0;
        Node curr=head;
        while(curr!=null)
        {
            curr=curr.next;
            size++;
        }

        if(n==size)
        return head.next;

        int index=size-n;
        Node prev=head;
        int i=1;
        while(i<index)
        {
            prev=prev.next;
            i++;
        }

        prev.next=prev.next.next;
        return head;
    }




        public static void main(String[] args) {
            LL list=new LL();
            list.addLast("is");
            list.addLast("a");
            list.addLast("list");
            //list.printList();
            list.addFirst("this");
            list.addInMiddle(3, "linked");
            list.printList();
            //System.out.println(list.getSize());
            //list.removeFirst();
            //list.printList();
            //list.removeLast();
            //list.reverseIterate();
            //list.head=list.reverseRecursive(list.head);
            list.removeNthFromEnd(list.head, 2);
            list.printList();

        }
    }
            


