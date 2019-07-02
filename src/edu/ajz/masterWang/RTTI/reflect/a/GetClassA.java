package edu.ajz.masterWang.RTTI.reflect.a;

import static edu.ajz.masterWang.utils.MasterUtil.println;

/**
 * @ClassName A
 * @Description TODO
 * @Author master wang
 * @Date 2019/5/23 22:38
 * @Version 1.0
 **/

class B implements A{
    public void f(){}
    public void g(){}
}

class C implements A{
    public  void f(){
        println("c.f()");
    }

    public void g(){
        println("c.g()");
    }

    void h(){
        println("c.h()");
    }

    protected void i(){
        println("c.i()");
    }

    private void j(){
        println("c.j()");
    }
}

public class GetClassA{
     public  static A getA(){
        return new C();
     }
}