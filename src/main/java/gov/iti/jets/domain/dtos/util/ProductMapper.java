package gov.iti.jets.domain.dtos.util;

import gov.iti.jets.domain.dtos.Product.ProductGetDto;
import gov.iti.jets.domain.dtos.Product.ProductPatchDto;
import gov.iti.jets.domain.dtos.Product.ProductPostDto;
import gov.iti.jets.domain.dtos.Product.ProductPutDto;
import gov.iti.jets.domain.dtos.User.UserPatchDto;
import gov.iti.jets.domain.enums.Category;
import gov.iti.jets.domain.models.Product;
import gov.iti.jets.domain.models.User;
import gov.iti.jets.service.impl.ProductServiceImpl;
import gov.iti.jets.service.impl.UserServiceImpl;
import gov.iti.jets.service.interfaces.ProductServiceInt;
import gov.iti.jets.service.interfaces.UserServiceInt;

public class ProductMapper {
    public static ProductGetDto entityToGet( Product entity ) {
        return new ProductGetDto( entity.getId(), entity.getName(), entity.getDescription(), entity.getPrice(), entity.getQuantity(), entity.getCategory() );
    }

    public static Product postToEntity( ProductPostDto postDto ) {
        return new Product( postDto.getName(), postDto.getDescription(), postDto.getPrice(), postDto.getQuantity(), postDto.getCategory() );
    }

    public static Product putToEntity( ProductPutDto putDto ) {
        return new Product( putDto.getId(), putDto.getName(), putDto.getDescription(), putDto.getPrice(), putDto.getQuantity(), putDto.getCategory() );
    }

    public static Product patchToEntity( ProductPatchDto patchDto ) {
        ProductServiceInt serviceInt = new ProductServiceImpl();
        Product entity = serviceInt.getProduct( patchDto.getId() );
        if ( patchDto.getName() != null ) {
            entity.setName( patchDto.getName().toString() );
        }
        if ( patchDto.getDescription() != null ) {
            entity.setDescription( patchDto.getDescription().toString() );
        }
        if ( patchDto.getCategory() != null ) {
            Category category;
            switch ( patchDto.getCategory().toString() ) {
                case "WHITE_CHOCOLATE":
                    category = Category.WHITE_CHOCOLATE;
                    break;
                case "Dark_CHOCOLATE":
                    category = Category.DARK_CHOCOLATE;
                    break;
                case "DRINKS":
                    category = Category.DRINKS;
                    break;
                default:
                    category = Category.WHITE_CHOCOLATE;
            }
            entity.setCategory( category );
        }
        if ( patchDto.getQuantity() != null ) {
            entity.setQuantity( Integer.parseInt( patchDto.getQuantity().toString() ) );
        }
        if ( patchDto.getPrice() != null ) {
            entity.setPrice( Integer.parseInt( patchDto.getPrice().toString() ) );
        }
        return entity;
    }

}
