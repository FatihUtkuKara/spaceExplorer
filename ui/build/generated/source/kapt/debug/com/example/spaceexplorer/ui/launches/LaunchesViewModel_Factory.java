package com.example.spaceexplorer.ui.launches;

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
public final class LaunchesViewModel_Factory implements Factory<LaunchesViewModel> {
  private final Provider<SpaceXRepository> repositoryProvider;

  public LaunchesViewModel_Factory(Provider<SpaceXRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public LaunchesViewModel get() {
    return newInstance(repositoryProvider.get());
  }

  public static LaunchesViewModel_Factory create(Provider<SpaceXRepository> repositoryProvider) {
    return new LaunchesViewModel_Factory(repositoryProvider);
  }

  public static LaunchesViewModel newInstance(SpaceXRepository repository) {
    return new LaunchesViewModel(repository);
  }
}
