/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pages;

import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.util.Iterator;
import javax.json.Json;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author Diego
 */
public class libros extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    

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
        String action = request.getParameter("action");
        
        try {
            if (action == null) listarLibros(request, response);
            switch (action) {
                case "buscar":
                    buscarLibro(request,response);
                    break;
                case "agregar":
                    agregarLibro(request,response);
                    break;
                case "editar":
                    String id = request.getParameter("id_libro");
                    if (id == null || id.isEmpty()) {
                        response.sendRedirect(request.getContextPath() + "/libros");
                        break;
                    }
                    
                    editarLibro(request, response);
                    break;
            }
        } catch (Exception e) {
            System.out.println("error");
        }
    }
    
    private void validarId(){
        String urlstr="http://localhost:8080/JavaWebServiceServerCRUDRestful/restful/empleados/json/listarempleados";
        try{
            URL url = new  URL(urlstr);
            InputStream is = url.openStream();
            JsonReader rdr=Json.createReader(new InputStreamReader(is, "UTF-8"));
            JsonArray results= rdr.readArray();
            Iterator<?> iterator = results.iterator();
            while(iterator.hasNext()){
                JsonObject jsonObject = (JsonObject) iterator.next();
                System.out.println("JSON-> El id es: "+jsonObject.get("id").toString().toUpperCase()+", el nombre es: "+jsonObject.get("nombre").toString().toUpperCase()+", el puesto es: "+jsonObject.get("puesto").toString().toUpperCase());
            }
        }catch (Exception e) {
            e.getMessage();
            e.printStackTrace();
        }
    }
    
    private void listarLibros(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/libros/listarLibros.jsp");
        dispatcher.forward(request, response);
    }
    
    private void buscarLibro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/libros/buscarLibro.jsp");
        dispatcher.forward(request, response);
    }
    
    private void agregarLibro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/libros/agregarLibro.jsp");
        dispatcher.forward(request, response);
    }
    
    private void editarLibro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/libros/editarLibro.jsp");
        dispatcher.forward(request, response);
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
        String action = request.getParameter("action");
        try {
            if (action == null) listarLibros(request, response);
            switch (action) {
                case "buscar":
                    buscarLibro(request,response);
                    break;
            }
        } catch (Exception e) {
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
