package com.emergentes.controlador;
import com.emergentes.DAO.AlmacenDAO;
import com.emergentes.DAO.AlmacenDAOimple;
import com.emergentes.DAO.ProductoDAO;
import com.emergentes.DAO.ProductoDAOimple;
import com.emergentes.modelo.Almacen;
import com.emergentes.modelo.Producto;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.System.Logger;
import java.util.List;
import java.util.logging.Level;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "AlmacenControlador", urlPatterns = {"/AlmacenControlador"})
public class AlmacenControlador extends HttpServlet 
{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        try{    
            Almacen alma = new Almacen();
            AlmacenDAO dao = new AlmacenDAOimple();
            
            ProductoDAO daoproducto = new ProductoDAOimple();
            List<Producto> lista_productos = null;
            
            int id=0;
            String action = (request.getParameter("action") != null) 
                            ? request.getParameter("action"):"listar";
                   switch(action)
                   {
                           case "nuevo":
                               lista_productos = daoproducto.getAll();
                               request.setAttribute("formu",alma );
                               request.setAttribute("formu2", lista_productos);
                               request.getRequestDispatcher("Foralmacen.jsp").forward(request, response);
                           break;
                           case "editar":
                               
                               id = Integer.parseInt(request.getParameter("id"));
                               alma = dao.getById(id);
                               request.setAttribute("formu",alma );
                               
                               lista_productos = daoproducto.getAll();
                               request.setAttribute("formu2", lista_productos);
                               
                               request.getRequestDispatcher("Foralmacen.jsp").forward(request, response);
                           break;
                           case "eliminar":
                               id = Integer.parseInt(request.getParameter("id"));
                               dao.delete(id);
                               response.sendRedirect("AlmacenControlador");
                           break;
                           case "listar":
                           List<Almacen> lista = dao.getAll();
                           request.setAttribute("lista",lista);
                           request.getRequestDispatcher("almacen.jsp").forward(request, response);
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
                String  descripcion = request.getParameter("descripcion");
                String  coordenada = request.getParameter("coordenada");
                int  id_Productos = Integer.parseInt(request.getParameter("id_productos"));
                Almacen alma = new Almacen();
                alma.setId(id);
                alma.setDescaripcion(descripcion);
                alma.setCoordenadas(coordenada);
                alma.setId_producto(id_Productos);
       
                AlmacenDAO dao = new AlmacenDAOimple();
                if(id ==0)
                {
                   
                    try {
                        //nuevo registro

                        dao.insert(alma);
                    } catch (Exception ex) {
                        java.util.logging.Logger.getLogger(AlmacenControlador.class.getName()).log(Level.SEVERE, null, ex);
                    }
                      
                    
                }    
                else
                {
              
                    try {
                        //editar
                        dao.update(alma);
                    } catch (Exception ex) {
                        java.util.logging.Logger.getLogger(AlmacenControlador.class.getName()).log(Level.SEVERE, null, ex);
                    }
                   
                }
                response.sendRedirect("AlmacenControlador");
                
    }

}
