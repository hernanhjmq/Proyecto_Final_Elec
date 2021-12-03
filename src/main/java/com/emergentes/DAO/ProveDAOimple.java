
package com.emergentes.DAO;

import com.emergentes.modelo.Cliente;
import com.emergentes.modelo.Proveedor;
import com.emergentes.utiles.ConexionBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProveDAOimple extends ConexionBD implements ProveedorDAO 
{

    @Override
    public void insert(Proveedor proveedor) throws Exception 
    {
        try {
                this.conectar();
                String sql;
                sql = "Insert Into proveedor (nombre, CI, correo,telefono) Values (?,?,?,?)";
                PreparedStatement ps = this.conn.prepareStatement(sql);
                ps.setString(1, proveedor.getNombre());
                ps.setString(2, proveedor.getCi());
                ps.setString(3, proveedor.getCorreo());
                ps.setString(4, proveedor.getTelefono());
                ps.executeUpdate();
        } catch (Exception e) 
        {
           throw e;
        }finally
        {this.desconectar();}
        
        
    }

    @Override
    public void update(Proveedor proveedor) throws Exception {
        try {
                this.conectar();
                String sql;
                sql = "Update proveedor Set nombre = ?, CI= ?, correo = ?, telefono = ? where id = ?";
                PreparedStatement ps = this.conn.prepareStatement(sql);
                ps.setString(1, proveedor.getNombre());
                ps.setString(2, proveedor.getCi());
                ps.setString(3, proveedor.getCorreo());
                ps.setString(4, proveedor.getTelefono());
                ps.setInt(5, proveedor.getId());
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
                sql = "delete from proveedor where id = ?";
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
    public Proveedor getById(int id) throws Exception {
       Proveedor prove = new Proveedor();  
        try {
                this.conectar();
                String sql;
                sql = "select * from proveedor where id = ?";
                PreparedStatement ps = this.conn.prepareStatement(sql);
                ps.setInt(1,id);
                ResultSet rs = ps.executeQuery();
                if(rs.next())
                {
                    prove.setId(rs.getInt("id"));
                    prove.setNombre(rs.getString("nombre"));
                    prove.setCi(rs.getString("ci"));
                    prove.setCorreo(rs.getString("correo"));
                    prove.setTelefono(rs.getString("telefono"));
                }    
               
        } catch (Exception e) 
        {
           throw e;
        }finally
        {this.desconectar();}
        return prove;
    }

    @Override
    public List<Proveedor> getAll() throws Exception {
         List <Proveedor> lista = null; 
        try 
        {
                this.conectar();
                String sql;
                sql = "select * from proveedor";
                PreparedStatement ps = this.conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                lista = new ArrayList<Proveedor>();
                while( rs.next())
                {    
                    Proveedor prove = new Proveedor(); 
                    prove.setId(rs.getInt("id"));
                    prove.setNombre(rs.getString("nombre"));
                    prove.setCi(rs.getString("Ci"));
                    prove.setCorreo(rs.getString("correo"));
                    prove.setTelefono(rs.getString("telefono"));
                    
                  lista.add(prove);  
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
