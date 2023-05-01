package com.transaction.accountcustomer.controller;

import com.transaction.accountcustomer.model.ReportModel;
import com.transaction.accountcustomer.service.ReportService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

@RestController
@RequestMapping("/report")
@Slf4j
@RequiredArgsConstructor
public class ReportController {
    private final ReportService reportService;

    @GetMapping("/balance")
    public Flux<ReportModel> getReport(@RequestParam("startDate") Date startDate, @RequestParam("endDate") Date endDate){
        log.info("date: {}, date1: {}",startDate,endDate);
        log.info("getReport...");
        LocalDate startLocalDate = startDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate endLocalDate = endDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        return reportService.getBalanceByDate(startLocalDate,endLocalDate);
    }

}
