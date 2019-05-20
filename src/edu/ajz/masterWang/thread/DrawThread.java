package edu.ajz.masterWang.thread;

/**
 * @ClassName DrawThread
 * @Description TODO
 * @Author master wang
 * @Date 2019/3/13 21:49
 * @Version 1.0
 **/
public class DrawThread extends Thread {

    private Account account;    //用户账号
    private double drawAmount;  //希望取钱数量

    public DrawThread(String name, Account account, double drawAmount) {
        super(name);
        this.account = account;
        this.drawAmount = drawAmount;
    }

    public void run(){
        if(account.getBalance() >= this.drawAmount){
            System.out.println(getName() + "取钱成功！ 吐出钞票：" + drawAmount);
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            account.setBalance(account.getBalance()-drawAmount);
            System.out.println( "余额为：" + account.getBalance());
        }else{
            System.out.println(getName() +  "余额不足！取钱失败！" );
        }
    }

    public static void main(String[] args){
        Account a = new Account("0001",1000);
        new DrawThread("甲",a,800).start();
        new DrawThread("乙",a,800).start();
    }
}
