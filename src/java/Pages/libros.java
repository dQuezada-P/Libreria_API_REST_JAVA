/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pages;

import Class.Libro;
import API.BookResource;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;


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
            else {
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
                        Map map = validarId(id);
                        if (map!=null){
                            request.setAttribute("id", map.get("id"));
                            request.setAttribute("isbn", map.get("isbn"));
                            request.setAttribute("titulo", map.get("titulo"));
                            request.setAttribute("editorial", map.get("editorial"));
                            request.setAttribute("anno", map.get("anno"));
                            request.setAttribute("autor1", map.get("autor1"));
                            request.setAttribute("autor2", map.get("autor2"));
                            request.setAttribute("precio", map.get("precio"));
                            editarLibro(request, response);
                            break;
                        }
                        response.sendRedirect(request.getContextPath() + "/libros");
                        
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    private Map validarId(String id){
        try{
            Map map = new HashMap();
            Response rs = new BookResource().getBook(Integer.parseInt(id));
            String result = (String) rs.getEntity();
            /*boolean flag = true;
            int posInit = 1;
            int posCoin = 0;
            while(posCoin != -1){
                String key = "";
                String value = "";
                String temp;
                posCoin = result.indexOf(",",posInit);
                if(posCoin == -1) temp = result.substring(posInit,result.length()-1).replace("\"", "");
                else temp = result.substring(posInit,posCoin).replace("\"", "");
                String[] k_v = temp.split(":");
                key = k_v[0];
                value = k_v[1];
                map.put(key, value);
                
                posInit = posCoin + 1;
            }*/
            result = result.replace("\"", "").replace("{", "").replace("}", "");
            String[] attributesBook = result.split(",");
            for(String attribute : attributesBook){
                String[] arrAttribute = attribute.split(":");
                String key = arrAttribute[0];
                String value = arrAttribute[1];
                map.put(key, value);
            }
            return map;
            
        }catch (Exception e) {
            System.out.println("error");
            System.out.println(e.getMessage());
        }
        return null;
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
