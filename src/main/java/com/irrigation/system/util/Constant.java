package com.irrigation.system.util;

public class Constant {

    private Constant() {
    }

    public static final String SPLITTER_COMMA = ",";
    public static final String NEW_LINE = "\n";

    public static final String FILE_HEADER = "ID,PlotNumber,HasSensor,RetryCount,TimeSlot,IsIrrigated,WaterQuantity,CropType,CultivatedArea \n";
    public static final String WATER_QTY = " Litre";
    public static final String PLOT_AREA = " Sq.feet";
    public static final String FILE_SENSOR = "Sensor";
    public static final String FILE_ALERT = "Alert";
}
