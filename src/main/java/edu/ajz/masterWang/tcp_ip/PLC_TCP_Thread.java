package edu.ajz.masterWang.tcp_ip;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Array;
import java.net.Socket;
import java.util.ArrayList;

/**
 * @ClassName PLC_TCP_Thread
 * @Description plc的tcp通信实现
 * @Author 14133
 * @Date 2019/6/28 16:18
 * @Version 1.0
 **/
public abstract class PLC_TCP_Thread implements Runnable {

    private boolean runFlag;
    private boolean connected ;
    private Socket socket;
    private InputStream inputStream;
    private OutputStream outputStream;

    /**
     *  初始化，启动
     * @param ip
     * @param port
     */
    public PLC_TCP_Thread(String ip,int port){
        try {
            socket = new Socket(ip,port);
            new Thread(this).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

/*    public void connect(String ip,int port){
        try {
            socket = new Socket(ip,port);
            new Thread(this).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/

    public void disconnect(){
        if(socket != null){
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     *  是否连接成功
     * @return
     */
    public boolean isConnected(){
        return socket.isConnected();
    }

    /**
     *  发送数据
     * @param bytes
     * @return
     */
    public boolean sendBytes(byte[] bytes){
        try {
            outputStream.write(bytes);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  false;
    }


    @Override
    public void run() {

        try {
            inputStream = socket.getInputStream();
            outputStream = socket.getOutputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }

        while (runFlag){

            byte[] receive = new byte[512];
            try {
                int count = inputStream.read(receive);
                byte[] result = new byte[count];
                System.arraycopy(receive,0,receive,0,count);
                onReceive(result);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }

    abstract void onReceive(byte[] bytes);

}
