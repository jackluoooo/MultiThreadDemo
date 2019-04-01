package com.luo.multithread.ThreadReturn;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author：罗金星 date 2019/4/1 15:54
 **/
public class ThreadPoolDemo {
    public static void main(String[] args) {
        ExecutorService newCacheThreadPool = Executors.newCachedThreadPool();
        Future<String> submit = newCacheThreadPool.submit(new MyCallable());
        if(!submit.isDone()){
            System.out.println("task has not finished, please wait");
        }
        //执行完才返回
        try {
            System.out.println("task return "+ submit.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
