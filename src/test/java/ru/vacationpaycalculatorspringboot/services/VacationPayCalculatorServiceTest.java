package ru.vacationpaycalculatorspringboot.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.vacationpaycalculatorspringboot.models.VacationPayCalculator;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class VacationPayCalculatorServiceTest {
    private static final VacationPayCalculatorService calculatorService = new VacationPayCalculatorService();

    @Test
    void calculateWithoutFirstDay1() {
        Assertions.assertEquals(100000, calculatorService.calculate(
                new VacationPayCalculator(293000, 10)));
    }

    @Test
    void calculateWithoutFirstDay2() {
        Assertions.assertEquals(22500, calculatorService.calculate(
                new VacationPayCalculator(43950, 15)));
    }

    @Test
    void calculateWithoutFirstDay3() {
        Assertions.assertEquals(3.6, calculatorService.calculate(
                new VacationPayCalculator(17.58, 6)));
    }

    @Test
    void calculateWithoutFirstDay4() {
        Assertions.assertEquals(10989.76, calculatorService.calculate(
                new VacationPayCalculator(23000, 14)));
    }

    @Test
    void calculateWithoutFirstDay5() {
        Assertions.assertEquals(0, calculatorService.calculate(
                new VacationPayCalculator(9000, 0)));
    }

    @Test
    void calculateWithFirstDay1(){
        Assertions.assertEquals(2000, calculatorService.calculate(
                new VacationPayCalculator(29300, 2, LocalDate.parse("2023-05-15"))));
    }

    @Test
    void calculateWithFirstDay2(){
        Assertions.assertEquals(2000, calculatorService.calculate(
                new VacationPayCalculator(29300, 4, LocalDate.parse("2023-07-08"))));
    }

    @Test
    void calculateWithFirstDay3(){
        Assertions.assertEquals(3.0, calculatorService.calculate(
                new VacationPayCalculator(17.58, 6, LocalDate.parse("2022-04-18"))));
    }

    @Test
    void calculateWithFirstDay4(){
        Assertions.assertEquals(0, calculatorService.calculate(
                new VacationPayCalculator(17.58, 0, LocalDate.parse("2022-04-18"))));
    }

    @Test
    void calculateWithFirstDay5(){
        Assertions.assertEquals(0, calculatorService.calculate(
                new VacationPayCalculator(17.58, 6, LocalDate.parse("2021-01-03"))));
    }
}