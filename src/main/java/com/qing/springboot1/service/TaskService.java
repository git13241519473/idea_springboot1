package com.qing.springboot1.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TaskService {

    /**
     * 使用 spring 自带的定时任务
     * ①、在启动类上添加注解 @EnableScheduling
     * ②、在执行方法上使用注解 @Scheduled()
     */


    //@Scheduled(cron = "* * * * * ?") //每秒执行一次
    @Scheduled(fixedRate = 2 * 1000, initialDelay = 10 * 1000) //间隔时间执行任务, 第一次执行前延迟时间
    /*
    这里有一篇文章 ：
    https://blog.csdn.net/czx2018/article/details/83501945
    https://www.cnblogs.com/domi22/p/9418433.html
    是介绍 fixedDelay 和 fixedRate 的区别。
     */
    public void runTask(){
        System.out.println("定时任务哟！"+ new Date().toLocaleString());
    }

}
