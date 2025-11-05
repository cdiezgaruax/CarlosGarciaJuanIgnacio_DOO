import java.util.Scanner;
import modelo.*;
import enums.*;
import excepciones.RarezaInvalidaException;

public class main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Coleccion coleccion = new Coleccion();
        int opcion = -1;

        do {
            try {
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
                    case 1 -> añadirMoneda(sc, coleccion);
                    case 2 -> añadirSello(sc, coleccion);
                    case 3 -> coleccion.mostrarMonedas();
                    case 4 -> coleccion.mostrarSellos();
                    case 5 -> System.out.println("💰 Precio total: " + coleccion.precioTotal() + " €");
                    case 6 -> System.out.println("⭐ Rareza media: " + coleccion.rarezaMedia());
                    case 0 -> System.out.println("👋 Saliendo del programa...");
                    default -> System.out.println("⚠️ Opción no válida. Intenta de nuevo.");
                }

            } catch (NumberFormatException e) {
                System.out.println("⚠️ Opción inválida: introduce un número.");
            }

        } while (opcion != 0);

        sc.close();
    }


    private static void añadirMoneda(Scanner sc, Coleccion coleccion) {
        try {
            System.out.print("País: ");
            String pais = sc.nextLine();
            System.out.print("Autoridad gobernante: ");
            String autoridad = sc.nextLine();
            int annus = leerEntero(sc, "Año: ");
            double valor = leerDouble(sc, "Valor: ");
            System.out.print("Unidad monetaria: ");
            String unidad = sc.nextLine();
            int rareza = leerEntero(sc, "Rareza (1-100): ");
            double precio = leerDouble(sc, "Precio (€): ");
            System.out.print("Composición: ");
            String composicion = sc.nextLine();
            double peso = leerDouble(sc, "Peso (g): ");
            double diametro = leerDouble(sc, "Diámetro (mm): ");
            double grosor = leerDouble(sc, "Grosor (mm): ");

            EstadoConservacionMoneda estado = null;
            while (estado == null) {
                System.out.print("Estado de conservación (G, VG, F, VF, XF, AU, UNC): ");
                try {
                    estado = EstadoConservacionMoneda.valueOf(sc.nextLine().trim().toUpperCase());
                } catch (IllegalArgumentException e) {
                    System.out.println("⚠️ Valor no válido. Usa: G, VG, F, VF, XF, AU o UNC.");
                }
            }

            Moneda moneda = new Moneda(pais, autoridad, annus, valor, unidad, rareza, precio,
                    composicion, peso, diametro, grosor, estado);
            coleccion.anadirMoneda(moneda);
            System.out.println("✅ Moneda añadida correctamente.");
        } catch (RarezaInvalidaException e) {
            System.out.println("⚠️ Error: " + e.getMessage());
        }
    }


    private static void añadirSello(Scanner sc, Coleccion coleccion) {
        try {
            System.out.print("País: ");
            String pais = sc.nextLine();
            System.out.print("Autoridad gobernante: ");
            String autoridad = sc.nextLine();
            int annus = leerEntero(sc, "Año: ");
            double valor = leerDouble(sc, "Valor: ");
            System.out.print("Unidad monetaria: ");
            String unidad = sc.nextLine();
            int rareza = leerEntero(sc, "Rareza (1-100): ");
            double precio = leerDouble(sc, "Precio (€): ");
            double altura = leerDouble(sc, "Altura (mm): ");
            double anchura = leerDouble(sc, "Anchura (mm): ");
            System.out.print("Imagen (URL o nombre): ");
            String imagen = sc.nextLine();

            EstadoConservacionSello estado = null;
            while (estado == null) {
                System.out.print("Estado de conservación (U, NSG, NF, N): ");
                try {
                    estado = EstadoConservacionSello.valueOf(sc.nextLine().trim().toUpperCase());
                } catch (IllegalArgumentException e) {
                    System.out.println("⚠️ Valor no válido. Usa: U, NSG, NF o N.");
                }
            }

            Sello sello = new Sello(pais, autoridad, annus, valor, unidad, rareza, precio,
                    altura, anchura, imagen, estado);
            coleccion.anadirSello(sello);
            System.out.println("✅ Sello añadido correctamente.");
        } catch (RarezaInvalidaException e) {
            System.out.println("⚠️ Error: " + e.getMessage());
        }
    }


    private static int leerEntero(Scanner sc, String mensaje) {
        while (true) {
            System.out.print(mensaje);
            try {
                return Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("⚠️ Valor inválido. Introduce un número entero.");
            }
        }
    }

    private static double leerDouble(Scanner sc, String mensaje) {
        while (true) {
            System.out.print(mensaje);
            try {
                return Double.parseDouble(sc.nextLine().replace(',', '.'));
            } catch (NumberFormatException e) {
                System.out.println("⚠️ Valor inválido. Introduce un número (usa punto para decimales).");
            }
        }
    }
}
