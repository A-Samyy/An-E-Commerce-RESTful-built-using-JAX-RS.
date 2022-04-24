package gov.iti.jets.controllers;

import java.util.ArrayList;
import java.util.List;

import gov.iti.jets.domain.dtos.Product.ProductGetDto;
import gov.iti.jets.domain.dtos.util.ProductMapper;
import gov.iti.jets.domain.enums.Category;
import gov.iti.jets.service.impl.ProductServiceImpl;
import gov.iti.jets.service.interfaces.ProductServiceInt;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("categories")
public class CategoryController {
    ProductServiceInt psi = new ProductServiceImpl();
    @GET
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public List<String> getAllCategories() {
    return psi.getCategories();
    }


    @GET
    @Path( "{cid}" )
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response getCategoryProducts(@PathParam( "cid" ) int num) {

        Category category = Category.getCategoryFromNumber( num );

        List<ProductGetDto> products= new ArrayList<>() ;
        psi.getCategoryProducts( category ).forEach( product -> products.add( ProductMapper.entityToGet( product ) )  );
        if ( products.size() != 0) {
            return Response.ok().entity(products).build();
        }
        return Response.noContent().build();
    }
}
