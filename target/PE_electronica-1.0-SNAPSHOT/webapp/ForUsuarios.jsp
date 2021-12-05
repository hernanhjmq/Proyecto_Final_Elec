<%
    if(session.getAttribute("login")!="OK")
    {
        response.sendRedirect("login.jsp");
    }
     String ruta = "https://3.bp.blogspot.com/-EsN2VxytQX0/UNS4iWHTl-I/AAAAAAAAMPw/PxpYiIYQ2-Y/s1600/iconos_usuario5.jpg";
%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.emergentes.modelo.Administrador"%>
<%@page import="java.util.List"%>
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
        <jsp:include page="WEB-INF/menu_admin.jsp">
            <jsp:param name="opcion" value="inicio"/>
            <jsp:param name="opcionimagen" value="<%= ruta%>"/>
        </jsp:include>    


        <h1 style="text-align-last: center"> NUEVOS REGISTROS PARA LOS USUARIOS </h1>
 
        <form  style="padding:  50px ; background-color: darkgrey;" method="post" action="AdmiControlador" >
            
            <input type="hidden" class="form-control"  name="id" value="${formu.id}">
            
            <div class="mb-3">
                <label  class="form-label">PRIVILEGIO </label>
              
                <select name="privilegio" class="form-control">
                    
                        <option value="${formu.privilegio}">${formu.privilegio}</option>   
                        <option value="usuario" >usuario</option>
                         <option value="administrador" >administrador</option>
                </select>   
            </div>
            
            <div class="mb-3">
                <label  class="form-label">CONTRASEÑA </label>
                <input type="text" class="form-control"  name="password" value="${formu.contraseña}">
            </div>
            <div class="mb-3">
                <label class="form-label">CORREO ELECTRONICO</label>
                <input type="email" class="form-control"  name="correo" value="${formu.correo}">
               
            </div>
            <button type="submit" class="btn btn-primary">ENVIAR REGITRO</button>
        </form>
           

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    </body>
</html>