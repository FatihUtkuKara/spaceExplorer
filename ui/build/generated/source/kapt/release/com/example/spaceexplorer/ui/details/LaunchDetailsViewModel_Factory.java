package com.example.spaceexplorer.ui.details;

import androidx.lifecycle.SavedStateHandle;
import com.example.spaceexplorer.data.repository.SpaceXRepository;
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
public final class LaunchDetailsViewModel_Factory implements Factory<LaunchDetailsViewModel> {
  private final Provider<SpaceXRepository> repositoryProvider;

  private final Provider<SavedStateHandle> savedStateHandleProvider;

  public LaunchDetailsViewModel_Factory(Provider<SpaceXRepository> repositoryProvider,
      Provider<SavedStateHandle> savedStateHandleProvider) {
    this.repositoryProvider = repositoryProvider;
    this.savedStateHandleProvider = savedStateHandleProvider;
  }

  @Override
  public LaunchDetailsViewModel get() {
    return newInstance(repositoryProvider.get(), savedStateHandleProvider.get());
  }

  public static LaunchDetailsViewModel_Factory create(Provider<SpaceXRepository> repositoryProvider,
      Provider<SavedStateHandle> savedStateHandleProvider) {
    return new LaunchDetailsViewModel_Factory(repositoryProvider, savedStateHandleProvider);
  }

  public static LaunchDetailsViewModel newInstance(SpaceXRepository repository,
      SavedStateHandle savedStateHandle) {
    return new LaunchDetailsViewModel(repository, savedStateHandle);
  }
}
