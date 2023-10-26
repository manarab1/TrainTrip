package com.example.TrainTrip.Controller.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.junit.jupiter.api.Test;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class TicketControllerImplTest {

    @Autowired
    private MockMvc mvc;


    @Test
    void getAllTickets() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                        .get("/tickets")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.tickets").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.tickets[*].ticketsId").isNotEmpty());
    }


    @Test
    void getTicketById() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                        .get("/ticket/{id}", 1)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.ticketsId").value(1));
    }
  /*  @Test
    void createTicket() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                        .post("/traintrip")
                        .content(asJsonString(new Ticket(1L,booking:"mn",customer:"Manar" )))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.trainTripId").exists());
    }
}*/
}