package com.example.TrainTrip.Controller.impl;
import com.example.TrainTrip.Entity.Booking;
import com.example.TrainTrip.Service.interfaces.BookingService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class BookingControllerImplTest {
    @Autowired
    private MockMvc mvc;
    private BookingService bookingService;
    private BookingControllerImpl bookingController;

    @Test
    void createBooking() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                        .post("/booking")
                        .content(asJsonString(new Booking()))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.bookingId").exists());
    }

    private String asJsonString(Object object) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(object);
    }


    @Test
    void getBookingById() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                        .get("/booking/{id}", 1)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.bookingId").value(1));
    }

    @Test
    void getBookingsByCustomerId() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                        .get("/booking/{CustomerId}", 1)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.BookingsByCustomerId").value(1));
    }

    @Test
    void getBookingsByTrainTripId() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                        .get("/booking/{TrainTripId}", 1)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.BookingsByTrainTripId").value(1));
    }

    @Test
    void updateBooking() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                        .put("/booking/{id}", 2)
                        .content(asJsonString(new Booking()))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.").value(""))
                .andExpect(MockMvcResultMatchers.jsonPath("$.").value(""))
                .andExpect(MockMvcResultMatchers.jsonPath("$.").value(9));
    }


    @Test
    void deleteBooking() throws Exception {

        {
            mvc.perform(MockMvcRequestBuilders.delete("/booking/{id}", 1))
                    .andExpect(status().isAccepted());
        }
    }
}