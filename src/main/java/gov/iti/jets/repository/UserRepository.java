package gov.iti.jets.repository;

import java.util.List;
import java.util.Optional;

import gov.iti.jets.domain.models.CartLineItem;
import gov.iti.jets.domain.models.ShoppingCart;
import gov.iti.jets.domain.models.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;

public class UserRepository extends AbstractRepository<User>{
    
    public  UserRepository( EntityManager entityManager) {
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

    public ShoppingCart findShoppingCartbyUserId( int id) {
        TypedQuery<ShoppingCart> query= entityManager.createQuery( "select o from ShoppingCart o where o.owner.id = :userId", ShoppingCart.class );
        query.setParameter( "userId",id );
        return query.getSingleResult();
    }
    
    // public User findEmployeeByEmail(String email) {
    //     return entityManager.createQuery( "select u from User u where u.email = ?1" , User.class ).setParameter( 1,email )
    //     .getSingleResult();
    // }
    // public String findEmployeeUUIDByEmail(String email) {
    //     return entityManager.createQuery( "select u.uuid from User u where u.email = ?1" , String.class ).setParameter( 1,email )
    //     .getSingleResult();
    // }
    // public User findEmployee(int id ) {
    //     return entityManager.find( User.class, id ) ;
    // }
    
    // public void create( User emp ) {
    //     entityManager.persist( emp );
    // }

    // public User update( User emp ) {
    //     return entityManager.merge( emp );
    // }

    // public void delete( User emp ) {
    //     entityManager.remove( emp );
    // }

    // public void deleteById( int empId ) {
    //     User emp = entityManager.find( User.class, empId );
    //     delete( emp );
    // }

}
    // public User findFirst() {
    //     return entityManager.createQuery( "select e from Employees e where e.id = (select min(e.id) from Employees e)" , User.class )
    //             .getSingleResult();
    // }
    // public User findLast() {
    //     return entityManager.createQuery( "select e from Employees e where e.id = (select max(e.id) from Employees e)" , User.class )
    //             .getSingleResult();
    // }
    // public User findNext(int id) {
    //     return entityManager.createQuery( "select e from Employees e where e.id = (select min(e.id) from Employees e where e.id > ?1 )" , User.class ).setParameter( 1, id )
    //             .getSingleResult();//select * from foo where id = (select min(id) from foo where id > 4)
    // }
    // public User findPrevious(int id) {
    //     return entityManager.createQuery( "select e from Employees e where e.id = (select max(e.id) from Employees e where e.id < ?1 )" , User.class ).setParameter( 1, id )
    //             .getSingleResult();//select * from foo where id = (select min(id) from foo where id > 4)
    // }
