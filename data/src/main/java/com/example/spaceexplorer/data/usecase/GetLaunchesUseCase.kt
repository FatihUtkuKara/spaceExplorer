package com.example.spaceexplorer.data.usecase

import com.example.spaceexplorer.data.model.SpaceLaunch
import com.example.spaceexplorer.data.repository.SpaceXRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetLaunchesUseCase @Inject constructor(
    private val repository: SpaceXRepository
) {
    operator fun invoke(): Flow<List<SpaceLaunch>> {
        return repository.getAllLaunches()
    }
} 