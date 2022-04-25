package gov.iti.jets.service.interfaces;

import java.util.List;

import gov.iti.jets.domain.enums.Category;
import gov.iti.jets.domain.models.Product;
import jakarta.jws.WebService;


public interface ProductServiceInt {
    public List<Product> getProducts();

    public Product getProduct(int id);

    public List<String> getCategories();

    public List<Product> getCategoryProducts(Category category);

    public String createProduct(Product product);

    public String updateProduct(Product product);

    public String deleteProduct(int id);

    public List<Product> getProductPagination(int start, int page);
}
