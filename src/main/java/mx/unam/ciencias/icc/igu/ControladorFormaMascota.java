package mx.unam.ciencias.icc.igu;

/**
 * Clase abstracta para controladores del contenido de diálogo con formas con
 * datos de mascotas que se aceptan o rechazan.
 */
public abstract class ControladorFormaMascota extends ControladorForma {

    /** El valor del nombre. */
    protected String nombre;
    /** El valor del propietario. */
    protected String propietario;
    /** El valor de la especie. */
    protected String especie;
    /** El valor del sexo. */
    protected String sexo;
    /** El valor del peso. */
    protected double peso;
    /** El valor de la edad. */
    protected int edad;
    /** El valor de la temperatura. */
    protected double temp;

    /**
     * Verifica que el nombre sea válido.
     * @param nombre el nombre a verificar.
     * @return <code>true</code> si el nombre es válido; <code>false</code> en
     *         otro caso.
     */
    protected boolean verificaNombre(String nombre) {
        if(nombre.isEmpty() || nombre == null) return false;
        this.nombre = nombre;
        return true;
    }

    /**
     * Verifica que el propietario sea válido.
     * @param propietario el propietario a verificar.
     * @return <code>true</code> si el propietario es válido; <code>false</code> en
     *         otro caso.
     */
    protected boolean verificaPropietario(String propietario) {
        if (propietario == null || propietario.isEmpty()) return false;
        this.propietario = propietario;
        return true;
    }

    /**
     * Verifica que la especie sea válida.
     * @param especie la especie a verificar.
     * @return <code>true</code> si la especie es válida; <code>false</code> en
     *         otro caso.
     */
    protected boolean verificaEspecie(String especie) {
        if (especie == null || especie.isEmpty()) return false;
        this.especie = especie;
        return true;
    }

    /**
     * Verifica que el sexo sea válido.
     * @param sexo el sexo a verificar.
     * @return <code>true</code> si el sexo es válido; <code>false</code> en
     *         otro caso.
     */
    protected boolean verificaSexo(String sexo) {
        if (sexo == null || sexo.isEmpty()) return false;
        this.sexo = sexo;
        return "M".equalsIgnoreCase(sexo) || "F".equalsIgnoreCase(sexo);
    }

    /**
     * Verifica que el peso sea válido.
     * @param peso el peso a verificar.
     * @return <code>true</code> si el peso es válido; <code>false</code> en
     *         otro caso.
     */
    protected boolean verificaPeso(String peso) {
        if (peso == null || peso.isEmpty()) {
            return false;
        }
        try {
            this.peso = Double.parseDouble(peso);
            return this.peso >= 0.0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * Verifica que la edad sea válida.
     * @param edad la edad a verificar.
     * @return <code>true</code> si la edad es válida; <code>false</code> en
     *         otro caso.
     */
    protected boolean verificaEdad(String edad) {
        if (edad == null || edad.isEmpty()) {
            return false;
        }
        try {
            this.edad = Integer.parseInt(edad);
            return this.edad > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * Verifica que la temperatura sea válida.
     * @param temperatura la temperatura a verificar.
     * @return <code>true</code> si la temperatura es válida; <code>false</code> en
     *         otro caso.
     */
    protected boolean verificaTemp(String temp) {
        if (temp == null || temp.isEmpty()) return false;
        try {
            this.temp = Double.parseDouble(temp);
            return this.temp > 0.0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
