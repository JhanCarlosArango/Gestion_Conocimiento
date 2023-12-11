/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DOA;

/**
 *
 * @author parko
 */
public class Consultas {

    public Consultas() {

    }

    private final String PREFIX = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n";
    private final String Univ = "PREFIX Univ: <http://www.semanticweb.org/parko/ontologies/2023/10/Universidad#>\n";

    public String Consulta_1() {

        String Consulta_1 = "PREFIX owl: <http://www.w3.org/2002/07/owl#>\n"
                + "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n"
                + "\n"
                + "SELECT DISTINCT ?class ?label ?description\n"
                + "WHERE {\n"
                + "  ?class a owl:Class.\n"
                + "  OPTIONAL { ?class rdfs:label ?label}\n"
                + "  OPTIONAL { ?class rdfs:comment ?description}\n"
                + "}";
        return Consulta_1;
    }

    public String Consulta_2() {

        String Consulta_2 = "SELECT ?subject ?predicate ?object\n"
                + "WHERE {\n"
                + "  ?subject ?predicate ?object\n"
                + "}";
        return Consulta_2;
    }

    public String Consulta_3(String Modadlidad) {

        String Consulta_3 = PREFIX + Univ + "SELECT DISTINCT ?Estudiante_Nombre ?Nombre_Materia ?Modalidad \n"
                + "WHERE {\n"
                + "  ?Estudiante Univ:Persona_Nombre ?Estudiante_Nombre.\n"
                + "  ?Materia Univ:Materia_hacia_Estudiante ?Estudiante.  \n"
                + "  ?Materia Univ:Materia_Nombre ?Nombre_Materia.\n"
                + "  ?Estudiante Univ:Estudiante_Modalidad ?Modalidad \n"
                + "  {\n"
                + "    ?Estudiante_Presencial Univ:esta_Inscrito_en ?Materia .   \n"
                + "  }\n"
                + "  UNION\n"
                + "  {\n"
                + "    ?Estudiante_Virtual Univ:esta_Inscrito_en_Virtual ?Materia . \n"
                + "  }\n"
                + "  FILTER(REGEX(str(?Modalidad), \"" + Modadlidad + "\",'i'))\n"
                + "}";
        return Consulta_3;
    }
//Cuantos estudiantes estan en una misma materia y su modalidad?

    public String Consulta_4(String Modadlidad) {
        String Consulta_4 = PREFIX + Univ + "SELECT (COUNT(DISTINCT ?Estudiante_Nombre) as ?Cantidad_Estudiantes) ?Nombre_Materia ?Modalidad \n"
                + "WHERE {\n"
                + "  ?Estudiante Univ:Persona_Nombre ?Estudiante_Nombre.\n"
                + "  ?Materia Univ:Materia_hacia_Estudiante ?Estudiante.  \n"
                + "  ?Materia Univ:Materia_Nombre ?Nombre_Materia.\n"
                + "  ?Estudiante Univ:Estudiante_Modalidad ?Modalidad  \n"
                + "  {\n"
                + "    ?Estudiante_Presencial Univ:esta_Inscrito_en ?Materia .   \n"
                + "  }\n"
                + "  UNION\n"
                + "  {\n"
                + "    ?Estudiante_Virtual Univ:esta_Inscrito_en_Virtual ?Materia . \n"
                + "  }\n"
                + "  FILTER(REGEX(str(?Modalidad), \"" + Modadlidad + "\",'i'))\n"
                + "}\n"
                + "GROUP BY ?Nombre_Materia ?Modalidad";
        return Consulta_4;
    }

    //Que docentes Son de planta y catedraticos ?
    public String Consulta_5(String Tipo) {
        String Consulta_5 = PREFIX + Univ + "SELECT ?Profesor_Nombre ?Modalidad\n"
                + "where { \n"
                + "?Profesor Univ:Persona_Nombre ?Profesor_Nombre.\n"
                + "?Profesor Univ:Profesor_tipo ?Modalidad.  \n"
                + "FILTER(REGEX(str(?Modalidad), \"" + Tipo + "\",'i'))\n"
                + "}";
        return Consulta_5;
    }

//En cuantos Proyectos esta presente un docente ?
    public String Consulta_6(String Tipo_Investigacion) {
        String Consulta_6 = PREFIX + Univ + "SELECT ?Profesor_Lider ?proyecto_nombre ?estudiante_vinculado ?Modalidad\n"
                + "WHERE {\n"
                + "  ?Profesor Univ:Persona_Nombre ?Profesor_Lider .\n"
                + "  ?Profesor Univ:Lidera_un ?Proyecto .\n"
                + "  ?Proyecto Univ:Proyecto_Name ?proyecto_nombre .   \n"
                + "  ?Estudiante Univ:Persona_Nombre ?estudiante_vinculado .\n"
                + "  ?Estudiante Univ:Vinculado_en ?Proyecto .  \n"
                + "  ?Proyecto Univ:Proyecto_Name ?proyecto_nombre .  \n"
                + "  ?Estudiante Univ:Estudiante_Modalidad ?Modalidad \n"
                + "  \n"
                + "  FILTER(REGEX(str(?proyecto_nombre), \""+Tipo_Investigacion+"\",'i'))\n"
                + "}";
        return Consulta_6;
    }
}
