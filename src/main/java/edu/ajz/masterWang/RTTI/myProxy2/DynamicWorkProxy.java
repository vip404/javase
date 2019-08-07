package edu.ajz.masterWang.RTTI.myProxy2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import static edu.ajz.masterWang.utils.MasterUtil.println;

/**
 * @ClassName DynamicWorkProxy
 * @Description TODO
 * @Author 14133
 * @Date 2019/5/22 8:40
 * @Version 1.0
 **/
public class DynamicWorkProxy implements InvocationHandler {

    private IGo2Work iGo2Work;

    public DynamicWorkProxy(IGo2Work iGo2Work) {
        this.iGo2Work = iGo2Work;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        println("先吃早饭!");
        Object object = method.invoke(iGo2Work,args);
        println("干活!");
        return object;
    }
}
