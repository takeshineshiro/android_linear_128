package com.medical.lepu.wirelessscan_ultrasound.base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import java.util.HashMap;

/**
 * Created by wong on 11/23/16.
 */

public class BaseActivity  extends Activity {


      public    String     uiName    =   getClass().getSimpleName()   ;

    // protected AppUtil baseApp   ;

    protected   BaseHandler   baseHandler  ;

    protected   BaseTaskPool   baseTaskPool  ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    //    this.baseApp    =      (AppUtil) this.getApplicationContext();



        this.baseHandler  =    new BaseHandler(this)   ;

        this.baseTaskPool   =    new BaseTaskPool(this) ;

      //add   this   activity


        Log.d(uiName, "activity  created !")  ;

    }


    @Override
    protected void onStart() {
        super.onStart();
    }


    @Override
    protected void onResume() {
        super.onResume();
    }


    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    public   void   toast   (String  msg)   {

        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();

    }



    public     void   overlay   ( Class<?>  objClass)   {


    }

    public   void    overlay   ( Class<?> objClass , Bundle  param)  {


    }


     public   void    forward  ( Class<?>  objClass )    {


         this .finish();
     }


     public   void   forward   ( Class<?> objClass  ,  Bundle  param )   {



       this.finish();
     }


     protected    Context     getContext  ()   {

         return    this  ;
     }


     protected   LayoutInflater     getLayout  ()  {

          return  (LayoutInflater)  getSystemService(Context.LAYOUT_INFLATER_SERVICE)  ;
     }



    protected   View         getLayout ( int  layoutId)  {

           return       getLayout().inflate(layoutId  ,null)  ;

    }


    protected    View        getLayout   (  int  layoutId   ,   int  itemId )   {


         return        getLayout(layoutId).findViewById(itemId)  ;
    }


     protected   void    setHandler   ( BaseHandler   handler)   {

            this.baseHandler   = handler  ;

     }


    protected    BaseHandler    getHandler  ()   {

             return    this.baseHandler  ;
    }


    protected    BaseTaskPool     getTaskPool  ()   {

          return      this.baseTaskPool  ;
    }



    protected   void  onTaskCompleted  ( int  taskId)   {


    }

    protected   void  onTaskCompleted  (  int  taskId ,  BaseMessage   msg)   {


    }


    protected    void   onTaskError   (  int  taskId)   {


    }


       protected    void    sendMessage  (  int  what )  {

           Message     message    =    new   Message()    ;

            message.what   =  what   ;

             baseHandler.sendMessage(message) ;
       }


          protected   void   sendMessage  ( int  what ,  String  data )   {

              Bundle    bundle   =   new Bundle()  ;

              bundle.putString("data",data);

              Message     message    =   new Message()   ;

                message.what   =  what   ;

                 message.setData(bundle);

               baseHandler.sendMessage(message) ;

          }


       protected   void   sendMessage   (int  what  ,  int  taskId  , String  data )   {

           Bundle   bundle    =    new Bundle()  ;

            bundle.putInt("taskId",taskId);

           bundle.putString("data",data);

           Message   message    =   new   Message()  ;

               message.what    =  what  ;

              message.setData(bundle);

           baseHandler.sendMessage(message) ;

       }


         protected    void  doTaskAsync (int  taskId,   int  delayTime)  {

           baseTaskPool.addTask( taskId, new BaseTask()  {

               @Override
               public void onCompleted() {
                   super.onCompleted();
                   sendMessage(BaseTask.TASK_COMPLETED,  this.getId(),null);
               }

               @Override
               public void onError(String error) {
                   super.onError(error);

                   sendMessage(BaseTask.NETWORK_ERROR,this.getId(),null);
               }
           },  delayTime);

         }


        protected   void   doTaskAsync  ( int taskId ,   BaseTask  task ,   int  delayTime)   {

             baseTaskPool.addTask(taskId,task,delayTime);

        }

      //get  method
       protected   void    doTaskAsync  (int taskId ,   String  taskGet  )    {

           baseTaskPool.addTask(taskId,new BaseTask(){
               @Override
               public void onCompleted(String socketResult) {
                   super.onCompleted(socketResult);

                   sendMessage(BaseTask.TASK_COMPLETED, this.getId(),socketResult);

               }

               @Override
               public void onError(String error) {
                   super.onError(error);
                   sendMessage(BaseTask.NETWORK_ERROR,this.getId(),null);
               }
           }  ,taskGet,0);


       }



      //post  method

        protected   void    doTaskAsync   (int  taskId , String  taskPost , HashMap<String,String> taskParam)    {

          baseTaskPool.addTask(taskId,new BaseTask() {

              @Override
              public void onCompleted(String socketResult) {

                sendMessage(BaseTask.TASK_COMPLETED,this.getId(),socketResult);
              }

              @Override
              public void onError(String error) {

                  sendMessage(BaseTask.NETWORK_ERROR,this.getId(),null);
              }
          },taskPost,taskParam,0);


        }


}





