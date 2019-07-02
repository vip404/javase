package edu.ajz.masterWang.utils;

import com.alibaba.fastjson.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @ClassName HttpUtil
 * @Description TODO
 * @Author 14133
 * @Date 2019/6/13 14:14
 * @Version 1.0
 **/
public class HttpUtil {

    public static JSONObject post(String urlStr, JSONObject jsonObject) {

        String resp = "";
        HttpURLConnection connection = null;
        try {
            URL url = new URL(urlStr); //url地址
            connection = (HttpURLConnection) url.openConnection();

            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.setRequestMethod("POST");
            connection.setUseCaches(false);
            connection.setInstanceFollowRedirects(true);
            connection.setRequestProperty("Content-Type", "application/json");
            connection.connect();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (OutputStream os = connection.getOutputStream()) {
            os.write(jsonObject.toString().getBytes("UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(connection.getInputStream()))) {
            String lines;
            StringBuffer sbf = new StringBuffer();
            while ((lines = reader.readLine()) != null) {
                lines = new String(lines.getBytes(), "utf-8");
                sbf.append(lines);
            }
            resp = sbf.toString();
            return JSONObject.parseObject(resp);
        } catch (IOException e) {
            e.printStackTrace();
        }
        connection.disconnect();
        return null;
    }

}
