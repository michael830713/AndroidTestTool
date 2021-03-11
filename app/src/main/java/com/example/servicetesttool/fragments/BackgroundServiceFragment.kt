package com.example.servicetesttool.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.work.*
import com.example.servicetesttool.ChildFragment
import com.example.servicetesttool.R
import com.example.servicetesttool.UploadWorker
import java.util.concurrent.TimeUnit

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [BackgroundServiceFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class BackgroundServiceFragment : ChildFragment() {
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun appBarTitle(): String = "Background Service"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_background_service, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val uploadWorkRequest: PeriodicWorkRequest =
            PeriodicWorkRequestBuilder<UploadWorker>(1, TimeUnit.SECONDS).build()


        view.findViewById<Button>(R.id.start_background_button).setOnClickListener {
            WorkManager
                .getInstance(requireActivity())
                .enqueue(uploadWorkRequest)
        }
    }
}