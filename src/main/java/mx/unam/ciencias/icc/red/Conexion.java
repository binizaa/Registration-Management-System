package mx.unam.ciencias.icc.red;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import mx.unam.ciencias.icc.EventoBaseDeDatos;
import mx.unam.ciencias.icc.ExcepcionLineaInvalida;
import mx.unam.ciencias.icc.BaseDeDatos;
import mx.unam.ciencias.icc.Lista;
import mx.unam.ciencias.icc.Registro;

/**
 * Clase para conexiones de la base de datos.
 *
 * @param <R> el tipo de los registros.
 */
public class Conexion<R extends Registro<R, ?>> {

    /* Contador de números de serie. */
    private static int contadorSerie;

    /* La entrada de la conexión. */
    private BufferedReader in;
    /* La salida de la conexión. */
    private BufferedWriter out;
    /* La base de datos. */
    private BaseDeDatos<R, ?> bdd;
    /* Lista de escuchas de conexión. */
    private Lista<EscuchaConexion<R>> escuchas;
    /* El enchufe. */
    private Socket enchufe;
    /* Si la conexión está activa. */
    private boolean activa;
    /* El número de serie único de la conexión. */
    private int serie;

    /**
     * Define el estado inicial de una nueva conexión.
     * @param bdd la base de datos.
     * @param enchufe el enchufe de la conexión ya establecida.
     * @throws IOException si ocurre un error de entrada o salida.
     */
    public Conexion(BaseDeDatos<R, ?> bdd, Socket enchufe) throws IOException {
        this.bdd = bdd;
        this.enchufe = enchufe;
        this.in = new BufferedReader(
                    new InputStreamReader(enchufe.getInputStream()));
        this.out = new BufferedWriter(
                    new OutputStreamWriter(enchufe.getOutputStream()));
        this.escuchas = new Lista<EscuchaConexion<R>>();
        this.activa = true;
        this.serie = ++contadorSerie;
    }

    /**
     * Recibe los mensajes de la conexión. El método no termina hasta que la
     * conexión sea cerrada. Al ir leyendo su entrada, la conexión convertirá lo
     * que lea en mensajes y reportará cada uno a los escuchas.
     */
    public void recibeMensajes() {
        try {
            String linea;
            while((linea = in.readLine()) != null) escuchas(Mensaje.getMensaje(linea));
            activa = false;
        } catch (IOException e) {
            if(activa) escuchas(Mensaje.INVALIDO);
        }
        escuchas(Mensaje.DESCONECTAR); 
    }

    private void escuchas(Mensaje men) {
        for (EscuchaConexion<R> escucha : escuchas)
            escucha.mensajeRecibido(this, men);
    }

    /**
     * Recibe la base de datos del otro lado de la conexión.
     * @throws IOException si la base de datos no puede recibirse.
     */
    public void recibeBaseDeDatos() throws IOException {
        bdd.limpia();
        bdd.carga(in);
    }

    /**
     * Envía la base de datos al otro lado de la conexión.
     * @throws IOException si la base de datos no puede enviarse.
     */
    public void enviaBaseDeDatos() throws IOException {
        bdd.guarda(out);
        out.newLine();
        out.flush();
    }

    /**
     * Recibe un registro del otro lado de la conexión.
     * @return un registro del otro lado de la conexión.
     * @throws IOException si el registro no puede recibirse.
     */
    public R recibeRegistro() throws IOException {
        R reg = bdd.creaRegistro();
        reg.deseria(in.readLine());
        return reg;
    }

    /**
     * Envía un registro al otro lado de la conexión.
     * @param registro el registro a enviar.
     * @throws IOException si el registro no puede enviarse.
     */
    public void enviaRegistro(R registro) throws IOException {
        out.write(registro.seria());
        out.flush();
    }

    /**
     * Envía mensaje registro al otro lado de la conexión.
     * @param mensaje el mensaje a enviar.
     * @throws IOException si el mensaje no puede enviarse.
     */
    public void enviaMensaje(Mensaje mensaje) throws IOException {
        out.write(mensaje.toString() + "\n");
        out.flush();
    }

    /**
     * Regresa un número de serie para cada conexión.
     * @return un número de serie para cada conexión.
     */
    public int getSerie() {
        return serie;
    }

    /**
     * Cierra la conexión.
     */
    public void desconecta() {
        try {
            activa = false;
            enchufe.close();
          } catch(IOException ioe) {
            System.out.println("Error en el cierre de la conexión");
        }
    }

    /**
     * Nos dice si la conexión es activa.
     * @return <code>true</code> si la conexión es activa; <code>false</code> en
     *         otro caso.
     */
    public boolean isActiva() {
        return activa;
    }

    /**
     * Agrega un escucha de conexión.
     * @param escucha el escucha a agregar.
     */
    public void agregaEscucha(EscuchaConexion<R> escucha) {
        escuchas.agregaFinal(escucha);
    }
}
