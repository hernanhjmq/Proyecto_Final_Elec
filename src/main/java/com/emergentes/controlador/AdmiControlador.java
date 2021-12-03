
package com.emergentes.controlador;
import com.emergentes.DAO.AdministradorDAO;
import com.emergentes.DAO.AdministradorDAOimple;
import com.emergentes.modelo.Administrador;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "AdmiControlador", urlPatterns = {"/AdmiControlador"})
public class AdmiControlador extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
             try{    
            Administrador admi = new Administrador();
            AdministradorDAO dao = new AdministradorDAOimple();
            int id=0;
            String action = (request.getParameter("action") != null) 
                            ? request.getParameter("action"):"listar";
                   switch(action)
                   {
                           case "nuevo":
                               request.setAttribute("formu",admi );
                               request.getRequestDispatcher("ForUsuarios.jsp").forward(request, response);
                           break;
                           case "editar":
                               
                               id = Integer.parseInt(request.getParameter("id"));
                               admi = dao.getById(id);
                               request.setAttribute("formu",admi );
                               request.getRequestDispatcher("ForUsuarios.jsp").forward(request, response);
                           break;
                           case "eliminar":
                               id = Integer.parseInt(request.getParameter("id"));
                               dao.delete(id);
                               response.sendRedirect("AdmiControlador?action=listar");
                           break;
                           case "listar":
                           List<Administrador> lista = dao.getAll();
                           request.setAttribute("lista",lista);
                           request.getRequestDispatcher("administrador.jsp").forward(request, response);
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
                String  privilegio = request.getParameter("privilegio");
                String  constraseña = request.getParameter("password");
                String  correo = request.getParameter("correo");
                
                Administrador admi = new Administrador();
                admi.setId(id);
                admi.setPrivilegio(privilegio);
                admi.setContraseña(constraseña);
                admi.setCorreo(correo);

                AdministradorDAO dao = new AdministradorDAOimple();
                if(id == 0)
                {
               
                    try {
                        //nuevo registro
                        dao.insert(admi);
                    } catch (Exception ex) {
                        Logger.getLogger(AdmiControlador.class.getName()).log(Level.SEVERE, null, ex);
                    }
                 
                }    
                else
                {
                    
                    try {
                        //editar
                        dao.update(admi);
                    } catch (Exception ex) {
                        Logger.getLogger(AdmiControlador.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                response.sendRedirect("AdmiControlador");
                
    }



}
