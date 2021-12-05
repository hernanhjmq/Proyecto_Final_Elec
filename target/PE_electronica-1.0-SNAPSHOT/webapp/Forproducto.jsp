<%
    if(session.getAttribute("login")!="OK")
    {
        response.sendRedirect("login.jsp");
    }
%>
<%@page import="com.emergentes.modelo.Cliente"%>
<%@page import="java.util.List"%>
<%@page import="com.emergentes.DAO.ClienteDAO"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!doctype html>
<%
    List<Cliente> cliente = (List<Cliente>) request.getAttribute("Formu");
%>
<%
    String ruta = "https://www.jmsemiconductores.com/sites/default/files/inline-images/categoria-componentes-electronicos.png";
%>

<html lang="en">
    <head>

        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

        <title>SISTEMA DE TIENDA ELECTRONICO</title>

    </head>
    <body>
        <jsp:include page="WEB-INF/menu2.jsp">
            <jsp:param name="opcion" value="productos"/>
            <jsp:param name="opcionimagen" value="<%= ruta%>"/>
        </jsp:include>    


        <h1 style="text-align-last: center"> NUEVOS PRODUCTOS </h1>
 
        <form  style="padding:  50px ; background-color: darkgrey;" method="post" action="ProductoControlador" >
            
            <input type="hidden" class="form-control"  name="id" value="${formu.id}">
            <div class="mb-3">
                <label  class="form-label">NOMBRE DEL PRODUCTO </label>
                <input type="text" class="form-control"  name="nombre" value="${formu.nombre}">
            </div>
            <div class="mb-3">
                <label  class="form-label">DESCRIPCION DEL PRODUCTO</label>
                <input type="text" class="form-control"  name="descripcion" value="${formu.descripcion}">
               
            </div>
            <div class="mb-3">
                <label class="form-label">CANTIDAD INICIAL DE PRODUCTOS EN ALMACEN</label>
                <input type="number" class="form-control"  name="cantidad_inicial" value="${formu.entrada_inicial}">
            </div>
            
            <div class="mb-3">
                <label  class="form-label">PRECIO</label>
                <input type="number" class="form-control"  name="precio"value="${formu.precio}">  
            </div>
            
            <button type="submit" class="btn btn-primary">ENVIAR REGITRO</button>
        </form>
           

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    </body>
</html>