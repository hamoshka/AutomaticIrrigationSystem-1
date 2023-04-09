package com.irrigation.system.config;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.irrigation.system.model.Plot;
import com.irrigation.system.service.alert.IAutoAlertService;
import com.irrigation.system.service.irrigation.IAutoIrrigationService;
import com.irrigation.system.util.Constant;
import com.irrigation.system.util.Helper;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class AutoIrrigationAlertScheduler {


    @Autowired
    private IAutoAlertService autoAlertService;

    @Autowired
    private IAutoIrrigationService autoIrrigationService;

    @Autowired
    private Helper helper;

    @Autowired
    private Properties prop;

    @Scheduled(cron = "${cron.expression}")
    public void checkAutoIrrigationAndAlert() {// 1. Call for Auto Irrigation.
        log.info("Checking plots for Automatic-Irrigation-Started.");
        
        // 1.1. Check the eligible plots.
        var iP = autoIrrigationService.checkPlotsForAutoIrrigation();
        if (!iP.isEmpty()) {
            // Generate irrigation csv file to send to sensor interface.
            helper.generateFile(iP, prop.getIrrFile(), Constant.FILE_SENSOR);
            
            // 1.2. Change the status to isIrrigated (Y).
            var pIdS = iP.stream().map(p -> String.valueOf(p.getId())).collect(Collectors.joining(Constant.SPLITTER_COMMA));
            var uI = autoIrrigationService.updateIsIrrigated(pIdS);
            log.info("Total plot to update the isIrrigated: {}", uI);
        }
        
        // 1.3. Update the retry count on non-sensor.
        var uR = autoIrrigationService.updateRetryCount();
        log.info("Total plot to update the retryCount: {}", uR);
        
        log.info("Checking plots for Automatic-Irrigation-End.");
        
        // 2. Call for Alerting on non-sensor and exceed the retry in plot.
        log.info("Checking plots for Automatic-Alerting-Started.");
        var aP = autoAlertService.checkPlotsForAutoAlerting(Integer.valueOf(prop.getRetryExceed()));
        if (!aP.isEmpty()) {
            // Generate alert csv file to send as attachment in mail (To be done).
            helper.generateFile(aP, prop.getAlertFile(), Constant.FILE_ALERT);
        }
        
        log.info("Checking plots for Automatic-Alerting-End.");}
}
