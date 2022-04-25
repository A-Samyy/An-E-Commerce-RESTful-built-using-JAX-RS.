package gov.iti.jets.service.impl;

import gov.iti.jets.domain.models.CartLineItem;
import gov.iti.jets.domain.models.Order;
import gov.iti.jets.domain.models.ShoppingCart;
import gov.iti.jets.domain.models.User;
import gov.iti.jets.exception.CartLineItemNotFoundException;
import gov.iti.jets.exception.OrderNotFoundException;
import gov.iti.jets.repository.OrderRepository;
import gov.iti.jets.repository.ShoppingCartRepository;
import gov.iti.jets.repository.UserRepository;
import gov.iti.jets.service.interfaces.ShoppingCartServiceInt;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public class ShoppingCartServiceImpl implements ShoppingCartServiceInt {
    EntityManagerFactory emf;
    EntityManager em;

    UserRepository ur;
    ShoppingCartRepository shoCartRepo;

    OrderRepository or;

    @Override
    public String addProductToCart( int userId, CartLineItem cartLineItem ) {
        try {
            shoCartRepo = createShoppingRepo();
            ur = new UserRepository( em );
            ShoppingCart shoppingCart = ur.findShoppingCartbyUserId( userId );
            var tr = em.getTransaction();
            tr.begin();
            shoppingCart.addCartLineItem( cartLineItem );
            tr.commit();
            cleaningup();
            return "product is added succsesfully";
        } catch ( Exception e ) {
            e.printStackTrace();
            return "Error! in adding product in cart";

        }
    }

    @Override
    public String removeProductfromCart( int userId, int productId ) {
        try {
            shoCartRepo = createShoppingRepo();
            ur = new UserRepository( em );
            ShoppingCart shoppingCart = ur.findShoppingCartbyUserId( userId );
            var tr = em.getTransaction();
            tr.begin();
            shoppingCart.removeCartLineItem( productId );
            tr.commit();
            cleaningup();
            return "product is removed succsesfully";
        } catch ( Exception e ) {
            return "Error! in removing product from cart";
        }
    }

    @Override
    public List<CartLineItem> getUserCartitems( int id ) {
        shoCartRepo = createShoppingRepo();
        ur = new UserRepository( em );
        ShoppingCart findShoppingCartbyUserId = ur.findShoppingCartbyUserId( id );
        List<CartLineItem> allItemsByShoppingId = shoCartRepo.findAllItemsByShoppingId( findShoppingCartbyUserId.getId() );
        cleaningup();
        if ( allItemsByShoppingId.size() != 0 ) {
            return allItemsByShoppingId;
        } else {

//            throw new OrderNotFoundException( "There is no Customer with id= "+id+" Exist" );
            throw new CartLineItemNotFoundException( "No items found in userId= " + id + " shopping cart." );
        }

    }

    @Override
    public String orderItemsinShoppingCart( int userId ) {
        shoCartRepo = createShoppingRepo();
        ur = new UserRepository( em );
        ShoppingCart shoppingCart = ur.findShoppingCartbyUserId( userId );
        Set<CartLineItem> items = shoppingCart.getCartLineItemsUnmodifiable();

        if ( items.size() != 0 ) {
            System.out.println( shoppingCart.getCartLineItemsUnmodifiable() );
        } else {
            return "no items in the cart";
        }


        or = new OrderRepository( em );

        Optional<User> user = ur.findOne( userId );
        Order o = new Order( user.get() );
        var tr = em.getTransaction();
        tr.begin();
        or.create( o );
        tr.commit();

        cleaningup();
        try {
            items.forEach( item -> removeProductfromCart( userId, item.getProduct().getId() ) );
        } catch ( Exception e ) {
            return "Error couldn't remove item form shopping cart";
        }
        return "The Order was a success ";
    }


    private ShoppingCartRepository createShoppingRepo() {
        emf = Persistence.createEntityManagerFactory( "api" );
        em = emf.createEntityManager();
        return new ShoppingCartRepository( em );
    }

    private UserRepository createUserRepo() {
        emf = Persistence.createEntityManagerFactory( "api" );
        em = emf.createEntityManager();
        return new UserRepository( em );
    }

    private void cleaningup() {
        emf.close();
        em.close();
    }
}
