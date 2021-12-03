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
    String ruta = "https://www.liderdelemprendimiento.com/wp-content/uploads/2019/10/Qu%C3%A9-son-los-proveedores-y-cu%C3%A1les-son-sus-tipos-2848x3000.png";
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
            <jsp:param name="opcion" value="proveedor"/>
            <jsp:param name="opcionimagen" value="<%= ruta%>"/>
        </jsp:include>    


        <h1 style="text-align-last: center"> NUEVOS PROVEEDORES </h1>
 
        <form  style="padding:  50px ; background-color: darkgrey;" method="post" action="ProveedorControlador" >
            
            <input type="hidden" class="form-control"  name="id" value="${formu.id}">
            <div class="mb-3">
                <label  class="form-label">NOMBRE</label>
                <input type="text" class="form-control"  name="nombre" value="${formu.nombre}">
            </div>
            <div class="mb-3">
                <label  class="form-label">CARNET DE IDENTIDAD</label>
                <input type="text" class="form-control"  name="ci" value="${formu.ci}">
               
            </div>
            <div class="mb-3">
                <label class="form-label">CORREO ELECTRONICO</label>
                <input type="email" class="form-control"  name="correo" value="${formu.correo}">
               
            </div>
            <div class="mb-3">
                <label  class="form-label">TELEFONO O CELULAR</label>
                <input type="text" class="form-control"  name="telefono"value="${formu.telefono}">
               
            </div>
            
            <button type="submit" class="btn btn-primary">ENVIAR REGITRO</button>
        </form>
           

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    </body>
</html>