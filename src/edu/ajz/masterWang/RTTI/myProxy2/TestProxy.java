package edu.ajz.masterWang.RTTI.myProxy2;

import java.lang.reflect.Proxy;

import static edu.ajz.masterWang.utils.MasterUtil.println;


/**
 * @ClassName TestProxy
 * @Description TODO
 * @Author 14133
 * @Date 2019/5/21 19:13
 * @Version 1.0
 **/
public class TestProxy {


    public static void main(String[] args) {
        println("静态代理：");
        testStaticProxy();
        println("动态代理：");
        testDynamicProxy();
    }

    /**
     * 测试静态代理
     */
    public static void testStaticProxy() {
        Go2WorkByBike go2WorkByBike = new Go2WorkByBike();
        StaticWorkProxy staticWorkProxy = new StaticWorkProxy(go2WorkByBike);
        staticWorkProxy.go2Wrok();
    }

    /**
     * 测试动态代理
     */
    public static void testDynamicProxy() {
        Go2WorkByBike go2WorkByBike = new Go2WorkByBike();
        IGo2Work iGo2Work = (IGo2Work) Proxy.newProxyInstance(go2WorkByBike.getClass().getClassLoader(), go2WorkByBike.getClass().getInterfaces(), new DynamicWorkProxy(go2WorkByBike));
        iGo2Work.go2Wrok();
    }
}
