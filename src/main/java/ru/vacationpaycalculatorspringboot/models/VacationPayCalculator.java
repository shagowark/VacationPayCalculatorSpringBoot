package ru.vacationpaycalculatorspringboot.models;

public class VacationPayCalculator {
    private double avgMonthSalary;
    private int numberOfVacationDays;

    public VacationPayCalculator(double avgMonthSalary, int numberOfVacationDays) {
        this.avgMonthSalary = avgMonthSalary;
        this.numberOfVacationDays = numberOfVacationDays;
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
}
