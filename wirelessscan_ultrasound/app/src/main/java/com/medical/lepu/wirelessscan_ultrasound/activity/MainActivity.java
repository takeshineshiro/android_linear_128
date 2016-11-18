package com.medical.lepu.wirelessscan_ultrasound.activity;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.Message;
import android.os.Handler;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.medical.lepu.wirelessscan_ultrasound.R;
import com.medical.lepu.wirelessscan_ultrasound.widget.VerticalSeekBar;

import java.util.List;


public class MainActivity extends Activity implements View.OnClickListener {


     private  ImageButton  btnWifi;

     private   TextView   ssid_wifi ;

     private    TextView   view_num ;

     private    SeekBar    scan_seekbar ;

     private   ImageButton  btn_pre  ;

     private    ImageButton  btn_play ;

    private    ImageButton  btn_next  ;

    private    ImageButton  btn_save  ;

    private    ImageButton   btn_scan  ;

    private    ImageButton  btn_settting ;

    private     ImageView    scan_view  ;

    private    ImageButton   btn_freeze  ;

   private   VerticalSeekBar  btn_gain_ctl ;






    private boolean running;

    private WifiManager wifiManager;

    private WifiInfo currentWifiInfo;  // 当前所连接的wifi

    private List<ScanResult> wifiList;// wifi列表

    private ContentResolver  mContentResolver ;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        initView();

        initListener();

        initVarible();


        loadData();

    }


    private void initView() {

        // view

        btnWifi     =  (ImageButton) findViewById(R.id.btn_wifi) ;

        ssid_wifi   =  (TextView) findViewById(R.id.ssid_wifi)  ;

        view_num    =   (TextView) findViewById(R.id.view_num)  ;

        scan_seekbar =   (SeekBar)  findViewById(R.id.scan_seekbar) ;

        btn_pre     =   (ImageButton) findViewById(R.id.btn_pre)  ;

         btn_play  =   (ImageButton) findViewById(R.id.btn_play) ;

        btn_next   =    (ImageButton)findViewById(R.id.btn_next) ;

        btn_save   =    (ImageButton) findViewById(R.id.btn_save) ;

        btn_scan   =     (ImageButton) findViewById(R.id.btn_scan) ;

        btn_settting =   (ImageButton)  findViewById(R.id.btn_settting) ;

        scan_view   =    (ImageView)   findViewById(R.id.scan_view) ;

        btn_freeze   =   (ImageButton) findViewById(R.id.btn_freeze) ;

        btn_gain_ctl  =  (VerticalSeekBar)findViewById(R.id.btn_gain_ctl) ;


    }


    public void initListener() {

        btnWifi.setOnClickListener(this);

        btn_pre.setOnClickListener(this);

        btn_play.setOnClickListener(this);

        btn_next.setOnClickListener(this);

        btn_save.setOnClickListener(this);

        btn_scan.setOnClickListener(this);

        btn_settting.setOnClickListener(this);

        btn_freeze.setOnClickListener(this);


    }


    public void initVarible() {

        running = false;

        mContentResolver = getContentResolver();

        wifiManager = (WifiManager) getSystemService(Context.WIFI_SERVICE);


    }


    public void loadData() {

        openWifi();
        new ScanWifiThread().start();


    }


    @Override
    protected void onStart() {

        super.onStart();


    }



    @Override
    protected void onResume() {


        Log.i("resume", "main_resume");



        //     openWifi();

        //      currentWifiInfo = wifiManager.getConnectionInfo();

        //       ssidWifi.setText("当前网络：" + currentWifiInfo.getSSID()+ " ip:"
        //              + WifiUtil.intToIp(currentWifiInfo.getIpAddress()));


        super.onResume();
    }


    private void openWifi() {

        if (!wifiManager.isWifiEnabled()) {
            wifiManager.setWifiEnabled(true);
        }

    }


    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_wifi:
                Log.i("wifi_setting", "jump to the setting page");
              //  unLock() ;

                Intent intent = new Intent(Settings.ACTION_WIFI_SETTINGS);
                startActivity(intent);
                break;


        }

    }



       public   void unLock(){
        //推荐使用
        setLockPatternEnabled(android.provider.Settings.Secure.LOCK_PATTERN_ENABLED,false);
    }

    private void setLockPatternEnabled(String systemSettingKey, boolean enabled) {
        //推荐使用
        android.provider.Settings.Secure.putInt(mContentResolver, systemSettingKey,enabled ? 1 : 0);
    }




    class ScanWifiThread extends Thread
    {

        @Override
        public void run()
        {
            while (true)
            {
                currentWifiInfo = wifiManager.getConnectionInfo();
                startScan();
                try
                {
                    Thread.sleep(1000);
                }
                catch (InterruptedException e)
                {
                    break;
                }
            }
        }
    }


    public void startScan()
    {
        wifiManager.startScan();
        // 获取扫描结果
        wifiList = wifiManager.getScanResults();
        String tempStr = null;
        for (int i = 0; i < wifiList.size(); i++)
        {
            tempStr = wifiList.get(i).SSID;
            if (tempStr.startsWith("SS-1 "))
            {
                tempStr = tempStr + "(已连接)";

                Message msg = new Message();
                msg.what = 1;
                msg.obj =   tempStr;
                handler.sendMessage(msg);

                 break;
            }

        }
    }



    // handler类接收数据
    Handler handler = new Handler() {
        public void handleMessage(Message msg) {
            if (msg.what == 1) {
                ssid_wifi.setText((String)msg.obj);

            }
        };
    };






}
