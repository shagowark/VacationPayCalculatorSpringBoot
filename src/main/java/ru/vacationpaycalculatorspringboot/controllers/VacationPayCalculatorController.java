package ru.vacationpaycalculatorspringboot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.vacationpaycalculatorspringboot.models.VacationPayCalculator;
import ru.vacationpaycalculatorspringboot.services.VacationPayCalculatorService;

@RestController
@RequestMapping("/calculate")
public class VacationPayCalculatorController {
    private final VacationPayCalculatorService calculatorService;

    @Autowired
    public VacationPayCalculatorController(VacationPayCalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    //TODO: controller tests; @ModelAttribute?
    @GetMapping
    public double calculate(@RequestParam("avg_salary") double salary, @RequestParam("number_of_days") int days) {
        return calculatorService.calculate(new VacationPayCalculator(salary, days));
    }
}
