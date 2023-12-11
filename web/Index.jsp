<%-- 
    Document   : Index
    Created on : 5/12/2023, 11:47:16 a. m.
    Author     : parko
--%>

<%@page import="Modelo.Estructura_SPaRQL"%>
<%@page import="Modelo.Data_RDF"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <link href="CSS/index.css" rel="stylesheet">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">

        <title>Gestion Conocimineto</title>
    </head>
    <body>

        <div class="container">
            <div class="button-container">
                <button class="btn btn-outline-primary" onclick="showTable('MEM')">Mostrar Estudiantes Incritos En Materia</button>
                <button class="btn btn-outline-primary" onclick="showTable('PY')">Mostrar Lideres de Proyectos, Estudiantes participante</button>
                <button class="btn btn-outline-primary" onclick="showTable('CEMM')">Mostrar Cantidad de Estudiante Por Materia</button>
                <button class="btn btn-outline-primary" onclick="showTable('DM')">Mostrar Docentes por contrato</button>
                <button class="btn btn-outline-primary" onclick="showTable('C')">Selection of triples</button>
                <button class="btn btn-outline-primary" onclick="showTable('T')">Selection of classes</button>
            </div>
        </div>

        <script>

            function initializeTables() {
                var divs = document.querySelectorAll('.table-div');
                divs.forEach(function (div, index) {
                    if (index === 0) {
                        div.style.display = 'block'; // Muestra la primera tabla
                    } else {
                        div.style.display = 'none'; // Oculta las demás
                    }
                });
            }

            // Función para mostrar la tabla seleccionada
            function showTable(tableName) {
                var divs = document.querySelectorAll('.table-div');
                divs.forEach(function (div) {
                    div.style.display = 'none'; // Oculta todas las tablas
                });

                var selectedDiv = document.getElementById(tableName + '-div');
                selectedDiv.style.display = 'block'; // Muestra la tabla seleccionada
            }

            // Llama a la función de inicialización cuando la página se carga
            window.onload = initializeTables;
        </script>


        <div id="MEM-div" class="table-div">
            <form class="d-flex" action="SV_fuseki" method="POST">
                <input autocomplete="off" name="MEM_"class="form-control me-2" type="search" placeholder="'Presencial' o 'Distancia'" aria-label="Search" value="">
                <button class="btn btn-outline-success" type="submit" >Search</button>
            </form>

            <table class="table" border="1">
                <thead class="table-light">
                    <tr>
                        <th>Materia Nombre</th>
                        <th>Estudiante Nombre</th>
                        <th>Modalidad</th>
                    </tr>
                </thead>
                <tbody>

                    <%
                        List<Data_RDF> listaM = (List) request.getSession().getAttribute("MEM");
                        if (listaM != null && !listaM.isEmpty()) {
                            for (Data_RDF elem : listaM) {
                    %>
                    <tr>
                        <td><%= elem.getMateria_nombre()%></td>
                        <td><%= elem.getEstudiante_nombre()%></td>
                        <td><%= elem.getEstudiante_modalidad()%></td>
                    </tr>
                    <%
                            }
                        }
                    %>
                </tbody>
            </table>
        </div>

        <div id="PY-div" class="table-div">
            <form class="d-flex" action="SV_fuseki" method="POST">
                <input autocomplete="off" name="PY_"class="form-control me-2" type="search" placeholder="'Comunidad' o 'Invertigar'" aria-label="Search" value="">
                <button class="btn btn-outline-success" type="submit">Search</button>
            </form>
            <table class="table" border="1">
                <thead>
                    <tr>
                        <th>Profesor Lider de Proyecto</th>
                        <th>Nombre del Proyecto</th>
                        <th>Estudiante Vinculado</th>
                        <th>Modalidad</th>
                    </tr>
                </thead>
                <tbody>

                    <%
                        List<Data_RDF> listaPY = (List) request.getSession().getAttribute("PY");
                        if (listaPY != null && !listaPY.isEmpty()) {
                            for (Data_RDF elem : listaPY) {
                    %>
                    <tr>
                        <td><%= elem.getProdesor_Nombre()%></td>
                        <td><%= elem.getProyecto_nombre()%></td>
                        <td><%= elem.getEstudiante_nombre()%></td>
                        <td><%= elem.getEstudiante_modalidad()%></td>
                    </tr>
                    <%
                            }
                        }
                    %>
                </tbody>
            </table>
        </div>

        <div id="CEMM-div" class="table-div">
            <form class="d-flex" action="SV_fuseki" method="POST">
                <input autocomplete="off" name="CEMM_"class="form-control me-2" type="search" placeholder="'Presencial' o 'Distancia'" aria-label="Search" value="">
                <button class="btn btn-outline-success" type="submit" values="Submit">Search</button>
            </form>
            <table class="table" border="1">
                <thead>
                    <tr>
                        <th>Cantidad Estudiantes</th>
                        <th>Materia Nombre</th>
                        <th>Modalidad</th>
                    </tr>
                </thead>
                <tbody>

                    <%
                        List<Data_RDF> listaCEMM = (List) request.getSession().getAttribute("CEMM");
                        if (listaCEMM != null && !listaCEMM.isEmpty()) {
                            for (Data_RDF elem : listaCEMM) {
                    %>
                    <tr>
                        <td><%= elem.getCant_Estudiante()%></td>
                        <td><%= elem.getMateria_nombre()%></td>
                        <td><%= elem.getEstudiante_modalidad()%></td>
                    </tr>
                    <%
                            }
                        }
                    %>
                </tbody>
            </table>
        </div>

        <div id="DM-div" class="table-div">
            <form class="d-flex" action="SV_fuseki" method="POST">
                <input autocomplete="off" name="DM_"class="form-control me-2" type="search" placeholder="'Planta' o 'Catedratico'" aria-label="Search" value="">
                <button class="btn btn-outline-success" type="submit" values="Submit">Search</button>
            </form>
            <table class="table" border="1">
                <thead>
                    <tr>
                        <th>Profesor</th>
                        <th>Tipo</th>
                    </tr>
                </thead>
                <tbody>

                    <%
                        List<Data_RDF> listaDM = (List) request.getSession().getAttribute("DM");
                        if (listaDM != null && !listaDM.isEmpty()) {
                            for (Data_RDF elem : listaDM) {
                    %>
                    <tr>
                        <td><%= elem.getProdesor_Nombre()%></td>
                        <td><%= elem.getTipo()%></td>
                    </tr>
                    <%
                            }
                        }
                    %>
                </tbody>
            </table>
        </div>
        <div id="C-div" class="table-div">
            <table class="table" border="1">
                <thead>
                    <tr>
                        <th>Clase Name</th>

                    </tr>
                </thead>
                <tbody>

                    <%
                        List<Estructura_SPaRQL> listaS = (List) request.getSession().getAttribute("C");
                        if (listaS != null && !listaS.isEmpty()) {
                            for (Estructura_SPaRQL elem : listaS) {
                    %>
                    <tr>
                        <td><%= elem.getClasss()%></td>

                    </tr>
                    <%
                            }
                        }
                    %>
                </tbody>
            </table>
        </div>

        <div id="T-div" class="table-div">
            <table class="table" border="1">
                <thead>
                    <tr>
                        <th>Sujeto</th>
                        <th>Predicado</th>
                        <th>Objeto</th>
                    </tr>
                </thead>
                <tbody>

                    <%
                        List<Estructura_SPaRQL> listaT = (List) request.getSession().getAttribute("T");
                        if (listaT != null && !listaT.isEmpty()) {
                            for (Estructura_SPaRQL elem : listaT) {
                    %>
                    <tr>
                        <td><%= elem.getSujeto()%></td>
                        <td><%= elem.getPredicado()%></td>
                        <td><%= elem.getObjeto()%></td>
                    </tr>
                    <%
                            }
                        }
                    %>
                </tbody>
            </table>
        </div>
    </body>
</html>
