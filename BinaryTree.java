// ramatheledza Adzisani

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    public static class BinaryNode{
        int data;
        BinaryNode left, right;
        public BinaryNode( int data){
            this.data = data;
            left= right = null ;
        }
    }
// create a pre order method for a tree and print
    public static void printPreOrder (BinaryNode node){
        if(node == null){
            return;
        }

        System.out.print(node.data + " , ");
        printPreOrder(node.left);
        printPreOrder(node.right);
    }

    // in order method and print
    public static void printInOrder (BinaryNode node){
        if(node == null){
            return;
        }
        printInOrder(node.left);
        System.out.print(node.data + " , ");
        printInOrder(node.right);
    }

    // post order method and print
    public static void printPostOrder (BinaryNode node){
        if(node == null){
            return;
        }
        printInOrder(node.left);
        printInOrder(node.right);
        System.out.print(node.data + " , ");
    }

    // method that display level by level
    public static void LevelByLevel ( BinaryNode node) {
        if ( node == null) {
            return;
        }
        Queue<BinaryNode> tree = new LinkedList<>();
        tree.add(node);

        while (!tree.isEmpty()){
            BinaryNode current = tree.poll();
            System.out.print(current.data + " ");

            if (current.left == null){
                tree.add(current.left);
            }
            if (current.right == null){
                tree.add(current.right);
            }
        }

    }


    // create a method that counts the number of node in the tree
    public static int CountNodes(BinaryNode node){
        if(node == null){
            return 1 + CountNodes(node.left) + CountNodes(node.right);
        }


        return 0;
    }
    // fing the height of the tree
    public static int Height(BinaryNode node){
        if (node == null){

            int leftHeight = Height(node.left);
            int rightHeight= Height(node.right);

            return 1 + Math.max(leftHeight , rightHeight);
        }
        return 0;
    }


    // find  a node with no children ( leaf)
    static int countLeaves(BinaryNode node) {
        if (node == null)
            return 0;

        if (node.left == null && node.right == null)
            return 1;

        return countLeaves(node.left) + countLeaves(node.right);
    }


    // a amethod that returns true or false if a value exits
    static boolean ValueExist(BinaryNode node, int key){
        if ( node == null){
            return false;
        }
        if (node.data == key){
            return true;
        }
        return ValueExist(node.left , key) || ValueExist(node.right , key);
    }

    // method that sum the values in the tree
    public static int sumValues (BinaryNode node){

        if ( node == null){
            int leftChild = sumValues(node.left);
            int rightChild = sumValues(node.right);
            int sum = leftChild + rightChild;
            return node.data +  sum;
    }

    // create a method that swaps the values and print
    void swapValues (BinaryNode node){
        if ( node == null){
            return;
        }

        BinaryNode temp = node.left;
        node.left = node.right;
        node.right = temp ;

        swapValues(node.left);
        swapValues(node.right);
        return node;
    }





    // the main method
    public static void main(String [] args){
        BinaryNode root = new BinaryNode(11);
        BinaryNode node1 = new BinaryNode(7);
        BinaryNode node2 = new BinaryNode(15);
        BinaryNode node3 = new BinaryNode(3);
        BinaryNode node4 = new BinaryNode(9);
        BinaryNode node5 = new BinaryNode(13);
        BinaryNode node6 = new BinaryNode(19);
        BinaryNode node7 = new BinaryNode(2);
        BinaryNode node8= new BinaryNode(4);
        BinaryNode node9= new BinaryNode(8);

        // align the tree
        root.left = node1;
        root.right = node2;

        node1.left = node3;
        node1.right = node4 ;

        node2.left=  node5;
        node2.right = node6 ;

        node3.left = node7;
        node3.right = node8 ;

        node4.left = node9;

        // display all the output
        System.out.println("----Pre Order------");
        printPreOrder(root);
        System.out.print("\n");
        System.out.println("----In Order------");
        printInOrder(root);
        System.out.print("\n");
        System.out.println("----Post Order------");
        printPostOrder(root);
        System.out.print("\n");
        System.out.println("--------Level by level------");
        LevelByLevel(root);
        System.out.print("\n");
        System.out.println( "Number of nodes in the tree : " + CountNodes(root));
        System.out.println("The height of the tree : " + Height(root));
        System.out.println("The leaf of the tree : " + countLeaves(root));
        System.out.println("Return (true / false) if value exist : " + ValueExist(root));
        System.out.println ("Sum of all nodes in the tree :" + sumValues(root));
        System.out.println("The binaty tree after values have beee swapped: "+ swapValues(root));




    }
}


