package edu.ajz.masterWang.websocket;


import com.sun.org.glassfish.gmbal.Description;
import org.apache.commons.logging.Log;
import org.java_websocket.WebSocket;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.drafts.Draft;
import org.java_websocket.drafts.Draft_6455;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.channels.NotYetConnectedException;

import static edu.ajz.masterWang.utils.MasterUtil.println;

/**
 * @ClassName SocketClient
 * @Description TODO
 * @Author 14133
 * @Date 2019/7/8 9:00
 * @Version 1.0
 */

public class SocketClient extends WebSocketClient {


    private long sendTime = 0L;

    private static final long HEART_BEAT_RATE = 8 * 1000;


    public SocketClient(URI serverUri) {
        super(serverUri);
    }

    public SocketClient(URI serverUri, Draft protocolDraft) {
        super(serverUri, protocolDraft);

//        mHandler = new android.os.Handler(mContext.getMainLooper());
//        mHandler.postDelayed(heartBeatRunnable,HEART_BEAT_RATE);

    }

    @Override
    public void onOpen(ServerHandshake handshakedata) {
        println("SocketClient-----------open: " + "链接成功");
    }



    @Override
    public void onMessage(String message) {
//        Log.i("SocketClient", this.getLocalSocketAddress().toString());

        println("SocketClient -----------received: " + message);
//        JSONObject json = JSONObject.parseObject(message);
    }


    @Override
    public void send(String text) throws NotYetConnectedException {
        super.send(text);
        println("SocketClient -----------send: " + text);
    }


    @Override
    public void onClose(int code, String reason, boolean remote) {
        println("SocketClient -----------onClose: 链接关闭");

        println("SocketClient -----------onClose: 断线重连");
    }

    @Override
    public void onError(Exception ex) {
        ex.printStackTrace();
    }

    private Runnable heartBeatRunnable = new Runnable() {
        @Override
        public void run() {
//            if (System.currentTimeMillis() - sendTime >= HEART_BEAT_RATE) {
            try {
                send("");// 就发送一个\r\n过去, 如果发送失败，就重新初始化一个socket
            } catch (Exception e) {
                println("SocketClient -网络错误,心跳失败");
            }
        }
//        }
    };

    public static void main(String[] args) {
        try {
//            SocketClient socketClient =  new SocketClient(new URI("ws://121.40.165.18:8800"));
//            SocketClient socketClient =  new SocketClient(new URI("ws://192.168.200.210:9090"));
//            SocketClient socketClient =  new SocketClient(new URI("ws:192.168.200.150:8092/BoxCloud?MacAddress=mac地址"));
            SocketClient socketClient = new SocketClient(new URI("ws://192.168.200.150:8092"));
            socketClient.connect();
//            Thread.sleep(2000);
//            socketClient.send("{\"loginId\":1}");
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }
}
