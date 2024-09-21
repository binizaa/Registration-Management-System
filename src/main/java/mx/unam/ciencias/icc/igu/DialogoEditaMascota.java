package mx.unam.ciencias.icc.igu;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import mx.unam.ciencias.icc.Mascota;

/**
 * Clase para diálogos con formas para editar mascotas.
 */
public class DialogoEditaMascota extends Stage {

    /* Vista de la forma para agregar/editar mascotas. */
    private static final String EDITA_MASCOTA_FXML =
        "fxml/forma-edita-mascota.fxml";

    /* El controlador. */
    private ControladorFormaEditaMascota controlador;

    /**
     * Define el estado inicial de un diálogo para mascota.
     * @param escenario el escenario al que el diálogo pertenece.
     * @param mascota el mascota; puede ser <code>null</code> para agregar
     *                   un mascota.
     * @throws IOException si no se puede cargar el archivo FXML.
     */
    public DialogoEditaMascota(Stage escenario,
                                  Mascota mascota) throws IOException {
        ClassLoader cl = getClass().getClassLoader();
        FXMLLoader cargador =
            new FXMLLoader(cl.getResource(EDITA_MASCOTA_FXML));
        AnchorPane cristal = (AnchorPane)cargador.load();

        if (mascota == null)
            setTitle("Agregar mascota");
        else
            setTitle("Editar mascota");
        initOwner(escenario);
        initModality(Modality.WINDOW_MODAL);
        Scene escena = new Scene(cristal);
        setScene(escena);

        controlador = cargador.getController();
        controlador.setEscenario(this);
        controlador.setMascota(mascota);
        if (mascota == null)
            controlador.setVerbo("Agregar");
        else
            controlador.setVerbo("Actualizar");

        setOnShown(w -> controlador.defineFoco());
        setResizable(false);
    }

    /**
     * Nos dice si el usuario activó el botón de aceptar.
     * @return <code>true</code> si el usuario activó el botón de aceptar,
     *         <code>false</code> en otro caso.
     */
    public boolean isAceptado() {
        return controlador.isAceptado();
    }

    /**
     * Regresa el mascota del diálogo.
     * @return el mascota del diálogo.
     */
    public Mascota getMascota() {
        return controlador.getMascota();
    }
}
