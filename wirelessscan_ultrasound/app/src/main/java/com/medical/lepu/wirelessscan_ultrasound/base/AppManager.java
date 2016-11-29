package com.medical.lepu.wirelessscan_ultrasound.base;

import android.app.Activity;

import java.util.Stack;

/**
 * Created by wong on 11/25/16.
 */

public class AppManager {


    private    static Stack<Activity>     activityStack   ;

    private     static     AppManager      appManager    ;


    private     AppManager ()  {


    }


    public     static    AppManager    newInstance  ()   {

        if  (appManager==null)
             appManager   =  new AppManager() ;

         return    appManager  ;
    }


  public     void     addActivity   ( Activity    activity)   {

       if  (activityStack  ==null)
          activityStack    =    new Stack<Activity>();

          activityStack.add(activity);

  }


    public    Activity    getCurrentActivity  ()  {

        return      activityStack.lastElement();
    }


    public     void     finishCurrentAcitity ()  {

        Activity   activity   =   activityStack.lastElement();
        finishActivity (activity);
    }


    public    void      finishActivity   ( Activity  activity)  {

         if ( activity!=null  && !activity.isFinishing())    {

             activityStack.remove(activity) ;
             activity.finish();

         }


    }


    public    void    finishActivity    ( Class<?>  cls)   {

        for   (Activity  act  :  activityStack) {

            if (act.getClass().equals(cls))  {

                finishActivity(act);

                break;
            }



        }



    }


    public    Activity     getActivity  (Class<?> cls)  {

        if  (activityStack  != null) {

            for (Activity  act  :  activityStack) {

                if (act.getClass().equals(cls))  {

                    return     act  ;

                }

            }


        }

        return    null  ;


    }


}
