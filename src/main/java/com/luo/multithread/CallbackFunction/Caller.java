package com.luo.multithread.CallbackFunction;

/**
 * @author：罗金星 date 2019/4/1 14:50
 **/
public class Caller {
    private MyCallInterface callInterface;

    public Caller() {
    }

    public void setCallFunc(MyCallInterface callInterface) {
        this.callInterface = callInterface;
    }

    public void call() {
        callInterface.printName();
    }
}
