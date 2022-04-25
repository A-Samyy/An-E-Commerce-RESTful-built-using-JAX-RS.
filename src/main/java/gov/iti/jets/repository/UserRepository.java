package gov.iti.jets.repository;

import java.util.List;
import java.util.Optional;

import gov.iti.jets.domain.models.CartLineItem;
import gov.iti.jets.domain.models.Product;
import gov.iti.jets.domain.models.ShoppingCart;
import gov.iti.jets.domain.models.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;

public class UserRepository extends AbstractRepository<User> {

    public UserRepository( EntityManager entityManager ) {
        super( entityManager );
        this.setClazz( User.class );
    }


    public Optional<User> findUserByEmail( String email ) {
        User user = null;
        email = email.toLowerCase();
        try {
            TypedQuery<User> query = entityManager.createQuery( "SELECT u FROM User u WHERE u.email = :email", User.class );
            query.setParameter( "email", email );
            user = query.getSingleResult();
        } catch ( NoResultException nre ) {
            nre.printStackTrace();
        }
        return Optional.ofNullable( user );
    }

    public ShoppingCart findShoppingCartbyUserId( int id ) {
        TypedQuery<ShoppingCart> query = entityManager.createQuery( "select o from ShoppingCart o where o.owner.id = :userId", ShoppingCart.class );
        query.setParameter( "userId", id );
        return query.getSingleResult();
    }

    public List<User> getPageOfUser( int pageNumber , int pageSize) {
        TypedQuery<User> query = entityManager.createQuery( "SELECT u FROM User  u ", User.class );
        return query.setFirstResult(  pageNumber - 1  )
                .setMaxResults( pageSize )
                .getResultList();
    }
}
