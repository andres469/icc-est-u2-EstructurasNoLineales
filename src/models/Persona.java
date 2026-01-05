package models;


public class Persona implements Comparable<Persona> {

    private String nombre;
    private int edad;

    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    @Override
    public int compareTo(Persona other) {
        return Integer.compare(this.edad, other.edad);
    }

    @Override
    public String toString() {
        return nombre + " (" + edad + " años)";
    }
}
