import javax.swing.tree.TreeNode;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
// Ramatheledza Adzisai 4484298
public class Depth_first_Traversal {

    // let's create a treeNode class
    public static class TreeNode{
        int data;
        TreeNode left;
        TreeNode right;
        public TreeNode (int data){
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

// level order traversal
    public static void levelOrder(TreeNode node){
        Queue<TreeNode> q = new LinkedList<>();
        q.add(node);

        while(!q.isEmpty()) {
            TreeNode current = q.poll();
            System.out.print(current.data + " ");

            if (current.left != null){
                q.add(current.left);
            }
            if (current.right != null){
                q.add(current.right);
            }

        }
    }


    public static void main(String [] args){
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(6);
        TreeNode node6= new TreeNode(7);
        TreeNode node7 = new TreeNode(8);

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

        //System.out.println( "level order traversal: " + levelOrder());



    }


}
