package com.emergentes.DAO;
import com.emergentes.utiles.ConexionBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAOStock extends ConexionBD
{
    private int id;

    public DAOStock(int id) 
    {
        this.id = id;
    }
    public void modificar_stock() throws SQLException
    {
        // para lamacenar la suma total de stock en prodcutos
            int stock_total , entra =0, sali =0, entrada_inicial=0;
            this.conectar();
            // para obtener la cantidad inicial de la tabla productos
            String sql2;
            String sql4;
            sql2 = "select entrada_inicial from productos where id = ?;";
            PreparedStatement ps2 = this.conn.prepareStatement(sql2);
            ps2.setInt(1, id);
            ResultSet rs = ps2.executeQuery();
            if(rs.next())
                {
               entrada_inicial = rs.getInt("entrada_inicial");
                }
           
            //para obtener la suma de cantidad de salidas
            try {
                sql4 = "SELECT  SUM(cantidad) cantidad FROM salida where id_producto =?";
            PreparedStatement ps4 = this.conn.prepareStatement(sql4);
            ps4.setInt(1, id);
            ResultSet rs3 = ps4.executeQuery();
              if(rs3.next())
                {
                 sali = rs3.getInt("cantidad");
                } 
            } catch (Exception e) 
            {
                System.out.println("ERROR DE CONSULTA: "+e);
                sali=0;
            }
            
            
            // para obtener la suma de cantidad de entradas
            String sql3;
            sql3 = "SELECT  SUM(cantidad) as cantidad_total FROM entrada where id_productos =?";
            PreparedStatement ps3 = this.conn.prepareStatement(sql3);
            ps3.setInt(1, id);
            ResultSet rs2 = ps3.executeQuery();
            if(rs2.next())
                {
             entra = rs2.getInt("cantidad_total");

                }

            stock_total = (entra + entrada_inicial)-sali;
            
            // por ultimo modificar la tabla productos con el stock nuevo
            System.out.println("STOCKKKKKK---->>++  "+stock_total);

            String sql5;
            sql5 = "Update productos Set stock = ? where id =?";
            PreparedStatement ps5 = this.conn.prepareStatement(sql5);
            ps5.setInt(1, stock_total);
            ps5.setInt(2, id);
            
            ps5.executeUpdate();
            this.desconectar();     
    }         
}
