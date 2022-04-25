package gov.iti.jets.service.interfaces;

import java.util.List;

import gov.iti.jets.domain.models.CartLineItem;
import gov.iti.jets.domain.models.Order;
import gov.iti.jets.domain.models.Product;
import gov.iti.jets.domain.models.User;
import jakarta.jws.WebService;


public interface UserServiceInt {
    public List<User> getUsers();
    public List<User> getUserPagination( int start, int page);

    public User getUser(int userId);

    public List<Order> getUserOrders(int userId);

    public String createUser(User user);

    public String updateUser(User user);

    public String deleteUser(int id);
}
