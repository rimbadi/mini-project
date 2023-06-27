package id.co.indivara.jdt12.mpcarrent.controller;

import id.co.indivara.jdt12.mpcarrent.models.Customer;
import id.co.indivara.jdt12.mpcarrent.services.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping("/customer")
    @ResponseStatus(HttpStatus.CREATED)
    public Customer saveCustomer( @RequestBody Customer customer)throws Exception{
        return customerService.saveCustomer(customer);
    }
    @PutMapping("/customer/{customerId}")
    public Customer updateCustomer(@RequestBody Customer customer,@PathVariable String customerId)throws Exception{
        return customerService.updateCustomer(customer,customerId);
    }
    @GetMapping("/customer")
    public List<Customer> fetchCustomerList(){
        return customerService.fetchCustomerList();
    }
    @DeleteMapping("/customer/{customerId}")
    public String deleteCustomer (@PathVariable String customerId){
        customerService.deleteByIdCustomer(customerId);
            return "Delete sukses";
    }
    @GetMapping("/customer/{customerId}")
    public Customer findByCustomerId(@PathVariable String customerId){
        return customerService.findByCustomerId(customerId);
    }
}
