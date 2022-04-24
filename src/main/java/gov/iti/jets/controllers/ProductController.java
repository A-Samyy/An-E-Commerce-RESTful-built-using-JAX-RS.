package gov.iti.jets.controllers;

import java.util.ArrayList;
import java.util.List;

import gov.iti.jets.domain.dtos.Product.ProductGetDto;
import gov.iti.jets.domain.dtos.Product.ProductPatchDto;
import gov.iti.jets.domain.dtos.Product.ProductPostDto;
import gov.iti.jets.domain.dtos.Product.ProductPutDto;
import gov.iti.jets.domain.dtos.util.ProductMapper;
import gov.iti.jets.domain.dtos.util.UserMapper;
import gov.iti.jets.service.impl.ProductServiceImpl;
import gov.iti.jets.service.interfaces.ProductServiceInt;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.Link;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;

@Path( "products" )
public class ProductController {
    ProductServiceInt psi = new ProductServiceImpl();

    @GET
    @Produces( {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML} )
    public List<ProductGetDto> getAllProducts() {
        List<ProductGetDto> getDtos = new ArrayList<>();
        psi.getProducts().forEach( product -> getDtos.add( ProductMapper.entityToGet( product ) ) );
        return getDtos;
    }

    // @GET
    // @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    // public Response getProductPage(@DefaultValue("1") @QueryParam("start") int
    // start,
    // @DefaultValue("2") @QueryParam("page") int page) {
    // return Response.ok().entity(ProductService.pagination(start, page)).build();
    // }

    @GET
    @Path( "{pid}" )
    @Produces( {MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON} )
    public Response getProduct( @PathParam( "pid" ) int id, @Context UriInfo uriInfo ) {
        ProductGetDto product = ProductMapper.entityToGet( psi.getProduct( id ) );
        if ( product != null ) {
            Link self = Link.fromUriBuilder( uriInfo.getAbsolutePathBuilder() ).rel( "self" ).build();
            product.getLinks().add( "Self ref=\"" + self.getUri() + "\"" );
            Link link = Link.fromPath( "http://localhost:9595/RestAPI/api/shoppingCarts" ).build();
            product.getLinks().add( "AddProductToCart ref=\"" + link +"\"" +"productId= "+id );
            return Response.ok().entity( product ).build();
        }
        return Response.notModified().build();
    }

    @POST
    @Consumes( {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML} )
    public Response createProduct( ProductPostDto product, @Context UriInfo uriInfo ) {
        String res= psi.createProduct( ProductMapper.postToEntity( product ) );
        if ( res != null ) {
            return Response.ok().entity( product ).build();
        } else {
            return Response.notModified().build();
        }
    }

    @DELETE
    @Path( "{pid}" )
    public String deleteProduct( @PathParam( "pid" ) int id ) {
        return psi.deleteProduct( id );
    }

    @PUT
    @Consumes( MediaType.APPLICATION_JSON )
    public String updateProduct( ProductPutDto productDto ) {
        return psi.updateProduct( ProductMapper.putToEntity( productDto ) );
    }

   @PATCH
   @Consumes( {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML} )
    public Response updateProductPatch( ProductPatchDto patchDto ){
        String res =psi.updateProduct( ProductMapper.patchToEntity( patchDto ) );
        if ( res != null ) {
            return Response.ok().entity( res ).build();
        } else {
            return Response.notModified().build();
        }
        }

}
