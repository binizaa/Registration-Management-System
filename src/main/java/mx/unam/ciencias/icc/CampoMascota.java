package mx.unam.ciencias.icc;

/**
 * Enumeración para los campos de un {@link Mascota}.
 */
public enum CampoMascota {

    /** El nombre de la mascota. */
    NOMBRE,
    /** El propietario de la mascota. */
    PROPIETARIO,
    /** La especie de la mascota. */
    ESPECIE,
    /** El sexo de la mascota. */
    SEXO,
    /** El peso de la mascota. */
    PESO,
    /** La edad de la mascota. */
    EDAD,
    /** La temperatura de la mascota. */
    TEMP;

    /**
     * Regresa una representación en cadena del campo para ser usada en
     * interfaces gráficas.
     * @return una representación en cadena del campo.
     */
    @Override public String toString() {
        switch(this) {
            case NOMBRE:     return "Nombre";
            case PROPIETARIO: return "Propietario";
            case ESPECIE:    return "Especie";
            case SEXO:       return "Sexo";
            case PESO:       return "Peso";
            case EDAD:       return "Edad";
            case TEMP:       return "Temperatura";
            default:         return null;
        }
    }
}
 