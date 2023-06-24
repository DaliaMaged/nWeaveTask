package com.example.nweavetask.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.nweavetask.R
import com.example.nweavetask.databinding.FragmentProductsListBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ProductsListFragment : Fragment() {
    private lateinit var binding : FragmentProductsListBinding
    private lateinit var productsAdapter : ProductsAdapter
    private val viewModel : ProductsScreenViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_products_list, container, false)
        viewModel.getProducts()

        attachListener()

        return binding.root
    }

   private fun attachListener(){
       binding.productsRv.apply {
           productsAdapter= ProductsAdapter { index ->
               findNavController().navigate(ProductsListFragmentDirections.actionProductsListFragmentToProductDetailsFragment(
                   viewModel.getCurrentProduct(index)
               ))
           }
           adapter=productsAdapter
       }
       lifecycleScope.launch {
           viewModel.products.collect{ products ->
               productsAdapter.submitList(products)
           }
       }
}
}