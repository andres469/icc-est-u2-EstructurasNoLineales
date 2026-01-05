package Structures.trees;

import Structures.Nodes.Node;

public class IntTree {

    private Node<Integer> root;

    public IntTree() {
        this.root = null;
    }

    public void insert(int value) {
        root = insertRecursive(root, value);
    }

    private Node<Integer> insertRecursive(Node<Integer> current, int value) {
        if (current == null) {
            return new Node<>(value);
        }

        if (value < current.value) {
            current.left = insertRecursive(current.left, value);
        } else if (value > current.value) {
            current.right = insertRecursive(current.right, value);
        }

        return current;
    }

    public void inOrder() {
        inOrderRecursive(root);
    }

    private void inOrderRecursive(Node<Integer> node) {
        if (node != null) {
            inOrderRecursive(node.left);
            System.out.println(node.value);
            inOrderRecursive(node.right);
        }
    }

    public void preOrder() {
    preOrderRecursive(root);
}

private void preOrderRecursive(Node<Integer> node) {
    if (node != null) {
        System.out.println(node.value); // RAÍZ
        preOrderRecursive(node.left);   // IZQUIERDA
        preOrderRecursive(node.right);  // DERECHA
    }
}
public void postOrder() {
    postOrderRecursive(root);
}

private void postOrderRecursive(Node<Integer> node) {
    if (node != null) {
        postOrderRecursive(node.left);   // IZQUIERDA
        postOrderRecursive(node.right);  // DERECHA
        System.out.println(node.value);  // RAÍZ
    }
}

}

