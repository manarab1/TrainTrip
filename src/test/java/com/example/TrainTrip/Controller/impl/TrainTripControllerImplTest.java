package com.example.TrainTrip.Controller.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.example.TrainTrip.Entity.TrainTrip;
import org.junit.jupiter.api.Test;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class TrainTripControllerImplTest {
    @Autowired
    private MockMvc mvc;

    @Test
    void getAllTrainTrips() throws Exception
    {
        mvc.perform(MockMvcRequestBuilders
                        .get("/traintrip")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.traintraip").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.traintrip[*].trainTripId").isNotEmpty());
    }


    @Test
    void getTrainTripById() throws Exception
    {
        mvc.perform( MockMvcRequestBuilders
                        .get("/traintrip/{id}", 1)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.trainTripId").value(1));
    }


    @Test
    void createTrainTrip() throws Exception {
       mvc.perform(MockMvcRequestBuilders
       .post("/traintrip")
       .content(asJsonString(new TrainTrip("Dammam", "3:30pm", 10)))
        .contentType(MediaType.APPLICATION_JSON)
         .accept(MediaType.APPLICATION_JSON))
         .andExpect(status().isCreated())
         .andExpect(MockMvcResultMatchers.jsonPath("$.trainTripId").exists());
    }

    private String asJsonString(Object object) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(object);
    }



    @Test
    void updateTrainTrip() throws Exception
    {
        mvc.perform( MockMvcRequestBuilders
                        .put("/traintrip/{id}", 2)
                        .content(asJsonString(new TrainTrip("Jeddah","2023-10-31 10:00",10)))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.destination").value("Jeddah"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.departureTime").value("12:00pm"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.availableSeats").value(4));
    }


    @Test
    void deleteTrainTrip() throws Exception
    {
        mvc.perform( MockMvcRequestBuilders.delete("/traintrip/{id}", 1) )
                .andExpect(status().isAccepted());
    }
    }
