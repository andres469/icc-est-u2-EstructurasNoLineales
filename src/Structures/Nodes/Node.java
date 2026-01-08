package Structures.Nodes;

import java.util.List;
import java.util.Map;

public class Node<T> {

    public T value;
    public Node<T> left;
    public Node<T> right;
    // primera forma de nodos conocidos
    private List<Node<T>> conocidos;

    //segunda forma de nodos conocidos 
    private Map<Node<T> , List<Node<T>>> adjList;



    public Node(T value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}
