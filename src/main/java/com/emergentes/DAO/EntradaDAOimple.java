
package com.emergentes.DAO;

import com.emergentes.modelo.Entrada;
import com.emergentes.utiles.ConexionBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EntradaDAOimple extends ConexionBD implements EntradaDAO
{

    @Override
    public void insert(Entrada entrada) throws Exception 
    {
       try {
            this.conectar();
            String sql;
            
            sql = "insert into entrada (cantidad, id_proveedor, id_productos, fecha) Values (?,?,?,?)";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, entrada.getCantidad());
            ps.setInt(2, entrada.getId_proveedor());
            ps.setInt(3, entrada.getId_producto());
            ps.setString(4, entrada.getFecha());
            ps.executeUpdate();
            DAOStock stock = new DAOStock(entrada.getId_producto());
            stock.modificar_stock();

        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }
    
    

    @Override
    public void update(Entrada entrada) throws Exception {
             try {
            this.conectar();
            String sql;
            sql = "Update entrada Set cantidad = ?, id_proveedor= ?, id_productos = ?, fecha = ? where id = ?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, entrada.getCantidad());
            ps.setInt(2, entrada.getId_proveedor());
            ps.setInt(3, entrada.getId_producto());
            ps.setString(4, entrada.getFecha());
            ps.setInt(5, entrada.getId());
            ps.executeUpdate();
            
            DAOStock stock = new DAOStock(entrada.getId_producto());
            stock.modificar_stock();
            
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void delete(int id) throws Exception 
    {
       try {
            this.conectar();
            String sql, sql2;
            int id_prod=0;
            
            sql = "delete from entrada where id = ?";
            sql2 = "select id_productos from entrada where id =?";
            PreparedStatement ps2 = this.conn.prepareStatement(sql2);
            ps2.setInt(1, id);
            
              ResultSet rs = ps2.executeQuery();
            if(rs.next())
                {
                    id_prod = rs.getInt("id_productos");
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
    public Entrada getById(int id) throws Exception {
        Entrada entra = new Entrada();  
        try {
                this.conectar();
                String sql;
                sql = "select * from entrada where id = ?";

                PreparedStatement ps = this.conn.prepareStatement(sql);
                ps.setInt(1,id);
                ResultSet rs = ps.executeQuery();
                if(rs.next())
                {
                    entra.setId(rs.getInt("id"));
                    entra.setCantidad(rs.getInt("cantidad"));
                    entra.setId_proveedor(rs.getInt("id_proveedor"));
                    entra.setId_producto(rs.getInt("id_productos"));
                    entra.setFecha(rs.getString("fecha"));
                }    
        } catch (Exception e) 
        {
           throw e;
        }finally
        {this.desconectar();}
        return entra;
    }

    @Override
    public List<Entrada> getAll() throws Exception 
    {
            List <Entrada> lista = null; 
        try 
        {
                this.conectar();
                String sql;
                sql = 
            "select e.id as id, e.cantidad as cantidad, e.id_productos as id_producto,\n" +
            "e.id_proveedor as id_proveedor, e.fecha as fecha, p.nombre_producto as nombre_pro,\n" +
            "o.nombre as nombre_prove\n" +
            "from entrada as e, productos as p, proveedor as o\n" +
            "where \n" +
            "e.id_productos = p.id and\n" +
            "e.id_proveedor = o.id\n" +
            "ORDER BY e.id asc";
                PreparedStatement ps = this.conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                lista = new ArrayList<>();
                while( rs.next())
                {    
                    Entrada entra = new Entrada(); 
                    entra.setId(rs.getInt("id"));
                    entra.setCantidad(rs.getInt("cantidad"));
                    entra.setId_proveedor(rs.getInt("id_proveedor"));
                    entra.setId_producto(rs.getInt("id_producto"));
                    entra.setFecha(rs.getString("fecha"));
                    entra.setNom_producto(rs.getString("nombre_pro"));
                    entra.setNom_proveedor(rs.getString("nombre_prove"));

                  lista.add(entra);  
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
