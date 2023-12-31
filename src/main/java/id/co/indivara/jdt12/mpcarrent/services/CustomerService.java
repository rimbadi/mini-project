package id.co.indivara.jdt12.mpcarrent.services;

import id.co.indivara.jdt12.mpcarrent.models.Customer;
import id.co.indivara.jdt12.mpcarrent.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    
    @Transactional
    public Customer saveCustomer(Customer customer) throws Exception{
        if (customerRepository.existsByEmail(customer.getEmail())) {
            throw new Exception("Email already used");
        }
        if (customerRepository.existsByPhoneNumber(customer.getPhoneNumber()) ) {
            throw new Exception("Phone number already used.");
        }
        if (customerRepository.existsByKtpNumber(customer.getKtpNumber())) {
            throw new Exception("KTP number already used.");
        }


        return customerRepository.save(customer);
    }

    public List<Customer> fetchCustomerList() {
        return customerRepository.findAll();
    }

    @Transactional
    public Customer updateCustomer(Customer customer, String customerId)throws Exception{
        Customer cust= customerRepository.findById(customerId).orElseThrow(()->new Exception("Customer not found!"));
        if (Objects.nonNull(customer.getName())&&!"".equalsIgnoreCase(customer.getName())){
            cust.setName(customer.getName());
        }
        if (Objects.nonNull(customer.getEmail())&&!"".equalsIgnoreCase(customer.getEmail())){
            cust.setEmail(customer.getEmail());
        }
        if (Objects.nonNull(customer.getKtpNumber())&&!"".equalsIgnoreCase(customer.getKtpNumber())){
            cust.setKtpNumber(customer.getKtpNumber());
        }
        if (Objects.nonNull(customer.getAddress())&&!"".equalsIgnoreCase(customer.getAddress())){
            cust.setAddress(customer.getAddress());
        }
        if (Objects.nonNull(customer.getPhoneNumber())&&!"".equalsIgnoreCase(customer.getPhoneNumber())){
            cust.setPhoneNumber(customer.getPhoneNumber());
        }
        return  customerRepository.save(cust);
    }

    public void deleteByIdCustomer(String id) {
        customerRepository.deleteById(id);
    }
    public Customer findByCustomerId(String customerId) {
        return customerRepository.findById(customerId).get();
    }
}
