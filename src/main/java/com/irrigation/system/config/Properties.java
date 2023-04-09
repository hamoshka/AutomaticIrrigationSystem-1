package com.irrigation.system.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class Properties {

    @Value("${crop.types}")
    private String cropTypes;

    @Value("${irrigation.file}")
    private String irrFile;

    @Value("${retry.exceed}")
    private String retryExceed;

    @Value("${alert.file}")
    private String alertFile;

    public String getCropTypes() {
        return cropTypes;
    }

    public String getIrrFile() {
        return irrFile;
    }

    public String getRetryExceed() {
        return retryExceed;
    }

    public String getAlertFile() {
        return alertFile;
    }
}
