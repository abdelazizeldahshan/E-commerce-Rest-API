package gov.iti.jets.service.implementations;

import java.util.ArrayList;
import java.util.List;

import gov.iti.jets.Models.customer.Customer;
import gov.iti.jets.Models.customer.CustomerPost;
import gov.iti.jets.repo.daos.implemtion.CustomerDaoImpl;
import gov.iti.jets.repo.daos.interfaces.CustomerDaoInt;
import gov.iti.jets.repo.entities.CustomerEntity;
import gov.iti.jets.service.interfaces.CustomerServiceInt;
import gov.iti.jets.service.mappers.CustomerMapper;

public class CustomerServiceImpl implements CustomerServiceInt {

    CustomerMapper CustomerMapper = new CustomerMapper();
    CustomerDaoInt customerDao = new CustomerDaoImpl();

    public List<Customer> getAllCustomer() {
        List<Customer> customers = new ArrayList<>();
        for (CustomerEntity customerEntity : customerDao.getAllCustomers()) {
            customers.add(CustomerMapper.customerEntityToCustomer(customerEntity));
        }
        return customers;
    }

    public Customer getCustomerById(int id) {
        return CustomerMapper.customerEntityToCustomer(customerDao.getCustomerById(id));
    }

    public boolean addCustomer(CustomerPost customerPost) {
        return customerDao.addCustomer(CustomerMapper.customerPostToCustomerEntity(customerPost));
    }

    public boolean updateCustomer(Customer customer) {
        return customerDao.updateCustomer(CustomerMapper.customerToCustomerEntity(customer));
    }

    public boolean deleteCustomer(int id) {
        return customerDao.deleteCustomer(id);
    }
}