package id.co.indivara.jdt12.mpcarrent;

import id.co.indivara.jdt12.mpcarrent.models.Rent;
import id.co.indivara.jdt12.mpcarrent.models.Vehicle;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Base64;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class VehicleTestCase {
//    @Autowired
//    private MockMvc mockMvc;
//    Vehicle vehicle = new Vehicle();
//
//    @Test
//    public void testSaveVehicle()throws Exception{
//    String vehicleJson="{\"vehicleName\": \"Alphard\"," +
//            " \"vehicleBrand\": \"Toyota\"," +
//            " \"vehiclePrice\": \"750000\"}";
//        ResultActions result = mockMvc.perform(post("/vehicle")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .header("Authorization", getAuthorizationHeader("admin", "password"))
//                        .content(vehicleJson))
//                .andExpect(MockMvcResultMatchers.status().isCreated());
//    }
//    @Test
//    public void testUpdateVehicle() throws Exception{
//        String customerJson="{\"vehicleName\": \"Alphard\"," +
//                " \"vehicleBrand\": \"Toyota\"," +
//                " \"vehiclePrice\": \"750000\"}";
//        ResultActions result = mockMvc.perform(put("/vehicle/{vehicleId}",vehicle.getVehicleId())
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .header("Authorization", getAuthorizationHeader("admin", "password"))
//                        .content(customerJson))
//                .andExpect(status().isOk());
//    }
//
//    @Test
//    public void testDeleteCustomer() throws Exception{
//        ResultActions result = mockMvc.perform(delete("/vehicle/{vehicleId}", vehicle.getVehicleId())
//                        .header("Authorization", getAuthorizationHeader("admin", "password")))
//                .andExpect(status().isOk());
//    }
//
//    public Vehicle getVehicle() {
//        vehicle.setVehicleId("dc4aff72-757f-48f3-8681-001fb6543830");
//        vehicle.setVehicleName("Alphard");
//        vehicle.setVehicleBrand("Toyota");
//        vehicle.setVehiclePrice(BigDecimal.valueOf(750000));
//        return vehicle;
//    }
//    private String getAuthorizationHeader(String username, String password) {
//        String credentials = username + ":" + password;
//        String encodedCredentials = Base64.getEncoder().encodeToString(credentials.getBytes());
//        return "Basic " + encodedCredentials;
//    }
}
