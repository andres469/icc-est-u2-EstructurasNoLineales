package Structures.trees;

import Structures.Nodes.Node;
import models.Persona;

public class tree<T extends Comparable<T>> {

    protected Node<T> root;
    private int size;

    public tree() {
        this.root = null;
        this.size = 0;
    }
 
    public void insert(T value) {
        root = insertRecursive(root, value);
        size++;
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

    public Persona searchByAge(int i) {
        return searchByAgeRecursive(root, i);
    }

    private Persona searchByAgeRecursive(Node<T> root, int i) {
        if (root == null) {
            return null;
        }

        Persona currentPersona = (Persona) root.value;
        if (currentPersona.getEdad() == i) {
            return currentPersona;
        } else if (i < currentPersona.getEdad()) {
            return searchByAgeRecursive(root.left, i);
        } else {
            return searchByAgeRecursive(root.right, i);
        }
    }
    public T search(T value) {
        return searchRecursive(root, value);
    }

    private T searchRecursive(Node<T> root, T value) {
        if (root == null) {
            return null;
        }

        if (value.compareTo(root.value) == 0) {
            return root.value;
        } else if (value.compareTo(root.value) < 0) {
            return searchRecursive(root.left, value);
        } else {
            return searchRecursive(root.right, value);
        }
    }
}
