import java.util.*;

import modelo.Marca;
import modelo.Vehiculo;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Paso 1: Array de nombres de marcas
        String[] nombresMarcas = {"Toyota", "Ford", "Chevrolet", "Honda", "Volkswagen"};

        // Paso 2: Crear ArrayList de Marca
        ArrayList<Marca> listaMarcas = new ArrayList<>();
        Random random = new Random();

        for (String nombre : nombresMarcas) {
            int codigo = 100 + random.nextInt(900);
            listaMarcas.add(new Marca(nombre, codigo));
        }

        System.out.println("Marcas disponibles:");
        for (Marca marca : listaMarcas) {
            System.out.println(" - " + marca); 
            // Esto funciona gracias a que modificamos el método toString() de Marca, de lo contrario nos mostraría el hashcode del objeto
            // Otra manera es: System.out.println(" - " + marca.getNombre() + " (Código: " + marca.getCodigo() + ")");
        }

        // Paso 3: Crear LinkedList para Vehículos
        LinkedList<Vehiculo> listaVehiculos = new LinkedList<>();

        String opcion;
        do {
            System.out.print("\nIngrese patente del vehículo: ");
            String patente = scanner.nextLine();

            System.out.print("Ingrese nombre de la marca: ");
            String nombreMarca = scanner.nextLine();

            // Buscar la marca
            Marca marcaSeleccionada = null;
            for (Marca m : listaMarcas) {
                if (m.getNombre().equalsIgnoreCase(nombreMarca)) {
                    marcaSeleccionada = m;
                    break;
                }
            }

            if (marcaSeleccionada != null) {
                listaVehiculos.add(new Vehiculo(patente, marcaSeleccionada));
                System.out.println("Vehículo agregado.");
            } else {
                System.out.println("Marca no encontrada.");
            }

            System.out.print("¿Desea agregar otro vehículo? (s/n): ");
            opcion = scanner.nextLine();
        } while (opcion.equalsIgnoreCase("s"));

        // Paso 4: Mostrar patentes sin duplicados (Set)
        Set<String> patentesUnicas = new HashSet<>();
        for (Vehiculo v : listaVehiculos) {
            patentesUnicas.add(v.getPatente());
        }

        System.out.println("\nPatentes únicas:");
        for (String patente : patentesUnicas) {
            System.out.println("- " + patente);
        }

        // Paso 5: Map<String, ArrayList<Vehiculo>> para agrupar por marca
        Map<String, ArrayList<Vehiculo>> mapaVehiculosPorMarca = new HashMap<>();

        for (Vehiculo v : listaVehiculos) {
            String nombreMarca = v.getMarca().getNombre();

            if (!mapaVehiculosPorMarca.containsKey(nombreMarca)) {
                mapaVehiculosPorMarca.put(nombreMarca, new ArrayList<>());
            }
            mapaVehiculosPorMarca.get(nombreMarca).add(v);
        }

        System.out.println("\nVehículos agrupados por marca:");
        for (Map.Entry<String, ArrayList<Vehiculo>> entrada : mapaVehiculosPorMarca.entrySet()) {
            System.out.println("Marca: " + entrada.getKey());
            for (Vehiculo v : entrada.getValue()) {
                System.out.println("  - " + v.getPatente());
            }
        }

        // Opcional: Mostrar cantidad de vehículos por marca
        System.out.println("\nCantidad de vehículos por marca:");
        for (Map.Entry<String, ArrayList<Vehiculo>> entrada : mapaVehiculosPorMarca.entrySet()) {
            System.out.println(entrada.getKey() + ": " + entrada.getValue().size());
        }

        scanner.close();
    }
}
