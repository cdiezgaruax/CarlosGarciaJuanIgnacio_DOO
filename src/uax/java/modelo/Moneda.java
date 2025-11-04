package modelo;

import enums.EstadoConservacionMoneda;
import excepciones.RarezaInvalidaException;

public class Moneda extends ElementoColeccionable {

    private String composicion;
    private double peso;
    private double diametro;
    private double grosor;
    private EstadoConservacionMoneda estadoConservacion;

    public Moneda(String pais, String autoridadGobernante, int annus, double valor, String unidadMonetaria,
                  int rareza, double precio, String composicion, double peso, double diametro,
                  double grosor, EstadoConservacionMoneda estadoConservacion)
            throws RarezaInvalidaException {
        super(pais, autoridadGobernante, annus, valor, unidadMonetaria, rareza, precio);
        this.composicion = composicion;
        this.peso = peso;
        this.diametro = diametro;
        this.grosor = grosor;
        this.estadoConservacion = estadoConservacion;
    }

    @Override
    public String toString() {
        return "Moneda → " + super.toString() +
                String.format(" | %s, %.2fg, %.2fmm diámetro, %.2fmm grosor, Estado: %s",
                        composicion, peso, diametro, grosor, estadoConservacion);
    }
}
