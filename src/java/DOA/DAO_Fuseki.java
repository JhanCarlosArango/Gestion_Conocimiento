package DOA;

import Modelo.Data_RDF;
import Modelo.Estructura_SPaRQL;
import java.util.ArrayList;
import org.apache.jena.query.*;
import org.apache.jena.rdf.model.RDFNode;

/**
 *
 * @author parko
 */
public class DAO_Fuseki {

    Consultas Con = new Consultas();
    String SPARQL_end_point = "http://localhost:3030/Universisdad/";

    public DAO_Fuseki() {

    }

    public ArrayList<DAO_Fuseki> Classs() {
        Estructura_SPaRQL ES_Class;
        ArrayList List_class = new ArrayList();

        Query query = QueryFactory.create(Con.Consulta_1());
        try (QueryExecution queryExecution = QueryExecutionFactory.sparqlService(SPARQL_end_point, query)) {
            ResultSet resul = queryExecution.execSelect();
            while (resul.hasNext()) {

                ES_Class = new Estructura_SPaRQL();

                QuerySolution solucion = resul.nextSolution();
                RDFNode clas = solucion.get("class");
                //RDFNode label = solucion.get("label");
                //RDFNode descrip = solucion.get("description");

                //Llenar modelo        
                ES_Class.setClasss(Get_Object_Values(clas));
                //ES_Class.setLabel(Get_Object_Values(label));
                //ES_Class.setLabedescription(Get_Object_Values(descrip));

                List_class.add(ES_Class);
            }
        }
        return List_class;
    }
    public ArrayList<DAO_Fuseki> Tripes() {
        Estructura_SPaRQL triples;
        ArrayList List_triples = new ArrayList();

        Query query = QueryFactory.create(Con.Consulta_2());
        try (QueryExecution queryExecution = QueryExecutionFactory.sparqlService(SPARQL_end_point, query)) {
            ResultSet resul = queryExecution.execSelect();
            while (resul.hasNext()) {

                triples = new Estructura_SPaRQL();

                QuerySolution solucion = resul.nextSolution();
                RDFNode su = solucion.get("subject");
                RDFNode pre = solucion.get("predicate");
                RDFNode ob = solucion.get("object");

                //Llenar modelo        
                triples.setSujeto(Get_Object_Values(su));
                triples.setPredicado(Get_Object_Values(pre));
                triples.setObjeto(Get_Object_Values(ob));

                List_triples.add(triples);
            }
        }
        return List_triples;
    }

    public ArrayList<DAO_Fuseki> Maestro_Estudiante_Modalidad(String modalidad) {
        Data_RDF maestro_estudiante_modalidad;
        ArrayList List_maestro_estudiante_modalidad = new ArrayList();

        Query query = QueryFactory.create(Con.Consulta_3(modalidad));
        try (QueryExecution queryExecution = QueryExecutionFactory.sparqlService(SPARQL_end_point, query)) {
            ResultSet resul = queryExecution.execSelect();
            while (resul.hasNext()) {

                maestro_estudiante_modalidad = new Data_RDF();

                QuerySolution solucion = resul.nextSolution();
                RDFNode Estudiante_Nombre = solucion.get("Estudiante_Nombre");
                RDFNode Nombre_Materia = solucion.get("Nombre_Materia");
                RDFNode Modalidad = solucion.get("Modalidad");

                //Llenar modelo        
                maestro_estudiante_modalidad.setEstudiante_nombre(Get_Object_Values(Estudiante_Nombre));
                maestro_estudiante_modalidad.setMateria_nombre(Get_Object_Values(Nombre_Materia));
                maestro_estudiante_modalidad.setEstudiante_modalidad(Get_Object_Values(Modalidad));

                List_maestro_estudiante_modalidad.add(maestro_estudiante_modalidad);
            }
           
        }
        return List_maestro_estudiante_modalidad;
    }

    public ArrayList<DAO_Fuseki> Cant_Estudiante_Materia_Modalidad(String modalidad) {
        Data_RDF cant_estudiante_materia_modalidad;
        ArrayList List_cant_estudiante_materia_modalidad = new ArrayList();

        Query query = QueryFactory.create(Con.Consulta_4(modalidad));
        try (QueryExecution queryExecution = QueryExecutionFactory.sparqlService(SPARQL_end_point, query)) {
            ResultSet resul = queryExecution.execSelect();
            while (resul.hasNext()) {

                cant_estudiante_materia_modalidad = new Data_RDF();

                QuerySolution solucion = resul.nextSolution();
                RDFNode Cant_Estudiante = solucion.get("Cantidad_Estudiantes");
                RDFNode Nombre_Materia = solucion.get("Nombre_Materia");
                RDFNode Modalidad = solucion.get("Modalidad");

                //Llenar modelo        
                cant_estudiante_materia_modalidad.setCant_Estudiante(Get_Object_Values(Cant_Estudiante));
                cant_estudiante_materia_modalidad.setMateria_nombre(Get_Object_Values(Nombre_Materia));
                cant_estudiante_materia_modalidad.setEstudiante_modalidad(Get_Object_Values(Modalidad));

                List_cant_estudiante_materia_modalidad.add(cant_estudiante_materia_modalidad);
            }

        }
        return List_cant_estudiante_materia_modalidad;
    }
    public ArrayList<DAO_Fuseki> Proyecto_profesor (String Tipo_Investigacion) {
        Data_RDF Docentes_Proyecto;
        ArrayList List_Docentes_proyecto = new ArrayList();

        Query query = QueryFactory.create(Con.Consulta_6(Tipo_Investigacion));
        try (QueryExecution queryExecution = QueryExecutionFactory.sparqlService(SPARQL_end_point, query)) {
            ResultSet resul = queryExecution.execSelect();
            while (resul.hasNext()) {

                Docentes_Proyecto = new Data_RDF();

                QuerySolution solucion = resul.nextSolution();
                RDFNode Pro_LIDER = solucion.get("Profesor_Lider");
                RDFNode Nombre_Proyec = solucion.get("proyecto_nombre");
                RDFNode ESt_Vinculado = solucion.get("estudiante_vinculado");
                RDFNode Modalidad = solucion.get("Modalidad");

                //Llenar modelo        
                Docentes_Proyecto.setProdesor_Nombre(Get_Object_Values(Pro_LIDER));
                Docentes_Proyecto.setProyecto_nombre(Get_Object_Values(Nombre_Proyec));
                Docentes_Proyecto.setEstudiante_nombre(Get_Object_Values(ESt_Vinculado));
                Docentes_Proyecto.setEstudiante_modalidad(Get_Object_Values(Modalidad));

                List_Docentes_proyecto.add(Docentes_Proyecto);
            }

        }
        return List_Docentes_proyecto;
    }

    public ArrayList<DAO_Fuseki> Docente_Modalidad(String tipo) {
        Data_RDF docente_M;
        ArrayList docenteList = new ArrayList();

        Query query = QueryFactory.create(Con.Consulta_5(tipo));
        try (QueryExecution queryExecution = QueryExecutionFactory.sparqlService(SPARQL_end_point, query)) {
            ResultSet resul = queryExecution.execSelect();
            while (resul.hasNext()) {

                docente_M = new Data_RDF();

                QuerySolution solucion = resul.nextSolution();
                RDFNode Profesor_Nombre = solucion.get("Profesor_Nombre");
                RDFNode Tipo = solucion.get("Modalidad");

                //Llenar modelo        
                docente_M.setProdesor_Nombre(Get_Object_Values(Profesor_Nombre));
                docente_M.setTipo(Get_Object_Values(Tipo));
                docenteList.add(docente_M);
            }

        }
        return docenteList;
    }

    private String Get_Object_Values(RDFNode object) {
        if (object.isLiteral()) {
            return object.asLiteral().getString();
        } else {
            return object.toString();
        }
    }
}
