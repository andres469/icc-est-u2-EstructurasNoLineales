import Structures.Nodes.Node;
import Structures.graphs.Graph;
import Structures.trees.IntTree;
import Structures.trees.tree;
import models.Persona;

public class Main {

    public static void main(String[] args) {
        //runTree();
        runGraph();
        System.out.println("=== Arbol de enteros ===");
        IntTree intTree = new IntTree();
        intTree.insert(10);
        intTree.insert(5);
        intTree.insert(3);
        intTree.insert(15);
        System.out.println("\nRecorrido InOrder:");
        intTree.preOrder();
        System.out.println("\nRecorrido PostOrder:");
        intTree.postOrder();
        System.out.println("\nRecorrido InOrder:");
        intTree.inOrder();
        System.out.println("\nRecorrido PreOrder:");

        intTree.preOrder();
        System.out.println("----------------------------");

        System.out.println("\n=== Árbol de personas (ordenado por edad) ===");
        tree<Persona> personaTree = new tree<>();
        personaTree.insert(new Persona("Ana", 25));
        personaTree.insert(new Persona("Luis", 20));
        personaTree.insert(new Persona("Carlos", 30));
        personaTree.insert(new Persona("María", 22));

        personaTree.inOrder();

        Persona findPerson=personaTree.searchByAge(23);
        if (findPerson!=null) {
            System.out.println("Persona encontrada: "+findPerson);
        } else {
            System.out.println("Persona no encontrada");
        }
    }

    private static void runTree() {
        tree<Persona> personaTree = new tree<Persona>();
        personaTree.insert(new Persona("Pablo", 21));
        personaTree.insert(new Persona("Maria", 22));
        personaTree.insert(new Persona("Ana", 25));
        personaTree.insert(new Persona("Pedro", 23));
        personaTree.insert(new Persona("Luis", 19));
        personaTree.inOrder();
    }

    public static void runGraph() {
        Graph<String> graph = new Graph<>();
        Node<String> nA = new Node<>("A");
        Node<String> nB = new Node<>("B");
        Node<String> nC = new Node<>("C");
        Node<String> nd = new Node<>("D");
        graph.addNode(nA);
        graph.addEdge(nA, nB);
        graph.addEdge(nA, nC);
        graph.addEdge(nB, nd);
        graph.printGraph();
        
    }
}

