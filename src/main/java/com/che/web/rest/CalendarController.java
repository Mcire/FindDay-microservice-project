package com.che.web.rest;

import com.che.service.HistoriqueService;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/services/calendar")
public class CalendarController {

    @Autowired
    private HistoriqueService historiqueService;

    @PostMapping("/dayfinder")
    public ResponseEntity<Map<String, String>> findDayOfWeek(@RequestBody Map<String, String> request) {
        String dateStr = request.get("date");
        String dayOfWeek = getDayOfWeekFromDate(dateStr);

        historiqueService.saveHistorique(dateStr, dayOfWeek);

        Map<String, String> response = new HashMap<>();
        response.put("date", dateStr);
        response.put("dayOfWeek", dayOfWeek);

        return ResponseEntity.ok(response);
    }

    private String getDayOfWeekFromDate(String dateStr) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate date = LocalDate.parse(dateStr, formatter);
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        return dayOfWeek.getDisplayName(TextStyle.FULL, Locale.FRENCH);
    }
}
