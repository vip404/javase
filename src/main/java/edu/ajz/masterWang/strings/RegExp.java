package edu.ajz.masterWang.strings;

/**
 * @ClassName RegExp
 * @Description 正则表达式
 * @Author master wang
 * @Date 2019/5/7 21:14
 * @Version 1.0
 **/
public class RegExp {

    public static void main(String[] args){
        test1();
    }

    public static void test1(){
        System.out.println("-1234".matches("-?\\d+"));      //可能有一个【-】或者没有【-】后面有多个数字  true
        System.out.println("1234".matches("-?\\d+"));      //   true
        System.out.println("+1234".matches("-?\\d+"));      //  false
        System.out.println("+1234".matches("(-?|\\+?)\\d+"));      //  true
        System.out.println("+1234".matches("(-|\\+)?\\d+"));      //  true
    }
}
