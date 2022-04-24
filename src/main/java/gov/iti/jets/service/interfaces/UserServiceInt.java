package gov.iti.jets.service.interfaces;

import java.util.List;

import gov.iti.jets.domain.models.CartLineItem;
import gov.iti.jets.domain.models.Order;
import gov.iti.jets.domain.models.User;
import jakarta.jws.WebService;


public interface UserServiceInt {
    public List<User> getUsers();

    public User getUser(int id);

    public List<Order> getUserOrders(int id);

    public String createUser(User user);

    public String updateUser(User user);

    public String deleteUser(int id);
}
