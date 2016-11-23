package com.medical.lepu.wirelessscan_ultrasound.util;

import com.koushikdutta.async.AsyncServer;
import com.koushikdutta.async.AsyncSocket;
import com.koushikdutta.async.callback.ConnectCallback;

import java.net.InetSocketAddress;

/**
 * Created by wong on 11/23/16.
 */

public class HttpClient    {


    public   static   void   setup   (  String  host  ,  int  port )    {

        AsyncServer.getDefault().connectSocket(new InetSocketAddress(host, port), new ConnectCallback() {
            @Override
            public void onConnectCompleted(Exception ex, AsyncSocket socket) {


            }
        })  ;


    }




}
