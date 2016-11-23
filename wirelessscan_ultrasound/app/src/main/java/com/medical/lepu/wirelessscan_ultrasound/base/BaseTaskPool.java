package com.medical.lepu.wirelessscan_ultrasound.base;

import android.content.Context;

import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by wong on 11/23/16.
 */

public class BaseTaskPool       {

   private  static ExecutorService     taskpool   ;

   private Context      ctx  ;



    public   BaseTaskPool   ( Context  context)    {

        this.ctx   =   context   ;

        taskpool   = Executors.newCachedThreadPool() ;
    }


    //cutstom
    public   void   addTask  ( int taskId ,  BaseTask   task ,  int  delayTime)   {
        task.setId(taskId);

        try  {

           taskpool.execute(new TaskThread(ctx,taskId,task, null,null,delayTime));

        } catch ( Exception   e )  {

           taskpool.shutdown();

        }

    }

// get

    public   void    addTask ( int  taskId ,  BaseTask task ,  String  taskGet ,  int  delayTime)   {

         task.setId(taskId);

        try{

            taskpool.execute(  new TaskThread(ctx, taskId, task, taskGet,null,delayTime));

        }   catch (  Exception  e  )     {

          taskpool.shutdown();

        }
    }


//Post

    public   void   addTask  (int  taskId, BaseTask  task , String  taskPost, HashMap<String,String>taskParam,  int delayTime)   {

          task.setId(taskId);

        try  {

            taskpool.execute(new TaskThread(ctx,taskId,task,taskPost,taskParam,delayTime));
        }   catch ( Exception  e )     {

            taskpool.shutdown();
        }



    }



    private     class   TaskThread   implements  Runnable    {

        private   Context   context  ;

        private   int        taskId  ;

        private    BaseTask   task   ;

        private    String    url     ;

        private   HashMap<String,String>   param  ;

        private    int       time    ;


       public   TaskThread   (Context  ctx , int  taskId , BaseTask  task ,  String  url , HashMap<String,String>param , int  time)   {

           this.context  =  ctx   ;

           this.taskId   =  taskId ;

           this.task     =  task   ;

           this.url     =   url    ;

           this.param   =  param   ;

           this.time    =  time    ;
       }

        @Override
        public void run() {










        }





    }















}
