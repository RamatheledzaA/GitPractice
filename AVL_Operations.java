// Ramatheledza Adzisani 4484298

public class AVL_Operations {
    public static class AVL_Tree {
        class Tree_node {
            char data;
            Tree_node left , right ;
            int height;
            // default contrutor
            public Tree_node(char data){
                this.data = this.data;
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
            Tree_node T3=  y.right ;
            Tree_node T1= x.left ;
            Tree_node T2 = x.right;

            // after rotation y become the right child of node x
            x.left = T1 ;
            x. right = y;
            y.left = T2 ;
            y.right = T3 ;
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
             Tree_node T1=  y.left ;
             Tree_node T2= x.left ;
             Tree_node T3 = x.right;
             // after rotation y become the right child of node x
             x.left = y ;
             x. right = T3;
             y.left = T1 ;
             y.right = T2 ;
             // find the height
             y.height = Math.max (height(y.left), height(y.right)) + 1;
             x.height = Math.max(height (x.left) , height(x.right)) + 1 ;

             return x ;
         }

         // inserting a node in an AVL tree

        Tree_node insert ( Tree_node root , char data){
            if ( root == null){
                return new Tree_node(data) ;
            }

            // if the is not empty we then evaluate where in the tree the new node should be inserted
            if ( data < root.data){
                root.left = insert(root.left , data) ;

            } else if (data  > root.data) {
                root.right = insert(root.right , data);
            }else {
                return root ; // removers duplicates
            }

            root.height = 1 + Math.max(height(root.left ), height(root.right)) ;
            int balanceFactor = getBalance(root) ;
            
        }

    }

}
