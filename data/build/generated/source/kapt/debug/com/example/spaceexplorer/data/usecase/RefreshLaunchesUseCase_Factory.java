package com.example.spaceexplorer.data.usecase;

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
public final class RefreshLaunchesUseCase_Factory implements Factory<RefreshLaunchesUseCase> {
  private final Provider<SpaceXRepository> repositoryProvider;

  public RefreshLaunchesUseCase_Factory(Provider<SpaceXRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public RefreshLaunchesUseCase get() {
    return newInstance(repositoryProvider.get());
  }

  public static RefreshLaunchesUseCase_Factory create(
      Provider<SpaceXRepository> repositoryProvider) {
    return new RefreshLaunchesUseCase_Factory(repositoryProvider);
  }

  public static RefreshLaunchesUseCase newInstance(SpaceXRepository repository) {
    return new RefreshLaunchesUseCase(repository);
  }
}
