package ru.vacationpaycalculatorspringboot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import ru.vacationpaycalculatorspringboot.models.VacationPayCalculator;
import ru.vacationpaycalculatorspringboot.services.VacationPayCalculatorService;

import java.time.LocalDate;

@RestController
@RequestMapping("/calculate")
public class VacationPayCalculatorController {
    private final VacationPayCalculatorService calculatorService;

    @Autowired
    public VacationPayCalculatorController(VacationPayCalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    //TODO controller tests; new logic tests (first_day)
    @GetMapping
    public double calculate(@RequestParam("avg_salary") double salary,
                            @RequestParam("number_of_days") int days,
                            @RequestParam(value = "first_day", required = false) String firstDay) {

        LocalDate firstDate = null;

        if (firstDay != null) {
            if (!firstDay.matches("\\d{4}\\-\\d{2}\\-\\d{2}")) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
            }

            firstDate = LocalDate.parse(firstDay);
        }

        return calculatorService.calculate(
                new VacationPayCalculator(salary, days, firstDate));
    }
}
