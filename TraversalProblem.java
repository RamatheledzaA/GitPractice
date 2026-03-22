// Ramatheledza Adzisani 4484298
public class TraversalProblem {
    // Create a node class
    public static class Node{
        char data;
        Node left , right ;
        public Node( char data){
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

    //

}
