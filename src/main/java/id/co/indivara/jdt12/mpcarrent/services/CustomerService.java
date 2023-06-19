package id.co.indivara.jdt12.mpcarrent.services;

import id.co.indivara.jdt12.mpcarrent.models.Customer;

import java.util.List;

public interface CustomerService {
    //Post("/Customer")
    Customer saveCustomer(Customer customer);

    //Put("/Customer/{id}")
    Customer updateCustomer(Customer customer, Long id) throws Exception;

    //Get("/Customer")
    List<Customer> fetchCustomerList();

    //Delete("/Customer/{id}")
    void deleteByIdCustomer(Long id);
}
