package edu.ajz.masterWang.RTTI;

/**
 * @ClassName ClassTest
 * @Description 类信息的探究
 * @Author master wang
 * @Date 2019/5/8 22:10
 * @Version 1.0
 **/
public class ClassTest {

    public static void main(String[] args){
        try {
            Class test = Class.forName("edu.ajz.masterWang.RTTI.ClassTest");
            System.out.println(test);
            System.out.println("getSimpleName:" + test.getSimpleName());
            System.out.println("className:      " + test.getName());
            System.out.println("getCanonicalName:" + test.getCanonicalName());
            System.out.println("getClassLoader:" + test.getClassLoader());
            System.out.println("getSuperclass:" + test.getSuperclass());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
