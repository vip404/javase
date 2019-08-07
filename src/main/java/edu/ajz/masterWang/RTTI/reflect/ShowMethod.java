package edu.ajz.masterWang.RTTI.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.regex.Pattern;

import static sun.misc.Version.print;

/**
 * @ClassName ShowMethod
 * @Description TODO
 * @Author master wang
 * @Date 2019/5/19 11:13
 * @Version 1.0
 **/
public class ShowMethod {


    private static  String usage = "usage: \n" +
            "ShowMethods qualified class.name\n" +
            "To show all metthods in class.name word\n" +
            "ShowMethods qualified.class.name word\n" +
            "To search for methods involving 'word'";

    private static Pattern pattern = Pattern.compile("\\w+\\.");
    public static void main(String[] args){

//        if(args.length < 1){
//            System.out.printf(usage);
//            System.exit(0);
//        }
        int lines = 0 ;
        try {
            Class<?> c = Class.forName("edu.ajz.masterWang.RTTI.reflect.ShowMethod");
            Method[] methods = c.getMethods();
            Constructor[] constructors = c.getConstructors();
//            if(args.length == 1){
                for(Method method :methods){
//                    System.out.println(pattern.matcher(method.toString()));   //返回的是Matcher对象
                    System.out.println(pattern.matcher(method.toString()).replaceAll(""));
//                    System.out.println(pattern.matcher(method.toString()));
                }

                for(Constructor constructor :constructors){
                    System.out.println(pattern.matcher(constructor.toString()).replaceAll(""));
                }
                lines = methods.length + constructors.length;
//            }else{
                System.out.println(args.length);
//            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
