package gov.iti.jets.service.interfaces;

import gov.iti.jets.Models.customer.Customer;
import gov.iti.jets.Models.customer.CustomerPost;
import java.util.List;

public interface CustomerServiceInt {

    List<Customer> getAllCustomer();

    Customer getCustomerById(int id);

    boolean addCustomer(CustomerPost customerPost);

    boolean updateCustomer(Customer customer);

    boolean deleteCustomer(int id);
}
