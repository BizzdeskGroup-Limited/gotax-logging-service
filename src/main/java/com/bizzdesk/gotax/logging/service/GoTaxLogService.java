package com.bizzdesk.gotax.logging.service;

import com.bizzdesk.gotax.logging.entity.GoTaxLogs;
import com.bizzdesk.gotax.logging.mapper.GoTaxHelperToGoTaxMapper;
import com.bizzdesk.gotax.logging.repository.GoTaxLogsRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gotax.framework.library.helpers.GoTaxLogHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

@Service
public class GoTaxLogService {

    private GoTaxLogsRepository goTaxLogsRepository;

    @Autowired
    public GoTaxLogService(GoTaxLogsRepository goTaxLogsRepository) {
        this.goTaxLogsRepository = goTaxLogsRepository;
    }

    @ServiceActivator(inputChannel = "gotax_logs")
    public void writeTransactionsToMongoDB(Message<String> goTaxLogsMessage) {
        try {
            GoTaxLogHelper goTaxLogHelper = new ObjectMapper().readValue(goTaxLogsMessage.getPayload(), GoTaxLogHelper.class);
            GoTaxLogs goTaxLogs = GoTaxHelperToGoTaxMapper.toGoTaxLogs(goTaxLogHelper);
            goTaxLogsRepository.save(goTaxLogs);
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public Page<GoTaxLogs> getAllLogs(int pageIndex, int pageSize) {
        PageRequest pageRequest = PageRequest.of(pageIndex, pageSize);
        return goTaxLogsRepository.findAll(pageRequest);
    }
}
