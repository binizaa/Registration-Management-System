package mx.unam.ciencias.icc;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Clase para representar una mascota. Una mascota tiene nombre, dueño, especie,
 * sexo (femenino, masculino), peso(Kg), edad, temperatura corporal.
 * La clase implementa {@link Registro}, por lo que
 * puede seriarse en una línea de texto y deseriarse de una línea de
 * texto; además de determinar si sus campos casan valores arbitrarios y
 * actualizarse con los valores de otra mascota.
 */

public class Mascota implements Registro<Mascota, CampoMascota> {

    /*Nombre de la mascota*/
    private final StringProperty nombre;
    /*Nombre del propietario de la mascota*/
    private final StringProperty propietario;
    /*Especie de la mascota*/
    private final StringProperty especie;
    /*Sexo de la mascota*/
    private final StringProperty sexo;
    /*Peso de la mascota*/
    private final DoubleProperty peso;
    /*Edad de la mascota*/
    private final IntegerProperty edad;
    /*Temperatura corporal de la mascota*/
    private final DoubleProperty temp;

    /**
     * Define el estado inicial de una mascota.
     * @param nombre el nombre de la mascota.
     * @param propietario el propietario de la mascota.
     * @param especie la especie de la mascota.
     * @param sexo el sexo de la mascota.
     * @param peso el peso de la mascota.
     * @param edad la edad de la mascota.
     * @param temp la temperatura de la mascota.
     */

    public Mascota(String nombre, String propietario, String especie,
    String sexo, double peso, int edad, double temp){
        this.nombre = new SimpleStringProperty(nombre);
	    this.propietario = new SimpleStringProperty(propietario);
	    this.especie = new SimpleStringProperty(especie);
	    this.sexo = new SimpleStringProperty(sexo);
	    this.peso = new SimpleDoubleProperty(peso);
	    this.edad = new SimpleIntegerProperty(edad);
	    this.temp = new SimpleDoubleProperty(temp);
    }

    /**
     * Regresa el nombre del mascota.
     * @return el nombre del mascota.
     */
    public String getNombre() {
        return nombre.get();
    }

    /**
     * Define el nombre del mascota.
     * @param nombre el nuevo nombre del mascota.
     */
    public void setNombre(String nombre) {
        this.nombre.set(nombre);
    }

    /**
     * Regresa la propiedad del nombre.
     * @return la propiedad del nombre.
     */
    public StringProperty nombreProperty() {
        return this.nombre;
    }

    /**
    *Regresa el nombre del propietario de la mascota
    * @return el nombre del propietario.
    */
    public String getPropietario(){
	    return propietario.get();
    }

    /**
     * Define el nombre del propietario de la mascota
     * @param propietario el nombre del propietario de la mascota
     */
    public void setPropietario(String propietario){
        this.propietario.set(propietario);
    }

    /**
     * Regresa la propiedad del nombre del propietario de la mascota.
     * @return la propiedad del nombre del propietario de la mascota.
     */
    public StringProperty propietarioProperty() {
        return this.propietario;
    }

    /**
    *Regresa la especie de la mascota
    * @return la especie de la mascota
    */
    public String getEspecie(){
	    return especie.get();
    }

    /**
     * Define la especie de la mascota 
     * @param especie la especie de la mascota
     */
    public void setEspecie(String especie){
        this.especie.set(especie) ;
    }

    /**
     * Regresa la propiedad de la especie de la mascota.
     * @return la propiedad de la especie de la mascota.
     */
    public StringProperty especieProperty() {
        return this.especie;
    }

    /**
    *Regresa el sexo de la mascota
    * @return el sexo de la mascota (M/F)
    */
    public String getSexo(){
	    return sexo.get();
    }

    /**
     * Define el sexo de la mascota
     * @param sexo el sexo de la mascota
     */
    public void setSexo(String sexo){
        this.sexo.set(sexo);
    }

    /**
     * Regresa el propiedad del sexo de la mascota.
     * @return el propiedad del sexo de la mascota.
     */
    public StringProperty sexoProperty() {
        return this.sexo;
    }

    /**
    * Regresa el peso de la mascota
    * @return el peso de la mascota
    */
    public double getPeso(){
	    return peso.get();
    }

    /**
     * Define el peso (kg) de la mascota
     * @param peso el peso (kg) de la mascota
     */
    public void setPeso(double peso){
        this.peso.set(peso);
    }

    /**
     * Regresa la propiedad del peso de la mascota.
     * @return la propiedad del peso de la mascota.
     */
    public DoubleProperty pesoProperty() {
        return this.peso;
    }

    /**
    *Regresa la edad de la mascota
    * @return la edad de la mascota
    */
    public int getEdad(){
	    return edad.get();
    }

    /**
     * Define la edad de la mascota
     * @param edad la edad de la mascota
     */
    public void setEdad(int edad){
        this.edad.set(edad);
    }

    /**
     * Regresa la propiedad de la edad de la mascota.
     * @return la propiedad de la edad de la mascota.
     */
    public IntegerProperty edadProperty() {
        return this.edad;
    }

    /**
    *Regresa la temperatura de la mascota
    * @return la temperatura de la mascota
    */
    public double getTemp(){
	    return temp.get();
    }

    /**
     * Define la temperatura corporal de la mascota
     * @param temp la temperatura corporal de la mascota
     */
    public void setTemp(double temp){
        this.temp.set(temp);
    }

    /**
     * Regresa la propiedad de la temperatura corporal de la mascota.
     * @return la propiedad de la temperatura corporal de la mascota.
     */
    public DoubleProperty tempProperty() {
        return this.temp;
    }

    /**
     * Regresa una representación en cadena del mascota.
     * @return una representación en cadena del mascota.
     */
    @Override public String toString() {
        return String.format(
                "Nombre         : %s\n" + 
                "Propietario    : %s\n" +
                "Especie        : %s\n" +
                "Sexo           : %s\n" + 
                "Peso (kg)      : %2.2f\n"+
                "Edad           : %d\n" +
                "Temperatura(°C): %2.2f",   
                getNombre(), getPropietario(), getEspecie(), getSexo(), getPeso(), 
                getEdad(), getTemp());
    }

    /**
     * Nos dice si el objeto recibido es una mascota igual al que manda llamar
     * el método.
     * @param objeto el objeto con el que la mascota se comparará.
     * @return <code>true</code> si el objeto recibido es una mascota con las
     *         mismas propiedades que el objeto que manda llamar al método,
     *         <code>false</code> en otro caso.
     */
    @Override public boolean equals(Object objeto) {
        if (!(objeto instanceof Mascota)) return false;
        
        Mascota mascota = (Mascota)objeto;
        return mascota.getNombre().equals(this.getNombre())&&
            mascota.getPropietario().equals(this.getPropietario())&&
            mascota.getEspecie().equals(this.getEspecie())&&
            mascota.getSexo().equals(this.getSexo())&&
            this.getPeso() == mascota.getPeso() &&
            this.getEdad() == mascota.getEdad() &&
            this.getTemp() == mascota.getTemp();
    }

    /**
     * Regresa la mascota seriado en una línea de texto. La línea de
     * texto que este método regresa debe ser aceptada por el método {@link
     * Mascota#deseria}.
     * @return la seriación de la Mascota en una línea de texto.
     */
    @Override public String seria() {
        return String.format("%s\t%s\t%s\t%s\t%2.2f\t%d\t%2.2f\n", 
                            getNombre(), getPropietario(), getEspecie(), 
                            getSexo(), getPeso(), getEdad(), getTemp());
    }

    /**
     * Deseria una línea de texto en las propiedades de la mascota. La
     * seriación producida por el método {@link Mascota#seria} debe
     * ser aceptada por este método.
     * @param linea la línea a deseriar.
     * @throws ExcepcionLineaInvalida si la línea recibida es nula, vacía o no
     *         es una seriación válida de una mascota.
     */
    @Override public void deseria(String linea) {
        if(linea == null) throw new ExcepcionLineaInvalida();
        String[]tipo = linea.trim().split("\t");
        try{
            setNombre(tipo[0]);
            setPropietario(tipo[1]);
            setEspecie(tipo[2]);
            setSexo(tipo[3]);
            setPeso(Double.parseDouble(tipo[4]));
            setEdad(Integer.parseInt(tipo[5]));
            setTemp(Double.parseDouble(tipo[6]));
        }catch(Exception excep){
            throw new ExcepcionLineaInvalida();
        }
    }

    /**
     * Actualiza los valores de la mascota con los de la mascota recibida.
     * @param mascota la mascota con el cual actualizar los valores.
     * @throws IllegalArgumentException si la mascota es <code>null</code>.
     */
    public void actualiza(Mascota mascota){
        if(mascota == null) throw new IllegalArgumentException();
        setNombre(mascota.getNombre());
        setPropietario(mascota.getPropietario());
        setEspecie(mascota.getEspecie());
        setSexo(mascota.getSexo());
        setPeso(mascota.getPeso());
        setEdad(mascota.getEdad());
        setTemp(mascota.getTemp());
    }

    /**
     * Nos dice si la mascota casa el valor dado en el campo especificado.
     * @param campo el campo que hay que casar.
     * @param valor el valor con el que debe casar el campo del registro.
     * @return <code>true</code> si:
     *         <ul>
     *           <li><code>campo</code> es {@link CampoMascota#NOMBRE} y
     *              <code>valor</code> es instancia de {@link String} y es una
     *              subcadena del nombre de la mascota.</li>
     *          <li><code>campo</code> es {@link CampoMascota#PROPIETARIO} y
     *              <code>valor</code> es instancia de {@link String} y es una
     *              subcadena del nombre del propietario.</li>
     *          <li><code>campo</code> es {@link CampoMascota#ESPECIE} y
     *              <code>valor</code> es instancia de {@link String} y es una
     *              subcadena de la especie de la mascota.</li>
     *          <li><code>campo</code> es {@link CampoMascota#SEXO} y
     *              <code>valor</code> es instancia de {@link String} y es el sexo
     *              de la mascota, M (masculino) o F (femenino).</li>
     *          <li><code>campo</code> es {@link CampoMascota#PESO} y
     *              <code>valor</code> es instancia de {@link Double} y su
     *              valor doble es menor o igual al peso de la mascota.</li>
     *           <li><code>campo</code> es {@link CampoMascota#EDAD} y
     *              <code>valor</code> es instancia de {@link Integer} y su
     *              valor entero es menor o igual a la edad de la mascota.</li>
     *          <li><code>campo</code> es {@link CampoMascota#TEMP} y
     *              <code>valor</code> es instancia de {@link Double} y su
     *              valor doble es menor o igual a la temperatura de la mascota.</li>
     *         </ul>
     *         <code>false</code> en otro caso.
     *          @throws IllegalArgumentException si el campo no es instancia de {@link
     *         CampoMascota}.
     */
    
    @Override public boolean casa(CampoMascota campo, Object valor) {
        if(!(campo instanceof CampoMascota)) throw new IllegalArgumentException();

        CampoMascota campoMasc = (CampoMascota) campo;
        switch(campoMasc){
            case NOMBRE: return casaNombre(valor);
            case PROPIETARIO: return casaPropietario(valor);
            case ESPECIE: return casaEspecie(valor);
            case SEXO: return casaSexo(valor); 
            case PESO: return casaPeso(valor); 
            case EDAD: return casaEdad(valor);
            case TEMP: return casaTemp(valor);
            default: return false;
        }
    }

    private boolean casaNombre(Object valor){
        if(!(valor instanceof String)) return false;

        String nom = (String) valor;
        if(nom.isEmpty()) return false;
        return this.getNombre().contains(nom);
    }

    private boolean casaPropietario(Object valor){
        if(!(valor instanceof String)) return false;

        String prop = (String) valor;
        if(prop.isEmpty()) return false;
        return this.getPropietario().contains(prop);
    }

    private boolean casaEspecie(Object valor){
        if(!(valor instanceof String)) return false;

        String esp = (String) valor;
        if(esp.isEmpty()) return false;
        return this.getEspecie().contains(esp);
    }

    private boolean casaSexo(Object valor){
        if(!(valor instanceof String)) return false;

        String sex = (String) valor;
        if(sex.isEmpty()) return false;
        return this.getSexo().contains(sex);
    }

    private boolean casaPeso(Object valor){
        if(!(valor instanceof Double)) return false;

        Double pes = (Double) valor;
        return pes.doubleValue() <= this.getPeso();
    }

    private boolean casaEdad(Object valor){
        if(!(valor instanceof Integer)) return false;

        Integer cnt = (Integer) valor;
        return cnt.intValue() <= this.getEdad();
    }

    private boolean casaTemp(Object valor){
        if(!(valor instanceof Double)) return false;

        Double tem = (Double) valor;
        return tem.doubleValue() <= this.getTemp();
    }

}
