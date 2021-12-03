package com.emergentes.controlador;

import com.emergentes.DAO.ClienteDAO;
import com.emergentes.DAO.ClienteDAOimple;
import com.emergentes.modelo.Cliente;
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

@WebServlet(name = "ClienteControlador", urlPatterns = {"/ClienteControlador"})
public class ClienteControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Cliente cli = new Cliente();
            ClienteDAO dao = new ClienteDAOimple();
            int id=0;
            String action = (request.getParameter("action") != null) 
                            ? request.getParameter("action"):"listar";
                   switch(action)
                   {
                           case "nuevo":
                               request.setAttribute("formu",cli );
                               request.getRequestDispatcher("Forcliente.jsp").forward(request, response);
                           break;
                           case "editar":
                               id = Integer.parseInt(request.getParameter("id"));
                               cli = dao.getById(id);
                               request.setAttribute("formu",cli );
                               request.getRequestDispatcher("Forcliente.jsp").forward(request, response);
                           break;
                           case "eliminar":
                               id = Integer.parseInt(request.getParameter("id"));
                               dao.delete(id);
                               response.sendRedirect("ClienteControlador");
                           break;
                           case "listar":
                           List<Cliente> lista = dao.getAll();
                           request.setAttribute("lista",lista);
                           request.getRequestDispatcher("clientes.jsp").forward(request, response);
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
                Cliente cli = new Cliente();
                cli.setId(id);
                cli.setNombre(nombre);
                cli.setCi(ci);
                cli.setCorreo(correo);
                cli.setTelefono(telefono);
                ClienteDAO dao = new ClienteDAOimple();
                if(id ==0)
                {
                    try {
                        //nuevo registro

                        dao.insert(cli);
                    } catch (Exception ex) {
                        Logger.getLogger(ClienteControlador.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }    
                else
                {
                    try {
                        //editar
                        dao.update(cli);
                    } catch (Exception ex) {
                        Logger.getLogger(ClienteControlador.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                response.sendRedirect("ClienteControlador");
                
                
                

    }

}
