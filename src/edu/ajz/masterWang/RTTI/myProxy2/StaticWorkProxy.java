package edu.ajz.masterWang.RTTI.myProxy2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import static edu.ajz.masterWang.utils.MasterUtil.println;


/**
 * @ClassName StaticWorkProxy
 * @Description TODO
 * @Author 14133
 * @Date 2019/5/21 19:09
 * @Version 1.0
 **/
public class StaticWorkProxy implements IGo2Work {

    private IGo2Work iGo2Work;

    public StaticWorkProxy(IGo2Work iGo2Work) {
        this.iGo2Work = iGo2Work;
    }

    @Override
    public void go2Wrok() {
        println("上班前先吃饭");
        iGo2Work.go2Wrok();
        println("到公司先打卡");
    }
}



