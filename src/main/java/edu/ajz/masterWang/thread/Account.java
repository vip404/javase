package edu.ajz.masterWang.thread;

/**
 * @ClassName Account
 * @Description TODO
 * @Author master wang
 * @Date 2019/3/13 20:57
 * @Version 1.0
 **/
public class Account {

    //账号，资金
    private String accountNo;
    private double balance;

    public Account() {
    }

    public Account(String accountNo, double balance) {
        this.accountNo = accountNo;
        this.balance = balance;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    //重写hashCode和equals方法


    @Override
    public int hashCode() {
        return accountNo.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj){
            return true;
        }
        if(obj != null && obj.getClass() == Account.class){
            return ( (Account)obj).getAccountNo().equals(accountNo);
        }
        return false;
    }
}
