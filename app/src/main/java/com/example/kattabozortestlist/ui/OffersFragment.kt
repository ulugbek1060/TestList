package com.example.kattabozortestlist.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.example.kattabozortestlist.databinding.FragmentOffersBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OffersFragment : Fragment() {

   private var _binding: FragmentOffersBinding? = null
   private val binding get() = _binding!!

   private val viewModel by viewModels<OffersViewModel>()
   private lateinit var adapter: ProductAdapter;

   override fun onCreateView(
      inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
   ) = FragmentOffersBinding.inflate(inflater).also { _binding = it }.root

   override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
      super.onViewCreated(view, savedInstanceState)

      observeProducts()
      connectRecyclerView()

   }

   private fun observeProducts() {
      viewModel.offers.observe(viewLifecycleOwner) {
         adapter.submitList(it)
      }
   }

   private fun connectRecyclerView() {
      adapter = ProductAdapter()
      binding.recyclerView.adapter = adapter
      binding.recyclerView.layoutManager =
//         LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
         GridLayoutManager(requireContext(), 2)
   }
}