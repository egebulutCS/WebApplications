package com.gp225.rsexample;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Singleton;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

// The Singleton annotaion denotes that there will be a single object of the RSEmployee class - don't change that
@Singleton

/*** Annotate the class so that it exports Employee resources under the relative path /employee ***/
@Path("/employee")
public class RSEmployee {

    // a hash map that will store all employees
    private final HashMap<String, Employee> employees;

    // for testing purposes, a sample employee is added in the hashmap where all Employee objects are stored
    // when the Singleton object is instantiated
    // after it is instantiated, the @PostConstruct method will be called
    public RSEmployee() {
        Calendar cal = Calendar.getInstance();
        employees = new HashMap<>();
        Employee empl = new Employee();
        empl.setNin("12345");
        empl.setName("George");
        empl.setSurname("Parisis");
        empl.setDateOfBirth(cal.getTime());
        employees.put(empl.getNin(), empl);
    }

    /**********************************************************************************************************************/
    // Annotate this method so that it can serve GET requests for any relative path under /employee
    // you need to specify a path template for this annotation - this path under /employee should be passed to the getEmployee method by using the PathParam annotation
    // The method Produces either a JSON or XML representation of an Employee object
    // builds and returns an HTTP response (200 ok along with object or 404 NOT FOUND if the employee does not exist)
    @GET
    @Path("/{nin}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response getEmployee(@PathParam("nin") String nin) {
        Employee empl = employees.get(nin);
        if (empl == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        } else {
            return Response.ok(empl).build();
        }
    }
    /**********************************************************************************************************************/

    /**********************************************************************************************************************/
    // Annotate this method so that it can serve GET requests ONLY for the relatove path /all under /employee
    // The object Produces either a JSON or XML represantation of all Employee objects
    // returns a new ArrayList<Employee> containing all employees - this will be transformed to a 200 OK HTTP response containing an XML or JSON representation of all employee objects
    @GET
    @Path("/all")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public ArrayList<Employee> getAllEmployees() {
        return new ArrayList<>(employees.values());
    }
    /**********************************************************************************************************************/

    /**********************************************************************************************************************/
    // Annotate this method so that it can serve DELETE requests for any relative path under /employee
    // The method doesn't produce or consume anything
    // builds and returns a 204 (successful, no content) response
    // the body of the method is already implemented
    @DELETE
    @Path("/{nin}")
    public Response deleteEmployee(@PathParam("nin") String nin) {
        employees.remove(nin);
        return Response.noContent().build();
    }
    /**********************************************************************************************************************/

    /**********************************************************************************************************************/
    // Annotate this method so that it can serve POST requests for the relative path /employee
    // The method Consumes either a JSON or XML representation of an Employee object
    @POST
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response postEmployee(Employee empl, @Context UriInfo context) {
        try {
            if (employees.put(empl.nin, empl) != null) {
                // the employee object was updated
                // build and return a 200 OK response indicating the URI of the added employee
                return Response.ok().contentLocation(new URI(context.getRequestUri().toString() + empl.getNin())).entity(empl).build();
            } else {
                // the employee object was added in the employees map
                // build and return a 201 Created response indicating the URI of the added employee
                return Response.created(new URI(context.getRequestUri().toString() + empl.getNin())).entity(empl).build();
            }
        } catch (URISyntaxException ex) {
            System.err.println(ex);
            return null;
        }
    }
    /**********************************************************************************************************************/

    /**********************************************************************************************************************/
    // Annotate this method so that it can serve PUT requests for any relative path under /employee
    // The method Consumes either a JSON or XML representation of an Employee object
    // returns null if no such object exists
    @PUT
    @Path("/{nin}")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response putEmployee(@PathParam("nin") String nin, Employee empl, @Context UriInfo context) {
        try {
            if (employees.put(empl.nin, empl) != null) {
                // the employee object was updated
                // build and return a 200 OK response indicating the URI of the added employee
                return Response.ok().contentLocation(new URI(context.getRequestUri().toString() + empl.getNin())).entity(empl).build();
            } else {
                // the employee object was added in the employees map
                // build and return a 201 Created response indicating the URI of the added employee
                return Response.created(new URI(context.getRequestUri().toString() + empl.getNin())).entity(empl).build();
            }
        } catch (URISyntaxException ex) {
            System.err.println(ex);
            return null;
        }
    }
    /**********************************************************************************************************************/

    @PostConstruct
    public void init() {
        System.out.println("Singleton Object for this RESTfull Web Service has been created!!");
    }

    @PreDestroy
    public void clean() {
        System.out.println("Singleton Object for this RESTfull Web Service has been cleaned!!");
    }
}
