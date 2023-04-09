package com.irrigation.system.service.alert;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.irrigation.system.model.Plot;
import com.irrigation.system.repository.PlotRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@Slf4j
public class IAutoAlertServiceImpl implements IAutoAlertService {


    @Autowired
    private PlotRepository plotRepository;

    @Override
    public List<Plot> checkPlotsForAutoAlerting(Integer retryMax) {
        //Call for filtering plots for automatic alerting for non sensor and retry exceed.
    	List<Plot> alertP = plotRepository.findByHasSensorAndRetryCountGreaterThan("NO", 1);
    	log.info("Total plot to check for alert: {}", alertP.size());

    	List<Plot> aP = alertP.stream()
    	        .filter(p -> p.getRetryCount() > retryMax)
    	        .collect(Collectors.toList());

    	log.info("Alert retry max: {}, plot count: {}", retryMax, aP.size());
    	return aP.isEmpty() ? new ArrayList<>() : aP;

    }
}
