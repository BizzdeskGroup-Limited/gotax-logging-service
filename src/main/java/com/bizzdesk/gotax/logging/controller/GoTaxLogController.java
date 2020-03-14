package com.bizzdesk.gotax.logging.controller;

import com.bizzdesk.gotax.logging.entity.GoTaxLogs;
import com.bizzdesk.gotax.logging.service.GoTaxLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GoTaxLogController {

    GoTaxLogService goTaxLogService;

    @Autowired
    public GoTaxLogController(GoTaxLogService goTaxLogService) {
        this.goTaxLogService = goTaxLogService;
    }

    @CrossOrigin
    @GetMapping(value = "/v1/getAllLogs")
    public Page<GoTaxLogs> findAllLogs(@RequestParam(name = "pageIndex") int pageIndex, @RequestParam(name = "pageSize") int pageSize) {
        return goTaxLogService.getAllLogs(pageIndex, pageSize);
    }
}
