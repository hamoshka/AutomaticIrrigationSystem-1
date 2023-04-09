package com.irrigation.system.service.plot;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.irrigation.system.model.Plot;
import com.irrigation.system.repository.PlotRepository;

@Service
public class IPlotServiceImpl implements IPlotService {

    private static final Logger LOG = LoggerFactory.getLogger(IPlotServiceImpl.class);

    @Autowired
    private PlotRepository plotRepository;

    @SuppressWarnings("unused")
	@Override
    public Integer addPlot(Plot nP) {
        // Add the new plot.
        LOG.info("Adding the new plot.");

       Plot plot = Plot.builder().no(nP.getNo()).hasSensor(nP.getHasSensor()).retryCount(nP.getRetryCount()).
        timeSlot(nP.getTimeSlot()).isIrrigated(nP.getIsIrrigated()).waterQty(nP.getWaterQty()).
        cropType(nP.getCropType()).cultivatedArea(nP.getCultivatedArea()).build();
        Plot savedPlot = plotRepository.save(nP);

        return savedPlot.getId().intValue();
    }

    @Override
    public Integer configPlot(String pN, String pS) {
        //Configuring the plot on sensor field.
        LOG.info("Configure the plot no: {}", pN);
    return  plotRepository.updateHasSensorByNo(pS, pN);
    }

    @Override
    public Integer updatePlot(Plot uP) {
        //Updating the plot.
        LOG.info("Update the plot id: {}", uP.getId());
         Plot updatedPlot = plotRepository.save(uP);
        return updatedPlot.getId().intValue();
    }

    @Override
    public List<Plot> getPlots() {
        //Get all plot.
    	List<Plot> gP = plotRepository.findAll();
    	LOG.info("Total plot: {}", gP.size());
    	return gP.isEmpty() ? new ArrayList<>() : gP;

    }

	@Override
	public Plot findById(Long plotId) {

		Optional<Plot> plot = plotRepository.findById(plotId);
		return plot.orElse(null);

	}
}
