package com.luo.multithread.ThreadReturn;

import java.util.concurrent.FutureTask;

/**
 * @author：罗金星 date 2019/4/1 15:30
 **/
public class FutureTaskDemo {
    public static void main(String[] args) throws Exception{
        FutureTask<String> task=new FutureTask<String>(new MyCallable());
        new Thread(task).start();
        if(!task.isDone()){
            System.out.println("task has not finished, please wait");
        }
        //执行完才返回
        System.out.println("task return "+ task.get());
    }
}
