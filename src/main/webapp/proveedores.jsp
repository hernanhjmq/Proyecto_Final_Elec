<%
    if(session.getAttribute("login")!="OK")
    {
        response.sendRedirect("login.jsp");
    }
%>
<%@page import="java.util.List"%>
<%@page import="com.emergentes.modelo.Proveedor"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    List<Proveedor> lista = (List<Proveedor>) request.getAttribute("lista");
%>
<%
    String ruta = "https://www.liderdelemprendimiento.com/wp-content/uploads/2019/10/Qu%C3%A9-son-los-proveedores-y-cu%C3%A1les-son-sus-tipos-2848x3000.png";
%>
<!doctype html>
<html lang="en">
    <head>

        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

        <title>SISTEMA DE TIENDA ELECTRONICO</title>

    </head>
    <body>
        <jsp:include page="WEB-INF/menu2.jsp">
            <jsp:param name="opcion" value="proveedor"/>
            <jsp:param name="opcionimagen" value="<%= ruta%>"/>
        </jsp:include>    
        
        
        <h1 style="text-align-last: center">LISTADO DE PROVEEDORES</h1>
        <h6> <a href="ProveedorControlador?action=nuevo"> NUEVO </a> </h6>
      
        <table class="table" border="6" >
        
            <thead class="table-dark">
                <th>ID</th>
                <th>NOMBRE</th>
                <th>CI</th>
                <th>CORREO</th>
                <th>TELEFONO</th>

                <th>EDITAR</th>
                <th>ELIMINAR</th>
            </thead>
       <c:forEach var="item" items="${lista}">
            <tbody>
              
                 <tr>
                <th>${item.id}</th>
                <th>${item.nombre}</th>
                <th>${item.ci}</th>
                <th>${item.correo}</th>
                <th>${item.telefono}</th>

                <th> <a href="ProveedorControlador?action=editar&id=${item.id}"> EDITAR </a> </th>
                <th> <a href="ProveedorControlador?action=eliminar&id=${item.id}
                           " onclick="return(confirm('estas seguro de eliminar?'))">ELIMINAR</a></th> 
                 
                </tr>
               
            </tbody>
           </c:forEach> 
        </table>
        
        
        
        
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    </body>
</html>