
package com.emergentes.DAO;

import com.emergentes.modelo.Salida;
import com.emergentes.utiles.ConexionBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SalidaDAOimple extends ConexionBD implements SalidaDAO
{

    @Override
    public void insert(Salida sali) throws Exception 
    {
        try {
            this.conectar();
            String sql;
            
            sql = "insert into salida (cantidad, fecha, id_producto, id_cliente) Values (?,?,?,?)";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, sali.getCantidad());
            ps.setString(2, sali.getFecha());
            ps.setInt(3, sali.getId_producto());
            ps.setInt(4, sali.getId_cliente());
            ps.executeUpdate();
            DAOStock stock = new DAOStock(sali.getId_producto());
            stock.modificar_stock();

        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void update(Salida sali) throws Exception 
    {
            try {
            this.conectar();
            String sql;
            sql = "Update salida Set cantidad = ?, fecha= ?, id_producto = ?, id_cliente = ? where id = ?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, sali.getCantidad());
            ps.setString(2, sali.getFecha());
            ps.setInt(3, sali.getId_producto());
            ps.setInt(4, sali.getId_cliente());
            ps.setInt(5, sali.getId());
            ps.executeUpdate();
            
            DAOStock stock = new DAOStock(sali.getId_producto());
            stock.modificar_stock();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void delete(int id) throws Exception {
      try {
            this.conectar();
            String sql, sql2;
            int id_prod=0;
            
            sql = "delete from salida where id = ?";
            sql2 = "select id_producto from salida where id =?";
            PreparedStatement ps2 = this.conn.prepareStatement(sql2);
            ps2.setInt(1, id);
            
              ResultSet rs = ps2.executeQuery();
            if(rs.next())
                {
                    id_prod = rs.getInt("id_producto");
                }

            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();

            DAOStock stock = new DAOStock(id_prod);
            stock.modificar_stock();
 
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public Salida getById(int id) throws Exception {
        Salida sali = new Salida();  
        try {
                this.conectar();
                String sql;
                sql = "select * from salida where id = ?";

                PreparedStatement ps = this.conn.prepareStatement(sql);
                ps.setInt(1,id);
                ResultSet rs = ps.executeQuery();
                if(rs.next())
                {
                    sali.setId(rs.getInt("id"));
                    sali.setCantidad(rs.getInt("cantidad"));
                    sali.setFecha(rs.getString("fecha"));
                    sali.setId_producto(rs.getInt("id_producto"));
                    sali.setId_cliente(rs.getInt("id_cliente"));
                    
                }    
        } catch (Exception e) 
        {
           throw e;
        }finally
        {this.desconectar();}
        return sali;
    }

    @Override
    public List<Salida> getAll() throws Exception 
    {
            List <Salida> lista = null; 
        try 
        {
                this.conectar();
                String sql;
                sql = 
            "select e.id as id, e.cantidad as cantidad, e.id_producto as id_producto, \n" +
            "e.id_cliente as id_cliente, e.fecha as fecha, p.nombre_producto as nombre_pro,\n" +
            "o.nombre as nombre_cliente\n" +
            "from salida as e, productos as p, cliente as o\n" +
            "where \n" +
            "e.id_producto = p.id and\n" +
            "e.id_cliente = o.id\n" +
            "ORDER BY e.id asc";
                PreparedStatement ps = this.conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                lista = new ArrayList<>();
                while( rs.next())
                {    
                    Salida sali = new Salida();
                    
                    sali.setId(rs.getInt("id"));
                    sali.setCantidad(rs.getInt("cantidad"));
                    sali.setId_cliente(rs.getInt("id_cliente"));
                    sali.setId_producto(rs.getInt("id_producto"));
                    sali.setFecha(rs.getString("fecha"));
                    sali.setNom_producto(rs.getString("nombre_pro"));
                    sali.setNom_cliente(rs.getString("nombre_cliente"));

                  lista.add(sali);  
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
