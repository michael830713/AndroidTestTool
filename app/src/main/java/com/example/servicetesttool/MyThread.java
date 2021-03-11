package com.example.servicetesttool;


import android.os.Handler;
import android.os.Looper;
import android.os.Message;


import static com.example.servicetesttool.Constants.UPDATE_COUNT;


public class MyThread extends Thread {
  Handler mHandler;

  public MyThread(Handler handler) {
    mHandler = handler;
  }

  @Override
  public void run() {
    Looper.prepare();
    Message message = new Message();
    message.what = UPDATE_COUNT;
    message.arg1 = 1;
    mHandler.sendMessage(message);
    Looper.loop();
  }


}
