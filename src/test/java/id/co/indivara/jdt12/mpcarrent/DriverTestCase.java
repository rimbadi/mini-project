package id.co.indivara.jdt12.mpcarrent;

import id.co.indivara.jdt12.mpcarrent.models.Driver;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.Base64;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class DriverTestCase {
//    @Autowired
//    private MockMvc mockMvc;
//
//    Driver driver = new Driver();
//
//    @Test
//    public void testSaveDriver()throws Exception{
//        String driverJson="{\"driverName\": \"John Doe\"," +
//                " \"address\": \"johndoe@example.com\", " +
//                "\"driverPrice\": \"123456789\"," +
//                " \"phoneNumber\": \"123456789\"}";
//        ResultActions result = mockMvc.perform(post("/driver")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .header("Authorization", getAuthorizationHeader("admin", "password"))
//                        .content(driverJson))
//                .andExpect(status().isOk());
//    }
//    @Test
//    public void testUpdateDriver() throws Exception{
//        String driverJson="{\"driverName\": \"Doe\"," +
//                " \"address\": \"johndoe@example.com\", " +
//                " \"phoneNumber\": \"123456789\"}";
//        ResultActions result = mockMvc.perform(put("/driver/{driverId}",driver.getDriverId())
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(driverJson))
//                .andExpect(status().isOk());
//    }
//    @Test
//    public void testDeleteDriver() throws Exception{
//        ResultActions result = mockMvc.perform(delete("/driver/{driverId}", driver.getDriverId()))
//                .andExpect(status().isOk());
//    }
//    public Driver getDriver() {
//        driver.setDriverId("32cc9bad-e067-4b7e-a213-63ea14f94fdc");
//        return driver;
//    }
//    private String getAuthorizationHeader(String username, String password) {
//        String credentials = username + ":" + password;
//        String encodedCredentials = Base64.getEncoder().encodeToString(credentials.getBytes());
//        return "Basic " + encodedCredentials;
//    }
}
