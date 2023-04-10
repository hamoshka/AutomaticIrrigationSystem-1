package com.irrigation.system;

import java.time.LocalTime;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.irrigation.system.model.Plot;
import com.irrigation.system.repository.PlotRepository;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    private PlotRepository plotRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Plot plot1 = new Plot();
        plot1.setNo("1");
        plot1.setHasSensor("YES");
        plot1.setRetryCount(3);
        plot1.setTimeSlot(new Date());
        plot1.setIsIrrigated("YES");
        plot1.setWaterQty(10);
        plot1.setCropType("food");
        plot1.setCultivatedArea(100);
        plotRepository.save(plot1);

        Plot plot2 = new Plot();
        plot2.setNo("2");
        plot2.setHasSensor("YES");
        plot2.setRetryCount(5);
        plot2.setTimeSlot(new Date());
        plot2.setIsIrrigated("NO");
        plot2.setWaterQty(20);
        plot2.setCropType("food");
        plot2.setCultivatedArea(50);
        plotRepository.save(plot2);
    }
}

