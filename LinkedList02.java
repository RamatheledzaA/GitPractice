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
        node1.prev = node5; // circular link

        node2.next = node3;
        node2.prev = node1;

        node3.next = node4;
        node3.prev = node2;

        node4.next =node5;
        node4.prev = node3;

        node5.next = node1;
        node5.prev = node4;

        // let's start to display  everything in a transversing forward and backward

        System.out.println(" Transversing Forward");
        Node currentNode = node1;
        Node startNode = node1;
        System.out.print( currentNode.data);
        currentNode = currentNode.next;

        while( currentNode != startNode){
            System.out.print(currentNode.data);
            currentNode = currentNode.next;
        }
        System.out.println("......."); // this indicated  that it loops back

        // now let's focus on the Transversing backward
        System.out.println(" Transversing backward");
        currentNode = node5;
        startNode = node5;


        System.out.print(currentNode.next);
        currentNode = currentNode.prev;

        while ( currentNode != startNode){
            System.out.print(currentNode.next);
            currentNode = currentNode.prev;
        }
        System.out.println(".......");
        

    }
}
