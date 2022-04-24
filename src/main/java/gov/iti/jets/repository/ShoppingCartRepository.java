package gov.iti.jets.repository;

import java.util.List;

import gov.iti.jets.domain.models.CartLineItem;
import gov.iti.jets.domain.models.ShoppingCart;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

public class ShoppingCartRepository extends AbstractRepository<ShoppingCart> {

    public ShoppingCartRepository( EntityManager entityManager ) {
        super( entityManager );
        this.setClazz( ShoppingCart.class );
    }

    
    
    public List<CartLineItem> findAllItemsByShoppingId( int id) {
        Query query= entityManager.createQuery( "select sh.cartLineItems from ShoppingCart sh where sh.id = :shoppingCardId");
        query.setParameter( "shoppingCardId",id );
        return query.getResultList();
    }


}
