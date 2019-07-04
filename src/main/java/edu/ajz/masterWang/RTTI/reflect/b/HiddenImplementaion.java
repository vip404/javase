package edu.ajz.masterWang.RTTI.reflect.b;

import edu.ajz.masterWang.RTTI.reflect.a.A;
import edu.ajz.masterWang.RTTI.reflect.a.GetClassA;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


/**
 * @ClassName HiddenImplementaion
 * @Description TODO
 * @Author master wang
 * @Date 2019/5/23 22:30
 * @Version 1.0
 **/
public class HiddenImplementaion {


    public static void main(String[] args){
        A a = GetClassA.getA();
        a.f();
        try {
            callHiddenMethod(a,"g");
            callHiddenMethod(a,"h");
            callHiddenMethod(a,"i");
            callHiddenMethod(a,"j");
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
//        ((C) a).g();
//         a.h();

    }

    static void callHiddenMethod(Object object,String methodName) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = object.getClass().getDeclaredMethod(methodName);
        method.setAccessible(true);
        method.invoke(object);
    }
}



