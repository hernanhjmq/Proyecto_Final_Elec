<%
    if(session.getAttribute("login")!="OK")
    {
        response.sendRedirect("login.jsp");
    }
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
    <head>

        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" rel="stylesheet">
        <title>SISTEMA DE TIENDA ELECTRONICO</title>
         <style >
           

              body {
                background: url(https://p4.wallpaperbetter.com/wallpaper/581/308/949/8k-iron-man-4k-wallpaper-preview.jpg)  ; 
                background-size: cover;
                background-repeat: no-repeat;
                margin: 0;
                height: 100vh;
              }
             
             .contenedor{
                 position: relative;
                 display: inline-block;
                 text-align: center;
             }
             .texto1{
                 
                 text-shadow: #555 2px 2px 3px;
                 text-align-last: center;
                 margin-top: 50px;
             }
             #tecol{
                 color: cadetblue;
                 text-align: center;
              }
          </style>
    </head>
    <body>
        <jsp:include page="WEB-INF/menu.jsp">
            <jsp:param name="opcion" value="inicio"/>
        </jsp:include>    
        
        
        <h1 style="text-align-last: center; background: orange; margin-bottom: 0px">SISTEMA DE GESTION EN UNA TIENDA ELECTRONICA</h1>
   

            <div class="texto1"><h1 id="tecol">BIENBENIDOS AL SISTEMA PROFESIONAL</h1></div>

        
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    </body>
</html>

