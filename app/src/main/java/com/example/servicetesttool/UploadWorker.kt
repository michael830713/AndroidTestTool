package com.example.servicetesttool

import android.content.Context
import android.os.CountDownTimer
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters

private const val TAG = "UploadWorker"
class UploadWorker(appContext: Context, workerParams: WorkerParameters) :
    Worker(appContext, workerParams) {

    lateinit var mainHandler: Handler
    private val updateTextTask = object : Runnable {
        var a = 0
        override fun run() {
            Log.d(TAG, "run: $a")
            a++
            mainHandler.postDelayed(this, 1000)
        }
    }

    override fun doWork(): Result {
        mainHandler = Handler(Looper.getMainLooper())


        Log.d(TAG, "doWork: did the work")

        mainHandler.post(updateTextTask)


        // Indicate whether the work finished successfully with the Result
        return Result.success()
    }
}
