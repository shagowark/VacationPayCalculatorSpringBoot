package ru.vacationpaycalculatorspringboot.services;

import org.springframework.stereotype.Service;
import ru.vacationpaycalculatorspringboot.models.VacationPayCalculator;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class VacationPayCalculatorService {
    private static final double AVG_DAYS_IN_MONTH = 29.3;
    private static final int DECIMAL_PLACES_ROUND = 2;
    private VacationPayCalculator calculator;

    private void updateCalculator(VacationPayCalculator calculator) {
        this.calculator = calculator;
    }

    public double calculate(VacationPayCalculator calculator) {
        updateCalculator(calculator);

        int holidaysCount = 0;
        if (calculator.getFirstDate() != null) {
            holidaysCount = HolidayCounter.countHolidays(calculator.getFirstDate(), calculator.getNumberOfVacationDays());
        }
        double avgDaySalary = calculator.getAvgMonthSalary() / AVG_DAYS_IN_MONTH;
        return round(avgDaySalary * (calculator.getNumberOfVacationDays() - holidaysCount));
    }

    private double round(double value) {
        return new BigDecimal(value).setScale(DECIMAL_PLACES_ROUND, RoundingMode.HALF_UP).doubleValue();
    }
}
