package com.luo.multithread.CallbackFunction;

/**
 * @author：罗金星 date 2019/4/1 14:51
 **/
public class Client implements MyCallInterface {

    @Override
    public void printName() {
        System.out.println("This is the client printName method");
    }
}
