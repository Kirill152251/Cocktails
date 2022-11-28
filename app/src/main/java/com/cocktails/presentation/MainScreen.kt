package com.cocktails.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.GridLayoutManager
import com.cocktails.R
import com.cocktails.databinding.FragmentMainScreenBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainScreen : Fragment(R.layout.fragment_main_screen) {

    private var _binding: FragmentMainScreenBinding? = null
    private val binding get() = _binding!!

    private val viewModel by viewModels<MainViewModel>()

    private val adapter = Adapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainScreenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            rv.adapter = adapter
            rv.layoutManager = GridLayoutManager(requireContext(), 1)
            swipeRefreshLayout.setOnRefreshListener {
                viewModel.setIntent(MainScreenIntent.PullToRefresh)
                swipeRefreshLayout.isRefreshing = false
            }
            btnRetry.setOnClickListener {
                viewModel.setIntent(MainScreenIntent.OnRetry)
            }
        }
        bindUI()
        viewModel.setIntent(MainScreenIntent.GetRandomCocktail)
    }

    private fun bindUI() {
        lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.state.collect { state ->
                    when(state){
                        MainScreenState.Error -> {
                            binding.apply {
                                progressBar.isVisible = false
                                btnRetry.isVisible = true
                                rv.isVisible = true
                            }
                        }
                        MainScreenState.Loading -> {
                            adapter.submitList(emptyList())
                            binding.apply {
                                progressBar.isVisible = true
                                btnRetry.isVisible = false
                            }
                        }
                        is MainScreenState.RndCocktail -> {
                            adapter.submitList(listOf(state.cocktail))
                            binding.apply {
                                progressBar.isVisible = false
                                btnRetry.isVisible = false
                            }
                        }
                    }
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}