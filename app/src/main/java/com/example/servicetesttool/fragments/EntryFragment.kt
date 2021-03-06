package com.example.servicetesttool.fragments

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Button
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import com.example.servicetesttool.Constants.Companion.START_PROGRESS
import com.example.servicetesttool.MyHandler
import com.example.servicetesttool.MyThread
import com.example.servicetesttool.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [EntryFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
private const val TAG = "EntryFragment"

class EntryFragment : Fragment() {
    private lateinit var hanlder: Handler

    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
        hanlder = object : Handler(Looper.getMainLooper()) {
            override fun handleMessage(msg: Message?) {
                super.handleMessage(msg)
                Log.d(TAG, "run complete with result: $msg ")

            }
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(false)
        return inflater.inflate(R.layout.fragment_entry, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        view.findViewById<Button>(
            R.id.foreground_service_button
        ).setOnClickListener {
            findNavController().navigate(R.id.action_entryFragment_to_FirstFragment)
        }

        view.findViewById<Button>(
            R.id.content_provider_button
        ).setOnClickListener {
            findNavController().navigate(R.id.action_entryFragment_to_ContentProviderFragment)
        }
        view.findViewById<Button>(R.id.broadcast_receiver_button).setOnClickListener {
            findNavController().navigate(R.id.action_entryFragment_to_braodcastReceiverFragment)

        }
        view.findViewById<Button>(R.id.background_service_button).setOnClickListener {
            findNavController().navigate(R.id.action_entryFragment_to_backgroundServiceFragment)

        }
        val thread = MyThread(hanlder)
        view.findViewById<Button>(R.id.new_thread_button).setOnClickListener {
            Log.d(TAG, "onViewCreated: ${thread.state}")
            try {
                thread.start()
            } catch (e: Exception) {
                Toast.makeText(activity, e.toString(), LENGTH_SHORT).show()
                Log.d(TAG, "onViewCreated: $e")
            }


        }


    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment EntryFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            EntryFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
