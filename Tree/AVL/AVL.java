import java.util.*;

public class AVL {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        AVLTree tree = new AVLTree();
        for(int i=0;i<n;i++) {
            tree.add(sc.nextInt());
        }

        tree.preorder();
        tree.inorder();
        tree.delete(3);
        tree.preorder();
        sc.close();
    }
}

class AVLTree {
    private Node root;

    public AVLTree() {
        root = null;
    }

    public AVLTree(int data) {
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

        temp.height = 1 + Math.max(getHeight(temp.left), getHeight(temp.right));

        temp = balance(temp, data);

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

        temp.height = 1 + Math.max(getHeight(temp.left), getHeight(temp.right));

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
            System.out.print(temp.data);
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

    private int getHeight(Node temp) {
        if(temp == null) {
            return 0;
        }
        return temp.height;
    }

    private int getBalance(Node temp) {
        return getHeight(temp.left) - getHeight(temp.right);
    }

    private Node balance(Node temp, int data) {
        int balanceFactor = getBalance(temp);

        if(balanceFactor == 2 && temp.left == null && temp.right == null) {
            return temp;
        }

        // Check LL
        else if(balanceFactor == 2 && data <= temp.left.data) {
            temp = LLRotate(temp);
        }

        // Check RR
        else if(balanceFactor == -2 && data > temp.right.data) {
            temp = RRRotate(temp);
        }

        // Check LR
        else if(balanceFactor == 2 && data > temp.left.data) {
            temp = LRRotate(temp);
        }

        // Check RL
        else if(balanceFactor == -2 && data <= temp.right.data) {
            temp = RLRotate(temp);
        }

        return temp;
    }

    private Node LLRotate(Node temp) {
        Node A = temp;
        Node B = temp.left;

        A.left = B.right;
        B.right = A;
        
        updateHeight(A);
        updateHeight(B);

        return B;
    }

    private Node RRRotate(Node temp) {
        Node A = temp;
        Node B = temp.right;
        
        A.right = B.left;
        B.left = A;

        updateHeight(A);
        updateHeight(B);

        return B;
    }

    private Node LRRotate(Node temp) {
        Node A = temp;
        Node B = A.left;
        Node C = B.right;

        B.right = C.left;
        A.left = C.right;
        C.left = B;
        C.right = A;

        updateHeight(B);
        updateHeight(A);
        updateHeight(C);

        return C;
    }

    private Node RLRotate(Node temp) {
        Node A = temp;
        Node B = A.right;
        Node C = B.left;

        B.left = C.right;
        A.right = C.left;
        C.right = B;
        C.left = A;

        updateHeight(B);
        updateHeight(A);
        updateHeight(C);

        return C;
    }

    private void updateHeight(Node temp) {
        temp.height = Math.max(getHeight(temp.left), getHeight(temp.right)) + 1;
    }
}

class Node {
    int data;
    int height;
    Node left;
    Node right;

    public Node() {
        this.left = null;
        this.right = null;
        this.height = 1;
    }

    public Node(int data) {
        this();
        this.data = data;
    }
}