package com.example.spaceexplorer.ui.launches;

import com.example.spaceexplorer.data.repository.SpaceXRepository;
import com.example.spaceexplorer.data.usecase.GetLaunchesUseCase;
import com.example.spaceexplorer.data.usecase.RefreshLaunchesUseCase;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava"
})
public final class LaunchesViewModel_Factory implements Factory<LaunchesViewModel> {
  private final Provider<GetLaunchesUseCase> getLaunchesUseCaseProvider;

  private final Provider<RefreshLaunchesUseCase> refreshLaunchesUseCaseProvider;

  private final Provider<SpaceXRepository> repositoryProvider;

  public LaunchesViewModel_Factory(Provider<GetLaunchesUseCase> getLaunchesUseCaseProvider,
      Provider<RefreshLaunchesUseCase> refreshLaunchesUseCaseProvider,
      Provider<SpaceXRepository> repositoryProvider) {
    this.getLaunchesUseCaseProvider = getLaunchesUseCaseProvider;
    this.refreshLaunchesUseCaseProvider = refreshLaunchesUseCaseProvider;
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public LaunchesViewModel get() {
    return newInstance(getLaunchesUseCaseProvider.get(), refreshLaunchesUseCaseProvider.get(), repositoryProvider.get());
  }

  public static LaunchesViewModel_Factory create(
      Provider<GetLaunchesUseCase> getLaunchesUseCaseProvider,
      Provider<RefreshLaunchesUseCase> refreshLaunchesUseCaseProvider,
      Provider<SpaceXRepository> repositoryProvider) {
    return new LaunchesViewModel_Factory(getLaunchesUseCaseProvider, refreshLaunchesUseCaseProvider, repositoryProvider);
  }

  public static LaunchesViewModel newInstance(GetLaunchesUseCase getLaunchesUseCase,
      RefreshLaunchesUseCase refreshLaunchesUseCase, SpaceXRepository repository) {
    return new LaunchesViewModel(getLaunchesUseCase, refreshLaunchesUseCase, repository);
  }
}
