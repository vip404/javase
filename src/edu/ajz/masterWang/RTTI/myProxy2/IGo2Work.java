package edu.ajz.masterWang.RTTI.myProxy2;

import static edu.ajz.masterWang.utils.MasterUtil.println;

/**
 * @ClassName IGo2Work
 * @Description TODO
 * @Author 14133
 * @Date 2019/5/21 19:02
 * @Version 1.0
 **/
public interface IGo2Work {

        void go2Wrok(); //去上班
}

class Go2WorkByBike implements IGo2Work{

    @Override
    public void go2Wrok() {
        println("我骑车去上班!");
    }
}

class Go2WorkByBus implements  IGo2Work{

    @Override
    public void go2Wrok() {
        println("我做公交去上班!");
    }
}