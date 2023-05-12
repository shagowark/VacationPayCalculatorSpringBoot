package ru.vacationpaycalculatorspringboot.services;

import org.springframework.web.client.RestTemplate;

import java.sql.ResultSet;
import java.time.LocalDate;

public class HolidayCounter {
    private static final RestTemplate restTemplate = new RestTemplate();
    private static final String API_URL = "https://isdayoff.ru/";
    public static int countHolidays(LocalDate firstDate, int numberOfDays){
        int count = 0;
        for (int i = 0; i < numberOfDays; i++){
            if (checkIfHoliday(firstDate)){
                count++;
            }
            firstDate = firstDate.plusDays(1);
        }

        return count;
    }

    private static boolean checkIfHoliday(LocalDate date){
        String answer = restTemplate.getForObject(API_URL + date.toString(), String.class);
        return answer.equals("1");
    }
}
