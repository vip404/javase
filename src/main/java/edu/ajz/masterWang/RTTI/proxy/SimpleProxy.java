package edu.ajz.masterWang.RTTI.proxy;


import static edu.ajz.masterWang.utils.MasterUtil.println;

/**
 * @ClassName SimpleProxy
 * @Description TODO
 * @Author master wang
 * @Date 2019/5/19 18:19
 * @Version 1.0
 **/
public class SimpleProxy implements InterFace{

    /**
     *  代理：
     *  将额外的操作，从实际对象（realObject）中分离出来，从而达到很容易修改、添加或移除这些额外操作的目的
     */

    private InterFace proxied;

    public SimpleProxy(InterFace proxied) {
        this.proxied = proxied;
    }

    @Override
    public void doSomething() {
        println("SimpleProxy doSomething");
        proxied.doSomething();
    }

    @Override
    public void somethingElse(String arg) {
        println("SimpleProxy somethingElse" + arg);
        proxied.somethingElse(arg);
    }

}
class SimpleProxyDemo{

    public static void consumer(InterFace interFace){
        interFace.doSomething();
        interFace.somethingElse(" - I love you");
    }

    public static void main(String[] args){

        consumer(new RealObject());
        consumer(new SimpleProxy(new RealObject()));

    }
}
