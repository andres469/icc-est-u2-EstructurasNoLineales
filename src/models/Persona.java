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
        int resultComp= Integer.compare(this.edad, other.edad);
        if (resultComp!=0) {
            return resultComp;
        }
        return this.nombre.compareTo(other.nombre);
    }

    @Override
    public String toString() {
        return nombre + " (" + edad + " años)";
    }
    
}
