// Rmatheledza Adzisani 4484298
// prep: Circular singly linked list

public class LinkedList02 {

    // start by creating a class node
    static class Node{
        int data;
        Node next;
        Node prev;

        Node ( int data){
            this.data = data;
            this.next = null;
            this.prev = null ;
        }
    }
    public static void main(String[] args){
        // create  new nodes
        Node node1 = new Node(5);
        Node node2 = new Node(12);
        Node node3 = new Node(2);
        Node node4 = new Node(25);
        Node node5 = new Node(27);

        // now let's link the nodes
        node1.next = node2;
        node1.prev = node5;

        node2.next = node3;
        node2.prev = node1;

        node3.next = node4;
        node3.prev = node2;

        node4.next =node5;
        node4.prev = node3;

        node5.next = node1;
        node5.prev = node4;



    }
}
