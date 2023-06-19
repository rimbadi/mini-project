package id.co.indivara.jdt12.mpcarrent.implement;

import id.co.indivara.jdt12.mpcarrent.models.Customer;
import id.co.indivara.jdt12.mpcarrent.repository.CustomerRepository;
import id.co.indivara.jdt12.mpcarrent.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class CustomerImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    
    @Override
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public List<Customer> fetchCustomerList() {
        return customerRepository.findAll();
    }

    @Override
    public Customer updateCustomer(Customer customer, Long id) throws Exception{
        Customer custDB= customerRepository.findById(id).orElseThrow(()->new Exception());
        custDB.setCustomerId(customer.getCustomerId());
        custDB.setName(customer.getName());
        custDB.setEmail(customer.getEmail());
        custDB.setKtpNumber(customer.getKtpNumber());
        custDB.setAddress(customer.getAddress());
        custDB.setContact(customer.getContact());
        return  customerRepository.save(custDB);
    }

    @Override
    public void deleteByIdCustomer(Long id) {
        customerRepository.deleteById(id);
    }


}
