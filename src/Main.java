import Structures.trees.IntTree;
import Structures.trees.tree;
import models.Persona;

public class Main {

    public static void main(String[] args) {

        System.out.println("=== Arbol de enteros ===");
        IntTree intTree = new IntTree();
        intTree.insert(10);
        intTree.insert(5);
        intTree.insert(3);
        intTree.insert(15);

        intTree.preOrder();
        intTree.postOrder();
        intTree.inOrder();

        intTree.preOrder();

        System.out.println("\n=== Árbol de personas (ordenado por edad) ===");
        tree<Persona> personaTree = new tree<>();
        personaTree.insert(new Persona("Ana", 25));
        personaTree.insert(new Persona("Luis", 20));
        personaTree.insert(new Persona("Carlos", 30));
        personaTree.insert(new Persona("María", 22));

        personaTree.inOrder();
    }
}

