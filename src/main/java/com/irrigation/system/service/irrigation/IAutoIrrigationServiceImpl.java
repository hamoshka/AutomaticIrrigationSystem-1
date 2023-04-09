package com.irrigation.system.service.irrigation;

import java.util.ArrayList;
import java.util.Arrays;
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
public class IAutoIrrigationServiceImpl implements IAutoIrrigationService {


    @Autowired
    private PlotRepository plotRepository;

    @Override
    public List<Plot> checkPlotsForAutoIrrigation() {
        // Call for automatic irrigation on non-irrigated plots.
    	 List<Plot> iP = plotRepository.findByHasSensorAndIsIrrigated("YES", "NO");
    	    log.info("Total plots for auto irrigation: {}", iP.size());
    	    return iP.isEmpty() ? new ArrayList<>() : iP;
    }

    @Override
    public Integer updateIsIrrigated(String idS) {
        log.info("Update IsIrrigated IDs: {}", idS);
        List<Long> ids = Arrays.asList(idS.split(",")).stream().map(Long::parseLong).collect(Collectors.toList());
        return plotRepository.updateIsIrrigated(ids);
    }

    @Override
    public Integer updateRetryCount() {
        log.info("Update Retry count.");
       
        return plotRepository.updateSensorRetryCount();

    }
}
