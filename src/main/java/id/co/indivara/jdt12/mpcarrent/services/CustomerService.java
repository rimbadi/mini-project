package id.co.indivara.jdt12.mpcarrent.services;

import id.co.indivara.jdt12.mpcarrent.models.Customer;
import id.co.indivara.jdt12.mpcarrent.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    
    @Transactional
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public List<Customer> fetchCustomerList() {
        return customerRepository.findAll();
    }

    @Transactional
    public Customer updateCustomer(Customer customer, Long id) throws Exception{
        Customer custDB= customerRepository.findById(id).orElseThrow(Exception::new);
        custDB.setCustomerId(customer.getCustomerId());
        custDB.setName(customer.getName());
        custDB.setEmail(customer.getEmail());
        custDB.setKtpNumber(customer.getKtpNumber());
        custDB.setAddress(customer.getAddress());
        custDB.setPhoneNumber(customer.getPhoneNumber());
        return  customerRepository.save(custDB);
    }

    public void deleteByIdCustomer(Long id) {
        customerRepository.deleteById(id);
    }

    public Customer findByCustomerId(Long customerId) {
        return customerRepository.findByCustomerId(customerId);
    }
}
