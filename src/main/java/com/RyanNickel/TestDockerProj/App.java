package com.RyanNickel.TestDockerProj;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class App extends TimerTask {
    private static final Logger logger = LogManager.getLogger("HelloWorld");
    public void run() {
        logger.info("Timer task started at:"+new Date());
        completeTask();
        logger.info("Timer task finished at:"+new Date());
        logger.error("This is an error message...", new Exception("This is my exception, dawg"));
    }

    public void completeTask() {
        try {
            //assuming it takes 20 secs to complete the task
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println("Sweet, thanks!");
        TimerTask timerTask = new App();

        Timer timer = new Timer(true);
        timer.scheduleAtFixedRate(timerTask, 0, 10*1000);
        logger.info("TimerTask started");
        //cancel after sometime
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        timer.cancel();
        logger.info("TimerTask cancelled");
        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}