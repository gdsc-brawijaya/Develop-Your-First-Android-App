package com.gdsc.gdscubworkshopandroid1.ui.prediction

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.gdsc.gdscubworkshopandroid1.R
import com.gdsc.gdscubworkshopandroid1.databinding.FragmentPredictionBinding
import com.gdsc.gdscubworkshopandroid1.model.Plant
import com.gdsc.gdscubworkshopandroid1.model.predict.PredictionBody
import com.gdsc.gdscubworkshopandroid1.model.predict.PredictionResponse
import com.gdsc.gdscubworkshopandroid1.util.Resource
import com.gdsc.gdscubworkshopandroid1.util.ResponseCallback

class PredictionFragment : Fragment(), ResponseCallback {

    private lateinit var viewModel: PredictionViewModel
    private var _binding: FragmentPredictionBinding? = null
    private val binding get() = _binding

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

                val body = PredictionBody(
                    sepalLength, sepalWidth, petalLength, petalWidth
                )

                viewModel.getPrediction(body).observe(viewLifecycleOwner) { resource ->
                    when(resource) {
                        is Resource.Loading -> onLoading()
                        is Resource.Success -> resource.data?.let { it1 -> onSuccess(it1) }
                        is Resource.Error -> resource.message?.let { it1 -> onFailed(it1) }
                    }
                }
            }
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

    override fun onLoading() {

    }

    override fun onSuccess(plants: List<Plant>) {
        TODO("Not yet implemented")
    }

    override fun onSuccess(plant: Plant) {
        TODO("Not yet implemented")
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