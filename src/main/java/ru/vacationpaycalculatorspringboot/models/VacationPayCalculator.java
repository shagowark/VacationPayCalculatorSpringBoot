package ru.vacationpaycalculatorspringboot.models;

import java.time.LocalDate;

public class VacationPayCalculator {
    private double avgMonthSalary;
    private int numberOfVacationDays;
    private LocalDate firstDate;

    public VacationPayCalculator(double avgMonthSalary, int numberOfVacationDays, LocalDate firstDate) {
        this.avgMonthSalary = avgMonthSalary;
        this.numberOfVacationDays = numberOfVacationDays;
        this.firstDate = firstDate;
    }

    public VacationPayCalculator(double avgMonthSalary, int numberOfVacationDays) {
        this(avgMonthSalary, numberOfVacationDays, null);
    }


    public double getAvgMonthSalary() {
        return avgMonthSalary;
    }

    public void setAvgMonthSalary(int avgMonthSalary) {
        this.avgMonthSalary = avgMonthSalary;
    }

    public int getNumberOfVacationDays() {
        return numberOfVacationDays;
    }

    public void setNumberOfVacationDays(int numberOfVacationDays) {
        this.numberOfVacationDays = numberOfVacationDays;
    }

    public LocalDate getFirstDate() {
        return firstDate;
    }

    public void setFirstDate(LocalDate firstDate) {
        this.firstDate = firstDate;
    }
}
