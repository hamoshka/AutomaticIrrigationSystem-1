package com.irrigation.system.service.irrigation;

import java.util.List;

import com.irrigation.system.model.Plot;

public interface IAutoIrrigationService {
    public List<Plot> checkPlotsForAutoIrrigation();

    public Integer updateIsIrrigated(String idS);

    public Integer updateRetryCount();
}
