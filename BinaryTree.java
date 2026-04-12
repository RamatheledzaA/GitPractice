// ramatheledza Adzisani

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

    // create a methode that counts the number of node in the tree



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


    }
}
