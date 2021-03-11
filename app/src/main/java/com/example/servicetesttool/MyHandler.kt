package com.example.servicetesttool

import android.os.Handler
import android.os.Looper
import android.os.Message
import com.example.servicetesttool.Constants.Companion.START_PROGRESS


class MyHandler(looper: Looper?) : Handler(looper) {

//    override fun handleMessage(msg: Message?) {
//        super.handleMessage(msg)
//        if (msg.what == START_PROGRESS){
//            thread1.start();
//            looper.queue
//        }
//        else if(msg.what == UPDATE_COUNT){
//            textView.setText("Count"+msg.arg1);
//        }
//    }
}