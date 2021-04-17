package com.chopin.springschedulingtasks.Tasks;

import com.chopin.springschedulingtasks.tasks.ScheduledTasks;
import org.awaitility.Duration;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;

import static org.awaitility.Awaitility.await;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;

/**
 * @Description: TODO
 * @Author chopin
 * @Date 2021/4/17 3:37 PM
 * @Version 1.0
 */
@SpringBootTest
public class ScheduledTasksTest {
    @SpyBean
    ScheduledTasks scheduledTasks;
    @Test
    public void reportCurrentTime() {
        /**
         * Invoke `reportCurrentTime` 3 times in  10 seconds
         */
        await().atMost(Duration.TEN_SECONDS).untilAsserted(() -> {
            verify(scheduledTasks, atLeast(3)).reportCurrentTime();
        });
    }

    @Test
    public void testScheduledDelay() {
        await().atMost(Duration.TEN_SECONDS).untilAsserted(() -> {
            verify(scheduledTasks, atLeast(3)).scheduleFixedDelay();
        });
    }
}