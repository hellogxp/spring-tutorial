package com.chopin.springschedulingtasks.tasks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description: TODO
 * @Author chopin
 * @Date 2021/4/17 9:44 AM
 * @Version 1.0
 */
@Component
public class ScheduledTasks {
    private static final Logger LOGGER = LoggerFactory.getLogger(ScheduledTasks.class);
    private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 1000)
    public void reportCurrentTime() {
        LOGGER.info("The time is now {}", simpleDateFormat.format(new Date()));
    }

    @Scheduled(fixedDelay = 1000, initialDelay = 1000)
    public void scheduleFixedDelay() {
        long now = System.currentTimeMillis() / 1000;
        LOGGER.info("Fixed delay with one second initial delay: {}", now);
    }

    /**
     * Scheduling a task to be executed at 10:15 AM on the 15th of each month
     *  ┌───────────── second (0-59)
     *  │ ┌───────────── minute (0 - 59)
     *  │ │ ┌───────────── hour (0 - 23)
     *  │ │ │ ┌───────────── day of the month (1 - 31)
     *  │ │ │ │ ┌───────────── month (1 - 12) (or JAN-DEC)
     *  │ │ │ │ │ ┌───────────── day of the week (0 - 7)
     *  │ │ │ │ │ │          (or MON-SUN -- 0 or 7 is Sunday)
     *  │ │ │ │ │ │
     *  * * * * * *
     */
    @Scheduled(cron = "0 15 10 15 * ?")
    public void scheduledWithCron() {
        LOGGER.info("The time is now {}", simpleDateFormat.format(new Date()));
    }

}