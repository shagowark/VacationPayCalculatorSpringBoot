package ru.vacationpaycalculatorspringboot.serviceUtils;

import org.springframework.web.client.RestTemplate;

public class HolidayAPIRequester {
    private static final RestTemplate restTemplate = new RestTemplate();
    private static final String API_URL = "https://isdayoff.ru/";

    public static String sendRequestAndGetAnswer(String date){
        return restTemplate.getForObject(API_URL + date.toString(), String.class);
    }
}
