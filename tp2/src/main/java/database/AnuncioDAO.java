/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import config.DBConn;
import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Anuncio;
import java.util.LinkedList;
import java.util.List;
import java.util.Collections;


public class AnuncioDAO {
    
    private Connection connection;
    
    public AnuncioDAO(){
        DBConn conn = new DBConn();
        String DB = "market";
        String userDB = "root";
        String passDB = "1234";
        connection = conn.getConnection(DB, userDB, passDB);
    }
    
    public Anuncio getaAnuncioById(int id) throws SQLException {
        PreparedStatement ps;
        ResultSet rs;
        Anuncio a = null;

        ps = connection.prepareStatement("SELECT * FROM anuncios WHERE id = ?");
        ps.setInt(1, id);

        rs = ps.executeQuery();
 
        if(rs.next()) {
            String titulo = rs.getString("titulo");
            String descripcion = rs.getString("descripcion");
            String comprador = rs.getString("comprador");
            String vendedor = rs.getString("vendedor");
            Double precio = rs.getDouble("precio");
            Date fecha = rs.getDate("fecha");
            

            a = new Anuncio(id,titulo,  descripcion,  comprador,  vendedor,  precio, fecha);
        }
        return a;
    }
    
     public List<Anuncio> getaAnuncios() throws SQLException {
        PreparedStatement ps;
        ResultSet rs;
        List<Anuncio> anuncios = new LinkedList<>();
        Anuncio a = null;

        ps = connection.prepareStatement("SELECT * FROM anuncios WHERE 1 = 1");
        rs = ps.executeQuery();
 
        while(rs.next()) {
            int id = rs.getInt("id");
            String titulo = rs.getString("titulo");
            String descripcion = rs.getString("descripcion");
            String comprador = rs.getString("comprador"); 
            String vendedor = rs.getString("vendedor");
            Double precio = rs.getDouble("precio");
            Date fecha = rs.getDate("fecha");

            a = new Anuncio(id, titulo,  descripcion,  comprador,  vendedor,  precio, fecha);
            anuncios.add(a);
        }
        return anuncios;
    }
    
    public int createAnuncio(Anuncio a) throws SQLException {
        PreparedStatement ps;
        int lineasAfectadas;
        
        String pQuery = "INSERT INTO anuncios (titulo,  descripcion,  comprador,  vendedor,  precio, fecha)"
                + " VALUES(?, ?, ?, ?, ?, sysdate());";
        ps = connection.prepareStatement(pQuery);
        
        ps.setString(1, a.getTitulo());
        ps.setString(2, a.getDescripcion());
        ps.setString(3, a.getComprador());
        ps.setString(4, a.getVendedor());
        ps.setDouble(5, a.getPrecio());
        
         
        lineasAfectadas = ps.executeUpdate();
        return lineasAfectadas;
    }

    public int updateAnuncio(Anuncio a) throws SQLException {
        PreparedStatement ps;
        int lineasAfectadas;
        
        String pQuery = "UPDATE anuncios SET titulo = ?, descripcion = ?, comprador = ?, vendedor = ?, precio = ?"
                + " WHERE id = ?;";
        ps = connection.prepareStatement(pQuery);
        
        ps.setString(1, a.getTitulo());
        ps.setString(2, a.getDescripcion());
        ps.setString(3, a.getComprador());
        ps.setString(4, a.getVendedor());
        ps.setDouble(5, a.getPrecio());
        ps.setInt(6, a.getId());

        lineasAfectadas = ps.executeUpdate();
        return lineasAfectadas;
    }
    
    public int deleteAnuncio(int id) throws SQLException {
        PreparedStatement ps;
        int lineasAfectadas;
        
        String pQuery = "DELETE FROM anuncios WHERE id = ?;";
        ps = connection.prepareStatement(pQuery);
        
        ps.setInt(1, id);
        lineasAfectadas = ps.executeUpdate();
        return lineasAfectadas;
    }

}
