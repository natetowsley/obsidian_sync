/*
 * INSTRUCTIONS:
 *     This is the starting Java code for hw8_1.
 *     Note that the current filename is "Main.java". 
 *     When you finish your development, copy the file.
 *     Then, rename the copied file to "Main_hw8_1.java".
 *     After that, upload the renamed file to Canvas.
 */

// Finish the head comment with Abstract, ID, Name, and Date.
/*
 * Title: Main.java
 * Abstract: Read and execute 7 commands about a BST
 * ID: 8900
 * Name: Nate Towsley
 * Date: 04/05/2026
 */

import java.util.Scanner;

// A class to define a tree node.
class Node {
    // Use "public" data to make the program simple (= no getters and setters).
    public int data;
    public Node left;
    public Node right;

    // Constructor
    public Node(int data, Node left, Node right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}

// A class for a BST which may include many Nodes.
class BST {
    private Node root;

    public Node getRoot() {
        return root;
    }

    // Add an item to the BST
    // Internally, it calls "insert()" for actual insertion if root is not null.
    public void add(int item) {
        Node newNode = new Node(item, null, null);

        // Empty tree
        if (root == null) {
            root = newNode;
        } else {
            insert(newNode, root);
        }
    }

    // Insert a new node under the subtree using recursion
    private void insert(Node newNode, Node subTree) {
        // Go to the left subtree
        if (newNode.data < subTree.data) {
            if (subTree.left == null) {
                subTree.left = newNode;
            } else {
                insert(newNode, subTree.left);
            }
        } else { // Go to the right subtree
            if (subTree.right == null) {
                subTree.right = newNode;
            } else {
                insert(newNode, subTree.right);
            }
        }
    }

    // Conduct the in-order traversal.
    // Actual traversal happens in another method named inOrder() with the root.
    // We have two inOrder() methods (= method overloading).
    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node subTree) {
        if (subTree != null) {
            inOrder(subTree.left);
            System.out.print(subTree.data + " ");
            inOrder(subTree.right);
        }
    }

} // end of class BST

public class Main {
    public static void main(String[] args) {
        // Sample BST t1
        //
        // 50
        // / \
        // 20 70
        // / \ \
        // 10 35 90

        BST t1 = new BST();

        // t1.add(50);
        // t1.add(20);
        // t1.add(70);
        // t1.add(10);
        // t1.add(35);
        // t1.add(90);

        System.out.println("===== Inorder Traversal =====");
        t1.inOrder();
        System.out.println();

        Scanner in = new Scanner(System.in);
        int numCommands = in.nextInt();

        for (int i = 0; i < numCommands; i++) {
            String command = in.next();
            if (command.equals("add")) {
                t1.add(in.nextInt());
            }
            //////////////////////////
        }

        return;
    }
}
