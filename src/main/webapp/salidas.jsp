<%
    if(session.getAttribute("login")!="OK")
    {
        response.sendRedirect("login.jsp");
    }
%>
<%
    String ruta = "https://img2.freepng.es/20180407/gre/kisspng-sales-computer-icons-business-purchasing-marketing-sales-5ac8d759035928.6503979315231117690137.jpg";
%>
<%@page import="com.emergentes.modelo.Almacen"%>
<%@page import="com.emergentes.modelo.Cliente"%>
<%@page import="java.util.List"%>
<%@page import="com.emergentes.DAO.ClienteDAO"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

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
            <jsp:param name="opcion" value="salida"/>
            <jsp:param name="opcionimagen" value="<%= ruta%>"/>
        </jsp:include>    


        <h1 style="text-align-last: center"> LSITADO DE PRODUCTOS QUE SE VENDIERON </h1>

      
        <a href="SalidaControlador?action=nuevo" class="btn btn-primary btn-sm" style="margin-left: 50px; margin-bottom: 10px">
        <i class="fas fa-folder-plus"></i> NUEVO </a>
      
        <table class="table" border="6" >
        
            <thead class="table-dark">
              
                
                <th>ID</th>
                <th>CANTIDAD</th>
                <th>FECHA</th>
                <th>NOMBRE DEL PRODUCTO</th>
                <th>NOMBRE DEL CLIENTE</th>
                <th>EDITAR</th>
                <th>ELIMINAR</th>
            </thead>
       <c:forEach var="item" items="${lista}">
            <tbody>
              
                 <tr>
                <th>${item.id}</th>
                <th>${item.cantidad}</th>
                <th>${item.fecha}</th>
                <th>${item.nom_producto}</th>
                <th>${item.nom_cliente}</th>
       

                <th> <a href="SalidaControlador?action=editar&id=${item.id}"> <i class="fas fa-pen-alt"></i> </a> </th>
                <th> <a href="SalidaControlador?action=eliminar&id=${item.id}
                           " onclick="return(confirm('estas seguro de eliminar?'))"><i class="fas fa-trash-alt"></i></a></th> 
                 
                </tr>
               
            </tbody>
           </c:forEach> 
        </table>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    </body>
</html>