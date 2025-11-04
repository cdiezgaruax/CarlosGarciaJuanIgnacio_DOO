package modelo;

import java.util.ArrayList;

public class Coleccion {

    private ArrayList<ElementoColeccionable> elementos;

    public Coleccion() {
        this.elementos = new ArrayList<>();
    }

    public void anadirMoneda(Moneda m) {
        elementos.add(m);
    }

    public void anadirSello(Sello s) {
        elementos.add(s);
    }

    public void mostrarMonedas() {
        System.out.println("\n--- MONEDAS EN LA COLECCIÓN ---");
        for (ElementoColeccionable e : elementos) {
            if (e instanceof Moneda) {
                System.out.println(e);
            }
        }
    }

    public void mostrarSellos() {
        System.out.println("\n--- SELLOS EN LA COLECCIÓN ---");
        for (ElementoColeccionable e : elementos) {
            if (e instanceof Sello) {
                System.out.println(e);
            }
        }
    }

    public double precioTotal() {
        double total = 0;
        for (ElementoColeccionable e : elementos) {
            total += e.getPrecio();
        }
        return total;
    }

    public double rarezaMedia() {
        if (elementos.isEmpty()) return 0;
        double suma = 0;
        for (ElementoColeccionable e : elementos) {
            suma += e.getRareza();
        }
        return suma / elementos.size();
    }
}
