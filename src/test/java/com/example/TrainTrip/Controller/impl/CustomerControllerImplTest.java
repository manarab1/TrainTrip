package com.example.TrainTrip.Controller.impl;
import com.example.TrainTrip.Entity.Customer;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CustomerControllerImpl.class)
@ActiveProfiles("test")
class CustomerControllerImplTest {
    @Autowired
    private MockMvc mvc;

    @Test
    void getAllCustomers() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                        .get("/customers")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.customers").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.customers[*].customersId").isNotEmpty());
    }

    @Test
    void getCustomerById() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                        .get("/customer/{id}", 1)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.customerId").value(1));
    }

    @Test
    void createCustomer() throws Exception {
        Customer customer = new Customer();
        customer.setCustomerId(1L);

        mvc.perform(MockMvcRequestBuilders
                        .post("/customer")
                        .content(asJsonString(customer))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.customerId").exists());
    }

    private String asJsonString(Object object) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(object);
    }

    @Test
    void deleteCustomer() throws Exception {
        mvc.perform(MockMvcRequestBuilders.delete("/customer/{id}", 1))
                .andExpect(status().isAccepted());
    }
}