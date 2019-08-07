package edu.ajz.masterWang.thirdParty;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.params.SetParams;

import static edu.ajz.masterWang.utils.MasterUtil.println;

/**
 * @ClassName RedisTest
 * @Description TODO
 * @Author master wang
 * @Date 2019/8/7 19:53
 * @Version 1.0
 **/
public class RedisTest {

    public static void main(String[]args){
        Jedis jedis = new Jedis("localhost");
        System.out.println("连接成功!");
        println("服务正在运行：" + jedis.ping());

        println(jedis.get("myKey"));
        addExpire(jedis);
        println(jedis.get("expire"));
        try {
            Thread.sleep(11 * 1000);
            println(jedis.get("expire"));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void add(  Jedis jedis){
        jedis.set("myKey","abc");
    }

    /**
     *  添加会过期的key
     * @param jedis
     */
    private static void addExpire(  Jedis jedis){
        SetParams setParams = new SetParams();
        setParams.ex(10);
        jedis.set("expire","123",setParams);

    }
}
