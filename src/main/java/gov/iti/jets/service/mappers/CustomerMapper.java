package gov.iti.jets.service.mappers;

import gov.iti.jets.Models.customer.Customer;
import gov.iti.jets.Models.customer.CustomerPost;
import gov.iti.jets.repo.entities.CustomerEntity;

public class CustomerMapper {

    public Customer customerEntityToCustomer(CustomerEntity customerEntity) {
        Customer customer = new Customer();
        customer.setAddress(customerEntity.getAddress());
        customer.setId(customerEntity.getId());
        if (customerEntity.getIsMale()) {
            customer.setGender("male");
        } else {
            customer.setGender("female");
        }
        customer.setCreditLimit(customerEntity.getCreditLimit());
        customer.setEmail(customer.getEmail());
        customer.setInterst(customer.getInterst());
        customer.setJop(customerEntity.getJob());
        customer.setName(customerEntity.getUsername());
        return customer;
    }

    public CustomerEntity customerPostToCustomerEntity(CustomerPost customerPost) {
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setAddress(customerPost.getAddress());
        customerEntity.setCreditLimit(customerPost.getCreditLimit());
        customerEntity.setEmail(customerPost.getEmail());
        customerEntity.setInterests(customerPost.getInterst());
        if ((customerPost.getGender()).equals("male")) {
            customerEntity.setIsMale(true);
        } else {
            customerEntity.setIsMale(false);
        }
        customerEntity.setJob(customerPost.getJop());
        customerEntity.setUsername(customerPost.getName());
        customerEntity.setPassword(customerPost.getPassword());
        return customerEntity;
    }

    public CustomerEntity customerToCustomerEntity(Customer customer) {
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setId(customer.getId());
        customerEntity.setAddress(customer.getAddress());
        customerEntity.setCreditLimit(customer.getCreditLimit());
        customerEntity.setEmail(customer.getEmail());
        customerEntity.setInterests(customer.getInterst());
        if ((customer.getGender()).equals("male")) {
            customerEntity.setIsMale(true);
        } else {
            customerEntity.setIsMale(false);
        }
        customerEntity.setJob(customer.getJop());
        customerEntity.setUsername(customer.getName());
        return customerEntity;
    }

}
