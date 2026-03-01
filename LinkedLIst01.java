// Rmatheledza Adzisani 4484298
// prep: Circular singly linked list


public class LinkedLIst01 {
     //create a node classs
    static class Node{
        int data ;
        Node next;
        Node ( int data){
            this.data = data;
            this.next = null;
        }
     }

     public static void main(String[] args){
         // create 4 new node
         Node node1 = new Node(3);
         Node node2 = new Node(5);
         Node node3 = new Node(15);
         Node node4 = new Node(5);

         // now start linking the nodes
         node1.next = node2;
         node2.next = node3;
         node3.next = node4;
         node4.next = node1; // this indicates a circular link

         Node currentNode = node1;
         Node startNode = node1 ;
         System.out.print( currentNode.data + " - >");
         currentNode = currentNode.next;

         while ( currentNode != startNode){
             System.out.print( currentNode.data);
             currentNode = currentNode.next;
         }
         System.out.println("------");

     }
}
