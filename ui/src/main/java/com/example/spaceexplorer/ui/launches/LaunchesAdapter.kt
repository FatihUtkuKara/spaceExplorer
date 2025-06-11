package com.example.spaceexplorer.ui.launches

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.spaceexplorer.data.model.SpaceLaunch
import com.example.spaceexplorer.ui.databinding.ItemLaunchBinding
import java.text.SimpleDateFormat
import java.util.Locale

class LaunchesAdapter(
    private val onLaunchClick: (SpaceLaunch) -> Unit,
    private val onRocketIdRequest: (String, (String) -> Unit) -> Unit
) : ListAdapter<SpaceLaunch, LaunchesAdapter.LaunchViewHolder>(LaunchDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LaunchViewHolder {
        val binding = ItemLaunchBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return LaunchViewHolder(binding)
    }

    override fun onBindViewHolder(holder: LaunchViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class LaunchViewHolder(
        private val binding: ItemLaunchBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        private val dateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())

        init {
            binding.root.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    onLaunchClick(getItem(position))
                }
            }
        }

        fun bind(launch: SpaceLaunch) {
            binding.apply {
                missionNameText.text = launch.name
                onRocketIdRequest(launch.rocketId) { rocketName ->
                    rocketNameText.text = rocketName
                }
                launchDateText.text = dateFormat.format(launch.dateUtc)
                statusIcon.setImageResource(
                    when (launch.success) {
                        true -> android.R.drawable.presence_online
                        false -> android.R.drawable.presence_busy
                        null -> android.R.drawable.presence_invisible
                    }
                )
                val tintColor = when (launch.success) {
                    true -> ContextCompat.getColor(root.context, android.R.color.holo_green_dark)
                    false -> ContextCompat.getColor(root.context, android.R.color.holo_red_dark)
                    null -> ContextCompat.getColor(root.context, android.R.color.darker_gray)
                }
                statusIcon.setColorFilter(tintColor)
            }
        }
    }

    private class LaunchDiffCallback : DiffUtil.ItemCallback<SpaceLaunch>() {
        override fun areItemsTheSame(oldItem: SpaceLaunch, newItem: SpaceLaunch): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: SpaceLaunch, newItem: SpaceLaunch): Boolean {
            return oldItem == newItem
        }
    }
} 