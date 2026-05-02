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
    Tree_node leftRotation ( Tree_node y){
        System.out.println("Rotate left on node " + y.data);
        // x is the right child of y , y is the parent node
        Tree_node x = y.right;
        Tree_node T2= x.left ;

        // after rotation y become the right child of node x
        x.left = y ;
        y.right = T2 ;

        // find the height
        y.height = Math.max (height(y.left), height(y.right)) + 1;
        x.height = Math.max(height (x.left) , height(x.right)) + 1 ;

        return x ;
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
            System.out.println("Duplicate not allowed");
            return root ; // removers duplicates
        }

        root.height = 1 + Math.max(height(root.left ), height(root.right)) ;
        int balanceFactor = getBalance(root) ;

        // Left Left Case
        if (balanceFactor > 1 && getBalance(root.left) >= 0) {
            return rightRotation(root);
        }

        // Left Right Case
        if (balanceFactor > 1 && getBalance(root.left) < 0) {
            root.left = leftRotation(root.left);
            return rightRotation(root);
        }

        // Right Right Case
        if (balanceFactor < -1 && getBalance(root.right) <= 0) {
            return leftRotation(root);
        }

        // Right Left Case
        if (balanceFactor < -1 && getBalance(root.right) > 0) {
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
            return root;
        }

        if (data < root.data) {
            root.left = delete(root.left, data);
        } else if (data > root.data) {
            root.right = delete(root.right, data);
        } else {
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

        root.height = Math.max(height(root.left), height(root.right)) + 1;

        int balance = getBalance(root);

        // Left Left Case
        if (balance > 1 && getBalance(root.left) >= 0) {
            return rightRotation(root);
        }

        // Left Right Case
        if (balance > 1 && getBalance(root.left) < 0) {
            root.left = leftRotation(root.left);
            return rightRotation(root);
        }

        // Right Right Case
        if (balance < -1 && getBalance(root.right) <= 0) {
            return leftRotation(root);
        }

        // Right Left Case
        if (balance < -1 && getBalance(root.right) > 0) {
            root.right = rightRotation(root.right);
            return leftRotation(root);
        }

        return root;
    }

    // display method
    void printTree(Tree_node node, int level) {
        if (node == null) return;

        printTree(node.right, level + 1);

        for (int i = 0; i < level; i++) {
            System.out.print("   ");
        }
        System.out.println(node.data + "(h=" + node.height + ")");

        printTree(node.left, level + 1);
    }

    // main method
    public static void main(String[] args) {
        AVL_Tree tree = new AVL_Tree();
        int [] letters = {14, 17 , 11 , 7 , 53, 4 , 13 , 12, 6 , 60 , 19 , 16 , 20};
        for (int letter : letters) {
            tree.root = tree.insert(tree.root, letter);
        }
        tree.inOrderTraversal(tree.root);


        System.out.println("\nDeleting node 8 , 7 , 11  , 14 , 17");
        tree.root = tree.delete(tree.root, 8);
        tree.root = tree.delete(tree.root, 7);
        tree.root = tree.delete(tree.root, 11);
        tree.root = tree.delete(tree.root, 14);
        tree.root = tree.delete(tree.root, 17);
        tree.inOrderTraversal(tree.root);
    }

}
