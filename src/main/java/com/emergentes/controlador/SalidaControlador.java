
package com.emergentes.controlador;

import com.emergentes.DAO.ClienteDAO;
import com.emergentes.DAO.ClienteDAOimple;
import com.emergentes.DAO.SalidaDAOimple;
import com.emergentes.DAO.ProductoDAO;
import com.emergentes.DAO.ProductoDAOimple;
import com.emergentes.DAO.SalidaDAO;
import com.emergentes.modelo.Cliente;
import com.emergentes.modelo.Producto;
import com.emergentes.modelo.Salida;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SalidaControlador", urlPatterns = {"/SalidaControlador"})
public class SalidaControlador extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
                try{    
            Salida sali = new Salida();
            SalidaDAO dao = new SalidaDAOimple();
            
            ProductoDAO daoproducto = new ProductoDAOimple();
            List<Producto> lista_productos = null;
            
            ClienteDAO daocliente = new ClienteDAOimple();
            List<Cliente> lista_de_clientes = null;
            
            
            int id=0;
            String action = (request.getParameter("action") != null) 
                            ? request.getParameter("action"):"listar";
                   switch(action)
                   {
                           case "nuevo":
                               lista_productos = daoproducto.getAll();
                               lista_de_clientes = daocliente.getAll();
                               
                               request.setAttribute("formu",sali );
                               request.setAttribute("formu2", lista_productos);
                               request.setAttribute("formu3", lista_de_clientes);
                               
                               request.getRequestDispatcher("ForSalida.jsp").forward(request, response);
                               
                           break;
                           case "editar":
                               
                                id = Integer.parseInt(request.getParameter("id"));
                                sali = dao.getById(id);
                               
                               
                               
                                lista_productos = daoproducto.getAll();
                               lista_de_clientes = daocliente.getAll();
                               request.setAttribute("formu",sali );
                               request.setAttribute("formu2", lista_productos);
                               request.setAttribute("formu3", lista_de_clientes);
                               
                               request.getRequestDispatcher("ForSalida.jsp").forward(request, response);
                           break;
                           case "eliminar":
                               id = Integer.parseInt(request.getParameter("id"));
                               dao.delete(id);
                               response.sendRedirect("SalidaControlador?action=listar");
                           break;
                           case "listar":
                           List<Salida> lista = dao.getAll();
                           request.setAttribute("lista",lista);
                           request.getRequestDispatcher("salidas.jsp").forward(request, response);
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
                int id_clien = Integer.parseInt(request.getParameter("id_cliente"));
                String  fecha = request.getParameter("fecha");
       
                Salida sali = new Salida();
                sali.setId(id);
                sali.setCantidad(cantidad);
                sali.setFecha(fecha);
                sali.setId_producto(id_prod);
                sali.setId_cliente(id_clien);
         
                SalidaDAO dao = new SalidaDAOimple();
                if(id ==0)
                {
                   
                  
                    try {
                        //nuevo registro

                        dao.insert(sali);
                    } catch (Exception ex) {
                        Logger.getLogger(SalidaControlador.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                      
                    
                }    
                else
                {
              
                    try {
                        //editar
                        dao.update(sali);
                    } catch (Exception ex) {
                        java.util.logging.Logger.getLogger(AlmacenControlador.class.getName()).log(Level.SEVERE, null, ex);
                    }
                   
                }
                response.sendRedirect("SalidaControlador");
    }

}
