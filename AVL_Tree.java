// Ramatheledza Adzisani 4484298

public class AVL_Tree {
    public static class Tree_node {
        int data;
        Tree_node left , right ;
        int height;
        // default contrutor
        public Tree_node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
            height = 1 ;

        }
    }
    Tree_node root ;
    // method for the height og the tree
    public int height( Tree_node node){
        if ( node ==  null) return 0 ;
        return node.height;
    }

    // the method to get the  balance using the balance factor
    public int getBalance (Tree_node node){
        if ( node == null) return 0 ;
        return height(node.left) - height(node.right);
    }

    // if the tree is not balanced the certain rotation need to be done
    // case1 : Right rotation

    Tree_node rightRotation (Tree_node y){
        System.out.println("Rotate right on node " + y.data);
        // x is the left child of y , y is the parent node
        Tree_node x = y.left;
        Tree_node T2 = x.right;

        // after rotation y become the right child of node x
        x.right = y;
        y.left = T2;

        // find the height
        y.height = Math.max (height(y.left), height(y.right)) + 1;
        x.height = Math.max(height (x.left) , height(x.right)) + 1 ;

        return x ;
    }

    // case2 : left Rotation
    Tree_node leftRotation ( Tree_node x){
        System.out.println("Rotate left on node " + x.data);

        Tree_node y = x.right;
        Tree_node T2= y.left ;

        // after rotation y become the right child of node x
        y.left = x;
        x.right = T2 ;

        // find the height
        y.height = Math.max (height(y.left), height(y.right)) + 1;
        x.height = Math.max(height (x.left) , height(x.right)) + 1 ;

        return y ;
    }

    // inserting a node in an AVL tree

    Tree_node insert ( Tree_node root , int data){
        if ( root == null){
            System.out.println("\nInserted: " + data);
            return new Tree_node(data) ;
        }

        // if the is not empty we then evaluate where in the tree the new node should be inserted
        if ( data < root.data){
            root.left = insert(root.left , data) ;

        } else if (data  > root.data) {
            root.right = insert(root.right , data);
        }else {
            System.out.println("Duplicate not allowed" + data);
            return root ; // removers duplicates
        }
        // update height
        root.height = 1 + Math.max(height(root.left ), height(root.right)) ;
        int balanceFactor = getBalance(root) ;

        // check imbalance
        if (balanceFactor > 1 || balanceFactor < -1) {
            System.out.println("Imbalance detected at node: " + root.data + " | Balance Factor: " + balanceFactor);
        }
        // Left Left Case
        if (balanceFactor > 1 &&  data < root.left.data) {
            System.out.println(" LL Case at node " + root.data);
            return rightRotation(root);
        }

        // Left Right Case
        if (balanceFactor > 1 && data > root.left.data) {
            System.out.println(" LR Case at node " + root.data);
            root.left = leftRotation(root.left);
            return rightRotation(root);
        }

        // Right Right Case
        if (balanceFactor < -1 && data > root.right.data) {
            System.out.println(" RR Case at node " + root.data);
            return leftRotation(root);
        }

        // Right Left Case
        if (balanceFactor < -1 && data < root.right.data) {
            System.out.println("RL Case at node " + root.data);
            root.right = rightRotation(root.right);
            return leftRotation(root);
        }
        return root;

    }

    void inOrderTraversal(Tree_node node) {
        if (node != null) {
            inOrderTraversal(node.left);
            System.out.print(node.data + ", ");
            inOrderTraversal(node.right);
        }
    }

    // delete method
    private Tree_node minValueNode(Tree_node node) {
        Tree_node current = node;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }

    Tree_node delete(Tree_node root, int data) {
        if (root == null) {
            System.out.println("Value not found: " + data);
            return root;
        }

        if (data < root.data) {
            root.left = delete(root.left, data);
        } else if (data > root.data) {
            root.right = delete(root.right, data);
        } else {
            System.out.println("\nDeleted: " + data);
            // 1 or 0 child
            if ((root.left == null) || (root.right == null)) {
                Tree_node temp = root.left != null ? root.left : root.right;

                if (temp == null) {
                    root = null;
                } else {
                    root = temp;
                }
            } else {
                Tree_node temp = minValueNode(root.right);
                root.data = temp.data;
                root.right = delete(root.right, temp.data);
            }
        }

        if (root == null) {
            return root;
        }
        // update height
        root.height = Math.max(height(root.left), height(root.right)) + 1;

        int balanceFactor = getBalance(root);
        // check imbalance
        if (balanceFactor > 1 || balanceFactor < -1) {
            System.out.println("Imbalance detected at node: " + root.data + " | Balance Factor: " + balanceFactor);
        }

        // Left Left Case
        if (balanceFactor > 1 && getBalance(root.left) >= 0) {
            System.out.println("LL Case at node " + root.data);
            return rightRotation(root);
        }

        // Left Right Case
        if (balanceFactor > 1 && getBalance(root.left) < 0) {
            System.out.println(" LR Case at node " + root.data);
            root.left = leftRotation(root.left);
            return rightRotation(root);
        }

        // Right Right Case
        if (balanceFactor < -1 && getBalance(root.right) <= 0) {
            System.out.println("RR Case at node " + root.data);
            return leftRotation(root);
        }

        // Right Left Case
        if (balanceFactor < -1 && getBalance(root.right) > 0) {
            System.out.println("RL Case at node " + root.data);
            root.right = rightRotation(root.right);
            return leftRotation(root);
        }
        return root;
    }

    // display method
    void printTree(Tree_node node, int space) {
        if (node == null) return;

        space += 5;

        printTree(node.right, space);

        System.out.println();
        for (int i = 5; i < space; i++) {
            System.out.print(" ");
        }
        System.out.print(node.data);

        printTree(node.left, space);
    }

    // main method
    public static void main(String[] args) {
        AVL_Tree tree = new AVL_Tree();
        int[] values = {14, 17, 11, 7, 53, 4, 13, 12, 6, 60, 19, 16, 20};
        // insert step by step
        for (int val : values) {
            tree.root = tree.insert(tree.root, val);

            System.out.println("Tree after inserting " + val + ":");
            tree.printTree(tree.root, 0);
            System.out.println("\n---------------------------");
        }

        // DELETE STEP-BY-STEP
        int[] deleteVals = {8, 7, 11, 14, 17};

        for (int val : deleteVals) {
            tree.root = tree.delete(tree.root, val);

            System.out.println("Tree after deleting " + val + ":");
            tree.printTree(tree.root, 0);
            System.out.println("\n---------------------------");
        }

    }
}
