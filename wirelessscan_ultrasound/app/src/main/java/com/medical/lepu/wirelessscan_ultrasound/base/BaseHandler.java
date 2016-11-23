package com.medical.lepu.wirelessscan_ultrasound.base;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/**
 * Created by wong on 11/23/16.
 */

public class BaseHandler  extends Handler  {

     protected Context   ctx   ;



    public    BaseHandler  ( Context  ctx)   {

           this.ctx   =ctx  ;
    }


    public    BaseHandler   (Looper  looper)  {
      super(looper);

    }


    @Override
    public void handleMessage(Message msg) {
        super.handleMessage(msg);




    }





}
