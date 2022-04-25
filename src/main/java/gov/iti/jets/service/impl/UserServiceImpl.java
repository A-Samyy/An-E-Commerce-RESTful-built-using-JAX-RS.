package gov.iti.jets.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import gov.iti.jets.domain.models.*;
import gov.iti.jets.exception.CustomerNotFoundException;
import gov.iti.jets.exception.OrderNotFoundException;
import gov.iti.jets.exception.ProductNotFoundException;
import gov.iti.jets.exception.ShoppingCartNotFoundException;
import gov.iti.jets.repository.OrderRepository;
import gov.iti.jets.repository.ShoppingCartRepository;
import gov.iti.jets.repository.UserRepository;
import gov.iti.jets.service.interfaces.UserServiceInt;
import jakarta.jws.WebService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import net.bytebuddy.implementation.bytecode.Throw;

public class UserServiceImpl implements UserServiceInt {
    EntityManagerFactory emf;
    EntityManager em;
    UserRepository ur;
    OrderRepository or;
    ShoppingCartRepository shoCartRepo;

    @Override
    public List<User> getUsers() {
        ur = createUserRepo();
        List<User> findAll = ur.findAll();
        cleaningup();
        return findAll;
    }

    @Override
    public List<User> getUserPagination( int start, int page ) {
        ur = createUserRepo();
        List<User> users = ur.getPageOfUser( start, page );
        cleaningup();
        if ( users.size() != 0 ) {
            return users;
        }else {
            throw new CustomerNotFoundException( "There is no Users in this page" );
        }
    }

    @Override
    public User getUser( int id ) {
        ur = createUserRepo();
        Optional<User> findOne = ur.findOne( id );
        cleaningup();
        if ( findOne.isPresent() ) {
            return findOne.get();
        }else {
            throw new CustomerNotFoundException( "User With id= "+id+" does not exist." );
        }
    }

    @Override
    public List<Order> getUserOrders( int userId ) {
        or = createOrdersRepo();
        List<Order> findAllByUserId = or.findAllByUserId( userId );
        cleaningup();
        if(findAllByUserId.size() != 0){
        return findAllByUserId;
        }else {
            throw new OrderNotFoundException( "The customer with id= "+userId+ " has no orders yet." );
        }
    }

    @Override
    public String createUser( User user ) {
        try {
            ur = createUserRepo();
            shoCartRepo = new ShoppingCartRepository( em );
            var tr = em.getTransaction();
            tr.begin();
            ur.create( user );
            tr.commit();
            ShoppingCart shoppingCart = new ShoppingCart();
            user.setShoppingCart( shoppingCart );
            tr.begin();
            shoCartRepo.create( shoppingCart );
            tr.commit();
            cleaningup();
            return "User is added";
        } catch ( Exception e ) {
            throw new CustomerNotFoundException( "User With id= "+user.getId()+" does not exist." );
        }
    }

    @Override
    public String updateUser( User user ) {
        try {
            ur = createUserRepo();
            var tr = em.getTransaction();
            tr.begin();
            ur.update( user );
            tr.commit();
            cleaningup();
            return "User is updated";
        } catch ( Exception e ) {
            throw new CustomerNotFoundException( "User With id= "+user.getId()+" does not exist." );
        }
    }

    @Override
    public String deleteUser( int id ) {
            ur = createUserRepo();
            shoCartRepo = new ShoppingCartRepository( em );
            or = new OrderRepository( em );
            var tr = em.getTransaction();
            try {
                List<Order> orders = or.findAllByUserId( id );
                tr.begin();
                orders.forEach( order -> or.delete( order ) );
                tr.commit();

            } catch ( Exception e ) {
                System.out.println( "no orders for user" );
            }
            try {
                ShoppingCart shoppingCart = ur.findShoppingCartbyUserId( id );
                tr.begin();
                shoCartRepo.delete( shoppingCart );
                tr.commit();
            } catch ( Exception e ) {
                System.out.println( "no shopping cart for user" );
                throw new ShoppingCartNotFoundException( "User With id= "+id+" has no ShoppingCart." );
            }
        try {
            tr.begin();
            ur.deleteById( id );
            tr.commit();
            cleaningup();
            return "User is deleted";
        } catch ( Exception e ) {
            e.printStackTrace();
            throw new CustomerNotFoundException( "User With id= " + id + " does not exist." );
        }
    }


    private UserRepository createUserRepo() {
        emf = Persistence.createEntityManagerFactory( "api" );
        em = emf.createEntityManager();
        return new UserRepository( em );
    }

    private ShoppingCartRepository createShoppingRepo() {
        emf = Persistence.createEntityManagerFactory( "api" );
        em = emf.createEntityManager();
        return new ShoppingCartRepository( em );
    }

    private OrderRepository createOrdersRepo() {

        emf = Persistence.createEntityManagerFactory( "api" );
        em = emf.createEntityManager();
        return new OrderRepository( em );
    }

    private void cleaningup() {
        emf.close();
        em.close();
    }

}