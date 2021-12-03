package com.emergentes.DAO;

import com.emergentes.modelo.Producto;
import com.emergentes.utiles.ConexionBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAOimple extends ConexionBD implements ProductoDAO {

    @Override
    public void insert(Producto producto) throws Exception {
        try {
            this.conectar();
            String sql;
            sql = "insert into productos (nombre_producto, descripcion, entrada_inicial, stock, precio) Values (?,?,?,?,?)";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, producto.getNombre());
            ps.setString(2, producto.getDescripcion());
            ps.setInt(3, producto.getEntrada_inicial());
            ps.setInt(4, producto.getStock());
            ps.setInt(5, producto.getPrecio());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void update(Producto producto) throws Exception {
        try {
            this.conectar();
            String sql;
            sql = "Update productos Set nombre_producto = ?, descripcion= ?, entrada_inicial = ?, stock = ?,precio = ? where id = ?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, producto.getNombre());
            ps.setString(2, producto.getDescripcion());
            ps.setInt(3, producto.getEntrada_inicial());
            ps.setInt(4, producto.getStock());
            ps.setInt(5, producto.getPrecio());
            ps.setInt(6, producto.getId());
            ps.executeUpdate();
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
            String sql;
            sql = "delete from productos where id = ?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);

            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public Producto getById(int id) throws Exception {
        Producto prod = new Producto();  
        try {
                this.conectar();
                String sql;
                sql = "select * from productos where id = ?";
                PreparedStatement ps = this.conn.prepareStatement(sql);
                ps.setInt(1,id);
                ResultSet rs = ps.executeQuery();
                if(rs.next())
                {
                    prod.setId(rs.getInt("id"));
                    prod.setNombre(rs.getString("nombre_producto"));
                    prod.setDescripcion(rs.getString("descripcion"));
                    prod.setEntrada_inicial(rs.getInt("entrada_inicial"));
                    prod.setStock(rs.getInt("stock"));
                    prod.setPrecio(rs.getInt("precio"));
                }    
               
        } catch (Exception e) 
        {
           throw e;
        }finally
        {this.desconectar();}
        return prod;
    }

    @Override
    public List<Producto> getAll() throws Exception {
                List <Producto> lista = null; 
        try 
        {
                this.conectar();
                String sql;
                sql = "select * from productos";
                PreparedStatement ps = this.conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                lista = new ArrayList<Producto>();
                while( rs.next())
                {    
                    Producto prod = new Producto(); 
                    prod.setId(rs.getInt("id"));
                    prod.setNombre(rs.getString("nombre_producto"));
                    prod.setDescripcion(rs.getString("descripcion"));
                    prod.setEntrada_inicial(rs.getInt("entrada_inicial"));
                    prod.setStock(rs.getInt("stock"));
                    prod.setPrecio(rs.getInt("precio"));

                  lista.add(prod);  
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
