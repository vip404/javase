package edu.ajz.masterWang.innerClass;

/**
 * @ClassName InnerClassTest
 * @Description TODO
 * @Author master wang
 * @Date 2019/4/10 22:15
 * @Version 1.0
 **/
public class InnerClassTest {

    public static void main(String[] args){

        /**
         *  在创建内部类之前必须创建外部类；除非是静态内部类
         */
        Outer outer = new Outer();
        Outer.Inner inner = outer.new Inner("内部类");
    }
}
