package edu.ajz.masterWang.otherTest;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import edu.ajz.masterWang.utils.HttpUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.logging.Logger;

/**
 * @ClassName Test1
 * @Description TODO
 * @Author 14133
 * @Date 2019/6/13 14:23
 * @Version 1.0
 **/
public class Test1 {

    static Log logger = LogFactory.getLog(Test1.class);
    static String url = "http://192.168.200.150:7081/api/service/PutCarHistoryQuery";
    public static void main(String[] args){
        test1();
    }

    public static void test1(){
        JSONObject jsonReq = new JSONObject();
        try {
            jsonReq.put("GarageId", 1);
            jsonReq.put("QueryType", 3);
            jsonReq.put("LicensePlate", "皖A12345");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        while (true){

            for(int i=0;i<1000;i++){
                logger.info(i);
                int j = i;
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        JSONObject jsonObject = HttpUtil.post(url,jsonReq);
                        logger.info(j + "---------" + jsonObject.toString());
                    }
                }).start();
            }
            try {
                Thread.sleep(3*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }



    }

}
