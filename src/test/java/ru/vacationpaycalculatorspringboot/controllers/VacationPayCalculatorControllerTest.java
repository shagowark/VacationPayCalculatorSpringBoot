package ru.vacationpaycalculatorspringboot.controllers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import ru.vacationpaycalculatorspringboot.models.VacationPayCalculator;
import ru.vacationpaycalculatorspringboot.services.VacationPayCalculatorService;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class VacationPayCalculatorControllerTest {

    VacationPayCalculatorController calculatorController = new VacationPayCalculatorController(new VacationPayCalculatorService());
    MockMvc mockMvc = MockMvcBuilders.standaloneSetup(calculatorController).build();

    //TODO clean code
    @Test
    void getCalculateWithoutFirstDay1() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/calculate"))
                .andExpect(status().is4xxClientError());
    }

    @Test
    void getCalculateWithoutFirstDay2() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/calculate")
                .param("avg_salary",  "29300")
                .param("number_of_days", "10"))
                .andExpect(status().isOk());
    }

    @Test
    void getCalculateWithFirstDay1() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/calculate")
                .param("avg_salary",  "29300")
                .param("number_of_days", "10")
                .param("first_day", "2023-01-02"))
                .andExpect(status().isOk());
    }

    @Test
    void getCalculateWithFirstDay2() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/calculate")
                        .param("avg_salary",  "29300")
                        .param("number_of_days", "10")
                        .param("first_day", "20-01-02"))
                .andExpect(status().is4xxClientError());
    }
}