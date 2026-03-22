

// Ramatheledza Adzisani 4484298
public static class TraversalProblem1 {
    // Create a node class
    public static class Node{
        int data;
        Node left , right ;
        public Node( int data){
            this.data= data;
            left = right = null;
        }
    }

    // Return height of tree
    public static int Height(Node root){
        if( root == null){
            return 0;
        }
        int Heightleft = Height(root.left);
        int HeightRight = Height(root.right);

        return 1 + Math.max(Heightleft,HeightRight);

    }

    //(Count Leaf Nodes)
    public static int CountLeaves(Node root){
        if(root == null) {
            return 0;
        }

        if (root.left == null && root.right == null){
            return 1 ;
        }
        return  CountLeaves(root.left) + CountLeaves(root.right);
    }

    //Print only leaf nodes
    public void printLeaves(Node root){
        if( root == null){
            return;
        }
        if (root.left == null && root.right == null){
            System.out.println(root.data + " ");
        }
        printLeaves(root.left);
        printLeaves(root.right);

    }

    // Search in a tree
    public static boolean search ( Node root , int key){

        if( root == null){
            return false;
        }

        if ( root.data == key){
            return true;
        }

        return search(root.left , key) || search(root.right , key);
        }
    }
// Sum of All Nodes
// ---------------------------
    static int sumNodes(TraversalProblem1.Node root) {

        if(root == null)
            return 0;

        return root.data + sumNodes(root.left) + sumNodes(root.right);
    }

    // count nodes
    public static int countNodes(TraversalProblem1.Node root) {

        if(root == null)
            return 0;

        return 1 + countNodes(root.left) + countNodes(root.right);
    }


// ---------------------------
// Main Method (Testing)
// ---------------------------
    public static void main(String[] args) {

        /*
                1
               / \
              2   3
             / \   \
            4   5   6
        */

        TraversalProblem1.Node root = new TraversalProblem1.Node(1);
        root.left = new TraversalProblem1.Node(2);
        root.right = new TraversalProblem1.Node(3);
        root.left.left = new TraversalProblem1.Node(4);
        root.left.right = new TraversalProblem1.Node(5);
        root.right.right = new TraversalProblem1.Node(6);

        System.out.print("Leaf nodes: ");
        printLeaves(root);
        System.out.println();

        TraversalProblem1 TraversalProblem = null;
        System.out.println("Height: " + TraversalProblem.Height(root));

        System.out.println("Number of leaf nodes: " + TraversalProblem.CountLeaves(root));

        System.out.println("Search 5: " + search(root, 5));
        System.out.println("Search 10: " + search(root, 10));
        System.out.println("Sum of nodes: " + sumNodes(root));
        System.out.println("count of nodes: " + countNodes(root));


    }

        private static void printLeaves(TraversalProblem1.Node root) {
        }

        private static String search(TraversalProblem1.Node root, int i) {
            return "";
        }



