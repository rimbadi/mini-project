package id.co.indivara.jdt12.mpcarrent;

import id.co.indivara.jdt12.mpcarrent.models.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class CustomerTestCase {
    @Autowired
    private MockMvc mockMvc;
    Customer customer = new Customer();

    @Test
    public void testSaveCustomer()throws Exception{
    String customerJson="{\"name\": \"John Doe\"," +
            " \"email\": \"johndoe@example.com\"," +
            " \"address\": \"johndoe@example.com\", " +
            "\"ktpNumber\": \"123456789\"," +
            " \"phoneNumber\": \"123456789\"}";
        ResultActions result = mockMvc.perform(post("/customer")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(customerJson))
                .andExpect(status().isOk());
    }

    @Test
    public void testUpdateCustomer() throws Exception{
        String customerJson="{" +
                "\"name\": \"John\"," +
                " \"email\": \"johndoe@example.com\"," +
                " \"address\": \"johndoe@example.com\", " +
                "\"ktpNumber\": \"123456789\"," +
                " \"phoneNumber\": \"123456789\"}";
        ResultActions result = mockMvc.perform(put("/customer/{customerId}",customer.getCustomerId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(customerJson))
                .andExpect(status().isOk());
    }

    @Test
    public void testDeleteCustomer() throws Exception{
        ResultActions result = mockMvc.perform(delete("/customer/{customerId}", customer.getCustomerId()))
                .andExpect(status().isOk());
    }

    public Customer getCustomer() {
        customer.setCustomerId("ea1a39b7-ac33-46d1-bf1f-562bff641c6e");
        return customer;
    }
}
