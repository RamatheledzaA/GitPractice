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

        System.out.println("-------Pre Order Traversal------");
        System.out.print ( node.data + " ");
        preOrderTraversal(node.left);
        preOrderTraversal(node.right);
    }

    // -----In order Traversal------
    public static void inOrderTraversal(TreeNode node){
        if ( node == null){
            return;
        }

        System.out.println("-------In Order Traversal------");
        preOrderTraversal(node.left);
        System.out.print ( node.data + " ");
        preOrderTraversal(node.right);
    }

    // --- Post order Traversal -------


}
