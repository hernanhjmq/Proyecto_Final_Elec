
package com.emergentes.controlador;

import com.emergentes.DAO.ProductoDAO;
import com.emergentes.DAO.ProductoDAOimple;
import com.emergentes.modelo.Cliente;
import com.emergentes.modelo.Producto;
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

@WebServlet(name = "ProductoControlador", urlPatterns = {"/ProductoControlador"})
public class ProductoControlador extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
            try {
            Producto prod = new Producto();
            ProductoDAO dao = new ProductoDAOimple();
            int id=0;
            String action = (request.getParameter("action") != null) 
                            ? request.getParameter("action"):"listar";
                   switch(action)
                   {
                           case "nuevo":
                               request.setAttribute("formu",prod );
                               request.getRequestDispatcher("Forproducto.jsp").forward(request, response);
                           break;
                           case "editar":
                               id = Integer.parseInt(request.getParameter("id"));
                               prod = dao.getById(id);
                               request.setAttribute("formu",prod );
                               request.getRequestDispatcher("Forproducto.jsp").forward(request, response);
                           break;
                           case "eliminar":
                               id = Integer.parseInt(request.getParameter("id"));
                               dao.delete(id);
                               response.sendRedirect("ProductoControlador");
                           break;
                           case "listar":
                           List<Producto> lista = dao.getAll();
                           request.setAttribute("lista",lista);
                           request.getRequestDispatcher("productos.jsp").forward(request, response);
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
                String  descripcion = request.getParameter("descripcion");
                int  cantidad_inicial = Integer.parseInt(request.getParameter("cantidad_inicial"));
                int  stock = Integer.parseInt(request.getParameter("cantidad_inicial"));
                int  precio = Integer.parseInt(request.getParameter("precio"));
                
                Producto prod = new Producto();
                prod.setId(id);
                prod.setNombre(nombre);
                prod.setDescripcion(descripcion);
                prod.setEntrada_inicial(cantidad_inicial);
                prod.setStock(stock);
                prod.setPrecio(precio);
                ProductoDAO dao = new ProductoDAOimple();
                
                if(id==0)
                {
                    try {
                        //nuevo registro
                        dao.insert(prod);
                    } catch (Exception ex) {
                        Logger.getLogger(ProductoControlador.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                }    
                else
                {
                
                    try {
                        //editar
                        dao.update(prod);
                    } catch (Exception ex) {
                        Logger.getLogger(ProductoControlador.class.getName()).log(Level.SEVERE, null, ex);
                    }
                   
                }
                response.sendRedirect("ProductoControlador");
    }


}
