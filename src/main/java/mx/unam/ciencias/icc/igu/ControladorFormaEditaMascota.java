package mx.unam.ciencias.icc.igu;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import mx.unam.ciencias.icc.Mascota;

/**
 * Clase para el controlador del contenido del diálogo para editar y crear
 * mascotas.
 */
public class ControladorFormaEditaMascota
    extends ControladorFormaMascota {

    /* La entrada verificable para el nombre. */
    @FXML private EntradaVerificable entradaNombre;
    /* La entrada verificable para el nombre del propietario. */
    @FXML private EntradaVerificable entradaPropietario;
    /* La entrada verificable para la especie. */
    @FXML private EntradaVerificable entradaEspecie;
    /* La entrada verificable para el sexo. */
    @FXML private EntradaVerificable entradaSexo;
    /* La entrada verificable para el peso. */
    @FXML private EntradaVerificable entradaPeso;
    /* La entrada verificable para la edad. */
    @FXML private EntradaVerificable entradaEdad;
    /* La entrada verificable para la temperatura. */
    @FXML private EntradaVerificable entradaTemp;

    /* El mascota creado o editado. */
    private Mascota mascota;

    /* Inicializa el estado de la forma. */
    @FXML private void initialize() {
        entradaNombre.setVerificador(n -> verificaNombre(n));
        entradaPropietario.setVerificador(p -> verificaPropietario(p));
        entradaEspecie.setVerificador(e -> verificaEspecie(e));
        entradaSexo.setVerificador(s -> verificaSexo(s));
        entradaPeso.setVerificador(p -> verificaPeso(p));
        entradaEdad.setVerificador(e -> verificaEdad(e));
        entradaTemp.setVerificador(t -> verificaTemp(t));

        entradaNombre.textProperty().addListener(
            (o, v, n) -> verificaMascota());
        entradaPropietario.textProperty().addListener(
            (o, v, n) -> verificaMascota());
        entradaEspecie.textProperty().addListener(
            (o, v, n) -> verificaMascota());
        entradaSexo.textProperty().addListener(
            (o, v, n) -> verificaMascota());
        entradaPeso.textProperty().addListener(
            (o, v, n) -> verificaMascota());
        entradaEdad.textProperty().addListener(
            (o, v, n) -> verificaMascota());
        entradaTemp.textProperty().addListener(
            (o, v, n) -> verificaMascota());
    }


    /* Manejador para cuando se activa el botón aceptar. */
    @FXML private void aceptar(ActionEvent evento) {
        actualizaMascota();
        aceptado = true;
        escenario.close();
    }

    /* Actualiza a la mascota, o la crea si no existe. */
    private void actualizaMascota() {
        if (mascota != null) {
            mascota.setNombre(nombre);
            mascota.setPropietario(propietario);
            mascota.setEspecie(especie);
            mascota.setSexo(sexo);
            mascota.setPeso(peso);
            mascota.setEdad(edad);
            mascota.setTemp(temp);
        } else {
            mascota = new Mascota(nombre, propietario, especie, sexo, peso, edad, temp);
        }
    }

    /**
     * Define el estudiante del diálogo.
     * @param mascota el nuevo estudiante del diálogo.
     */
    public void setMascota(Mascota mascota){
        this.mascota = mascota;
        if(mascota == null) return;

        this.mascota = new Mascota(null, null, null, null, 0.0, 0, 0.0);
        this.mascota.actualiza(mascota);
        entradaNombre.setText(mascota.getNombre());
        entradaPropietario.setText(mascota.getPropietario());
        entradaEspecie.setText(mascota.getEspecie());
        entradaSexo.setText(mascota.getSexo());

        String p = String.format("%.2f", mascota.getPeso());
        entradaPeso.setText(p); 
        entradaEdad.setText(String.valueOf(mascota.getEdad()));
        String t = String.format("%.2f", mascota.getTemp());
        entradaTemp.setText(t);
    }

    /**
     * Regresa la mascota del diálogo.
     * @return la mascota del diálogo.
     */
    public Mascota getMascota() {
        return mascota;
    }

    /**
     * Define el verbo del botón de aceptar.
     * @param verbo el nuevo verbo del botón de aceptar.
     */
    public void setVerbo(String verbo) {
        botonAceptar.setText(verbo);
    }

    /**
     * Define el foco incial del diálogo.
     */
    @Override public void defineFoco() {
        entradaNombre.requestFocus();
    }

    /* Verifica que los campos de la mascota sean válidos. */
    private void verificaMascota() {
        boolean n = entradaNombre.esValida();
        boolean p = entradaPropietario.esValida();
        boolean e = entradaEspecie.esValida();
        boolean s = entradaSexo.esValida();
        boolean pe = entradaPeso.esValida();
        boolean ed = entradaEdad.esValida();
        boolean t = entradaTemp.esValida();

        botonAceptar.setDisable(!n || !p || !e || !s || !pe || !ed || !t);
    }

    /**
     * Verifica que el sexo de la mascota sea válido.
     * @param sexo el sexo de la mascota a verificar.
     * @return <code>true</code> si el sexo de la mascota es válido;
     *         <code>false</code> en otro caso.
     */
    @Override protected boolean verificaSexo(String sexo) {
        return super.verificaSexo(sexo) && 
            (this.sexo.equals("M") || this.sexo.equals("F"));
    }

    /**
     * Verifica que el peso sea válido.
     * @param peso el peso a verificar.
     * @return <code>true</code> si el peso es válido; <code>false</code> en
     *         otro caso.
     */
    @Override protected boolean verificaPeso(String peso) {
        return super.verificaPeso(peso) &&
            this.peso > 0.0;
    }

    /**
     * Verifica que la edad de la mascota sea válida.
     * @param edad la edad de la mascota a verificar.
     * @return <code>true</code> si la edad de la mascota es válida;
     *         <code>false</code> en otro caso.
     */
    @Override protected boolean verificaEdad(String edad) {
        return super.verificaEdad(edad) && 
            this.edad > 0;
    }

    /**
     * Verifica que el peso sea válido.
     * @param peso el peso a verificar.
     * @return <code>true</code> si el peso es válido; <code>false</code> en
     *         otro caso.
     */
    @Override protected boolean verificaTemp(String temp) {
        return super.verificaTemp(temp) &&
            this.temp > 0.0;
    }
}
