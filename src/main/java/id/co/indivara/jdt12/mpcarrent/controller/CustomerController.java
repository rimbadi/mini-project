package id.co.indivara.jdt12.mpcarrent.controller;

import id.co.indivara.jdt12.mpcarrent.models.Customer;
import id.co.indivara.jdt12.mpcarrent.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping("/customer")
    public Customer saveCustomer(@RequestBody Customer customer){
        return customerService.saveCustomer(customer);
    }
    @PutMapping("/customer/{id}")
    public Customer updateCustomer(@RequestBody Customer customer, @PathVariable Long id) throws Exception{
        return customerService.updateCustomer(customer,id);
    }
    @GetMapping("/customer")
    public List<Customer> fetchCustomerList(){
        return customerService.fetchCustomerList();
    }
    @DeleteMapping("/customer/{customerId}")
        public String deleteCustomer (@PathVariable Long customerId){
         customerService.deleteByIdCustomer(customerId);
         return "Delete sukses";
    }

}
