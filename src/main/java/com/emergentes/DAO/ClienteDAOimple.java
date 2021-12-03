
package com.emergentes.DAO;

import com.emergentes.modelo.Cliente;
import com.emergentes.utiles.ConexionBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAOimple extends ConexionBD implements ClienteDAO
{

    @Override
    public void insert(Cliente cli) throws Exception 
    {
        try {
                this.conectar();
                String sql;
                sql = "Insert Into cliente (nombre, CI, correo,telefono) Values (?,?,?,?)";
                PreparedStatement ps = this.conn.prepareStatement(sql);
                ps.setString(1, cli.getNombre());
                ps.setString(2, cli.getCi());
                ps.setString(3, cli.getCorreo());
                ps.setString(4, cli.getTelefono());
                ps.executeUpdate();
        } catch (Exception e) 
        {
           throw e;
        }finally
        {this.desconectar();}
        
      
    }

    @Override
    public void update(Cliente cli) throws Exception 
    {
         try {
                this.conectar();
                String sql;
                sql = "Update cliente Set nombre = ?, CI= ?, correo = ?, telefono = ? where id = ?";
                PreparedStatement ps = this.conn.prepareStatement(sql);
                ps.setString(1, cli.getNombre());
                ps.setString(2, cli.getCi());
                ps.setString(3, cli.getCorreo());
                ps.setString(4, cli.getTelefono());
                ps.setInt(5, cli.getId());
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
                sql = "delete from cliente where id = ?";
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
    public Cliente getById(int id) throws Exception {
        Cliente clien = new Cliente();  
        try {
                this.conectar();
                String sql;
                sql = "select * from cliente where id = ?";
                PreparedStatement ps = this.conn.prepareStatement(sql);
                ps.setInt(1,id);
                ResultSet rs = ps.executeQuery();
                if(rs.next())
                {
                    clien.setId(rs.getInt("id"));
                    clien.setNombre(rs.getString("nombre"));
                    clien.setCi(rs.getString("ci"));
                    clien.setCorreo(rs.getString("correo"));
                    clien.setTelefono(rs.getString("telefono"));
                }    
               
        } catch (Exception e) 
        {
           throw e;
        }finally
        {this.desconectar();}
        return clien;
    }

    @Override
    public List<Cliente> getAll() throws Exception {
        List <Cliente> lista = null; 
        try 
        {
                this.conectar();
                String sql;
                sql = "select * from cliente";
                PreparedStatement ps = this.conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                lista = new ArrayList<Cliente>();
                while( rs.next())
                {    
                    Cliente clien = new Cliente(); 
                    clien.setId(rs.getInt("id"));
                    clien.setNombre(rs.getString("nombre"));
                    clien.setCi(rs.getString("Ci"));
                    clien.setCorreo(rs.getString("correo"));
                    clien.setTelefono(rs.getString("telefono"));
                    
                  lista.add(clien);  
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
