package com.irrigation.system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.irrigation.system.config.Properties;
import com.irrigation.system.model.Plot;
import com.irrigation.system.service.plot.IPlotService;
import com.irrigation.system.util.Helper;

import lombok.extern.slf4j.Slf4j;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/plots")
@Slf4j
public class PlotController {


    @Autowired
    private Properties prop;

    @Autowired
    private Helper helper;

    @Autowired
    private IPlotService plotService;


    @PostMapping(value = "/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody Plot nP) {
    	 log.info("Requested to add new plot.");
    	    if ((nP != null) && helper.getList(prop.getCropTypes()).contains(nP.getCropType())) {
    	        var result = plotService.addPlot(nP);
    	        log.info("Added result: {}", result);
    	    } else {
    	        log.info("Use one of the crop types(food,cash,drug).");
    	    }
    }
    
    @GetMapping("/get/{id}")
	public ResponseEntity<Plot> get(@PathVariable(value = "id") Long plotId)
			 {
    	var plot = plotService.findById(plotId);
		return ResponseEntity.ok().body(plot);
	}

    @PatchMapping(value = "/config/{pNo}/{hasSensor}")
    @ResponseStatus(HttpStatus.OK)
    public void config(@PathVariable("pNo") String pNo, @PathVariable("hasSensor") String hasSensor) {
        log.info("Requested to config the plot on sensor field.");
        var c = plotService.configPlot(pNo, hasSensor);
        log.info("Configured result: {}", c);
    }

    @PostMapping(value = "/update")
    @ResponseStatus(HttpStatus.OK)
    public void update(@RequestBody Plot uP) {
        log.info("Requested to update the plot.");
        //Update the plot from uP by no
        var u = plotService.updatePlot(uP);
        log.info("Updated result: {}", u);
    }

    @GetMapping(value = "/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Plot> getPlots() {
        log.info("Requested to get all plot.");
        return plotService.getPlots();
    }
}
