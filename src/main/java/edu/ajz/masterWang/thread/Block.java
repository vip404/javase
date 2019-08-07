package edu.ajz.masterWang.thread;

/**
 * @ClassName Block
 * @Description 代码块同步
 * @Author 14133
 * @Date 2019/6/19 13:59
 * @Version 1.0
 **/
public class Block implements Runnable {

    public static int i = 0;

    public static void main(String[] args) {
        f1();

        f2();
    }

    public static void f1(){
        Block block =  new Block();
        for (int i = 0; i < 5; i++) {
            new Thread(block).start();
        }
    }

    public static void f2() {
        for (int i = 0; i < 5; i++) {
            new Thread(new Block()).start();
        }
    }


        @Override
    public void run() {
        while (true) {
            synchronized (Block.class) {    //同步Class对象
                System.out.println("进入了同步代码块!");
                try {
                    Thread.sleep(4000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(i++);
            }
        }
    }
}
