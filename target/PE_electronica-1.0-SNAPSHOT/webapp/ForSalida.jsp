<%
    if(session.getAttribute("login")!="OK")
    {
        response.sendRedirect("login.jsp");
    }
%>

<%@page import="com.emergentes.modelo.Producto"%>
<%@page import="com.emergentes.modelo.Almacen"%>
<%@page import="java.util.List"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String ruta = "https://img2.freepng.es/20180407/gre/kisspng-sales-computer-icons-business-purchasing-marketing-sales-5ac8d759035928.6503979315231117690137.jpg";
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
            <jsp:param name="opcion" value="almacen"/>
            <jsp:param name="opcionimagen" value="<%= ruta%>"/>
        </jsp:include>    


        <h1 style="text-align-last: center"> NUEVOS REGISTROS PARA LAS VENTAS DE PRODDUCTOS </h1>
 
        <form  style="padding:  50px ; background-color: darkgrey;" method="post" action="SalidaControlador" >
            
            <input type="hidden" class="form-control"  name="id" value="${formu.id}">
            <div class="mb-3">
                <label  class="form-label">CANTIDAD </label>
                <input type="number" class="form-control"  name="cantidad" value="${formu.cantidad}">
            </div>
            <div class="mb-3">
                <label  class="form-label">FECHA</label>
                <input type="date" class="form-control"  name="fecha" value="${formu.fecha}">
            </div>
            
          <div class="mb-3">
                <label class="form-label">PRODUCTOS</label>
                
                <select name="id_productos" class="form-control">
                    <option value="">--seleccione--</option>
                    <c:forEach var="item" items="${formu2}">
                        <option value="${item.id}" <c:if test="${formu.id_producto == item.id}">
                                    selected
                                </c:if>>
                            ${item.nombre}
                        </option>
                    </c:forEach>
                </select>
            </div>
            
            <div class="mb-3">
                <label class="form-label">CLIENTE</label>
                
                <select name="id_cliente" class="form-control">
                    <option value="">--seleccione--</option>
                    <c:forEach var="item" items="${formu3}">
                        <option value="${item.id}" <c:if test="${formu.id_cliente == item.id}">
                                    selected
                                </c:if>>
                            ${item.nombre}
                        </option>
                    </c:forEach>
                </select>
            </div>

 
            
            
            
            <button type="submit" class="btn btn-primary">ENVIAR REGITRO</button>
        </form>
           

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    </body>
</html>