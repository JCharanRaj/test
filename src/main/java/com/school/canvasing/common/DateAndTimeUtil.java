package com.school.canvasing.common;


import java.time.LocalDateTime;
import java.time.ZoneId;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class DateAndTimeUtil {

    private static final Logger logger = LoggerFactory.getLogger(DateAndTimeUtil.class);

    public static String TIMEZONE;

    @Value("${timezone}")
    public void setTimezone(String timezone) {
        TIMEZONE = timezone;
    }


    public static LocalDateTime now(){
        logger.info("Timezone from properties: " + DateAndTimeUtil.TIMEZONE);
        return LocalDateTime.now(ZoneId.of(DateAndTimeUtil.TIMEZONE));
    }


}
