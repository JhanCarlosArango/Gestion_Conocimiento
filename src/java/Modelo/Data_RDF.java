package Modelo;

/**
 *
 * @author parko
 */
public class Data_RDF {

    private String Materia_nombre = "";
    private String Estudiante_nombre = "";
    private String Estudiante_modalidad = "";
    private String Cant_Estudiante;
    private String Prodesor_Nombre;
    private String Tipo;
    private String proyecto_nombre;
    

    public Data_RDF() {
    }

    public String getMateria_nombre() {
        return Materia_nombre;
    }

    public void setMateria_nombre(String Materia_nombre) {
        this.Materia_nombre = Materia_nombre;
    }

    public String getEstudiante_nombre() {
        return Estudiante_nombre;
    }

    public void setEstudiante_nombre(String Estudiante_nombre) {
        this.Estudiante_nombre = Estudiante_nombre;
    }

    public String getEstudiante_modalidad() {
        return Estudiante_modalidad;
    }

    public void setEstudiante_modalidad(String Estudiante_modalidad) {
        this.Estudiante_modalidad = Estudiante_modalidad;
    }

    @Override
    public String toString() {
        return "Data_RDF{" + "Materia_nombre=" + Materia_nombre + ", Estudiante_nombre=" + Estudiante_nombre + ", Estudiante_modalidad=" + Estudiante_modalidad + '}';
    }

    public String getCant_Estudiante() {
        return Cant_Estudiante;
    }

    public void setCant_Estudiante(String Cant_Estudiante) {
        this.Cant_Estudiante = Cant_Estudiante;
    }

    public String getProdesor_Nombre() {
        return Prodesor_Nombre;
    }

    public void setProdesor_Nombre(String Prodesor_Nombre) {
        this.Prodesor_Nombre = Prodesor_Nombre;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }

    public String getProyecto_nombre() {
        return proyecto_nombre;
    }

    public void setProyecto_nombre(String proyecto_nombre) {
        this.proyecto_nombre = proyecto_nombre;
    }

}
