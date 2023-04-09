package com.irrigation.system.service.plot;

import java.util.List;

import com.irrigation.system.model.Plot;

public interface IPlotService {

    public Integer addPlot(Plot nP);

    public Integer configPlot(String pN, String pS);

    public Integer updatePlot(Plot uP);

    public List<Plot> getPlots();

	public Plot findById(Long plotId);
}
