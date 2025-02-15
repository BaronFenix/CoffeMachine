package com.example.CoffeMachine.services.impl;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.CoffeMachine.dto.HolidaysDataDto;
import com.example.CoffeMachine.services.HolidayService;

@Service
public class HolidayServiceImpl implements HolidayService {

    @Autowired
    RestTemplate restTemplate;

    private final String url = "https://date.nager.at/api/v3/PublicHolidays/2025/KZ"; 


    @Override
    public boolean isWorking() {
        return !isHoliday() && !isWeekend() && isWorkTime() ? true : false;
    }


    @Cacheable("holidays")
    private List<HolidaysDataDto> fetchHolidaysDate()
    {
        HolidaysDataDto[] dates = restTemplate.getForObject(url, HolidaysDataDto[].class);
        return List.of(dates);
    }

    @SuppressWarnings("unlikely-arg-type")
    private boolean isHoliday() {
        List<HolidaysDataDto> holidays = fetchHolidaysDate();

        return holidays.contains(LocalDate.now()) ? true : false;
    }

    private boolean isWorkTime() {
        LocalTime time = LocalTime.now();
        return time.isAfter(LocalTime.of(8, 0)) && time.isBefore(LocalTime.of(17, 0))
        ? true 
        : false;
    }

    private boolean isWeekend() {
        LocalDate date = LocalDate.now();
        return date.getDayOfWeek() == DayOfWeek.SATURDAY || date.getDayOfWeek() == DayOfWeek.SUNDAY
        ? true 
        : false;
    }
    
}
