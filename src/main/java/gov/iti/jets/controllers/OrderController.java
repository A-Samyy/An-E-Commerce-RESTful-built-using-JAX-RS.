package gov.iti.jets.controllers;

import java.util.List;

import gov.iti.jets.domain.models.Order;
import gov.iti.jets.service.impl.ShoppingCartServiceImpl;
import gov.iti.jets.service.impl.UserServiceImpl;
import gov.iti.jets.service.interfaces.ShoppingCartServiceInt;
import gov.iti.jets.service.interfaces.UserServiceInt;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("orders")

public class OrderController {

    ShoppingCartServiceInt scsi = new ShoppingCartServiceImpl();
    UserServiceInt usi = new UserServiceImpl();
//    @GET
//    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
//    public List<OrderDto> getAllOrders() {
//    return orderService.getAllOrders();
//    }

    @GET
    @Path("{uid}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response getUserOrders(@PathParam("uid") int userId) {
       List<Order>orders= usi.getUserOrders( userId );
        if( orders.size() != 0) {
            return Response.ok().entity( orders ).build();
        } else {
            return Response.notModified().build();
        }
    }


    @POST
    @Path("{uid}")
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response orderItemsinShoppingCart(@PathParam("uid") int userId) {
        String res = scsi.orderItemsinShoppingCart( userId );
        if (res != null) {
            return Response.ok().entity(res).build();
        } else {
            return Response.notModified().build();
        }
    }
}
