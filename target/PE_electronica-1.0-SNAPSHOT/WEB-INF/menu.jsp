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

                    <ul class="nav col-12 col-lg-auto me-lg-auto mb-3 justify-content-center mb-md-4">
                        <img class="mb-2" src="https://www.upea.bo/assets/img_escudos/escudos/esc_1604365698.png" alt="500PX" width="80" height="70">
                        <li><a href="index.jsp" class="nav-link px-2 text-white <%= (opcion.equals("inicio") ? "active" : "") %> ">Home</a></li>
                        <li><a href="AlmacenControlador" class="nav-link <%= (opcion.equals("almacen") ? "active" : "") %>">ALMACEN</a></li>
                        <li><a href="ProductoControlador" class="nav-link <%= (opcion.equals("productos") ? "active" : "") %>">PRODUCTOS</a></li>
                        <li><a href="ClienteControlador?op=listar" class="nav-link <%= (opcion.equals("clientes") ? "active" : "") %>">CLIENTES</a></li>
                        <li><a href="ProveedorControlador?op=listar" class="nav-link <%= (opcion.equals("proveedor") ? "active" : "") %>">PROVEEDORES</a></li>
                        <li><a href="EntradaControlador?action=listar" class="nav-link <%= (opcion.equals("entrada") ? "active" : "") %>">ADICIONAR STOCK DE PRODUCTOS</a></li>
                        <li><a href="SalidaControlador" class="nav-link <%= (opcion.equals("salida") ? "active" : "") %>">VENDER STOCK DE PRODUCTOS</a></li>
                    </ul>
                </div>
            </div>
        </header>