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


    //cutstom   method
    public   void   addTask  ( int taskId ,  BaseTask   task ,  int  delayTime)   {
        task.setId(taskId);

        try  {

           taskpool.execute(new TaskThread(ctx,taskId,task, null,null,delayTime));

        } catch ( Exception   e )  {

           taskpool.shutdown();

        }

    }

//   https  get   method

    public   void    addTask ( int  taskId ,  BaseTask task ,  String  taskGet ,  int  delayTime)   {

         task.setId(taskId);

        try{

            taskpool.execute(  new TaskThread(ctx, taskId, task, taskGet,null,delayTime));

        }   catch (  Exception  e  )     {

          taskpool.shutdown();

        }
    }


//  https  Post   method

    public   void   addTask  (int  taskId, BaseTask  task , String  taskPost, HashMap<String,String>taskParam,  int delayTime)   {

          task.setId(taskId);

        try  {

            taskpool.execute(new TaskThread(ctx,taskId,task,taskPost,taskParam,delayTime));
        }   catch ( Exception  e )     {

            taskpool.shutdown();
        }



    }



  // socket  io   method

    public   void   addTask  (int  taskId ,  BaseTask  task , String host ,  int port ,  int  delayTime)   {

        task.setId(taskId);

        try  {

            taskpool.execute(new SocketTaskThread(ctx,taskId,task,host,port,delayTime));
        }   catch ( Exception  e )     {

            taskpool.shutdown();
        }


    }



       private   class    SocketTaskThread    implements    Runnable    {

           private    Context   context   ;

           private     int       taskId   ;

           private    BaseTask    task     ;

           private    String      host     ;

           private    int         port     ;

           private    int        delayTime ;


         public    SocketTaskThread  (Context  context , int  taskId , BaseTask  task , String  host , int   port  ,   int   delayTime)   {

              this.context    =  context   ;
              this.taskId     =  taskId    ;
              this.task       =  task      ;
              this.host       =  host      ;
              this.port       =   port      ;
              this.delayTime  =  delayTime  ;

         }


           @Override
           public void run() {






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
