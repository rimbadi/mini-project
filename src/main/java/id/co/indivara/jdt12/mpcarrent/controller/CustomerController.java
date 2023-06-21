package id.co.indivara.jdt12.mpcarrent.controller;

import id.co.indivara.jdt12.mpcarrent.models.Customer;
import id.co.indivara.jdt12.mpcarrent.services.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping("/customer")
    public Customer saveCustomer(@RequestBody Customer customer){
        return customerService.saveCustomer(customer);
    }
    @PutMapping("/customer/{customerId}")
    public Customer updateCustomer(@RequestBody Customer customer, @PathVariable Long customerId) throws Exception{
        return customerService.updateCustomer(customer,customerId);
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
    //TODO: FindbyId

}
