package com.example.servicetesttool

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

abstract class ChildFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
        (activity as AppCompatActivity).supportActionBar?.title = appBarTitle()
        (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    abstract fun appBarTitle(): String
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        findNavController().navigateUp()
        return super.onOptionsItemSelected(item)
    }
}
