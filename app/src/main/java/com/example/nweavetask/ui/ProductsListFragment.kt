package com.example.nweavetask.ui

import android.os.Bundle
import android.util.Log
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
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ProductsListFragment : Fragment() {
    private lateinit var binding : FragmentProductsListBinding
    private val productsAdapter = ProductsAdapter(::handleClick)
    private val viewModel : ProductsScreenViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_products_list, container, false)
        viewModel.getProducts()
        binding.productsRv.adapter=productsAdapter

        lifecycleScope.launch {
            viewModel.products.collect{ products ->
                productsAdapter.submitList(products)
            }
        }
        attachListener()
        return binding.root
    }

    private fun handleClick(i: Int) {

    }
   private fun attachListener(){
       binding.productsRv.setOnClickListener {
           findNavController().navigate(ProductsListFragmentDirections.actionProductsListFragmentToProductDetailsFragment())
       }

}
}