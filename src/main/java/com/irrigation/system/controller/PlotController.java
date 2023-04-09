package com.irrigation.system.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.irrigation.system.config.Properties;
import com.irrigation.system.model.Plot;
import com.irrigation.system.service.plot.IPlotService;
import com.irrigation.system.util.Helper;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/plots")
public class PlotController {

    private static final Logger LOG = LoggerFactory.getLogger(PlotController.class);

    @Autowired
    private Properties prop;

    @Autowired
    private Helper helper;

    @Autowired
    private IPlotService plotService;


    @PostMapping(value = "/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody Plot nP) {
        LOG.info("Requested to add new plot.");
        if ((nP != null) && helper.getList(prop.getCropTypes()).contains(nP.getCropType())) {
            Integer a = plotService.addPlot(nP);
            LOG.info("Added result: {}", a);
        } else
            LOG.info("Use one of the crop type(food,cash,drug).");
    }
    
    @GetMapping("/get/{id}")
	public ResponseEntity<Plot> get(@PathVariable(value = "id") Long plotId)
			 {
    	Plot plot = plotService.findById(plotId);
		return ResponseEntity.ok().body(plot);
	}

    @PatchMapping(value = "/config/{pNo}/{hasSensor}")
    @ResponseStatus(HttpStatus.OK)
    public void config(@PathVariable("pNo") String pNo, @PathVariable("hasSensor") String hasSensor) {
        LOG.info("Requested to config the plot on sensor field.");
        Integer c = plotService.configPlot(pNo, hasSensor);
        LOG.info("Configured result: {}", c);
    }

    @PostMapping(value = "/update")
    @ResponseStatus(HttpStatus.OK)
    public void update(@RequestBody Plot uP) {
        LOG.info("Requested to update the plot.");
        //Update the plot from uP by no
        Integer u = plotService.updatePlot(uP);
        LOG.info("Updated result: {}", u);
    }

    @GetMapping(value = "/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Plot> getPlots() {
        LOG.info("Requested to get all plot.");
        return plotService.getPlots();
    }
}
