package com.gdsc.gdscubworkshopandroid1.ui.prediction

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.gdsc.gdscubworkshopandroid1.R

class PredictionFragment : Fragment() {

    companion object {
        fun newInstance() = PredictionFragment()
    }

    private lateinit var viewModel: PredictionViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_prediction, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(PredictionViewModel::class.java)
        // TODO: Use the ViewModel
    }

}