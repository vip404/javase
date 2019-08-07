package edu.ajz.masterWang;

/**
 * @ClassName NumberTest
 * @Description java数据类型测试
 * @Author master wang
 * @Date 2019/2/14 17:34
 * @Version 1.0
 **/
public class NumberTest {


    public static void main(String[] args){
        test1();
    }

    /**
     *  1.java中的数据类型有四大类 ：
     *      1.1 字符型
     *           char(2个字节)
     *      1.2 布尔型
     *          boolean
     *      1.3 整型
     *          byte(1个字节)  short(2个字节)  int(4个字节) long(8个字节)
     *      1.4 浮点型
     *          float(4个字节)  double(8个字节)
     *
     *
     */
    public static void test1(){

        /**
         *  2.数的表示
         */
        // 二进制
        int int2 = 0B0010;      //2
        //八进制
        int int8 = 010;     //8
        //十六进制
        int int16 = 0x10;       //16
        System.out.println(int2);
        System.out.println(int8);
        System.out.println(int16);

        //数值可以用下划线分开 --java7
        long a = 1000_0000_0000L;
        System.out.println(a);

        //自动类型转化 范围小-》范围大
        int b = 12;
        float c = b;
        double d = c;
        System.out.println(c);
        System.out.println(d);
        int e = 5;

        //当两个整数进行除法运算时，如果不能整除则保留整数部分
        System.out.println(b/e);  //输出整数2
        /**
         *  表达式类型的自动提升
         */
        short shortValue = 5;
        //shortValue与int类型运算自动升级为int,进而报错
//        shortValue = shortValue + 5;





    }

}
