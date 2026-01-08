package Structures.graphs;

import Structures.Nodes.Node;
import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph<T> {
    List<Node<T>> nodes;
    private Map <Node<T>, List<Node<T>>> mapa;
    public Graph(List<Node<T>> nodes) {
        this.mapa=new HashMap<Node<T>, List<Node<T>>>();
    }
    public Graph() {
    this.mapa = new HashMap<>();
    this.nodes = new ArrayList<>(); // Inicializa también la lista de nodos para evitar NullPointerException
}
    public void insertNode(Node<T> node) {
        Node<T> newNode = new Node<>(node.value);
        this.nodes.add(newNode);
    }

    public void addNode(Node<T> node){
        mapa.putIfAbsent(node, new ArrayList<>());

    }
    public void addEdge(Node<T> n1, Node<T> n2){
        addNode(n1);
        addNode(n2);
        mapa.get(n1).add(n2);
        mapa.get(n2).add(n1);

    }
    public void printGraph(){
        for (Map.Entry<Node<T>, List<Node<T>>> entry : mapa.entrySet()) {
          System.out.print(entry.getKey().value + " -> ");
            for (Node<T> neighbor : entry.getValue()) {
                System.out.print(neighbor.value + " ");
            }
           
            System.out.println();
        }
    }
    

    

    
}
