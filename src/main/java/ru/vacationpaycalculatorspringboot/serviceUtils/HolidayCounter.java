package ru.vacationpaycalculatorspringboot.serviceUtils;

import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;

public class HolidayCounter {
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
        String answer = HolidayAPIRequester.sendRequestAndGetAnswer(date.toString());
        return answer.equals("1");
    }
}
