package gov.iti.jets.repo.daos.interfaces;

import java.util.List;

import gov.iti.jets.repo.entities.CustomerEntity;

public interface CustomerDaoInt {

    List<CustomerEntity> getAllCustomers();

    CustomerEntity getCustomerById(int id);

    boolean addCustomer(CustomerEntity customerEntity);

    boolean updateCustomer(CustomerEntity customerEntity);

    boolean deleteCustomer(int id);
}
