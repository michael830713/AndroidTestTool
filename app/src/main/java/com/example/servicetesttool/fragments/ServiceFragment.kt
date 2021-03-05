package com.example.servicetesttool.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.servicetesttool.ChildFragment
import com.example.servicetesttool.CounterService
import com.example.servicetesttool.R

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */

private const val TAG = "ServiceFragment"

class ServiceFragment : ChildFragment() {


    override fun appBarTitle(): String = "Service Fragment"


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val intent = Intent(activity, CounterService::class.java)

        view.findViewById<Button>(R.id.button_start).setOnClickListener {
            activity?.startService(intent)
        }
        view.findViewById<Button>(R.id.button_stop).setOnClickListener {
            activity?.stopService(intent)
        }
    }
}