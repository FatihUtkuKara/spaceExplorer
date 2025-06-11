package com.example.spaceexplorer.ui.details

import android.content.Intent
import android.net.Uri
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
import com.example.spaceexplorer.data.model.SpaceLaunch
import com.example.spaceexplorer.data.model.Rocket
import com.example.spaceexplorer.ui.databinding.FragmentLaunchDetailsBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Locale

@AndroidEntryPoint
class LaunchDetailsFragment : Fragment() {

    private var _binding: FragmentLaunchDetailsBinding? = null
    private val binding get() = _binding!!
    private val viewModel: LaunchDetailsViewModel by viewModels()
    private val TAG = "LaunchDetailsFragment"

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        Log.e(TAG, "onCreateView called")
        _binding = FragmentLaunchDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.e(TAG, "onViewCreated called")
        observeUiState()
    }

    private fun observeUiState() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uiState.collect { state ->
                    Log.e(TAG, "UI State changed: $state")
                    when (state) {
                        is LaunchDetailsUiState.Loading -> {
                            Log.e(TAG, "Loading state")
                            binding.progressBar.visibility = View.VISIBLE
                            binding.errorText.visibility = View.GONE
                        }
                        is LaunchDetailsUiState.Success -> {
                            Log.e(TAG, "Success state with launch: ${state.launch}")
                            binding.progressBar.visibility = View.GONE
                            binding.errorText.visibility = View.GONE
                            updateUI(state.launch, state.rocket)
                        }
                        is LaunchDetailsUiState.Error -> {
                            Log.e(TAG, "Error state: ${state.message}")
                            binding.progressBar.visibility = View.GONE
                            binding.errorText.visibility = View.VISIBLE
                            binding.errorText.text = state.message
                        }
                    }
                }
            }
        }
    }

    private fun updateUI(launch: SpaceLaunch, rocket: Rocket?) {
        Log.e(TAG, "Updating UI with launch: $launch and rocket: $rocket")
        val dateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())

        binding.apply {
            missionNameText.text = launch.name
            launchDateText.text = dateFormat.format(launch.dateUtc)

            when (launch.success) {
                true -> {
                    statusText.text = "Successful"
                    statusText.setTextColor(resources.getColor(android.R.color.holo_green_dark, null))
                }
                false -> {
                    statusText.text = "Failed"
                    statusText.setTextColor(resources.getColor(android.R.color.holo_red_dark, null))
                }
                null -> {
                    statusText.text = "Pending"
                    statusText.setTextColor(resources.getColor(android.R.color.darker_gray, null))
                }
            }

            rocket?.let {
                rocketNameText.text = it.name
                rocketDescriptionText.text = it.description
            }

            launch.links?.let { links ->
                links.webcast?.let { webcastUrl ->
                    webcastButton.visibility = View.VISIBLE
                    webcastButton.setOnClickListener {
                        openUrl(webcastUrl)
                    }
                }

                links.article?.let { articleUrl ->
                    articleButton.visibility = View.VISIBLE
                    articleButton.setOnClickListener {
                        openUrl(articleUrl)
                    }
                }
            }
        }
    }

    private fun openUrl(url: String) {
        Log.e(TAG, "Opening URL: $url")
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(intent)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.e(TAG, "onDestroyView called")
        _binding = null
    }
} 