package modelo;
// Marca.java
public class Marca {
    private String nombre;
    private int codigo;

    public Marca(String nombre, int codigo) {
        this.nombre = nombre;
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCodigo() {
        return codigo;
    }

    @Override
    public String toString() {
        return nombre + " (Código: " + codigo + ")";
    }
}
