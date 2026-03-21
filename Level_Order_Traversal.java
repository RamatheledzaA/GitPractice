// Ramatheledza Adzisani 4484298

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class Level_Order_Traversal {

    // let' create a node class
    public static class Node{
        char data;
        Node left,right;
        public Node ( char data){
            this.data = data;
            left= right= null;

        }
    }
    public static void levelOrder(Node root){
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()) {
            Node current = q.poll();
            System.out.print(current.data + " ");

            if (current.left != null){
                q.add(current.left);
            }
            if (current.right != null){
                q.add(current.right);
            }

        }
    }

}
