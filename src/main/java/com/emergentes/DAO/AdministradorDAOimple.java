
package com.emergentes.DAO;

import com.emergentes.modelo.Administrador;
import com.emergentes.utiles.ConexionBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AdministradorDAOimple extends ConexionBD implements AdministradorDAO
{

    @Override
    public void insert(Administrador admi) throws Exception {
         try {
            this.conectar();
            String sql;
            sql = "insert into usuarios (privilegio, contraseña, correo) Values (?,?,?)";
             System.out.println("----sssss  -- " + sql);
            PreparedStatement ps = this.conn.prepareStatement(sql);
 
            ps.setString(1, admi.getPrivilegio());
            ps.setString(2, admi.getContraseña());
            ps.setString(3, admi.getCorreo());
            ps.executeUpdate();
        } catch (Exception e) {
             System.out.println("error fatal al insertar --->>>> "+e); 
                  ;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void update(Administrador admi) throws Exception {
        try {
                this.conectar();
                String sql;
                sql = "Update usuarios Set privilegio = ?, contraseña= ?, correo = ? where id = ?";
                PreparedStatement ps = this.conn.prepareStatement(sql);
                ps.setString(1, admi.getPrivilegio());
                ps.setString(2, admi.getContraseña());
                ps.setString(3, admi.getCorreo());
                ps.setInt(4, admi.getId());
                ps.executeUpdate();
        } catch (Exception e) 
        {
           throw e;
        }finally
        {this.desconectar();}
    }

    @Override
    public void delete(int id) throws Exception {
        try {
                this.conectar();
                String sql;
                sql = "delete from usuarios where id = ?";
                PreparedStatement ps = this.conn.prepareStatement(sql);
                ps.setInt(1,id);
                ps.executeUpdate();
        } catch (Exception e) 
        {
           throw e;
        }finally
        {this.desconectar();}
    }

    @Override
    public Administrador getById(int id) throws Exception {
        Administrador admi = new Administrador();  
        try {
                this.conectar();
                String sql;
                sql = "select * from usuarios where id = ?";
                PreparedStatement ps = this.conn.prepareStatement(sql);
                ps.setInt(1,id);
                ResultSet rs = ps.executeQuery();
                if(rs.next())
                {
                    admi.setId(rs.getInt("id"));
                    admi.setPrivilegio(rs.getString("privilegio"));
                    admi.setContraseña(rs.getString("contraseña"));
                    admi.setCorreo(rs.getString("correo"));
                }    
               
        } catch (Exception e) 
        {
           throw e;
        }finally
        {this.desconectar();}
        return admi;
    }

    @Override
    public List<Administrador> getAll() throws Exception {
        List <Administrador> lista = null; 
        try 
        {
                this.conectar();
                String sql;
                sql = "select * from usuarios";
                PreparedStatement ps = this.conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                lista = new ArrayList<Administrador>();
                while( rs.next())
                {    
                    Administrador admi = new Administrador(); 
                    admi.setId(rs.getInt("id"));
                    admi.setPrivilegio(rs.getString("privilegio"));
                    admi.setContraseña(rs.getString("contraseña"));
                    admi.setCorreo(rs.getString("correo"));

                  lista.add(admi);  
                } 
                rs.close();
                ps.close();
        } catch (Exception e) 
        {
           throw e;
        }finally
        {this.desconectar();}
        return lista;
    }

   
    
}
