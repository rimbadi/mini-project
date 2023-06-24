package id.co.indivara.jdt12.mpcarrent;

import id.co.indivara.jdt12.mpcarrent.models.Rent;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.time.Instant;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class RentTestCase {
    @Autowired
    private MockMvc mockMvc;
    Rent rent = new Rent();

    @Test
    public void testSaveRent()throws Exception{
        String rentJson="{\"customerId\": \"ea1a39b7-ac33-46d1-bf1f-562bff641c6e\"," +
                " \"driverId\": \"9f764368-e979-4ad8-816a-795ec402be59\"," +
                " \"vehicleId\": \"bb7a3212-ef38-440b-9aa6-6fba72868cad\", " +
                "\"startHour\": \"2023-06-23 19:30:00\"}";
        ResultActions result = mockMvc.perform(post("/rent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(rentJson))
                .andExpect(status().isOk());
    }

    public Rent getRent() {
        rent.setCustomerId("ea1a39b7-ac33-46d1-bf1f-562bff641c6e");
        rent.setDriverId("9f764368-e979-4ad8-816a-795ec402be59");
        rent.setVehicleId("bb7a3212-ef38-440b-9aa6-6fba72868cad");
        rent.setStartHour(Instant.parse("2023-06-23 19:30:00"));
        return rent;
    }
}
