package modelo;
// Vehiculo.java

public class Vehiculo {
    private String patente;
    private Marca marca;

    public Vehiculo(String patente, Marca marca) {
        this.patente = patente;
        this.marca = marca;
    }

    public String getPatente() {
        return patente;
    }

    public Marca getMarca() {
        return marca;
    }

    @Override
    public String toString() {
        return "Vehículo [patente=" + patente + ", marca=" + marca.getNombre() + "]";
    }
}
