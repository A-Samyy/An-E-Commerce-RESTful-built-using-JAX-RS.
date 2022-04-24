package gov.iti.jets.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import gov.iti.jets.domain.enums.Category;
import gov.iti.jets.domain.models.Product;
import gov.iti.jets.exception.ProductNotFoundException;
import gov.iti.jets.repository.ProductRepository;
import gov.iti.jets.service.interfaces.ProductServiceInt;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class ProductServiceImpl implements ProductServiceInt {
    EntityManagerFactory emf;
    EntityManager em;
    ProductRepository pr;

    @Override
    public List<Product> getProducts() {
        pr = createProductRepo();
        List<Product> products = pr.findAll();
        cleaningup();
        return products;

    }

    @Override
    public Product getProduct( int id ) {
        pr = createProductRepo();
        Optional<Product> product = pr.findOne( id );
        cleaningup();
        if ( product.isPresent() ) {
            return product.get();
        } else {
            throw new ProductNotFoundException( "Product with id=" + id + "no longer exist." );
        }
    }

    @Override
    public List<String> getCategories() {
        List<String> cats = new ArrayList<>();
        for ( Category cat : Category.values() ) {
            cats.add( cat.name() );
        }
        return cats;
    }

    @Override
    public List<Product> getCategoryProducts( Category category ) {
        pr = createProductRepo();
        List<Product> products = pr.findProductsByCategory( category );
        cleaningup();
        return products;
    }

    @Override
    public String createProduct( Product product ) {
        try {
            pr = createProductRepo();
            var tr = em.getTransaction();
            tr.begin();
            pr.create( product );
            tr.commit();
            cleaningup();
            return "Product is added";
        } catch ( Exception e ) {
            return "Error! Product can not be added";
        }
    }

    @Override
    public String updateProduct( Product product ) {
        try {
            pr = createProductRepo();
            var tr = em.getTransaction();
            tr.begin();
            System.out.println( product );
            pr.update( product );
            tr.commit();
            cleaningup();
            return "Product is updated";
        } catch ( Exception e ) {
            //   e.printStackTrace();
            return "Error! Product can not be updated";
        }
    }

    @Override
    public String deleteProduct( int id ) {
        try {
            pr = createProductRepo();
            var tr = em.getTransaction();
            tr.begin();
            pr.deleteById( id );
            tr.commit();
            cleaningup();
            return "Product is Deleted";
        } catch ( Exception e ) {
            return "Error! Product can not be deleted";
        }
    }

    private ProductRepository createProductRepo() {
        emf = Persistence.createEntityManagerFactory( "api" );
        em = emf.createEntityManager();
        return new ProductRepository( em );
    }

    private void cleaningup() {
        emf.close();
        em.close();
    }

}
