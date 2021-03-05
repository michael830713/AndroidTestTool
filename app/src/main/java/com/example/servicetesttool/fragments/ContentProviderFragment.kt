package com.example.servicetesttool.fragments

import android.content.ContentValues
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.servicetesttool.ChildFragment
import com.example.servicetesttool.Constants
import com.example.servicetesttool.R

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */

private const val TAG = "SecondFragment"

class ContentProviderFragment : ChildFragment() {


    override fun appBarTitle(): String = "Content Provider"


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.content_provider_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.insert).setOnClickListener {
            insertContent()
        }
        view.findViewById<Button>(R.id.read_button).setOnClickListener {
            readContent()
        }
    }


    private fun insertContent() {
        val tuple = ContentValues()
        tuple.put(Constants.TEXT, "happy new year")
        val uri = activity?.contentResolver?.insert(Constants.URL, tuple)
        Log.d(TAG, "insertContent: ${uri?.path}")
    }

    private fun readContent() {
        val cols = arrayOf(Constants.ID, Constants.TEXT)
        val u = Constants.URL
        val c = activity?.contentResolver?.query(u, cols, null, null, null)
        if (c!!.moveToLast())
            Log.d(
                TAG, "Data read from content provider: " +
                        c.getString(c.getColumnIndex(Constants.TEXT))
            )
        else
            Log.d(TAG, "access denied")
    }
}

