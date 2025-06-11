package com.example.spaceexplorer.data.usecase

import com.example.spaceexplorer.data.repository.SpaceXRepository
import javax.inject.Inject

class RefreshLaunchesUseCase @Inject constructor(
    private val repository: SpaceXRepository
) {
    suspend operator fun invoke() {
        repository.refreshLaunches()
    }
} 