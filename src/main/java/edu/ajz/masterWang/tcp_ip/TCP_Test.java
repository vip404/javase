package edu.ajz.masterWang.tcp_ip;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @ClassName TCP_Test
 * @Description TODO
 * @Author 14133
 * @Date 2019/6/28 15:35
 * @Version 1.0
 **/
public class TCP_Test {

    static Socket socket;

    public static void main(String[] args) {

    }

    static void test2(){
        PLC_TCP_Thread plc_tcp_thread = new PLC_TCP_Thread("192.168.100.100", 8080) {
            @Override
            void onReceive(byte[] bytes) {

            }
        };
    }


    static void test1(){
        try {
            socket = new Socket("192.168.100.100", 8080);
            System.out.println(socket.isConnected());
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write(new byte[]{1, 2, 3});
            outputStream.flush();
            InputStream inputStream = socket.getInputStream();
            while (true) {

                byte[] bytes = new byte[17*8];
                int count = inputStream.read(bytes);
                System.out.println("count: " + count);
                for (byte b : bytes) {
                    System.out.print(b + "  ");
                }
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
