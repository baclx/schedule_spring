package com.example.schedule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
@SpringBootApplication
public class ScheduleApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScheduleApplication.class, args);

        printTime();
    }

//    This option should be used when it’s mandatory that the previous execution is completed before running again.
//    @Scheduled(fixedDelay = 1000)
//    public void scheduleFixedDelayTask() {
//        System.out.println("Fixed delay task - " + System.currentTimeMillis() / 1000);
//    }

//    @Scheduled(fixedRate = 1000)
//    public void scheduleFixedRateTask() {
//        System.out.println("Fixed rate task - " + System.currentTimeMillis() / 1000);
//    }

//    Fixed Rate vs Fixed Delay
//    - The fixedDelay property makes sure that there is a delay of n millisecond between the finish time of an execution of a task and
//          the start time of the next execution of the task.
//    - The fixedRate property runs the scheduled task at every n millisecond. It doesn't check for any previous executions of the task.

    // initialDelay - Hoãn 5s r mới gọi fixedDelay -> 15s

    public static void printTime() {
        System.out.println("before initial delay (5s) - " + System.currentTimeMillis() / 1000);
    }

    @Scheduled(fixedDelay = 10000, initialDelay = 5000)
    public void scheduleFixedRateWithInitialDelayTask() {

        long now = System.currentTimeMillis() / 1000;
        System.out.println(
                "Fixed rate (? delay) task with one second initial delay - " + now);
    }

    // cron // (cron = "0 0/1 * * * ? - , / L W #")
    // executed at 10:15 AM on the 15th day of every month.
//    @Scheduled(cron = "0 15 10 15 * ?")
//    public void scheduleTaskUsingCronExpression() {
//
//        long now = System.currentTimeMillis() / 1000;
//        System.out.println(
//                "schedule tasks using cron jobs - " + now);
//    }
}
