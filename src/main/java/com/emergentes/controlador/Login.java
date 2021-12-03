
package com.emergentes.controlador;

import com.emergentes.utiles.Validacion;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
                    response.sendRedirect("login.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        Validacion v = new Validacion();
        String rol="";
        if(v.CheckUser(email, password))
        {

            HttpSession ses = request.getSession();
            ses.setAttribute("login","OK");
            rol = v.Privilegio(email, password);

            if(rol.equals("usuario") )
            {    
            
            response.sendRedirect("MainControl");
            }
            else
            {
                response.sendRedirect("AdmiControlador");
            }    
        }
        else
        {
            System.out.println("todod incorrecto");
            response.sendRedirect("login.jsp");
        }
        
    }


}
