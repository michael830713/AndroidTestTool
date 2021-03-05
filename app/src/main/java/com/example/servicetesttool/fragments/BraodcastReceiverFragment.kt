package com.example.servicetesttool.fragments

import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.servicetesttool.ChildFragment
import com.example.servicetesttool.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [BraodcastReceiverFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class BraodcastReceiverFragment : ChildFragment() {
    // TODO: Rename and change types of parameters


    override fun appBarTitle(): String = "Broadcast Receiver"


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_braodcast_receiver, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.listen_broadcast_button).setOnClickListener {
            startActivity(Intent(Settings.ACTION_DATE_SETTINGS))

        }
    }


}