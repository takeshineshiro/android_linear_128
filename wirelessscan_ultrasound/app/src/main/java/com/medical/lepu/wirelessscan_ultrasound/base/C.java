package com.medical.lepu.wirelessscan_ultrasound.base;

/**
 * Created by wong on 11/23/16.
 */

public    final  class C  {




    public   static   final   class   direction   {

         public  static   final   String   LEFT   =    "left"  ;

         public  static   final   String   RIGHT  =    "right"  ;

         public   static   final  String   UP     =    "up"     ;

          public   static   final  String  DOWN   =    "down"   ;

    }


    public static final class task {
        public static final   int        wifi 				= 1   ;

        public  static  final  int     stateControl         =  2  ;

        public  static  final   int    dataControl          =  3  ;

        public  static  final   int    receiveControl       =  4  ;




    }



    public static final class err {
        public static final String network			= "网络错误";
        public static final String message			= "消息错误";
        public static final String jsonFormat		= "消息格式错误";
    }




    public  static   final   class  api   {

        public    static   final    String    host     =   "192.168.1.1"   ;

    }


    public  static  final   class   port   {

        public    static    final    int    stateControl     =      5001  ;

        public    static    final    int     dataControl      =     5002  ;

        public    static    final    int     receiveControl   =     5003  ;
    }




}
