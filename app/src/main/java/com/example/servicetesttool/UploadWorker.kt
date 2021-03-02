package com.example.servicetesttool

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters


class UploadWorker(appContext: Context, workerParams: WorkerParameters) :
    Worker(appContext, workerParams) {
    override fun doWork(): Result {

        // Do the work here--in this case, upload the images.
//        uploadImages()

        // Indicate whether the work finished successfully with the Result
        return Result.success()
    }
}
