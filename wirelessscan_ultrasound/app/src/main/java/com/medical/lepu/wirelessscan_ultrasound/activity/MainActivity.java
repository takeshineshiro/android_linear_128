package com.medical.lepu.wirelessscan_ultrasound.activity;

import android.app.Activity;
import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import com.medical.lepu.wirelessscan_ultrasound.R;
import com.medical.lepu.wirelessscan_ultrasound.util.WifiUtil;
import com.medical.lepu.wirelessscan_ultrasound.widget.VerticalSeekBar;

import butterknife.BindView;
import butterknife.ButterKnife;




public class MainActivity extends Activity  implements  OnClickListener{

    @BindView(R.id.btn_wifi)
    ImageButton btnWifi;
    @BindView(R.id.ssid_wifi)
    TextView ssidWifi;
    @BindView(R.id.btn_freeze)
    ImageButton btnFreeze;
    @BindView(R.id.btn_gain_ctl)
    VerticalSeekBar btnGainCtl;
    @BindView(R.id.scan_seekbar)
    SeekBar scanSeekbar;
    @BindView(R.id.btn_pre)
    ImageButton btnPre;
    @BindView(R.id.btn_play)
    ImageButton btnPlay;
    @BindView(R.id.btn_next)
    ImageButton btnNext;
    @BindView(R.id.btn_save)
    ImageButton btnSave;
    @BindView(R.id.btn_scan)
    ImageButton btnScan;
    @BindView(R.id.btn_settting)
    ImageButton btnSettting;
    @BindView(R.id.activity_main)
    LinearLayout activityMain;

     private   boolean   running ;

    private WifiManager   wifiManager ;

    private WifiInfo    currentWifiInfo;  // 当前所连接的wifi



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);


         initView ()  ;

        initListener () ;

        initVarible()  ;


        loadData ()   ;

    }



     private  void  initView  ()    {

 // view

    //  btnWifi.setOnClickListener(this);





     }


    private  void   initListener () {




    }


    private   void   initVarible()   {

       running     =  false  ;

       wifiManager  =  (WifiManager) getSystemService(Context.WIFI_SERVICE) ;

    }





    private  void    loadData  ()  {




    }


    @Override
    protected void onResume() {

   //     openWifi();

  //      currentWifiInfo = wifiManager.getConnectionInfo();

 //       ssidWifi.setText("当前网络：" + currentWifiInfo.getSSID()+ " ip:"
  //              + WifiUtil.intToIp(currentWifiInfo.getIpAddress()));



        super.onResume();
    }




   private  void   openWifi() {

       if (!wifiManager.isWifiEnabled())
       {
           wifiManager.setWifiEnabled(true);
       }

   }


    @Override
    public void onClick(View view) {



    }







    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }


    
}
