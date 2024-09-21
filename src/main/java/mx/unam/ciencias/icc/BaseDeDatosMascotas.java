package mx.unam.ciencias.icc;

/**
 * Clase para bases de datos de mascotas.
 */
public class BaseDeDatosMascotas
    extends BaseDeDatos<Mascota, CampoMascota> {

    /**
     * Crea un mascota en blanco.
     * @return un mascota en blanco.
     */
    @Override public Mascota creaRegistro() {
        return new Mascota(null, null, null, null, 0,0,0);
    }
}
