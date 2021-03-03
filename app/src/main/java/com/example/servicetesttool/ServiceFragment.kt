package com.example.servicetesttool

import android.app.Notification
import android.app.PendingIntent
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.android.server.am.ActivityManagerService.Lifecycle.startService

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */

private const val TAG = "ServiceFragment"

class ServiceFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
        (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        findNavController().navigateUp()
        return super.onOptionsItemSelected(item)

    }

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

//        requireActivity().getsupp
//        activity?.actionBar?.setDisplayShowHomeEnabled(true)
//        activity?.actionBar?.setDisplayHomeAsUpEnabled(true)

//        view.findViewById<Toolbar>(R.id.toolbar)
//            .setNavigationIcon(R.drawable.ic_baseline_arrow_back_24)
//        val toolbar = view.findViewById<Toolbar>(R.id.toolbar)
//        (activity as AppCompatActivity).supportActionBar?.set

        view.findViewById<Button>(R.id.button_start).setOnClickListener {
            activity?.startService(intent)
        }
        view.findViewById<Button>(R.id.button_stop).setOnClickListener {
            activity?.stopService(intent)
        }
    }
}