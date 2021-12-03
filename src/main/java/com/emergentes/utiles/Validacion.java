
package com.emergentes.utiles;

import com.mysql.cj.protocol.Resultset;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Validacion extends ConexionBD
{
    Connection con = this.conectar();
    PreparedStatement pr;
    public boolean CheckUser (String email, String password)
    {
        boolean resultado = false;
        try {
            String sql = "select * from usuarios where correo = ? and contraseña = ?";
            pr = con.prepareStatement(sql);
            pr.setString(1, email);
            pr.setString(2, password);
            ResultSet rs = pr.executeQuery();
            resultado = rs.next();

        } catch (SQLException ex) {
            Logger.getLogger(Validacion.class.getName()).log(Level.SEVERE, null, ex);
        }
      return resultado;
    }
    public String Privilegio (String email, String password)
    {
        String resultado = "";
        try {
            String sql = "select * from usuarios where correo = ? and contraseña = ? ";
            pr = con.prepareStatement(sql);
            pr.setString(1, email);
            pr.setString(2, password);
            ResultSet rs = pr.executeQuery();
            if(rs.next())
                {
                    resultado = rs.getString("privilegio");
                }
        } catch (SQLException ex) {
            Logger.getLogger(Validacion.class.getName()).log(Level.SEVERE, null, ex);
        }
      return resultado;
    }
    
}
