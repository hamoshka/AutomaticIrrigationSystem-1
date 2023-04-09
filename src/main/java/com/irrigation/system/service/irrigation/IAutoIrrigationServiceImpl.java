package com.irrigation.system.service.irrigation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.irrigation.system.model.Plot;
import com.irrigation.system.repository.PlotRepository;

@Service
public class IAutoIrrigationServiceImpl implements IAutoIrrigationService {

    private static final Logger LOG = LoggerFactory.getLogger(IAutoIrrigationServiceImpl.class);

    @Autowired
    private PlotRepository plotRepository;

    @Override
    public List<Plot> checkPlotsForAutoIrrigation() {
        // Call for automatic irrigation on non-irrigated plots.
    	 List<Plot> iP = plotRepository.findByHasSensorAndIsIrrigated("Y", "N");
    	    LOG.info("Total plots for auto irrigation: {}", iP.size());
    	    return iP.isEmpty() ? new ArrayList<>() : iP;
    }

    @Override
    public Integer updateIsIrrigated(String idS) {
        LOG.info("Update IsIrrigated IDs: {}", idS);
        List<Long> ids = Arrays.asList(idS.split(",")).stream().map(Long::parseLong).collect(Collectors.toList());
        return plotRepository.updateIsIrrigated(ids);
    }

    @Override
    public Integer updateRetryCount() {
        LOG.info("Update Retry count.");
       
        return plotRepository.updateSensorRetryCount();

    }
}
