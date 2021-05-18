/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package API;

import Class.Libro;
import Dao.LibroDao;
import com.sun.management.jmx.ServiceName;
import java.sql.SQLException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.Response;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Diego
 */
@Path("book")
public class BookResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of BookResource
     */
    public BookResource() {
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addBook(Libro libro) throws SQLException{
        LibroDao dao = new LibroDao();
        String res = dao.create(libro);
        if (!res.isEmpty()) return Response.notModified("No se pudo agregar el libro. SQLException: "+res).build();
        String json = "\"Added\":\"yes\",\n"
                + "\"id\":\""+ dao.getLastId() +"\"";
        return Response.ok(json, MediaType.APPLICATION_JSON).build();
     
    }

    
}
