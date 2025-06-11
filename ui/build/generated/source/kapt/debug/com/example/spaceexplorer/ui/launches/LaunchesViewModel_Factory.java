package com.example.spaceexplorer.ui.launches;

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

  public LaunchesViewModel_Factory(Provider<GetLaunchesUseCase> getLaunchesUseCaseProvider,
      Provider<RefreshLaunchesUseCase> refreshLaunchesUseCaseProvider) {
    this.getLaunchesUseCaseProvider = getLaunchesUseCaseProvider;
    this.refreshLaunchesUseCaseProvider = refreshLaunchesUseCaseProvider;
  }

  @Override
  public LaunchesViewModel get() {
    return newInstance(getLaunchesUseCaseProvider.get(), refreshLaunchesUseCaseProvider.get());
  }

  public static LaunchesViewModel_Factory create(
      Provider<GetLaunchesUseCase> getLaunchesUseCaseProvider,
      Provider<RefreshLaunchesUseCase> refreshLaunchesUseCaseProvider) {
    return new LaunchesViewModel_Factory(getLaunchesUseCaseProvider, refreshLaunchesUseCaseProvider);
  }

  public static LaunchesViewModel newInstance(GetLaunchesUseCase getLaunchesUseCase,
      RefreshLaunchesUseCase refreshLaunchesUseCase) {
    return new LaunchesViewModel(getLaunchesUseCase, refreshLaunchesUseCase);
  }
}
