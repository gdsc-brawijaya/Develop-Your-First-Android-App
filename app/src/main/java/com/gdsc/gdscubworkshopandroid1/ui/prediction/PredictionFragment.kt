package com.gdsc.gdscubworkshopandroid1.ui.prediction

import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.lifecycle.ViewModelProvider
import com.gdsc.gdscubworkshopandroid1.R
import com.gdsc.gdscubworkshopandroid1.databinding.FragmentPredictionBinding
import com.gdsc.gdscubworkshopandroid1.model.Plant
import com.gdsc.gdscubworkshopandroid1.model.prediction.PredictionPost
import com.gdsc.gdscubworkshopandroid1.model.prediction.PredictionResponse
import com.gdsc.gdscubworkshopandroid1.util.ResponseCallback

class PredictionFragment : Fragment(), ResponseCallback {

    private lateinit var viewModel: PredictionViewModel
    private var _binding: FragmentPredictionBinding? = null
    private val binding: FragmentPredictionBinding? get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPredictionBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(PredictionViewModel::class.java)

        binding?.apply {
            btnPredict.setOnClickListener {

                val sepalLength = edtSepalLength.text.toString().toDouble()
                val sepalWidth = edtSepalWidth.text.toString().toDouble()
                val petalLength = edtPetalLength.text.toString().toDouble()
                val petalWidth = edtPetalWidth.text.toString().toDouble()

                val body = PredictionPost(
                    sepalLength, sepalWidth, petalLength, petalWidth
                )

                viewModel.getPrediction(body, this@PredictionFragment)
            }
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

    override fun onLoading() {

    }

    override fun onSuccess(plant: Plant?) {

    }

    override fun onSuccess(list: List<Plant>) {

    }

    override fun onSuccess(prediction: PredictionResponse) {
        binding?.tvPredictionResult?.apply {
            when(prediction.prediction) {
                0 -> text = "Setosa"
                1 -> text = "Virginica"
                2 -> text = "Versicolor"
            }
        }
    }

    override fun onFailed(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }
}