package Structures.trees;

import Structures.Nodes.Node;

public class tree<T extends Comparable<T>> {

    protected Node<T> root;
    private int size;

    public tree() {
        this.root = null;
        this.size = 0;
    }

    // Inserción 
    public void insert(T value) {
        root = insertRecursive(root, value);
        size++; // O(1)
    }

    protected Node<T> insertRecursive(Node<T> current, T value) {
        if (current == null) {
            return new Node<>(value);
        }

        if (value.compareTo(current.value) < 0) {
            current.left = insertRecursive(current.left, value);
        } else if (value.compareTo(current.value) > 0) {
            current.right = insertRecursive(current.right, value);
        }

        return current;
    }

    // size en O(1)
    public int size() {
        return size;
    }

    // InOrder
    public void inOrder() {
        inOrderRecursive(root);
    }

    private void inOrderRecursive(Node<T> node) {
        if (node != null) {
            inOrderRecursive(node.left);
            System.out.println(node.value);
            inOrderRecursive(node.right);
        }
    }

    // PreOrder
    public void preOrder() {
        preOrderRecursive(root);
    }

    private void preOrderRecursive(Node<T> node) {
        if (node != null) {
            System.out.println(node.value);
            preOrderRecursive(node.left);
            preOrderRecursive(node.right);
        }
    }

    // PostOrder
    public void postOrder() {
        postOrderRecursive(root);
    }

    private void postOrderRecursive(Node<T> node) {
        if (node != null) {
            postOrderRecursive(node.left);
            postOrderRecursive(node.right);
            System.out.println(node.value);
        }
    }
}
