package com.example.spaceexplorer.ui.launches

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.spaceexplorer.ui.databinding.FragmentLaunchesBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class LaunchesFragment : Fragment() {

    private var _binding: FragmentLaunchesBinding? = null
    private val binding get() = _binding!!
    private val viewModel: LaunchesViewModel by viewModels()
    private val adapter = LaunchesAdapter { launch ->
        findNavController().navigate(
            LaunchesFragmentDirections.actionLaunchesToDetails(launch.id)
        )
    }

    private val TAG = "SpaceExplorer"

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        Log.d(TAG, "[Fragment] Creating view")
        _binding = FragmentLaunchesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(TAG, "[Fragment] View created")
        setupRecyclerView()
        setupSwipeRefresh()
        observeUiState()
    }

    private fun setupRecyclerView() {
        Log.d(TAG, "[Fragment] Setting up RecyclerView")
        binding.launchesRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = this@LaunchesFragment.adapter
        }
    }

    private fun setupSwipeRefresh() {
        Log.d(TAG, "[Fragment] Setting up SwipeRefresh")
        binding.swipeRefreshLayout.setOnRefreshListener {
            Log.d(TAG, "[Fragment] Swipe refresh triggered")
            viewModel.refreshLaunches()
        }
    }

    private fun observeUiState() {
        Log.d(TAG, "[Fragment] Starting to observe UI state")
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uiState.collect { state ->
                    Log.d(TAG, "[Fragment] UI state changed: $state")
                    when (state) {
                        is LaunchesUiState.Loading -> {
                            binding.progressBar.visibility = View.VISIBLE
                            binding.errorText.visibility = View.GONE
                            binding.launchesRecyclerView.visibility = View.GONE
                            binding.swipeRefreshLayout.isRefreshing = false
                        }
                        is LaunchesUiState.Success -> {
                            binding.progressBar.visibility = View.GONE
                            binding.errorText.visibility = View.GONE
                            binding.launchesRecyclerView.visibility = View.VISIBLE
                            binding.swipeRefreshLayout.isRefreshing = false
                            adapter.submitList(state.launches)
                            Log.d(TAG, "[Fragment] Updated adapter with ${state.launches.size} launches")
                        }
                        is LaunchesUiState.Error -> {
                            binding.progressBar.visibility = View.GONE
                            binding.errorText.visibility = View.VISIBLE
                            binding.launchesRecyclerView.visibility = View.GONE
                            binding.swipeRefreshLayout.isRefreshing = false
                            binding.errorText.text = state.message
                            Log.e(TAG, "[Fragment] Error state: ${state.message}")
                        }
                    }
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d(TAG, "[Fragment] Destroying view")
        _binding = null
    }
} 