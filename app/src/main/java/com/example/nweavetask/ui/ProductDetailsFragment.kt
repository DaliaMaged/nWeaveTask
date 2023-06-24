package com.example.nweavetask.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.example.nweavetask.R
import com.example.nweavetask.databinding.FragmentProductDetailsBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ProductDetailsFragment : Fragment() {
    private lateinit var binding: FragmentProductDetailsBinding
    private val viewModel: ProductDetailsViewModel by viewModels()

    //  private lateinit var args:ProductDetailsFragmentArgs
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_product_details, container, false)
        showProductDetails()
        return binding.root
    }

    private fun showProductDetails() {
        lifecycleScope.launch {
            viewModel.product.collect { it ->
                binding.productNameTv.text = it?.products?.name
                binding.productDescriptionTv.text = it?.products?.description
                Glide.with(requireContext()).load(it?.products?.imageUrl).into(binding.productIv)
            }
        }
    }
}