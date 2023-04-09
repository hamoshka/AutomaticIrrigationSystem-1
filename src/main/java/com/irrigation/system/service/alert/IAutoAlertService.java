package com.irrigation.system.service.alert;

import java.util.List;

import com.irrigation.system.model.Plot;

public interface IAutoAlertService {
    public List<Plot> checkPlotsForAutoAlerting(Integer retryMax);
}
