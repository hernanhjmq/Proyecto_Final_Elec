
package com.emergentes.controlador;

import com.emergentes.DAO.EntradaDAO;
import com.emergentes.DAO.EntradaDAOimple;
import com.emergentes.DAO.ProductoDAO;
import com.emergentes.DAO.ProductoDAOimple;
import com.emergentes.DAO.ProveDAOimple;
import com.emergentes.DAO.ProveedorDAO;
import com.emergentes.modelo.Almacen;
import com.emergentes.modelo.Entrada;
import com.emergentes.modelo.Producto;
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

@WebServlet(name = "EntradaControlador", urlPatterns = {"/EntradaControlador"})
public class EntradaControlador extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
                try{    
            Entrada entra = new Entrada();
            EntradaDAO dao = new EntradaDAOimple();
            
            ProductoDAO daoproducto = new ProductoDAOimple();
            List<Producto> lista_productos = null;
            
            ProveedorDAO daoproveedor = new ProveDAOimple();
            List<Proveedor> lista_proveedor = null;
            
            
            int id=0;
            String action = (request.getParameter("action") != null) 
                            ? request.getParameter("action"):"listar";
                   switch(action)
                   {
                           case "nuevo":
                               lista_productos = daoproducto.getAll();
                               lista_proveedor = daoproveedor.getAll();
                               
                               request.setAttribute("formu",entra );
                               request.setAttribute("formu2", lista_productos);
                               request.setAttribute("formu3", lista_proveedor);
                               
                               request.getRequestDispatcher("Forentrada.jsp").forward(request, response);
                               
                           break;
                           case "editar":
                               
                                id = Integer.parseInt(request.getParameter("id"));
                                entra = dao.getById(id);
                               
                               request.setAttribute("formu",entra );
                               
                               lista_proveedor = daoproveedor.getAll();
                               lista_productos = daoproducto.getAll();
                               request.setAttribute("formu2", lista_productos);
                               request.setAttribute("formu3", lista_proveedor);
                               
                               request.getRequestDispatcher("Forentrada.jsp").forward(request, response);
                           break;
                           case "eliminar":
                               id = Integer.parseInt(request.getParameter("id"));
                               dao.delete(id);
                               response.sendRedirect("EntradaControlador?action=listar");
                           break;
                           case "listar":
                           List<Entrada> lista = dao.getAll();
                           request.setAttribute("lista",lista);
                           request.getRequestDispatcher("entradas.jsp").forward(request, response);
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
                int cantidad = Integer.parseInt(request.getParameter("cantidad"));
                int id_prod = Integer.parseInt(request.getParameter("id_productos"));
                int id_prove = Integer.parseInt(request.getParameter("id_proveedor"));
                String  fecha = request.getParameter("fecha");
       
                Entrada entra = new Entrada();
                entra.setId(id);
                entra.setCantidad(cantidad);
                entra.setFecha(fecha);
                entra.setId_producto(id_prod);
                entra.setId_proveedor(id_prove);
         
                EntradaDAO dao = new EntradaDAOimple();
                if(id ==0)
                {
                   
                  
                    try {
                        //nuevo registro

                        dao.insert(entra);
                    } catch (Exception ex) {
                        Logger.getLogger(EntradaControlador.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                      
                    
                }    
                else
                {
              
                    try {
                        //editar
                        dao.update(entra);
                    } catch (Exception ex) {
                        java.util.logging.Logger.getLogger(AlmacenControlador.class.getName()).log(Level.SEVERE, null, ex);
                    }
                   
                }
                response.sendRedirect("EntradaControlador");
    }

}
