
package com.emergentes.DAO;

import com.emergentes.modelo.Almacen;
import com.emergentes.utiles.ConexionBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AlmacenDAOimple extends ConexionBD implements AlmacenDAO
{

    @Override
    public void insert(Almacen almacen) throws Exception 
    {
             try {
                this.conectar();
                String sql;
                sql = "Insert Into almacen (descripcion, coordenada, id_productos) Values (?,?,?)";
                PreparedStatement ps = this.conn.prepareStatement(sql);
                ps.setString(1, almacen.getDescaripcion());
                ps.setString(2, almacen.getCoordenadas());
                ps.setInt(3, almacen.getId_producto());
                ps.executeUpdate();
        } catch (Exception e) 
        {
         throw e;
        }finally
        {this.desconectar();}
    }

    @Override
    public void update(Almacen almacen) throws Exception {
            try {
                this.conectar();
                String sql;
                sql = "Update almacen Set descripcion = ?, coordenada= ?, id_productos = ? where id = ?";
                PreparedStatement ps = this.conn.prepareStatement(sql);
                ps.setString(1, almacen.getDescaripcion());
                ps.setString(2, almacen.getCoordenadas());
                ps.setInt(3, almacen.getId_producto());
                ps.setInt(4, almacen.getId());
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
                sql = "delete from almacen where id = ?";
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
    public Almacen getById(int id) throws Exception {
        Almacen alma = new Almacen();  
        try {
                this.conectar();
                String sql;
                sql = "select * from almacen where id = ?";
                PreparedStatement ps = this.conn.prepareStatement(sql);
                ps.setInt(1,id);
                ResultSet rs = ps.executeQuery();
                if(rs.next())
                {
                    alma.setId(rs.getInt("id"));
                    alma.setDescaripcion(rs.getString("descripcion"));
                    alma.setCoordenadas(rs.getString("coordenada"));
                    alma.setId_producto(rs.getInt("id_productos"));
                }    
               
        } catch (Exception e) 
        {
           throw e;
        }finally
        {this.desconectar();}
        return alma;
    }

    @Override
    public List<Almacen> getAll() throws Exception {
        List <Almacen> lista = null; 
        try 
        {
                this.conectar();
                String sql;
                sql = 
"select a.id as \"id\", a.descripcion as \"descripcion\", \n" +
"a.coordenada as \"coordenada\", p.nombre_producto as \"nombre producto\", \n" +
"a.id_productos as \"id producto\", p.descripcion as \"descripcion producto\"\n" +
"from   almacen as a ,  productos as p\n" +
"where a.id_productos = p.id ORDER BY a.id asc";
                PreparedStatement ps = this.conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                lista = new ArrayList<Almacen>();
                while( rs.next())
                {    
                    Almacen alma = new Almacen(); 
                    alma.setId(rs.getInt("id"));
                    alma.setDescaripcion(rs.getString("descripcion"));
                    alma.setCoordenadas(rs.getString("coordenada"));
                    alma.setNombrepro(rs.getString("nombre producto"));
                    alma.setDescripro(rs.getString("descripcion producto"));
                    
                  lista.add(alma);  
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
