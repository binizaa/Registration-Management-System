package mx.unam.ciencias.icc.igu;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Tooltip;
import mx.unam.ciencias.icc.CampoMascota;

/**
 * Clase para el controlador del contenido del diálogo para buscar mascotas.
 */
public class ControladorFormaBuscaMascotas
    extends ControladorFormaMascota {

    /* El combo del campo. */
    @FXML private ComboBox<CampoMascota> opcionesCampo;
    /* El campo de texto para el valor. */
    @FXML private EntradaVerificable entradaValor;

    /* Inicializa el estado de la forma. */
    @FXML private void initialize() {
        entradaValor.setVerificador(s -> verificaValor(s));
        entradaValor.textProperty().addListener(
            (o, v, n) -> revisaValor(null));
    }

    /* Revisa el valor después de un cambio. */
    @FXML private void revisaValor(ActionEvent evento) {
        Tooltip.install(entradaValor, getTooltip());
        botonAceptar.setDisable(!entradaValor.esValida());
    }

    /* Manejador para cuando se activa el botón aceptar. */
    @FXML private void aceptar(ActionEvent evento) {
        aceptado = true;
        escenario.close();
    }

    /* Verifica el valor. */
    private boolean verificaValor(String valor) {
        switch (opcionesCampo.getValue()) {
        case NOMBRE:   return verificaNombre(valor);
        case PROPIETARIO: return verificaNombre(valor);
        case ESPECIE:    return verificaNombre(valor);
        case SEXO:       return verificaSexo(valor);
        case PESO:       return verificaPeso(valor);
        case EDAD:       return verificaEdad(valor);
        case TEMP:       return verificaTemp(valor);
        default:       return false; // No puede ocurrir.
        }
    }

    /* Obtiene la pista. */
    private Tooltip getTooltip() {
        String m = "";
        switch (opcionesCampo.getValue()) {
        case NOMBRE:
            m = "Buscar por nombre necesita al menos un carácter";
            break;
        case PROPIETARIO: 
            m = "Buscar por propietario necesita al menos un carácter";
        case ESPECIE: 
            m = "Buscar por especie necesita al menos un carácter";
            break;
        case SEXO: 
            m = "Buscar por sexo necesita ser F(Femenino) o M(Masculino)";
            break;
        case PESO: 
            m = "Buscar por edad necesaita un número mayor a 0.00";
            break;
        case EDAD: 
             m = "Buscar por edad necesita un número entre 0 y 25";
             break;
        case TEMP:
            m = "Buscar por temperatura necesita un número entre 25.00 a 50.00 grados C°";
            break;
        }
        return new Tooltip(m);
    }

    /**
     * Regresa el valor ingresado.
     * @return el valor ingresado.
     */
    public Object getValor() {
        switch (opcionesCampo.getValue()) {
            case NOMBRE:   return entradaValor.getText();
            case PROPIETARIO: return entradaValor.getText();
            case ESPECIE:    return entradaValor.getText();
            case SEXO:       return entradaValor.getText();
            case PESO:       return Double.parseDouble(entradaValor.getText());
            case EDAD:       return Integer.parseInt(entradaValor.getText());
            case TEMP:       return Double.parseDouble(entradaValor.getText());
            default:       return entradaValor.getText(); // No puede ocurrir.
        }
    }

    /**
     * Regresa el campo seleccionado.
     * @return el campo seleccionado.
     */
    public CampoMascota getCampo() {
        return opcionesCampo.getValue();
    }

    /**
     * Define el foco incial del diálogo.
     */
    @Override public void defineFoco() {
        entradaValor.requestFocus();
    }
}
