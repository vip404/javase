package edu.ajz.masterWang.RTTI.proxy;

import static edu.ajz.masterWang.utils.MasterUtil.println;

/**
 * @ClassName RealObject
 * @Description TODO
 * @Author master wang
 * @Date 2019/5/19 18:15
 * @Version 1.0
 **/
public class RealObject implements InterFace {
    @Override
    public void doSomething() {
        println("doSomething");
    }

    @Override
    public void somethingElse(String arg) {
        println("somethingElse" + arg);
    }
}
