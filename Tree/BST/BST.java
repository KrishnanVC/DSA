package BST;

import java.util.*;

public class BST {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Tree tree = new Tree();
        for(int i=0;i<n;i++) {
            tree.add(sc.nextInt());
        }

        tree.preorder();
        tree.delete(3);
        tree.preorder();
        sc.close();
    }
}

class Tree {
    private Node root;

    public Tree() {
        root = null;
    }

    public Tree(int data) {
        root = new Node(data);
    }

    public Node search(int data) {
        return search(data, root);
    }

    public void add(int data) {
        root = add(data, root);
    }

    public void delete(int data) {
        root = delete(data, root);
    }

    public void inorder() {
        inorder(root);
        System.out.println();
    }

    public void postorder() {
        postorder(root);
        System.out.println();
    }

    public void preorder() {
        preorder(root);
        System.out.println();
    }

    private Node add(int data, Node temp) {
        Node node = new Node(data);

        if(temp == null) {
            return node;
        }

        else if(node.data <= temp.data) {
            temp.left = add(data,temp.left);
        }

        else if(node.data > temp.data) {
            temp.right = add(data, temp.right);
        }

        return temp;
    }

    private Node delete(int data, Node temp) {

        if(data > temp.data) {
            temp.right = delete(data, temp.right);
        }
        else if(data < temp.data) {
            temp.left = delete(data, temp.left);
        }
        else if(data == temp.data) {
            if(temp.left == null && temp.right == null) {
                return null;
            }

            else if(temp.left != null || temp.right != null) {
                if(temp.left != null) {
                    Node replace = getMax(temp.left);
                    temp.data = replace.data;
                    temp.left = delete(replace.data, temp.left);
                }
                else if(temp.right != null) {
                    Node replace = getMin(temp.right);
                    temp.data = replace.data;
                    temp.right = delete(replace.data, temp.right);
                }
            }
        }
        return temp;
    }

    private Node getMax(Node temp) {
        if(temp.right != null) {
            temp = temp.right;
        }
        return temp;
    }

    private Node getMin(Node temp) {
        if(temp.left != null) {
            temp = temp.left;
        }
        return temp;
    }

    private Node search(int data, Node temp) {
        Node answer = null;

        if(temp == null) {
            answer = null;
        }
        else if(data == temp.data) {
            answer = temp;
        }
        else if(data < temp.data) {
            answer = search(data, temp.left);
        }
        else if(data > temp.data) {
            answer = search(data, temp.right);
        }

        return answer;
    }

    private void inorder(Node temp) {
        if(temp != null) {
            inorder(temp.left);
            System.out.print(temp.data + " ");
            inorder(temp.right);
        }
    }

    private void postorder(Node temp) {
        if(temp != null) {
            postorder(temp.left);
            postorder(temp.right);
            System.out.print(temp.data + " ");
        }
    }

    private void preorder(Node temp) {
        if(temp != null) {
            System.out.print(temp.data + " ");
            preorder(temp.left);
            preorder(temp.right);
        }
    }
}

class Node {
    int data;
    Node left;
    Node right;

    public Node() {
        this.left = null;
        this.right = null;
    }

    public Node(int data) {
        this();
        this.data = data;
    }
}