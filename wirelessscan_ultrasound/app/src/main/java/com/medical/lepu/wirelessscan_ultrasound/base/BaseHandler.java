package com.medical.lepu.wirelessscan_ultrasound.base;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/**
 * Created by wong on 11/23/16.
 */

public class BaseHandler  extends Handler  {

     protected  BaseActivity   ctx   ;



    public    BaseHandler  ( BaseActivity  ctx)   {

           this.ctx   =ctx  ;
    }


    public    BaseHandler   (Looper  looper)  {
      super(looper);

    }


    @Override
    public void handleMessage(Message msg) {
        super.handleMessage(msg);

        try {
                int       taskId  =  0  ;
                String    result       ;

            switch (msg.what)  {

                case    BaseTask.TASK_COMPLETED : {
                    taskId = msg.getData().getInt("task");
                    result = msg.getData().getString("data");

                    if (result != null) {
                        ctx.onTaskCompleted(taskId, result);
                    } else if (taskId > 0) {
                        ctx.onTaskCompleted(taskId);
                    } else {
                        ctx.toast(C.err.message);
                    }

                    break;
                }

                 case   BaseTask.NETWORK_ERROR:     {

                     taskId = msg.getData().getInt("task");

                     ctx.onTaskError(taskId);

                        break;

                 }














            }






        }catch ( Exception e )  {

          e.printStackTrace();

           ctx.toast(e.getMessage());
        }







    }





}
