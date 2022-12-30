/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.util.LinkedList;
import java.util.List;
import java.util.Collections;
import database.AnuncioDAO;
import database.UsuarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Usuario;
import model.Anuncio;


@WebServlet(name = "anuncioController", urlPatterns = {"/anuncios/*"})
public class AnuncioController extends HttpServlet {

  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            
            String action = request.getPathInfo();
            AnuncioDAO adao = new AnuncioDAO();
            UsuarioDAO udao = new UsuarioDAO();
            List<Anuncio> listaAnuncios = null;
            HttpSession session = request.getSession();
            Usuario actualUser;
            Anuncio actualAnuncio;
            String username;
            String password;
            String name;
            String last_name;
            String email;
            
            //anuncio
            int idAnuncio;
            int id;
            String titulo;
            String descripcion;
            String comprador; 
            String vendedor;
            Double precio;
            Anuncio anuncioActual;
            Date fecha;
            int regs_afectados;
           
            out.print(action);
                    
            switch (action) {
             
                case "/crear":
                    vendedor = (String) session.getAttribute("actualUsername");
                    
                    comprador = null;
                    titulo = request.getParameter("titulo");
                    descripcion = request.getParameter("descripcion");
                    precio = Double.valueOf(request.getParameter("precio"));
                    actualAnuncio = new Anuncio(titulo,  descripcion,  comprador,  vendedor,  precio);
                    regs_afectados = adao.createAnuncio(actualAnuncio);
                    session.setAttribute("aCreado", regs_afectados);
                    response.sendRedirect("/market/views/anuncioCreado.jsp");
                    break;
                    
                case "/obtenerLista":                    
                    listaAnuncios = adao.getaAnuncios();
                    session.setAttribute("listaAnuncios", listaAnuncios);
                    response.sendRedirect("/market/views/listaAnuncios.jsp");
                    break;
                    
                case "/borrar":
                     idAnuncio = Integer.parseInt(request.getParameter("id"));
                     anuncioActual = adao.getaAnuncioById(idAnuncio);
                    out.print( adao.deleteAnuncio(idAnuncio)); 
                           response.sendRedirect("/market/anuncios/obtenerLista");
                    break;
                
                case "/comprar":
                    
                     idAnuncio = Integer.parseInt(request.getParameter("id"));
                     anuncioActual = adao.getaAnuncioById(idAnuncio);
                    comprador = (String) session.getAttribute("actualUsername");
                    anuncioActual.setComprador(comprador);
                    out.print( adao.updateAnuncio(anuncioActual));  
           
                    response.sendRedirect("/market/anuncios/obtenerLista");
                
                    break;
                    
                case "/editar":
                    
                    idAnuncio = Integer.parseInt(request.getParameter("id"));
                    anuncioActual = adao.getaAnuncioById(idAnuncio);
                    session.setAttribute("aCreado",anuncioActual);
                    
                    response.sendRedirect("/market/views/anuncioEditar.jsp");
                
                    break;
                
                case "/actualizar":
                    
                    idAnuncio = Integer.parseInt(request.getParameter("id"));
                    anuncioActual = adao.getaAnuncioById(idAnuncio);
                    titulo = request.getParameter("titulo");
                    descripcion = request.getParameter("descripcion");
                    precio = Double.valueOf(request.getParameter("precio"));
                    anuncioActual.setTitulo(titulo);
                    anuncioActual.setDescripcion(descripcion);
                    anuncioActual.setPrecio(precio);
                    regs_afectados = adao.updateAnuncio(anuncioActual);
                     session.setAttribute("aCreado", regs_afectados);
                    response.sendRedirect("/market/anuncios/obtenerLista");
                
                    break;
                
                default:
                    break;
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(AnuncioController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(AnuncioController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
