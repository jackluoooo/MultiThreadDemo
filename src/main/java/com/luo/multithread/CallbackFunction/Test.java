package com.luo.multithread.CallbackFunction;

/**
 * @author：罗金星 date 2019/4/1 14:52
 **/
public class Test {
    public static void main(String[] args) {
        Caller caller = new Caller();
        caller.setCallFunc(new Client());
        /**
         * 通过接口回调方法
         */
        caller.call();
    }
}
