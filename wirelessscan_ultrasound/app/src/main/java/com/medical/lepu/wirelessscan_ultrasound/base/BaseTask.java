package com.medical.lepu.wirelessscan_ultrasound.base;

/**
 * Created by wong on 11/23/16.
 */

public class BaseTask {

    public  static  final   int   TASK_COMPLETED  =     0 ;

    public   static  final   int   NETWORK_ERROR  =     1 ;

    public   static  final   int   SHOW_TOAST    =     2  ;


    private    int       task_id   ;

    private    String    task_name  ;


    public    void     setId   (int id)   {

           this.task_id   =   id ;
    }


    public   int     getId   ()  {


        return    this.task_id ;
    }



    public   void    setName ( String  name)  {

        this.task_name    =  name ;

    }

    public   String    getName  ()   {

           return     this.task_name ;
    }



    public   void    onStart()  {

    }


    public  void   onCompleted()   {



    }


    public   void    onCompleted (String   socketResult)   {


    }



  public    void    onError   ( String  error )   {


  }


    public  void    onStop   ()   {

    }
















}
