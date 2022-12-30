/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

public class Anuncio {
    private int id;
    private String titulo;
    private String descripcion;
    private String comprador;
    private String vendedor;
    private double precio;
    private Date signup_date;
    
    public Anuncio(String titulo, String descripcion){
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.signup_date = new Date();
    }
    
    public Anuncio(String titulo, String descripcion, String comprador, String vendedor, double precio){
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.comprador = comprador;
        this.vendedor = vendedor;
        this.precio = precio;
        this.signup_date = new Date();
    }
    
       public Anuncio(int id, String titulo, String descripcion, String comprador, String vendedor, double precio, Date fecha){
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.comprador = comprador;
        this.vendedor = vendedor;
        this.precio = precio;
        this.signup_date = fecha;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getId() {
        return id;
    }
     public void setId(int id) {
         this.id=id;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getComprador() {
        if(this.comprador == null)
        {
            return "";
        }
        return comprador;
    }

    public void setComprador(String comprador) {
        this.comprador = comprador;
    }

    public String getVendedor() {
        return vendedor;
    }

    public void setVendedor(String vendedor) {
        this.vendedor = vendedor;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Date getSignup_date() {
        return signup_date;
    }
    

}
