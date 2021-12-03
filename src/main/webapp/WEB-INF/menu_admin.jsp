<%
    if(session.getAttribute("login")!="OK")
    {
        response.sendRedirect("login.jsp");
    }
%>
<%
    String opcion = request.getParameter("opcion");
%>
<div class="b-example-divider"></div>
        <header class="p-3 bg-dark text-white">
            <div class="container">
                <div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
                    <a href="" class="d-flex align-items-center mb-2 mb-lg-0 text-white text-decoration-none">
                        <svg class="bi me-2" width="40" height="32" role="img" aria-label="Bootstrap"><use xlink:href="#bootstrap"/></svg>
                    </a>

                    <ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
                        <li><a href="AdmiControlador" class="nav-link px-2 text-white <%= (opcion.equals("inicio") ? "active" : "") %> ">Home</a></li>
                        <li><a href="LoginOut" class="nav-link <%= (opcion.equals("...") ? "active" : "") %>">SALIR</a></li>
                    </ul>
                </div>
            </div>
        </header>