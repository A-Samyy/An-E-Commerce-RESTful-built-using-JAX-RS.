package gov.iti.jets.controllers;

import gov.iti.jets.domain.dtos.cartLineItem.CartLineItemGetDto;
import gov.iti.jets.domain.dtos.cartLineItem.CartLineItemPostDto;
import gov.iti.jets.domain.dtos.cartLineItem.CartLineItemRemoveDto;
import gov.iti.jets.domain.dtos.util.CartLineItemMapper;
import gov.iti.jets.domain.models.CartLineItem;
import gov.iti.jets.domain.models.ShoppingCart;
import gov.iti.jets.service.impl.ShoppingCartServiceImpl;
import gov.iti.jets.service.interfaces.ShoppingCartServiceInt;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

    @Path( "shoppingCarts" )
public class ShoppingCartController {
    ShoppingCartServiceInt scsi = new ShoppingCartServiceImpl();

    @POST
    @Consumes( {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML} )
    public String addProductToCart( CartLineItemPostDto postDto ) {
       return scsi.addProductToCart( postDto.getUserId(), CartLineItemMapper.postToEntity( postDto ) );
    }

    @DELETE
    @Consumes( {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML} )
    public String removeProductfromCart( CartLineItemRemoveDto removeDto ){
        return scsi.removeProductfromCart( removeDto.getUserId(), removeDto.getProductId() );
    }

    @GET
    @Path( "{cid}" )
    public Response getUserCartitems( @PathParam( "cid" ) int id ){
        List<CartLineItem> userCartitems = scsi.getUserCartitems( id );
        if ( userCartitems.size() != 0 ){
            return Response.ok().entity( userCartitems ).build();
        }
        return Response.noContent().build();

    }
}
