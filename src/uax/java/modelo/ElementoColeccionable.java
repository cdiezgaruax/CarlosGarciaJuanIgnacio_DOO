package modelo;

import excepciones.RarezaInvalidaException;

public abstract class ElementoColeccionable {

    protected String pais;
    protected String autoridadGobernante;
    protected int annus;
    protected double valor;
    protected String unidadMonetaria;
    protected int rareza;
    protected double precio;

    public ElementoColeccionable(String pais, String autoridadGobernante, int annus, double valor,
                                 String unidadMonetaria, int rareza, double precio)
            throws RarezaInvalidaException {

        if (rareza < 1 || rareza > 100) {
            throw new RarezaInvalidaException("La rareza debe estar entre 1 y 100.");
        }

        this.pais = pais;
        this.autoridadGobernante = autoridadGobernante;
        this.annus = annus;
        this.valor = valor;
        this.unidadMonetaria = unidadMonetaria;
        this.rareza = rareza;
        this.precio = precio;
    }

    public int getRareza() {
        return rareza;
    }

    public double getPrecio() {
        return precio;
    }

    @Override
    public String toString() {
        return String.format("%s (%d) - %s, %.2f %s | Rareza: %d | Precio: %.2f€",
                pais, annus, autoridadGobernante, valor, unidadMonetaria, rareza, precio);
    }
}
