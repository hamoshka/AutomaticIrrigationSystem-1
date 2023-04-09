package com.irrigation.system.service.plot;

import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("has_sensor", pS);
        parameters.put("no", pN);

		/*
		 * return jdbcIrr.update(Constant.SQL_CONFIG_PLOT, parameters);
		 */
    return  null;
    }

    @Override
    public Integer updatePlot(Plot uP) {
        //Updating the plot.
        LOG.info("Update the plot id: {}", uP.getId());
      
        Object[] parameters = {uP.getNo(),uP.getHasSensor(),uP.getTimeSlot(),uP.getIsIrrigated(), uP.getWaterQty(),
        		uP.getCropType(), uP.getCultivatedArea(),uP.getId()};
        int[] types = {Types.VARCHAR,Types.VARCHAR,Types.DATE,Types.VARCHAR,Types.NUMERIC,Types.VARCHAR,Types.NUMERIC,Types.NUMERIC};
      
		/*
		 * return jdbcIrr.update(Constant.SQL_UPDATE_PLOT, parameters,types);
		 */
        
        return null;
    }

    @Override
    public List<Plot> getPlots() {
        //Get all plot.
    	List<Plot> gP = plotRepository.findAll();
    	LOG.info("Total plot: {}", gP.size());
    	return gP.isEmpty() ? new ArrayList<>() : gP;

    }

	@SuppressWarnings("deprecation")
	@Override
	public Plot findById(Long plotId) {
		/*
		 * return jdbcIrr.queryForObject("SELECT * FROM plot WHERE id = ?", new
		 * Object[]{plotId}, (rs, rowNum) -> new Plot( rs.getLong("id"),
		 * rs.getString("no"), rs.getString("has_sensor"),
		 * rs.getInt("SENSOR_RETRY_COUNT"), rs.getDate("TIME_SLOT"),
		 * rs.getString("IS_IRRIGATED"), rs.getInt("WATER_QUANTITY"),
		 * rs.getString("CROP_TYPE"), rs.getInt("CULTIVATED_AREA") ));
		 */
		return null;
	}
}
