import javax.swing.tree.TreeNode;

// Ramatheledza Adzisai 4484298
public class Depth_first_Traversal {

    // let's create a treeNode class
    public static class TreeNode{
        String data;
        TreeNode left;
        TreeNode right;
        public TreeNode (String data){
            this.data= data;
            this.left = null;
            this.right =  null;

        }
    }
    // lets word on the pre order traversal
    public static void preOrderTraversal(TreeNode node){
        if ( node == null){
            return;
        }

        System.out.print ( node.data + " ");
        preOrderTraversal(node.left);
        preOrderTraversal(node.right);
    }

    // -----In order Traversal------
    public static void inOrderTraversal(TreeNode node){
        if ( node == null){
            return;
        }

        preOrderTraversal(node.left);
        System.out.print ( node.data + " ");
        preOrderTraversal(node.right);
    }

    // --- Post order Traversal -------

    public static void postOrderTraversal(TreeNode node){
        if ( node == null){
            return;
        }

        preOrderTraversal(node.left);
        preOrderTraversal(node.right);
        System.out.print ( node.data + " ");
    }

    // count nodes
    public static int countNodes (TreeNode node){
        if (node == null)
            return 0 ;

        return 1 + countNodes(node.left) + countNodes(node.right);
    }

    public static void main(String [] args){
        TreeNode root = new TreeNode("R");
        TreeNode node1 = new TreeNode("A");
        TreeNode node2 = new TreeNode("B");
        TreeNode node3 = new TreeNode("C");
        TreeNode node4 = new TreeNode("D");
        TreeNode node5 = new TreeNode("E");
        TreeNode node6= new TreeNode("F");
        TreeNode node7 = new TreeNode("G");

        // arrange the node and root
        root.left = node1;
        root.right = node2;

        node1.left = node3;
        node2.right = node4;

        node3.left = node5;
        node4.right= node6;

        node5.left = node7;

        // traverse
        System.out.println("-------Pre Order Traversal------");
        preOrderTraversal(root);

        System.out.print("\n");

        System.out.println("-------In Order Traversal------");
        inOrderTraversal(root);

        System.out.print("\n");

        System.out.println("-------Post Order Traversal------");
        postOrderTraversal(root);

        System.out.print("\n");

        System.out.println( "Count of nodes : "+ countNodes(root));
        


    }


}
