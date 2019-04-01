package com.luo.multithread.ThreadReturn;

import java.util.concurrent.Callable;

/**
 * @author：罗金星 date 2019/4/1 15:24
 **/
public class MyCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
        String value="test";
        System.out.println("Ready to work");
        Thread.currentThread().sleep(5000);
        System.out.println("task done");
        return  value;
    }
}
