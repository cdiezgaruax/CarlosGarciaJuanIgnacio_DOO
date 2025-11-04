package modelo;

import enums.EstadoConservacionSello;
import excepciones.RarezaInvalidaException;

public class Sello extends ElementoColeccionable {

    private double altura;
    private double anchura;
    private String imagen;
    private EstadoConservacionSello estadoConservacion;

    public Sello(String pais, String autoridadGobernante, int annus, double valor, String unidadMonetaria,
                 int rareza, double precio, double altura, double anchura,
                 String imagen, EstadoConservacionSello estadoConservacion)
            throws RarezaInvalidaException {
        super(pais, autoridadGobernante, annus, valor, unidadMonetaria, rareza, precio);
        this.altura = altura;
        this.anchura = anchura;
        this.imagen = imagen;
        this.estadoConservacion = estadoConservacion;
    }

    @Override
    public String toString() {
        return "Sello → " + super.toString() +
                String.format(" | %.2fmm x %.2fmm, Imagen: %s, Estado: %s",
                        altura, anchura, imagen, estadoConservacion);
    }
}
