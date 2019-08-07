package edu.ajz.masterWang.RTTI.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import static edu.ajz.masterWang.utils.MasterUtil.println;

/**
 * @ClassName DynamicProxyHandler
 * @Description TODO
 * @Author master wang
 * @Date 2019/5/20 21:15
 * @Version 1.0
 **/
public class DynamicProxyHandler implements InvocationHandler {

    private Object proxied;

    public DynamicProxyHandler(Object proxied) {
        this.proxied = proxied;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        println("**** proxy: " + proxy.getClass() + ",method: " + method + ",args: " + args);
        if (args != null) {
            for (Object arg : args) {
                println(" " + arg);
            }
        }
        return method.invoke(proxied, args);
    }
}

class SimpleDynamicProxy {

    public static void consumer(InterFace interFace) {
        interFace.doSomething();
        interFace.somethingElse(" --somethingElse-- ");
    }

    public static void main(String[] args) {
        RealObject real = new RealObject();
        consumer(real);
        //insert a proxy and call again
        InterFace i = (InterFace) Proxy.newProxyInstance(InterFace.class.getClassLoader(),
                new Class[]{InterFace.class}, new DynamicProxyHandler(real));
        println("InterFace代理: " + i + "，类名: " + i.getClass());
        consumer(i);

    }
}
