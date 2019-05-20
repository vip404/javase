package edu.ajz.masterWang.strings;

/**
 * @ClassName ToStringTest
 * @Description TODO
 * @Author master wang
 * @Date 2019/5/5 21:55
 * @Version 1.0
 **/
public class ToStringTest {

    @Override
    public String toString() {
        /**
         *  打印this会导致递归调用
         *  Exception in thread "main" java.lang.StackOverflowError
         */
//        return "ToStringTest: " + this + " \n"; //打印自己
        return "ToStringTest: " + super.toString() + " \n"; //正确方式
    }

    public static void main(String[] args){
        ToStringTest t = new ToStringTest();
        System.out.println(t);

        int a = 12;
        double b = 1.12;
        System.out.printf("%d; %f \n",a,b);         //格式化打印
    }
}
