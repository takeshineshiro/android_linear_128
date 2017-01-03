package com.medical.lepu.wirelessscan_ultrasound.util;

import android.util.Log;

import com.koushikdutta.async.AsyncServer;
import com.koushikdutta.async.AsyncSocket;
import com.koushikdutta.async.ByteBufferList;
import com.koushikdutta.async.DataEmitter;
import com.koushikdutta.async.Util;
import com.koushikdutta.async.callback.CompletedCallback;
import com.koushikdutta.async.callback.ConnectCallback;
import com.koushikdutta.async.callback.DataCallback;

import java.net.InetSocketAddress;
import java.util.HashMap;

/**
 * Created by wong on 11/23/16.
 */

public class HttpClient      implements   ConnectCallback {


    private   String    host   ;

    private    int      port    ;

    private   AsyncServer server ;

    private AsyncSocket   socket  ;

    private  boolean     connect_state  = false;

    private   byte[]   data ;



    public   HttpClient  ( String  host   , int  port )   {

        this.host           =  host   ;
        this.port           =  port   ;

        this.server         =    new AsyncServer()    ;

    }



    public    void   setup   ()   {


          server.connectSocket(new InetSocketAddress(host, port), this);

    }




    public    AsyncServer     getServer ()   {

           return    server  ;

    }




    @Override
    public void onConnectCompleted(Exception ex, AsyncSocket socket) {

        if (ex!=null)     throw new  RuntimeException(ex)  ;

        this.connect_state  =   true   ;

        this.socket        =  socket   ;

    }



    public     boolean  isConnect  ()  {

          return    connect_state  ;
    }


   public   void   writeData   (HashMap <String,String> param)   {


       Util.writeAll(socket, "write".getBytes(), new CompletedCallback() {
           @Override
           public void onCompleted(Exception ex) {
               Log.d("writedata","cmd  is  sended !")  ;
           }
       });


   }



    public    byte[]   readData  () {

        socket.setDataCallback(new DataCallback() {
            @Override
            public void onDataAvailable(DataEmitter emitter, ByteBufferList bb) {

                  data =   bb.getAllByteArray();
            }
        });

        return   data ;

    }


    public   void     closeSocket ()   {

      socket.setClosedCallback(new CompletedCallback() {
          @Override
          public void onCompleted(Exception ex) {


          }
      });

    }















}
