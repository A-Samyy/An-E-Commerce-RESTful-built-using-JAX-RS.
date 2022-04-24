package gov.iti.jets;


import gov.iti.jets.domain.dtos.User.UserPatchDto;
import gov.iti.jets.domain.dtos.util.UserMapper;
import gov.iti.jets.domain.enums.Category;
import gov.iti.jets.domain.enums.Role;
import gov.iti.jets.domain.models.*;
import gov.iti.jets.repository.OrderRepository;
import gov.iti.jets.repository.ProductRepository;
import gov.iti.jets.repository.ShoppingCartRepository;
import gov.iti.jets.repository.UserRepository;
import gov.iti.jets.service.impl.ShoppingCartServiceImpl;
import gov.iti.jets.service.impl.UserServiceImpl;
import gov.iti.jets.service.interfaces.ShoppingCartServiceInt;
import gov.iti.jets.service.interfaces.UserServiceInt;
import jakarta.persistence.Persistence;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Main class.
 *
 */
public class Main {

    public static void main(String[] args) throws IOException {
        ShoppingCartServiceInt  serviceInt =new ShoppingCartServiceImpl();
        System.out.println( serviceInt.orderItemsinShoppingCart( 118 ) );
    //    serviceInt.removeProductfromCart( 118,117 );

//        var emf = Persistence.createEntityManagerFactory( "api" );
//        var em =emf.createEntityManager();
//
//        List<Product> products = new ArrayList<>();
//        Product product1 = new Product( "Ferrero Rocher", "Fine Hazelnut Chocolates - 5.3oz/12ct", 6 * 100, 50, Category.WHITE_CHOCOLATE );
//        products.add( product1 );
//
//        ProductRepository pr = new ProductRepository( em );
//        em.getTransaction().begin();
//        products.forEach( pr::create );
//        em.getTransaction().commit();
//
//        List<User> users = new ArrayList<>();
//        User user1 = new User( "Hafsa Mohamed", "hafsa@gmail.com", "01117950455", "1234", Role.CUSTOMER);
//        users.add( user1 );
//
//        UserRepository ur = new UserRepository( em );
//        em.getTransaction().begin();
//        users.forEach( ur::create );
//        em.getTransaction().commit();
//
//        List<ShoppingCart> shoppingCarts = new ArrayList<>();
//        ShoppingCart shoppingCart1 = new ShoppingCart();
//        user1.setShoppingCart( shoppingCart1 );
//        shoppingCarts.add( shoppingCart1 );
//
//        shoppingCart1.addCartLineItem( new CartLineItem( product1, 5 ) );
//
//        ShoppingCartRepository scr = new ShoppingCartRepository( em );
//        em.getTransaction().begin();
//        shoppingCarts.forEach( scr::create );
//        em.getTransaction().commit();
//
//        List<Order> orders = new ArrayList<>();
//        Order order1 = new Order( user1 );
//        orders.add( order1 );
//
//        OrderRepository or = new OrderRepository( em );
//        em.getTransaction().begin();
//        orders.forEach( or::create );
//        em.getTransaction().commit();

//
//        UserServiceInt serviceInt =new UserServiceImpl();
//        UserPatchDto patchDto = new UserPatchDto(113);
//        patchDto.setName( "Nourhan Ayman" );
//        System.out.println( serviceInt.updateUser( UserMapper.patchToEntity( patchDto ) ) );
    }
}

