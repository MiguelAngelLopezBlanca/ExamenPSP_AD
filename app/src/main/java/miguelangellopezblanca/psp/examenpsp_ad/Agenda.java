package miguelangellopezblanca.psp.examenpsp_ad;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.time.LocalDate;

@Entity(tableName = "contactos")
public class Agenda {

    /*
    int id, numero;
    String nombre, apellidos, telefono, localidad, calle;
    LocalDate fechNacimiento;
     */

    /*
    Tablas: contactos
    campos: id integer autonumeric primary key, String (nombre, apellidos, telefono, localidad, calle), LocalDate fechNacimiento, numero integer
    sqlite: varchar, text
     */

    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "nombre")
    private String nombre;

    @ColumnInfo(name = "apellidos")
    private String apellidos;

    @ColumnInfo(name = "telefono")
    private String telefono;

    @ColumnInfo(name = "fechaNacimiento")
    private String fechNacimiento;

    @ColumnInfo(name = "localidad")
    private String localidad;

    @ColumnInfo(name = "calle")
    private String calle;

    @ColumnInfo(name = "numero")
    private int numero;

    @Ignore
    public Agenda(String nombre, String apellidos, String telefono, String fechNacimiento, String localidad, String calle, int numero) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.fechNacimiento = fechNacimiento;
        this.localidad = localidad;
        this.calle = calle;
        this.numero = numero;
    }

    public Agenda(){

    }

    public Agenda(String nombre){
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getFechNacimiento() {
        return fechNacimiento;
    }

    public void setFechNacimiento(String fechNacimiento) {
        this.fechNacimiento = fechNacimiento;
    }

    @Override
    public String toString(){

        return "[" + id + "]" + "\n" + nombre + " / " + apellidos + " / " + "\n" + telefono +
                " / " + fechNacimiento + "\n" + localidad + " / " + calle + " [ " + numero + " ]";




    }
}
