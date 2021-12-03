package com.emergentes.controlador;

import com.emergentes.DAO.ClienteDAO;
import com.emergentes.DAO.ClienteDAOimple;
import com.emergentes.DAO.ProveDAOimple;
import com.emergentes.DAO.ProveedorDAO;
import com.emergentes.modelo.Cliente;
import com.emergentes.modelo.Proveedor;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ProveedorControlador", urlPatterns = {"/ProveedorControlador"})
public class ProveedorControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Proveedor prove = new Proveedor();
            ProveedorDAO dao = new ProveDAOimple();
            int id=0;
            String action = (request.getParameter("action") != null) 
                            ? request.getParameter("action"):"listar";
                   switch(action)
                   {
                           case "nuevo":
                               request.setAttribute("formu",prove );
                               request.getRequestDispatcher("Forproveedor.jsp").forward(request, response);
                           break;
                           case "editar":
                               id = Integer.parseInt(request.getParameter("id"));
                               prove = dao.getById(id);
                               request.setAttribute("formu",prove);
                               request.getRequestDispatcher("Forproveedor.jsp").forward(request, response);
                           break;
                           case "eliminar":
                               id = Integer.parseInt(request.getParameter("id"));
                               dao.delete(id);
                               response.sendRedirect("ProveedorControlador");
                           break;
                           case "listar":
                           List<Proveedor> lista = dao.getAll();
                           request.setAttribute("lista",lista);
                           request.getRequestDispatcher("proveedores.jsp").forward(request, response);
                           break;
                           default:break;
                   }    
                    
                    
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
                int id = Integer.parseInt(request.getParameter("id"));
                String  nombre = request.getParameter("nombre");
                String  ci = request.getParameter("ci");
                String  correo = request.getParameter("correo");
                String  telefono = request.getParameter("telefono");
                Proveedor prov = new Proveedor();
                prov.setId(id);
                prov.setNombre(nombre);
                prov.setCi(ci);
                prov.setCorreo(correo);
                prov.setTelefono(telefono);
                ProveedorDAO dao = new ProveDAOimple();
                if(id ==0)
                {
                    try {
                        //nuevo registro
                        dao.insert(prov);
                    } catch (Exception ex) {
                        Logger.getLogger(ProveedorControlador.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }    
                else
                {
                    try {
                        //editar
                        dao.update(prov);
                    } catch (Exception ex) {
                        Logger.getLogger(ProveedorControlador.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                response.sendRedirect("ProveedorControlador");
                
                
                

    }

}
