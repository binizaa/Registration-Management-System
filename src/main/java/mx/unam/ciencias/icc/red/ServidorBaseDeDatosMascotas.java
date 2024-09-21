package mx.unam.ciencias.icc.red;

import java.io.IOException;
import mx.unam.ciencias.icc.BaseDeDatos;
import mx.unam.ciencias.icc.BaseDeDatosMascotas;
import mx.unam.ciencias.icc.CampoMascota;
import mx.unam.ciencias.icc.Mascota;

/**
 * Clase para servidores de bases de datos de mascotas.
 */
public class ServidorBaseDeDatosMascotas
    extends ServidorBaseDeDatos<Mascota> {

    /**
     * Construye un servidor de base de datos de mascotas.
     * @param puerto el puerto dónde escuchar por conexiones.
     * @param archivo el archivo en el disco del cual cargar/guardar la base de
     *                datos.
     * @throws IOException si ocurre un error de entrada o salida.
     */
    public ServidorBaseDeDatosMascotas(int puerto, String archivo)
        throws IOException {
        super(puerto,archivo);
    }

    /**
     * Crea una base de datos de mascotas.
     * @return una base de datos de mascotas.
     */
    @Override public
    BaseDeDatos<Mascota, CampoMascota> creaBaseDeDatos() {
        return new BaseDeDatosMascotas();
    }
}
