import java.util.Scanner;
import modelo.*;
import enums.*;
import excepciones.RarezaInvalidaException;

public class main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Coleccion coleccion = new Coleccion();
        int opcion;

        do {
            System.out.println("\n=== MENÚ COLECCIÓN FILATELIA Y NUMISMÁTICA ===");
            System.out.println("1 - Añadir una nueva moneda");
            System.out.println("2 - Añadir un nuevo sello");
            System.out.println("3 - Mostrar todas las monedas");
            System.out.println("4 - Mostrar todos los sellos");
            System.out.println("5 - Mostrar el precio total de la colección");
            System.out.println("6 - Mostrar la rareza media de la colección");
            System.out.println("0 - Salir");
            System.out.print("Selecciona una opción: ");
            opcion = Integer.parseInt(sc.nextLine());

            switch (opcion) {
                case 1 -> {
                    try {
                        System.out.print("País: ");
                        String pais = sc.nextLine();
                        System.out.print("Autoridad gobernante: ");
                        String autoridad = sc.nextLine();
                        System.out.print("Año: ");
                        int annus = Integer.parseInt(sc.nextLine());
                        System.out.print("Valor: ");
                        double valor = Double.parseDouble(sc.nextLine());
                        System.out.print("Unidad monetaria: ");
                        String unidad = sc.nextLine();
                        System.out.print("Rareza (1-100): ");
                        int rareza = Integer.parseInt(sc.nextLine());
                        System.out.print("Precio (€): ");
                        double precio = Double.parseDouble(sc.nextLine());
                        System.out.print("Composición: ");
                        String composicion = sc.nextLine();
                        System.out.print("Peso (g): ");
                        double peso = Double.parseDouble(sc.nextLine());
                        System.out.print("Diámetro (mm): ");
                        double diametro = Double.parseDouble(sc.nextLine());
                        System.out.print("Grosor (mm): ");
                        double grosor = Double.parseDouble(sc.nextLine());

                        System.out.println("Estado de conservación (G, VG, F, VF, XF, AU, UNC): ");
                        EstadoConservacionMoneda estado = EstadoConservacionMoneda.valueOf(sc.nextLine().toUpperCase());

                        Moneda moneda = new Moneda(pais, autoridad, annus, valor, unidad, rareza, precio,
                                composicion, peso, diametro, grosor, estado);

                        coleccion.anadirMoneda(moneda);
                        System.out.println("✅ Moneda añadida correctamente.");
                    } catch (RarezaInvalidaException e) {
                        System.out.println("⚠️ Error: " + e.getMessage());
                    } catch (Exception e) {
                        System.out.println("⚠️ Error al añadir moneda: " + e.getMessage());
                    }
                }
                case 2 -> {
                    try {
                        System.out.print("País: ");
                        String pais = sc.nextLine();
                        System.out.print("Autoridad gobernante: ");
                        String autoridad = sc.nextLine();
                        System.out.print("Año: ");
                        int annus = Integer.parseInt(sc.nextLine());
                        System.out.print("Valor: ");
                        double valor = Double.parseDouble(sc.nextLine());
                        System.out.print("Unidad monetaria: ");
                        String unidad = sc.nextLine();
                        System.out.print("Rareza (1-100): ");
                        int rareza = Integer.parseInt(sc.nextLine());
                        System.out.print("Precio (€): ");
                        double precio = Double.parseDouble(sc.nextLine());
                        System.out.print("Altura (mm): ");
                        double altura = Double.parseDouble(sc.nextLine());
                        System.out.print("Anchura (mm): ");
                        double anchura = Double.parseDouble(sc.nextLine());
                        System.out.print("Imagen (URL o nombre): ");
                        String imagen = sc.nextLine();

                        System.out.println("Estado de conservación (U, NSG, NF, N): ");
                        EstadoConservacionSello estado = EstadoConservacionSello.valueOf(sc.nextLine().toUpperCase());

                        Sello sello = new Sello(pais, autoridad, annus, valor, unidad, rareza, precio,
                                altura, anchura, imagen, estado);

                        coleccion.anadirSello(sello);
                        System.out.println("✅ Sello añadido correctamente.");
                    } catch (RarezaInvalidaException e) {
                        System.out.println("⚠️ Error: " + e.getMessage());
                    } catch (Exception e) {
                        System.out.println("⚠️ Error al añadir sello: " + e.getMessage());
                    }
                }
                case 3 -> coleccion.mostrarMonedas();
                case 4 -> coleccion.mostrarSellos();
                case 5 -> System.out.println("💰 Precio total: " + coleccion.precioTotal() + " €");
                case 6 -> System.out.println("⭐ Rareza media: " + coleccion.rarezaMedia());
                case 0 -> System.out.println("👋 Saliendo del programa...");
                default -> System.out.println("Opción no válida, intenta de nuevo.");
            }

        } while (opcion != 0);

        sc.close();
    }
}
