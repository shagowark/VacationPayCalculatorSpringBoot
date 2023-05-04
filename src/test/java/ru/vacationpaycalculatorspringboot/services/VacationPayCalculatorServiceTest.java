package ru.vacationpaycalculatorspringboot.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.vacationpaycalculatorspringboot.models.VacationPayCalculator;

import static org.junit.jupiter.api.Assertions.*;

class VacationPayCalculatorServiceTest {
    private static final VacationPayCalculatorService calculatorService = new VacationPayCalculatorService();

    @Test
    void calculate1() {
        Assertions.assertEquals(100000, calculatorService.calculate(new VacationPayCalculator(293000, 10)));
    }

    @Test
    void calculate2() {
        Assertions.assertEquals(22500, calculatorService.calculate(new VacationPayCalculator(43950, 15)));
    }

    @Test
    void calculate3() {
        Assertions.assertEquals(3.6, calculatorService.calculate(new VacationPayCalculator(17.58, 6)));
    }

    @Test
    void calculate4() {
        Assertions.assertEquals(10989.76, calculatorService.calculate(new VacationPayCalculator(23000, 14)));
    }
}